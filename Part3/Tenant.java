// Justin Villegas
import java.util.ArrayList;

public class Tenant extends User {
    private Property property;
    private Lease lease;
    private ArrayList<MaintenanceRequest> requests;

    public Tenant(int id, String name, String phone) {
        super(id, name, phone);
        this.requests = new ArrayList<>();
    }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }

    public Lease getLease() { return lease; }
    public void setLease(Lease lease) { this.lease = lease; }

    public void submitRequest(String issue) {
        if (property == null) {
            System.out.println("You aren't assigned to a property, so a request can't be submitted.");
            return;
        }
        requests.add(new MaintenanceRequest(property, issue));
        System.out.println("Maintenance request submitted.");
    }

    public ArrayList<MaintenanceRequest> getRequest() { return requests; }
}
