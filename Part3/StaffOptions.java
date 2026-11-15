import java.util.List;
import java.util.Scanner;

/**
 * Class that executes the StaffOptions From StaffSubMenu
 * @author Hannah Travis
 */
public class StaffOptions {
    
    private final Scanner scanner;
    private Staff staff;
    private final MaintenanceRequestManager requestManager;

    public StaffOptions(Scanner scanner, Staff staff,MaintenanceRequestManager requestManager) {
        this.scanner = scanner;
        this.staff = staff;
        this.requestManager = requestManager;
    }
    
    /**
     * Views maintenance requests assigned to specific staff members
     */
    public void viewMaintenanceReq() {
        List<MaintenanceRequest> myRequests = requestManager.requestsForStaff(this.staff);
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
        List<MaintenanceRequest> myRequests = requestManager.requestsForStaff(this.staff);
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
        this.staff.updateStatus(selectedRequest, newStatus);
        System.out.println("Status updated to: " + selectedRequest.getStatus());
    }
    
    
    public void viewPersonalInfo() {
        System.out.println("=========================================");
        System.out.println("           STAFF PERSONAL INFO           ");
        System.out.println("=========================================");
        this.staff.displayInfo();
        System.out.println("=========================================");
    }
}
