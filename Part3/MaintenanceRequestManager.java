import java.util.ArrayList;
import java.util.List;
/**
 * This class keeps a list of the Maintenance Requests
 * @author Hannah Travis
 * @author Edited by Connor Heck
 */
public class MaintenanceRequestManager {
    private ArrayList<MaintenanceRequest> requests;

    /**
     * Constructor method - initializes array list for mx requests
     */
    public MaintenanceRequestManager() {
        requests = new ArrayList<>();
    }
    
    /**
     * Adds a new request to the system list
     * @param request 
     */
    public void addRequeset(MaintenanceRequest request){
        this.requests.add(request);
    }
    
    /**
     * Retrieves the list of all active mx requests
     * @return 
     */
    public ArrayList<MaintenanceRequest> getAllRequests(){
        return requests;
    }
    
    /**
     * Retrieves the mx requests for a particular staff member
     * @param staff the staff member to search for requests for
     * @return assigned the list of requests assigned to them
     */
    public ArrayList<MaintenanceRequest> requestsForStaff(Staff staff) {
        ArrayList<MaintenanceRequest> assigned = new ArrayList<>();
        for (MaintenanceRequest req : requests) {
            if (req.getAssignedStaff() != null && req.getAssignedStaff().equals(staff)) {
                assigned.add(req);
            }
        }
        return assigned;
    }
    
    /**
     * Displays a numbered list of mx requests
     * @param list the list of requests to number
     */
    public void displayNumberedList(List<MaintenanceRequest> list) {
        for (int i = 0; i < list.size(); i++) {
            MaintenanceRequest req = list.get(i);
            System.out.println((i + 1) + ". " + req.getIssue() + " (Status: " + req.getStatus() + ")");
        }
    }
}