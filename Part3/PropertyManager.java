// Justin Villegas
import java.util.ArrayList;

public class PropertyManager {
    private ArrayList<Property> properties;

    public PropertyManager() { properties = new ArrayList<>(); }

    public void addProperty(Property property) { properties.add(property); }

    public void displayProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties.");
            return;
        }
        for (Property p : properties) {
            displayProperty(p);
            System.out.println();
        }
    }

    // Added: prints one property (used by displayProperties and by tenants)
    public void displayProperty(Property p) {
        System.out.println("Address: " + p.getAddress());
        System.out.print("Size: ");
        p.displaySize();
        System.out.println("Rent: $" + p.getRent());
        System.out.println("Occupied: " + (p.getOccupiedStatus() ? "Yes" : "No"));
        if (p.getTenant() != null) {
            System.out.println("Tenant: " + p.getTenant().getName());
        }
    }

    // Added: lets Manager/Tenant code look a property up by address
    public Property findProperty(String address) {
        for (Property p : properties) {
            if (p.getAddress().equalsIgnoreCase(address)) return p;
        }
        return null;
    }
}
