import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that executes the StaffOptions From StaffSubMenu
 * @author Hannah Travis
 * @author Edited by Connor Heck
 */
public class StaffOptions {
    
    private final Scanner scanner;
    private Staff staff;
    private final MaintenanceRequestManager requestManager;
    private StaffManager staffManager;

    /**
     * Constructor method - sets initial values for option processing
     * @param scanner user input scanner
     * @param staffManager manager passed for functional use
     * @param requestManager manager passed for function use
     */
    public StaffOptions(Scanner scanner, StaffManager staffManager, MaintenanceRequestManager requestManager) {
        this.scanner = scanner;
        this.staffManager = staffManager;
        this.requestManager = requestManager;
    }
    
    /**
     * Views maintenance requests assigned to specific staff members
     */
    public void viewMaintenanceReq() {
        
        ArrayList<MaintenanceRequest> myRequests = requestManager.requestsForStaff(staff);
        if (myRequests.isEmpty()) {
            System.out.println("No maintenance requests assigned to you.");
            return;
        }
        for (int i = 0; i < myRequests.size(); i++) {
            System.out.println("Request #" + (i + 1));
            myRequests.get(i).displayMaintenanceReqInfo();
        }
    }
    
    /**
     * Lets the staff member pick an assigned request and update its status
     */
    public void updateRequest() {

        ArrayList<MaintenanceRequest> myRequests = requestManager.requestsForStaff(staff);
        if (myRequests.isEmpty()) {
            System.out.println("No maintenance requests to update.");
            return;
        }
        
        requestManager.displayNumberedList(myRequests);
        System.out.print("Enter the number of the request you want to update: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > myRequests.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        MaintenanceRequest selectedRequest = myRequests.get(choice - 1);
        
        System.out.println("Current Status: " + selectedRequest.getStatus());
        System.out.print("Enter new status: ");
        String newStatus = scanner.nextLine();
        staff.updateStatus(selectedRequest, newStatus);
        System.out.println("Status updated to: " + selectedRequest.getStatus());
    }
    
    /**
     * Prints the personal information for a staff member
     */
    public void viewPersonalInfo() {
        System.out.println("=========================================");
        System.out.println("           STAFF PERSONAL INFO           ");
        System.out.println("=========================================");
        staff.displayInfo();
        System.out.println("=========================================");
    }
    
    /**
     * Assigns a staff member in a logged-in status
     * @param staff 
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}