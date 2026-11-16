import java.util.ArrayList;
/**
 * Serves as the manager class for collecting a list of tenants and performing operations
 * @author Justin Villegas
 * @author Edited by Connor Heck
 */
public class TenantManager {
    private ArrayList<Tenant> tenants;

    /**
     * Constructor method - initializes the new list of tenants
     */
    public TenantManager() { 
        tenants = new ArrayList<>(); 
    }

    /**
     * Adds a new tenant to the system list
     * @param tenant the tenant to be added 
     */
    public void addTenant(Tenant tenant) { 
        tenants.add(tenant); 
    }

    /**
     * Retruns the number of tenants in the system
     * @return the number of tenants in the list
     */
    public int getTenantCount() { 
        return tenants.size(); 
    }

    /**
     * Displays the list of active tenants in the system
     */
    public void displayTenants() {
        if (tenants.isEmpty()) {
            System.out.println("No tenants.");
            return;
        }
        for (Tenant t : tenants) {
            t.displayInfo();
            System.out.println();
        }
        System.out.println("Total tenants: " + tenants.size());
    }

    /**
     * Allows for the searching of tenant by system ID
     * @param id the system ID of the desired tenant
     * @return the tenant if they exist
     */
    public Tenant findTenant(int id) {
        for (Tenant t : tenants) {
            if (t.getID() == id) return t;
        }
        return null;
    }
    
    /**
     * retrieves the list of tenants in the system
     * @return 
     */
    public ArrayList<Tenant> getTenants() {
        return tenants;
    }
}