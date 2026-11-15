// Justin Villegas
import java.time.LocalDate;
import java.util.ArrayList;

public class Tenant extends User {
    private String email;
    private Property property;
    private Lease lease;
    private ArrayList<MaintenanceRequest> requests;

    public Tenant(int id, String name, String phone) {
        super(id, name, phone);
        this.email = "";
        this.requests = new ArrayList<>();
    }

    // Used by ManagerOptions.createNewLease, which also collects an email
    public Tenant(int id, String name, String phone, String email) {
        this(id, name, phone);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }

    public Lease getLease() { return lease; }
    public void setLease(Lease lease) { this.lease = lease; }

    
    public MaintenanceRequest submitRequest(String issue) {
        if (property == null) {
            System.out.println("You aren't assigned to a property, so a request can't be submitted.");
            return null;
        }
        MaintenanceRequest request = new MaintenanceRequest(
                property, LocalDate.now().toString(), "Submitted", issue);
        requests.add(request);
        System.out.println("Maintenance request submitted.");
        return request;
    }

    public ArrayList<MaintenanceRequest> getRequest() { return requests; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Email: " + email);
    }
}
