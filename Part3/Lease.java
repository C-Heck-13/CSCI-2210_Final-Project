/**
 * Class that defines leases
 * @author Hannah Travis
 * @author Edited by Connor Heck
 */
public class Lease {
    private Manager manager;
    private Tenant tenant;
    private String otherOccupants;
    private Property address;
    private int term;
    private int securityDeposit;

    
    /**
     * Constructor to initalize starting values
     * @param manager, gets manager name
     * @param tenant, gets the tenant name
     * @param otherOccupants, gets other occupants
     * @param address, gets the address
     * @param term , gets the number of months for term
     */
    public Lease(Manager manager, Tenant tenant, String otherOccupants, Property address, int term) {
        this.manager = manager;
        this.tenant = tenant;
        this.otherOccupants = otherOccupants;
        this.address = address;
        this.term = term;
    }
    
    /**
     * Method to generate lease text
     */
    public void generateLease(){
        System.out.println("=========================================");
        System.out.println("           RESIDENT LEASE                ");
        System.out.println("=========================================");
        System.out.println("Property Address: " + this.address.getAddress());
        System.out.println("Property Manager: " + this.manager.getName());
        System.out.println("Primary Tenant: " + this.tenant.getName());
        System.out.println("Other Occupants: " + this.otherOccupants);
        System.out.println("Lease Term: " + this.term + " months");
        System.out.println("Security Deposit: $" + this.securityDeposit);
        System.out.println("=========================================");
    }

    /**
     * Gets the String of other Occupants
     * @return 
     */
    public String getOtherOccupants() {
        return otherOccupants;
    }

    /**
     * Gets the address for the property 
     * @return 
     */
    public Property getAddress() {
        return address;
    }

    /**
     * gets the int value for term, int will represent the number of months
     * @return 
     */
    public int getTerm() {
        return term;
    }

    /**
     * Gets the int value for security deposit
     * @return 
     */
    public int getSecurityDeposit() {
        return securityDeposit;
    }

    /**
     * Sets the String of other occupants
     * @param OtherOccupants 
     */
    public void setOtherOccupants(String OtherOccupants) {
        this.otherOccupants = OtherOccupants;
    }

    /**
     * Sets the property address
     * @param address 
     */
    public void setAddress(Property address) {
        this.address = address;
    }

    /**
     * Sets the int value for term. int is months
     * @param term 
     */
    public void setTerm(int term) {
        this.term = term;
    }

    /**
     * Sets the inital security deposit value
     * @param securityDeposit 
     */
    public void setSecurityDeposit(int securityDeposit) {
        this.securityDeposit = securityDeposit;
    }
      
}