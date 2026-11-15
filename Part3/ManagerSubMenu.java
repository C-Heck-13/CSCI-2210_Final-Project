import java.util.Scanner;

/**
 * This class displays the Manager Subenu of the system. It implements the Menu interface
 * to display the options and process the user selection.
 * @author Connor Heck
 * Created on 11/3/26
 */
public class ManagerSubMenu implements Menu {
    
    private ManagerManager managerManager;
    private ManagerOptions managerOptions;
    private final Scanner scanner;

    /**
     * Constructor method that initializes the scanner value and managerManager and managerOptions
     * objects for later use
     * @param scanner a user-input selection for option selection.
     */
    public ManagerSubMenu(Scanner scanner, ManagerManager managerManager, PropertyManager propertyManager, TenantManager tenantManager, StaffManager staffManager, 
        LeaseManager leaseManager, CustomerFeedbackManager customerFeedbackManager, MaintenanceRequestManager maintenanceRequestManager) {

        this.scanner = scanner;
        managerManager = new ManagerManager();
        managerOptions = new ManagerOptions(scanner, managerManager, propertyManager, tenantManager, staffManager, 
        leaseManager, customerFeedbackManager, maintenanceRequestManager);

        Manager admin = new Manager(1001, "Admin", "555-5757", "admin@propertymanager.sys"); //Creates a "default" initial manager and adds to Management list
        managerManager.addManager(admin);

    }

    /**    
     * This method is implemented from the Menu interface. 
     * This method runs the loop that controls the display of the menu until the exit option 
     * is selected and processed in the processOption method.
     * @see Menu#showMenu()
     */
    @Override 
    public void showMenu() {
        int selection1; //selection value for user selection
        int selection2; //selection value for menu option
        int mgrexitvalue1 = managerManager.size(); //Value will change as managers are added
        final int MGREXITVALUE2 = 13; //The value of the exit option in the manager submenu

        System.out.println("Please select a user: ");
        do {
            for(int i = 0; i < managerManager.size(); i++) {
                System.out.println((i + 1) + managerManager.getManager(i).getName());
            }
            System.out.print("User: ");
            selection1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");
        } while(selection1 != mgrexitvalue1);
        System.out.println("Welcome, " + managerManager.getManager(selection1 - 1).getName() + "!");

        do { 

            displayOptions();
            System.out.print("Please select an option: ");
            selection2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            processOption(selection2);

        } while (selection2 != MGREXITVALUE2);

    }

    /**    
     * This method is implemented from the Menu interface. 
     * This method displays the text of the available options for this menu.
     * @see Menu#showMenu()
     */
    @Override 
    public void displayOptions() {
        System.out.println("==================================");
        System.out.println("Manager Functions:");
        System.out.println("==================================");
        System.out.println("1. Add a new Manager");
        System.out.println("2. Remove an existing Manager");
        System.out.println("3. Add a Property");
        System.out.println("4. View Current Properties");
        System.out.println("5. View Current Tenants");
        System.out.println("6. View Current Staff");
        System.out.println("7. Add New Staff Member");
        System.out.println("8. Create a new lease");
        System.out.println("9. Close out a lease");
        System.out.println("10. Assign a Maintenance Request");
        System.out.println("11. Close a Completed Maintenance Request");
        System.out.println("12. View Tenant Feedback");
        System.out.println("13. Return to Main Menu");

    }

    /**    
     * This method is implemented from the Menu interface. 
     * This uses a switch to process the user input of the desired option and runs the 
     * selected process or displays "Invalid option." if the selection is not valid.
     * @see Menu#showMenu()
     */
    @Override 
    public void processOption(int selection) {

        switch(selection) {
            case 1: managerOptions.addManager(); break;
            case 2: managerOptions.removeManager(); break;
            case 3: managerOptions.addProperty(); break;
            case 4: managerOptions.viewProperties(); break;
            case 5: managerOptions.viewTenants(); break;
            case 6: managerOptions.viewStaff(); break;
            case 7: managerOptions.addStaff(); break;
            case 8: managerOptions.createNewLease(); break;
            case 9: managerOptions.closeLease(); break;
            case 10: managerOptions.assignRequest(); break;
            case 11: managerOptions.closeRequest(); break;
            case 12: managerOptions.viewFeedback(); break;
            case 13:
                System.out.println("Returning to Main Menu.");
                break;
            default: 
                System.out.println("Invalid option.");
        }

    }
    
}
