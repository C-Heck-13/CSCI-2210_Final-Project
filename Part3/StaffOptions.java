import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
* Class that executes Staff Options from StaffSubMenu
* author: Hannah Travis
*/
public class StaffOptions {
    
    private final Scanner scanner;
    private Staff staff;
    private final List<MaintenanceRequest> allRequests;

    public StaffOptions(Scanner scanner, Staff staff, List<MaintenanceRequest> allRequests) {
        this.scanner = scanner;
        this.staff = staff;
        this.allRequests = allRequests;
    }
    
    /**
     * Views maintenance requests
     */
    public void viewMaintenanceReq() {
        List<MaintenanceRequest> myRequests = getAssignedRequests();
        if (myRequests.isEmpty()) {
            System.out.println("No maintenance requests assigned to you.");
            return;
        }
        for (int i = 0; i<myRequests.size();i++) {
            System.out.println("Request #" + (i + 1));
            myRequests.get(i).displayMaintenanceReqInfo();
        }
    }
    
    /**
     * Helper method to filter requests assigned to this staff member
     */
    private List<MaintenanceRequest> getAssignedRequests() {
        List<MaintenanceRequest> assigned = new ArrayList<>();
        if (allRequests == null) {
            return assigned;
        }
        for (MaintenanceRequest req : allRequests) {
            if (req.getAssignedStaff() != null && req.getAssignedStaff().equals(this.staff)) {
                assigned.add(req);
            }
        }
        return assigned;
    }
    
    /**
     * Lets the staff member pick an assigned request and update its status
     */
    public void updateRequest() {
        List<MaintenanceRequest> myRequests = getAssignedRequests();

        if (myRequests.isEmpty()) {
            System.out.println("No maintenance requests to update.");
            return;
        }
        for (int i = 0; i < myRequests.size(); i++) {
            MaintenanceRequest req = myRequests.get(i);
            System.out.println((i + 1) + ". " + req.getIssue() + " (Current Status: " + req.getStatus() + ")");
        }

        System.out.print("Enter the number of the request to update: ");
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
        System.out.println("Staff ID:   " + getId());
        System.out.println("Name:       " + getName());
        System.out.println("Contact:    " + getPhone());
        System.out.println("Role:       " + this.role);
        System.out.println("Supervisor: " + this.supervisor);
        System.out.println("=========================================");
    }
}
