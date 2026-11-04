import java.util.Scanner;

/**
 * This class displays the Main Menu of the system. It implements the Menu interface
 * to display the options and process the user selection.
 * @author Connor Heck
 * Created on 11/3/26
 */
public class MainMenu implements Menu {

    private ManagerSubMenu managerMenu;
    private StaffSubMenu staffMenu;
    private TenantSubMenu tenantMenu;
    private final Scanner scanner;

    /**
     * This constructor sets the initial scanner value and initializes the three submenus
     * @param scanner a user-input value to process menu selection later
     */
    public MainMenu(Scanner scanner) {

        this.scanner = scanner;
        this.managerMenu = new ManagerSubMenu(scanner);
        this.staffMenu = new StaffSubMenu(scanner);
        this.tenantMenu = new TenantSubMenu(scanner);

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
        final int EXITVALUE = 4; //The value of the exit option in this menu

        do { 

            displayOptions();
            System.out.print("Please select your role: ");
            selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            processOption(selection);

        } while (selection != EXITVALUE);

    }

    /**    
     * This method is implemented from the Menu interface. 
     * This method displays the text of the available options for this menu.
     * @see Menu#showMenu()
     */
    @Override 
    public void displayOptions() {
        System.out.println("=================");
        System.out.println("Main Menu:");
        System.out.println("=================");
        System.out.println("1. Managers");
        System.out.println("2. Staff");
        System.out.println("3. Tenants");
        System.out.println("4. Exit");

    }

    /**    
     * This method is implemented from the Menu interface. 
     * This uses a switch to process the user input of the desired option and displays the 
     * according submenu or "Invalid option." if the selection is not valid.
     * @see Menu#showMenu()
     */
    @Override 
    public void processOption(int selection) {

        switch(selection) {
            case 1: managerMenu.showMenu(); break;
            case 2: staffMenu.showMenu(); break;
            case 3: tenantMenu.showMenu(); break;
            case 4:
                System.out.println("Thank you for using our system. Goodbye!");
                break;
            default: 
                System.out.println("Invalid option.");
        }

    }
    
}
