import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class handles the display of the Tenant Submenu and processing of option selection
 * @author Justin Villegas
 * @author Edited by Connor Heck
 */
public class TenantSubMenu implements Menu {

    private Tenant tenant;
    private TenantOptions tenantOptions;
    private final Scanner scanner;
    private TenantManager tenantManager;
    private Tenant loggedTenant;
    private LeaseManager leaseManager;
    private PropertyManager propertyManager;
    private CustomerFeedbackManager customerFeedbackManager;
    private MaintenanceRequestManager maintenanceRequestManager;

    /**
     * Constructor method - sets initial values of the submenu
     * @param scanner used for user input
     * @param tenantManager manager passed for function use
     * @param leaseManager manager passed for function use
     * @param propertyManager manager passed for function use
     * @param customerFeedbackManager manager passed for function use
     * @param maintenanceRequestManager manager passed for function use
     */
    public TenantSubMenu(Scanner scanner, TenantManager tenantManager, LeaseManager leaseManager, 
            PropertyManager propertyManager, CustomerFeedbackManager customerFeedbackManager, MaintenanceRequestManager maintenanceRequestManager) {
        this.scanner = scanner;
        tenantOptions = new TenantOptions(scanner, customerFeedbackManager, maintenanceRequestManager);
        this.tenantManager = tenantManager;
        this.leaseManager = leaseManager;
        this.propertyManager = propertyManager;
        this.customerFeedbackManager = customerFeedbackManager;
        this.maintenanceRequestManager = maintenanceRequestManager;
        
    }

    /**
     * "Logs" a tenant in and runs the menu display and handles selection collection
     */
    @Override 
    public void showMenu() {

        int selection1; //selection value for user selection
        int selection2; //selection value for menu option
        ArrayList<Tenant> tenants = tenantManager.getTenants();
        int tenexitvalue1 = tenants.size(); //Value will change as tenants are added
        final int TENEXITVALUE2 = 7; //The value of the exit option in the tenant submenu
        
        if(tenants.size() == 0) {
            System.out.println("No available tenants in system.");
            return;
        }
        
        System.out.println("Please select a user: ");
        do {
            for(int i = 0; i < tenants.size(); i++) {
                System.out.println((i + 1) + tenants.get(i).getName());
            }
            System.out.print("User: ");
            selection1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");              
        } while(selection1 < 1 || selection1 > tenexitvalue1);
        System.out.println("Welcome, " + tenants.get(selection1 - 1).getName() + "!");
        loggedTenant = tenants.get(selection1 - 1);
        
        do { 

            displayOptions();
            System.out.print("Please select an option: ");
            selection2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            processOption(selection2);

        } while (selection2 != TENEXITVALUE2);

    }

    /**
     * Displays the available options for tenants
     */
    @Override
    public void displayOptions() {
        System.out.println("\n===== Tenant Menu =====");
        System.out.println(" 1. Submit maintenance request");
        System.out.println(" 2. View maintenance requests");
        System.out.println(" 3. View lease");
        System.out.println(" 4. View property");
        System.out.println(" 5. Pay rent");
        System.out.println(" 6. Leave feedback");
        System.out.println(" 7. Log out");
    }
    
    /**
     * Processes the tenant's option selection
     * @param selection 
     */
    @Override
    public void processOption(int selection) {
        switch(selection) {
            case 1: tenantOptions.createNewMaintenanceReq(loggedTenant); break;
            case 2: tenantOptions.viewMaintenanceReq(loggedTenant); break;
            case 3: tenantOptions.viewLease(loggedTenant); break;
            case 4: tenantOptions.viewProperty(propertyManager, loggedTenant); break;
            case 5: 
                if(loggedTenant.getProperty() == null || loggedTenant.getProperty().getRentRecord() == null) {
                    System.out.println("No rent on file to pay.");
                }
                else {
                    tenantOptions.payRent(loggedTenant.getProperty().getRentRecord());
                };
                break;
            case 6: tenantOptions.customerFeedback(); break;
            case 7: System.out.println("Logging out and returning to Main Menu. Thank you, " + loggedTenant.getName() + "!"); break;
            default: System.out.println("Invalid option selected."); break;
        }
    }
}