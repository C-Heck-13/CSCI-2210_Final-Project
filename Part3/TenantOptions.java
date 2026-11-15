// JustinVillegas
import java.util.ArrayList;
import java.util.Scanner;

public class TenantOptions {
    private final Scanner scanner;

    public TenantOptions(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createNewMaintenanceReq(Tenant tenant) {
        System.out.print("Describe the issue: ");
        String issue = scanner.nextLine().trim();
        if (issue.isEmpty()) {
            System.out.println("No issue entered.");
            return;
        }
        tenant.submitRequest(issue);
    }

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

    public void viewLease(LeaseManager leaseManager) {
        leaseManager.displayLease();
    }

    public void viewProperty(PropertyManager propertyManager, Tenant tenant) {
        if (tenant.getProperty() == null) {
            System.out.println("No property on file.");
        } else {
            propertyManager.displayProperty(tenant.getProperty());
        }
    }

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
            float newBalance = rent.makePayment(amount, rent.getBalance());
            System.out.println("Payment received. New balance: $" + newBalance);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
        }
    }

    public void customerFeedback(CustomerFeedback feedback) {
        System.out.print("Rating (1-5): ");
        try {
            int rating = Integer.parseInt(scanner.nextLine().trim());
            if (rating < 1 || rating > 5) {
                System.out.println("Rating must be 1-5.");
                return;
            }
            System.out.print("Comments: ");
            String comments = scanner.nextLine().trim();
            feedback.setRating(rating);
            feedback.setFeedback(comments);
            System.out.println("Thanks for the feedback!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid rating.");
        }
    }
}
