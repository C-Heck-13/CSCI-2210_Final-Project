import java.util.Scanner;

public class TenantSubMenu {

    private Tenant tenant;
    private TenantOptions tenantOptions;
    private final Scanner scanner;

    public TenantSubMenu(Scanner scanner) {
        this.scanner = scanner;
        this.tenantOptions = new TenantOptions(scanner);
    }

    // MainMenu calls this after login so the submenu knows who is logged in
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void displayMenu() {
        System.out.println("\n===== Tenant Menu =====");
        System.out.println(" Submit maintenance request");
        System.out.println(" View maintenance requests");
        System.out.println(" View lease");
        System.out.println(" View property");
        System.out.println(" Pay rent");
        System.out.println(" Leave feedback");
        System.out.println(" Log out");
        System.out.print("Choose an option: ");
    }
}