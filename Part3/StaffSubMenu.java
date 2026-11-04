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
        do{
            System.out.println("1. View Aviable Maintenance Requests");
            System.out.println("2. View Assigned Maintenance Requests");
            System.out.println("3. Update Assigned Maintenance Requests");
            System.out.println("4. View Personal Info");
            System.out.println("5. Return to Main Menu");
            System.out.println("Enter the number for your action:");       
            option = scanner.nextInt();
            scanner.nextLine();
            processOption(option);
        } while (5 != option);
    }

    /**
     * Implemented method that process the user choice and executed the proper
     * options/output.
     * @param option int value that holds user input, from display options method
     */
    @Override
    public void processOption(int option) {
        switch (option) {
            case 1:
                staffOptions.AviableMaintenanceReq();
                break;
            case 2:
                staffOptions.AssignedMaintenanceReq();
                break;
            case 3:
                staffOptions.UpdateMaintenanceReq();
                break;
            case 4:
                staffOptions.viewPersonalInfo();
                break;
            case 5:
                break;
            default:
                System.out.print("Invalid option. Please try again.");
                showMenu();
                break;
        }
    }
}
