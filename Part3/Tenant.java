// Justin Villegas
import java.time.LocalDate;
import java.util.ArrayList;

public class Tenant {
    private int id;
    private String name;
    private String phone;
    private String email;
    private Property property;
    private ArrayList<MaintenanceRequest> requests;

    public Tenant(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.requests = new ArrayList<>();
    }

    public int getID() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setID(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    // The property this tenant lives in (set by Property.setTenant)
    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }

    public void submitRequest(String issue) {
        if (property == null) {
            System.out.println("You aren't assigned to a property, so a request can't be submitted.");
            return;
        }
        requests.add(new MaintenanceRequest(property, LocalDate.now().toString(), issue));
        System.out.println("Maintenance request submitted.");
    }

    public ArrayList<MaintenanceRequest> getRequest() { return requests; }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}
