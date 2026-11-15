import java.util.Scanner;
/**
 * This class shows the staff sub Menu.
 * @author Hannah Travis
 * Created on 11/3/2026
 */
public class StaffSubMenu implements Menu {

    private Staff staff;
    private StaffOptions staffOptions;
    private final Scanner scanner;

    
    /**
     * Constructor that initializes the initial values. 
     * @param staff Accesses the Staff objects
     * @param staffOptions Accesses the Staff Options class
     * @param scanner represent user input. Allows user to traverse the Menu
     */
    public StaffSubMenu(Staff staff, StaffOptions staffOptions, Scanner scanner) {
        this.staff = staff;
        this.staffOptions = staffOptions;
        this.scanner = scanner;
    }

    /**
     * Implemented method that shows the menu
     */
    @Override
    public void showMenu() {
        System.out.println("======================");
        System.out.println("      Staff Menu      ");
        System.out.println("======================");
        displayOptions();
        
    }

    /**
     * Implemented method that shows the Specific Staff Sud menu options.
     */
    @Override
    public void displayOptions() {
        int option;
        do {
            System.out.println("1. View Assigned Maintenance Requests");
            System.out.println("2. Update Assigned Maintenance Requests");
            System.out.println("3. View Personal Info");
            System.out.println("4. Return to Main Menu");
            System.out.println("Enter the number for your action:");
            option = scanner.nextInt();
            scanner.nextLine();
            processOption(option);
        } while (5 != option);
    }

    /**
     * Implemented method that process the user choice and executed the proper
     * options/output.
     *
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
