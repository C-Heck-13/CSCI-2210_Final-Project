// Justin Villegas
import java.util.ArrayList;

public class TenantManager {
    private ArrayList<Tenant> tenants;

    public TenantManager() { tenants = new ArrayList<>(); }

    public void addTenant(Tenant tenant) { tenants.add(tenant); }

    public int getTenantCount() { return tenants.size(); }

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

    public Tenant findTenant(int id) {
        for (Tenant t : tenants) {
            if (t.getID() == id) return t;
        }
        return null;
    }
}
