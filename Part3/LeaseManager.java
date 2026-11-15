import java.util.ArrayList;
import java.util.List;
/**
 * Class to manage all leases
 * @author Hannah Travis
 */
public class LeaseManager {
    private List<Lease> leases;

    /**
     * Constructor to initialize the list of leases
     */
    public LeaseManager() {
        this.leases = new ArrayList<>();
    }
    
    /**
     * Adds a Lease object to the manager's list
     * @param lease the Lease to add
     */
    public void addLease(Lease lease) {
        leases.add(lease);
    }
     
    /**
     * Displays all leases stored in the manager
     */
    public void displayLease() {
        if (leases.isEmpty()) {
            System.out.println("No leases to display.");
            return;
        }
        for (Lease l : leases) {
            l.generateLease();
        }
    }
    
}
