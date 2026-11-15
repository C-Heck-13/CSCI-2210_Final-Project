/**
 * This class creates objects of the Rent for Managers to set and Tenants to make payments on
 * @author Connor Heck
 * Created on 11/12/26
 */
public class Rent {
    private float rentAmount;
    private float balance;
    private String dateDue;
    private Tenant tenant;

    /**
     * Constructor Class - Sets the initial values of the rent
     * @param rentAmount the total amount of rent to be paid
     * @param balance the remaining balance of the rent
     * @param dateDue the due date of the rent
     * @param tenant the tenant the rent is assigned to
     */
    public Rent(float rentAmount, float balance, String dateDue, Tenant tenant) {
        this.rentAmount = rentAmount;
        this.balance = balance;
        this.dateDue = dateDue;
        this.tenant = tenant;
    }

    /**
     * Getter method - retrieves the rent amount
     * @return rentAmount the total rent cost
     */
    public float getRentAmount() {
        return rentAmount;
    }

    /**
     * Getter method - retrieves the remaining balance of the rent
     * @return balance the remaining balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * Getter method - retrieves the due date of the rent
     * @return dateDue the due date of the rent
     */
    public String getDateDue() {
        return dateDue;
    }

    /**
     * Getter method - retrieves the assigned tenant of the rent
     * @return tenant the tenant responsible for the rent
     */
    public Tenant getTenant() {
        return tenant;
    }

    /**
     * Setter method - updates the rent amount
     * @param rentAmount the new amount for the rent
     */
    public void setRentAmount(float rentAmount) {
        this.rentAmount = rentAmount;
    }

    /**
     * This method takes a tenant's remaining rent balance, and if late, charges and applies a late
     * fee to their account
     * @param balance the current remaining balance
     * @param tenant 
     * @return
     */
    public float chargeLateFee(float balance, Tenant tenant) {
        float lateFee = rentAmount * 0.10f;
        float newBalance = balance + lateFee;
        setRentAmount(newBalance);
        System.out.printf("10 percent late fee charged to %s's account. Updated balance: %.2f\n", tenant.getName(), newBalance);
        return newBalance;
    }

    /**
     * This method processes a payment made on a rent balance.
     * @param balance the current rent balance
     * @param payment the amount being paid
     * @return newBalance the updated balance after the payment
     */
    public float makePayment(float balance, float payment) {
        float updatedBalance = balance - payment;
        System.out.printf("Payment processed. Updated balance: %.2f\n", updatedBalance);
        setRentAmount(updatedBalance);
        return updatedBalance;
    }
}
