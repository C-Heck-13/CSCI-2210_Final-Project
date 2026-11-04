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
    public ManagerSubMenu(Scanner scanner) {

        this.scanner = scanner;
        this.managerManager = new ManagerManager();
        this.managerOptions = new ManagerOptions(scanner);

    }

    /**    
     * This method is implemented from the Menu interface. 
     * This method runs the loop that controls the display of the menu until the exit option 
     * is selected and processed in the processOption method.
     * @see Menu#showMenu()
     */
    @Override 
    public void showMenu() {
        int selection;
        final int MGREXITVALUE = 9; //The value of the exit option in the manager submenu

        do { 

            displayOptions();
            System.out.print("Welcome. Please select an option: ");
            selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            processOption(selection);

        } while (selection != MGREXITVALUE);

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
        System.out.println("1. Add a Property");
        System.out.println("2. View Current Properties");
        System.out.println("3. View Current Tenants");
        System.out.println("4. View Current Staff");
        System.out.println("5. Add New Staff Member");
        System.out.println("6. Assign a Maintenance Request");
        System.out.println("7. Close a Completed Maintenance Request");
        System.out.println("8. View Tenant Feedback");
        System.out.println("9. Return to Main Menu");

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
            case 1: managerOptions.addProperty(); break;
            case 2: managerOptions.viewProperties(); break;
            case 3: managerOptions.viewTenants(); break;
            case 4: managerOptions.viewStaff(); break;
            case 5: managerOptions.addStaff(); break;
            case 6: managerOptions.assignRequest(); break;
            case 7: managerOptions.closeRequest(); break;
            case 8: managerOptions.viewFeedback(); break;
            case 9: 
                System.out.println("Returning to Main Menu.");
                break;
            default: 
                System.out.println("Invalid option.");
        }

    }
    
}
