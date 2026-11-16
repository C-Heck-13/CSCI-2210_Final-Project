import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class processes the selection from the tenant submenu
 * @author Justin Villegas
 * @author Edited by Connor Heck
 */
public class TenantOptions {
    private final Scanner scanner;
    private CustomerFeedbackManager customerFeedbackManager;
    private MaintenanceRequestManager maintenanceRequestManager;

    /**
     * Constructor Method - sets the initial values of the class
     * @param scanner user input value
     * @param customerFeedbackManager manager passed for function use
     * @param maintenanceRequestManager manager passed for function use
     */
    public TenantOptions(Scanner scanner, CustomerFeedbackManager customerFeedbackManager, MaintenanceRequestManager maintenanceRequestManager) {
        this.scanner = scanner;
        this.customerFeedbackManager = customerFeedbackManager;
        this.maintenanceRequestManager = maintenanceRequestManager;
    }

    /**
     * Allows a tenant to create a new maintenance request
     * @param tenant the tenant associated with the request
     */
    public void createNewMaintenanceReq(Tenant tenant) {
        System.out.print("Today's Date: ");
        String date = scanner.nextLine();
        System.out.println("");
        System.out.print("Describe the issue: ");
        String issue = scanner.nextLine().trim();
        if (issue.isEmpty()) {
            System.out.println("No issue entered.");
            return;
        }
        
        MaintenanceRequest request = tenant.submitRequest(date, issue);
        
        if(request != null) {
            maintenanceRequestManager.addRequeset(request);
        }
    }

    /**
     * Displays the active maintenance requests associated with a tenant
     * @param tenant the tenant to look up the requests for
     */
    public void viewMaintenanceReq(Tenant tenant) {
        ArrayList<MaintenanceRequest> list = tenant.getRequest();
        if (list.isEmpty()) {
            System.out.println("No maintenance requests.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\n#" + (i + 1));
            list.get(i).displayMaintenanceReqInfo();
        }
    }

    /**
     * Prints the lease for the tenant
     * @param tenant the tenant to look up a lease for
     */
    public void viewLease(Tenant tenant) {
        if(tenant.getLease() == null) {
            System.out.println("No lease on file");
        }
        else{
        tenant.getLease().generateLease();
        }
    }

    /**
     * Displays the property the tenant is associated with
     * @param propertyManager manager that allows the lookup of a property
     * @param tenant the tenant to search for their property
     */
    public void viewProperty(PropertyManager propertyManager, Tenant tenant) {
        if (tenant.getProperty() == null) {
            System.out.println("No property on file.");
        } else {
            propertyManager.displayProperty(tenant.getProperty());
        }
    }

    /**
     * Allows the tenant to make a payment on their rent
     * @param rent an object of Rent class - the tenant's rent file
     */
    public void payRent(Rent rent) {
        System.out.println("Balance due: $" + rent.getBalance());
        if (rent.getBalance() <= 0) {
            System.out.println("Nothing to pay.");
            return;
        }
        System.out.print("Payment amount: $");
        try {
            float amount = Float.parseFloat(scanner.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Enter an amount above 0.");
                return;
            }
            float newBalance = rent.makePayment(rent.getBalance(), amount);
            System.out.println("Payment received. New balance: $" + newBalance);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
        }
    }

    /**
     * Allows the tenant to create a new feedback submission
     */
    public void customerFeedback() {
        
        System.out.print("Rating (1-5): ");
        try {
            int rating = Integer.parseInt(scanner.nextLine().trim());
            if (rating < 1 || rating > 5) {
                System.out.println("Rating must be 1-5.");
                return;
            }
            System.out.print("Comments: ");
            String comments = scanner.nextLine().trim();
            customerFeedbackManager.addFeedback(new CustomerFeedback(rating, comments));
            System.out.println("Thanks for the feedback!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid rating.");
        }
    }
}