import java.util.ArrayList;
/**
 * This class defines objects of Tenants in the system
 * @author Justin Villegas
 * @author Edited by Connor Heck
 */
public class Tenant extends User {
    private Property property;
    private Lease lease;
    private ArrayList<MaintenanceRequest> requests;
    private String email;

    /**
     * Constructor method - Sets the initial values of the Tenant
     * @param id the system ID of the Tenant
     * @param name the tenant's name
     * @param phone the tenant's phone number
     * @param email the tenant's email
     */
    public Tenant(int id, String name, String phone, String email) {
        super(id, name, phone);
        this.email = email;
        this.requests = new ArrayList<>();
    }

    /**
     * Retrieves the property the tenant is assigned to
     * @return property the tenant's property
     */
    public Property getProperty() { 
        return property; 
    }
    
    /**
     * Updates the tenant's property
     * @param property the updated property
     */
    public void setProperty(Property property) { 
        this.property = property; 
    }

    /**
     * Retrieves the tenant's lease
     * @return lease the tenant's lease
     */
    public Lease getLease() { 
        return lease; 
    }
    
    /**
     * updates the lease assigned to the tenant
     * @param lease the updated lease
     */
    public void setLease(Lease lease) { 
        this.lease = lease; 
    }
    
    /**
     * Retrieves the tenant's email
     * @return email the tenant's email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Allows the tenant to submit a new maintenance request
     * @param date the date of the request's submission
     * @param issue the problem experienced by the tenant
     * @return newRequest a new request to be processed by the system
     */
    public MaintenanceRequest submitRequest(String date, String issue) {
        if (property == null) {
            System.out.println("You aren't assigned to a property, so a request can't be submitted.");
            return null;
        }
        MaintenanceRequest newRequest = new MaintenanceRequest(property, date, "incomplete", issue);
        requests.add(newRequest);
        System.out.println("Maintenance request submitted.");
        return newRequest;
    }

    /**
     * Retrieves a list of the tenant's active Mx requests
     * @return 
     */
    public ArrayList<MaintenanceRequest> getRequest() { 
        return requests; 
    }
}