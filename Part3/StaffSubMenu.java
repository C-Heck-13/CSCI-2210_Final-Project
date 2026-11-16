import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class shows the staff sub Menu.
 * @author Hannah Travis
 * Created on 11/3/2026
 * @author Edited by Connor Heck
 */
public class StaffSubMenu implements Menu {

    private Staff staff;
    private StaffOptions staffOptions;
    private final Scanner scanner;
    private StaffManager staffManager;
    private MaintenanceRequestManager requestManager;

    
    /**
     * Constructor that initializes the initial values. 
     * @param staffManager manager passed for function use
     * @param requestManager manager passed for function use
     * @param scanner represent user input. Allows user to traverse the Menu
     */
    public StaffSubMenu(Scanner scanner, StaffManager staffManager, MaintenanceRequestManager requestManager) {
        this.staffManager = staffManager;
        staffOptions = new StaffOptions(scanner, staffManager, requestManager);
        this.scanner = scanner;
        this.requestManager = requestManager;
    }

    /**
     * Implemented method that shows the menu
     */
    @Override
    public void showMenu() {
        int selection1; //selection value for user selection
        int selection2; //selection value for menu option                
        Staff loggedStaff;
        ArrayList<Staff> employees = staffManager.getAllStaff();
        int staffexitvalue1 = employees.size();//Value will change as staff are added
        final int STAFFEXITVALUE2 = 4; //The value of the exit option in the staff submenu
        
        if(employees.size() == 0) {
            System.out.println("No active staff");
            return;
        }
        
        System.out.println("Please select a user: ");
        do {
            for(int i = 0; i < employees.size(); i++) {
                System.out.println((i + 1) + ". " + employees.get(i).getName());
            }
            System.out.print("User: ");
            selection1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");
        } while(selection1 < 1 || selection1 > staffexitvalue1);
        loggedStaff = employees.get(selection1 - 1);
        staffOptions.setStaff(loggedStaff);
        System.out.println("Welcome, " + employees.get(selection1 - 1).getName() + "!");
        

        do {
            displayOptions();
            System.out.println("Enter the number for your action:");
            selection2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");
            processOption(selection2);
        } while (selection2 != STAFFEXITVALUE2);
    }

    /**
     * Implemented method that shows the Specific Staff Sud menu options.
     */
    @Override
    public void displayOptions() {

        System.out.println("======================");
        System.out.println("      Staff Menu      ");
        System.out.println("======================");
        System.out.println("1. View Assigned Maintenance Requests");
        System.out.println("2. Update Assigned Maintenance Requests");
        System.out.println("3. View Personal Info");
        System.out.println("4. Return to Main Menu");

    }

    /**
     * Implemented method that process the user choice and executed the proper
     * options/output.
     * @param option int value that holds user input, from display options
     * method
     */
    @Override
    public void processOption(int option) {
        switch (option) {
            case 1:
                staffOptions.viewMaintenanceReq();
                break;
            case 2:
                staffOptions.updateRequest();
                break;
            case 3:
                staffOptions.viewPersonalInfo();
                break;
            case 4:
                System.out.println("Exiting staff menu.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
}