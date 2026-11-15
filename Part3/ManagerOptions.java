import java.rmi.dgc.Lease;
import java.util.Scanner;

/**
 * This class handles the execution of the various options from the Employee Submenu. Uses EmployeeManager
 * to run the various functions and manage output.
 * @author Connor Heck
 * Created on 11/3/26
 */
public class ManagerOptions {

    private final Scanner scanner;
    private ManagerManager managerManager;
    private PropertyManager propertyManager;
    private TenantManager tenantManager;
    private StaffManager staffManager;
    private LeaseManager leaseManager;
    private CustomerFeedbackManager customerFeedbackManager;
    private MaintenanceRequestManager maintenanceRequestManager;

    /**
     * Constructor method. Initializes the scanner constant.
     * @param scanner the scanner used to collect user input
     */
    public ManagerOptions(Scanner scanner, ManagerManager managerManager, PropertyManager propertyManager, TenantManager tenantManager, StaffManager staffManager, 
        LeaseManager leaseManager, CustomerFeedbackManager customerFeedbackManager, MaintenanceRequestManager maintenanceRequestManager) {

        this.scanner = scanner;
        this.managerManager = managerManager;
        this.propertyManager = propertyManager;
        this.tenantManager = tenantManager;
        this.staffManager = staffManager;
        this.leaseManager = leaseManager;
        this.customerFeedbackManager = customerFeedbackManager;
        this.maintenanceRequestManager = maintenanceRequestManager;
    }

    public void addManager() {
        System.out.print("Enter system ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        System.out.print("Enter Manager name: ");
        String name = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter Manager's phone number: ");
        String phone = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter Manager email: ");
        String email = scanner.nextLine();
        System.out.println("");

        Manager manager = new Manager(id, name, phone, email);
        managerManager.addManager(manager);
    }

    public void removeManager() {
        System.out.print("Enter the name of the manager to be removed: ");
        String searchName = scanner.nextLine();
        System.out.println("");

        boolean matchFound = false;
        ManagerManager managers = managerManager;

        for(int i = 0; i < managerManager.size(); i++) {
            Manager manager = managerManager.get(i);
            if(searchName.equalsIgnoreCase(manager.getName())) {
                managerManager.remove(i);
                System.out.println("Manager removed successfully.");
                matchFound = true;
                break;
            }
        }
        if(!matchFound) {
            System.out.println("Requested Manager could not be found.");
        }
    }

    public void addProperty() {
        System.out.print("Enter the property address: ");
        String address = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter the property's monthly rent: ");
        float rentAmount = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("");
        Rent rent = new Rent(rentAmount, rentAmount, "1st of Month");
        System.out.print("Occupied? Yes or No: ");
        String answer = scanner.nextLine();
        System.out.println("");
        boolean occupied;
        if(answer.equalsIgnoreCase("Yes")) {
            occupied = true;
        }
        else {
            occupied = false;
        }
        Property property = new Property(address, rent, occupied);
        propertyManager.addProperty(property);
    }

    public void viewProperties() {
        propertyManager.displayProperties();
    }

    public void viewTenants() {
        if(tenantManager.size() == 0) {
            System.out.println("No tenants to display");
        }
        else {
            TenantManager tenants = tenantManager;
            for(Tenant tenant : tenants) {
                System.out.println("Tenant " + tenant.getID() + " Name: " + tenant.getName());
                System.out.println("\tPhone Number: " + tenant.getPhone());
                System.out.println("\tEmail: " + tenant.getEmail());
                System.out.println("\tAddress: " + tenant.getLease().getAddress());
            }
        }
    }

    public void viewStaff() {
        if(staffManager.size() == 0) {
            System.out.println("No staff to display");
        }
        else {
            StaffManager employees = staffManager;
            for(Staff staff : employees) {
                System.out.println("Employee " + staff.getID() + " Name: " + staff.getName());
                System.out.println("\tPhone number: " + staff.getPhone());
                System.out.println("\tRole: " + staff.getRole());
            }
        }
    }

    public void addStaff() {
        staffManager.addStaff();
    }

    public void createNewLease() {
        Manager manager = managerManager.get(0);

        System.out.print("Enter the Tenant System ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        System.out.print("Tenant Name: ");
        String name = scanner.nextLine();
        System.out.println("");
        System.out.print("Tenant Phone number: ");
        String phone = scanner.nextLine();
        System.out.println("");
        System.out.print("Tenant Email: ");
        String email = scanner.nextLine();
        System.out.println("");

        Tenant tenant = new Tenant(id, name, phone, email);
        tenantManager.addTenant(tenant);
        System.out.println("Tenant added to system");

        System.out.print("Other Occupants: ");
        String occupants = scanner.nextLine();
        System.out.println("");

        System.out.print("Address: ");
        String reqAddress = scanner.nextLine();
        Property property = propertyManager.findProperty(reqAddress);

        System.out.print("Lease Term in months: ");
        int term = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");

        System.out.print("Security Deposit: $");
        int deposit = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");

        Lease lease = new Lease(manager, tenant, occupants, property, term, deposit);
        leaseManager.addLease(lease);
        System.out.println("Lease created and added to system");
    }

    public void closeLease() {
        System.out.print("Enter name of tenant to close the lease of: ");
        String tenantName = scanner.nextLine();
        System.out.println("");

        bool matchFound = false;
        TenantManager tenants = tenantManager;
        Tenant tenantFound;
        for(int i = 0; i < tenants.size(); i++) {
            if(tenantName.equalsIgnoreCase(tenants.get(i).getName())) {
                tenantFound = tenants.get(i);
                matchFound = true;
                tenantManager.removeTenant(tenantFound);
                System.out.println("Tenant removed from system. Lease Closed.");
                break;
            }
        }
        if(!matchFound) {
            System.out.println("Tenant not found");
        }
    }

    public void assignRequest() {
        List<MaintenanceRequest> allRequests = MaintenanceRequestManager.getAllRequests();
        List<Staff> staffList = manager.getStaffList();

        System.out.println("=== Maintenance Requests ===");
        MaintenanceRequestManager.displayNumberedList(allRequests);
        System.out.println("Select the number of request you want to assign: ")
        int reqChoice = scanner.nextInt();
        scanner.nextLine();

        if (reqChoice < 1 || reqChoice > allRequests.size()){
            System.out.println("Invalid request.")
            return;
        }
        MaintenanceRequest selectedRequest = allRequests.get(reqChoice -1);

        System.out.println("=== Staff Members ===")
        staffManager.displayNumberedList();
        System.out.println("Select the number of the Staff member: ")
        int staffChoice = scanner.nextInt();
        scanner.nextLine();

        if (staffChoice < 1 || staffChoice > allStaff.size()){
            System.out.println("Invalid Staff request.")
            return;
        }
        Staff selectedStaff = allStaff.get(staffChoice -1);

        this.manager.assignRequest(selectedRequest, selectedStaff);   
    }
    
    public void closeRequest() {
        List<MaintenanceRequest> allRequests = MaintenanceRequestManager.getAllRequests();
        if (allRequests.isEmpty()){
            System.out.println("No request available.");
            return;
        }
        System.out.println("=== Maintenance Requests ===");
        MaintenanceRequestManager.displayNumberedList(allRequests);

        System.out.println("Select the number of request you want to close: ")
        int reqChoice = scanner.nextInt();
        scanner.nextLine();
        if (reqChoice < 1 || reqChoice > allRequests.size()){
            System.out.println("Invalid request.")
            return;
        }

        MaintenanceRequest selectedRequest = allRequests.get(reqChoice -1);
        selectedRequest.setStatus("Closed");
        System.out.println("Maintenance request has been closed");
        
        
    }

    public void viewFeedback() {
        customerFeedbackManager.getFullReport();
    }
}
