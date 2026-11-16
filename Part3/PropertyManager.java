import java.util.ArrayList;
/**
 * This class serves as a manager class for the properties in the system
 * @author Justin Villegas
 * @author Edited by Connor Heck
 */
public class PropertyManager {
    
    private ArrayList<Property> properties;

    /**
     * Constructor method - initializes the new list for properties
     */
    public PropertyManager() { 
        properties = new ArrayList<>(); 
    }

    /**
     * Adds a new property to the system list
     * @param property the property to be added
     */
    public void addProperty(Property property) { 
        properties.add(property); 
    }

    /**
     * Displays the list of active properties
     */
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

    /**
     * Displays a single property from the list
     * @param p the property to be added
     */
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
    /**
     * Allows for the lookup of a property by address
     * @param address the desired address to search for
     * @return the property, if it exists
     */
    public Property findProperty(String address) {
        for (Property p : properties) {
            if (p.getAddress().equalsIgnoreCase(address)) return p;
        }
        return null;
    }
}