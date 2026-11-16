import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
    private Manager loggedManager;

    /**
     * Constructor method. Initializes the scanner constant.
     * @param scanner the scanner used to collect user input
     * @param managerManager manager passed for function use
     * @param propertyManager manager passed for function use
     * @param tenantManager manager passed for function use
     * @param staffManager manager passed for function use
     * @param leaseManager manager passed for function use
     * @param customerFeedbackManager manager passed for function use
     * @param maintenanceRequestManager manager passed for function use
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
    
    /**
     * This method collects data and adds a new manager to the system
     */
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
    
    /**
     * This method removes a manager from the system
     */
    public void removeManager() {
        System.out.print("Enter the name of the manager to be removed: ");
        String searchName = scanner.nextLine();
        System.out.println("");

        boolean matchFound = false;
        ArrayList<Manager> managers = managerManager.getManagers();

        for(int i = 0; i < managers.size(); i++) {
            Manager manager = managers.get(i);
            if(searchName.equalsIgnoreCase(manager.getName())) {
                if(manager == loggedManager) {
                    System.out.println("You cannot remove yourself");
                    return;
                }
                managers.remove(i);
                System.out.println("Manager removed successfully.");
                matchFound = true;
                break;
            }
        }
        if(!matchFound) {
            System.out.println("Requested Manager could not be found.");
        }
    }
    
    /**
     * This method creates a new property to be added to the system.
     */
    public void addProperty() {
        Tenant assignedTenant;
        ArrayList<Tenant> tenants = tenantManager.getTenants();
        
        System.out.print("Enter the property address: ");
        String address = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter the property's monthly rent: ");
        float rentAmount = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("");
        
        System.out.print("Add a tenant? Yes or No");
        String response = scanner.nextLine();
        System.out.println("");
        if(response.equalsIgnoreCase("No")) {
            assignedTenant = null;
        }
        else if (tenants.isEmpty()) {
            System.out.println("No tenants to add.");
            assignedTenant = null;
        }
        else {
            int lineCount = 0;
            System.out.println("Available Tenants:");
                    for(Tenant tenant : tenants) {
                        System.out.println(lineCount + ". " + tenant.getName());
                        lineCount++;
                    }
            System.out.print("Select a Tenant: ");
            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");
            assignedTenant = tenants.get(selection);
        }
        Rent rent = new Rent(rentAmount, rentAmount, "1st of Month", assignedTenant);
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
        Property property = new Property(address, rent.getRentAmount(), occupied);
        
        property.setRentRecord(rent);
        
        if(assignedTenant != null) {
            property.setTenant(assignedTenant);
        }
        propertyManager.addProperty(property);
    }
    
    /**
     * This method displays all the active properties in the system
     */
    public void viewProperties() {
        propertyManager.displayProperties();
    }

    /**
     * This method displays the active Tenants in the system
     */
    public void viewTenants() {
        ArrayList<Tenant> tenants = tenantManager.getTenants();
        
        if(tenants.size() == 0) {
            System.out.println("No tenants to display");
        }
        else {
            
            for(Tenant tenant : tenants) {
                System.out.println("Tenant " + tenant.getID() + " Name: " + tenant.getName());
                System.out.println("\tPhone Number: " + tenant.getPhone());
                System.out.println("\tEmail: " + tenant.getEmail());
                System.out.println("\tAddress: " + (tenant.getProperty() != null ? tenant.getProperty().getAddress() : "No address"));
            }
        }
    }

    /**
     * This method displays the current employed staff (the staff that are in the system)
     */
    public void viewStaff() {
        ArrayList<Staff> employees = staffManager.getAllStaff();
        
        if(employees.size() == 0) {
            System.out.println("No staff to display");
        }
        else {
            for(Staff staff : employees) {
                System.out.println("Employee " + staff.getID() + " Name: " + staff.getName());
                System.out.println("\tPhone number: " + staff.getPhone());
                System.out.println("\tRole: " + staff.getRole());
            }
        }
    }

    /**
     * This method creates a new staff member and adds it to the system
     */
    public void addStaff() { //String role, , String phone
        ArrayList<Manager> managers = managerManager.getManagers();
        Manager supervisor = loggedManager;
        
        System.out.print("Employee's system ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        
        System.out.print("Employee Name: ");
        String name = scanner.nextLine();
        System.out.println("");
        
        System.out.print("Employee role: ");
        String role = scanner.nextLine();
        System.out.println("");
        
        System.out.print("Employee phone number: ");
        String phone = scanner.nextLine();
        System.out.println("");
        
        Staff newStaff = new Staff(role, supervisor, id, name, phone);
        staffManager.addStaff(newStaff);
        supervisor.addStaff(newStaff);
    }

    /**
     * This method creates a new lease for a new Tenant.
     * It also serves the purpose of creating a new Tenant and adding them to the system.
     */
    public void createNewLease() {
        ArrayList<Manager> managers = managerManager.getManagers();
        Manager manager = loggedManager;

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
        if(property == null) {
            System.out.println("Property not found. Lease could not be created.");
            return;
        }

        System.out.print("Lease Term in months: ");
        int term = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");

        System.out.print("Security Deposit: $");
        int deposit = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");

        Lease lease = new Lease(manager, tenant, occupants, property, term);
        leaseManager.addLease(lease);
        System.out.println("Lease created and added to system");
        
        lease.setSecurityDeposit(deposit);
        tenant.setLease(lease);
        property.setTenant(tenant);
    }

    /**
     * This method serves as a move-out method, removing a tenant from the system
     * and removing their lease. Also removes the tenant from being associated with 
     * a property.
     */
    public void closeLease() {
        System.out.print("Enter name of tenant to close the lease of: ");
        String tenantName = scanner.nextLine();
        System.out.println("");

        boolean matchFound = false;
        ArrayList<Tenant> tenants = tenantManager.getTenants();
        Tenant tenantFound;
        for(int i = 0; i < tenants.size(); i++) {
            if(tenantName.equalsIgnoreCase(tenants.get(i).getName())) {
                tenantFound = tenants.get(i);
                matchFound = true;
                if(tenantFound.getLease() != null) {
                    leaseManager.removeLease(tenantFound.getLease());
                }
                if(tenantFound.getProperty() != null) {
                    tenantFound.getProperty().setTenant(null);
                }
                tenants.remove(tenantFound);
                System.out.println("Tenant removed from system. Lease Closed.");
                break;
            }
        }
        if(!matchFound) {
            System.out.println("Tenant not found");
        }
    }

    /**
     * This method assigns an active maintenance request to a staff member
     */
    public void assignRequest() {
        ArrayList<MaintenanceRequest> allRequests = maintenanceRequestManager.getAllRequests();
        ArrayList<Staff> staffList = staffManager.getAllStaff();
        if(allRequests.size() == 0) {
            System.out.println("No maintenance requests at this time");
            return;
        }
        
        System.out.println("=== Maintenance Requests ===");
        maintenanceRequestManager.displayNumberedList(allRequests);
        System.out.println("Select the number of request you want to assign: ");
        int reqChoice = scanner.nextInt();
        scanner.nextLine();

        if (reqChoice < 1 || reqChoice > allRequests.size()){
            System.out.println("Invalid request.");
            return;
        }
        MaintenanceRequest selectedRequest = allRequests.get(reqChoice -1);

        System.out.println("=== Staff Members ===");
        staffManager.displayNumberedList();
        System.out.println("Select the number of the Staff member: ");
        int staffChoice = scanner.nextInt();
        scanner.nextLine();

        if (staffChoice < 1 || staffChoice > staffList.size()){
            System.out.println("Invalid Staff request.");
            return;
        }
        Staff selectedStaff = staffList.get(staffChoice -1);

        loggedManager.assignRequest(selectedRequest, selectedStaff);   
    }
    
    /**
     * This method serves as the manager's way to clear out a completed maintenance request
     */
    public void closeRequest() {
        List<MaintenanceRequest> allRequests = maintenanceRequestManager.getAllRequests();
        if (allRequests.isEmpty()){
            System.out.println("No request available.");
            return;
        }
        System.out.println("=== Maintenance Requests ===");
        maintenanceRequestManager.displayNumberedList(allRequests);

        System.out.println("Select the number of request you want to close: ");
        int reqChoice = scanner.nextInt();
        scanner.nextLine();
        if (reqChoice < 1 || reqChoice > allRequests.size()){
            System.out.println("Invalid request.");
            return;
        }

        MaintenanceRequest selectedRequest = allRequests.get(reqChoice -1);
        selectedRequest.setStatus("Closed");
        System.out.println("Maintenance request has been closed");
        
        
    }

    /**
     * This method allows a manager to view Tenant-submitted feedback
     */
    public void viewFeedback() {
        customerFeedbackManager.getFullReport();
    }
    
    /**
     * This method sets a manager in a logged-in state for menu and function use
     * @param manager 
     */
    public void setLoggedManager(Manager manager) {
        this.loggedManager = manager;
    }
}