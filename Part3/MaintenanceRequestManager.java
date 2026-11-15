import java.util.ArrayList;
import java.util.List;
/**
 * This class keeps a list of the Maintenance Requests
 * @author Hannah Travis
 */
public class MaintenanceRequestManager {
    private List<MaintenanceRequest> requests;

    public MaintenanceRequestManager() {
        this.requests = new ArrayList<>();
    }
    
    public void addRequeset(MaintenanceRequest request){
        this.requests.add(request);
    }
    
    public List<MaintenanceRequest> getAllRequests(){
        return this.requests;
    }
    
    public List<MaintenanceRequest> requestsForStaff(Staff staff) {
        List<MaintenanceRequest> assigned = new ArrayList<>();
        for (MaintenanceRequest req : this.requests) {
            if (req.getAssignedStaff() != null && req.getAssignedStaff().equals(staff)) {
                assigned.add(req);
            }
        }
        return assigned;
    }
    
    public void displayNumberedList(List<MaintenanceRequest> list) {
        for (int i = 0; i < list.size(); i++) {
            MaintenanceRequest req = list.get(i);
            System.out.println((i + 1) + ". " + req.getIssue() + " (Status: " + req.getStatus() + ")");
        }
    }
    
    
}
