import java.util.ArrayList;
import java.util.List;
/**
* Class that manages Leases defined in Lease Class
* author: Hannah Travis
*/
public class LeaseManager {
    private List<Leases> leases;

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
    public void addLease(Leases lease) {
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
        for (Leases lease : leases) {
            lease.generateLease();
        }
    }
    
}
