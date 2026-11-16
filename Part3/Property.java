/**
 * This class defines Property objects in the system
 * @author Justin Villegas
 * @author Edited by Connor Heck
 */
public class Property {
    private String address;
    private float rent;
    private Tenant assignedTenant;
    private boolean occupied;
    private int numBed;
    private int numBath;
    private Rent rentRecord;

    /**
     * Constructor class - sets the initial values of a property without an initial tenant
     * @param address the address of the property
     * @param rent the cost of the property's rent
     * @param occupied True/False if the property is occupied
     */
    public Property(String address, float rent, boolean occupied) {
        this.address = address;
        this.rent = rent;
        this.occupied = occupied;
    }

    /**
     * Constructor method - Used when a property has an initial tenant
     * @param address the address of the property
     * @param rent the cost of the property's rent
     * @param occupied True/False if the property is occupied
     * @param assignedTenant the tenant assigned to the property
     */
    public Property(String address, float rent, boolean occupied, Tenant assignedTenant) {
        this(address, rent, occupied);
        this.assignedTenant = assignedTenant;
    }

    /**
     * Constructor Method - Used when the property's size is supplied
     * @param address the address of the property
     * @param rent the cost of the property's rent
     * @param occupied True/False if the property is occupied
     * @param assignedTenant the tenant assigned to the property
     * @param numBed the number of bedrooms in the property
     * @param numBath the number of bathrooms in the property
     */
    public Property(String address, float rent, boolean occupied, Tenant assignedTenant,
                    int numBed, int numBath) {
        this(address, rent, occupied, assignedTenant);
        this.numBed = numBed;
        this.numBath = numBath;
    }

    /**
     * Getter method - retrieves the address of the property
     * @return address the property's address
     */
    public String getAddress() { 
        return address; 
    }
    
    /**
     * Getter method - Gets the occupied status of the property
     * @return True/False
     */
    public boolean getOccupiedStatus() { 
        return occupied; 
    }
    
    /**
     * Getter Method - retrieves the cost of rent for the property
     * @return rent the rent of the property
     */
    public float getRent() { 
        return rent; 
    }
    
    /**
     * Getter method - Retrieves the assigned tenant
     * @return retrieves the tenant assigned to the property
     */
    public Tenant getTenant() { 
        return assignedTenant; 
    }
    
    /**
     * Updates the address of the property
     * @param address the property's new address
     */
    public void setAddress(String address) { 
        this.address = address; 
    }
    
    /**
     * Updates the occupied status of a property
     * @param occupied the status of the location
     */
    public void setStatus(boolean occupied) { 
        this.occupied = occupied; 
    }
    
    /**
     * Updates the rent cost for the property
     * @param rent the updated cost
     */
    public void setRent(float rent) { 
        this.rent = rent; 
    }

    // Assigning a tenant marks the property occupied and links the tenant back to it
    /**
     * Adds a tenant to the property and updates the occupied status
     * @param tenant the tenant to be added
     */
    public void setTenant(Tenant tenant) {
        if (assignedTenant != null) assignedTenant.setProperty(null);
        this.assignedTenant = tenant;
        this.occupied = (tenant != null);
        if (tenant != null) tenant.setProperty(this);
    }
    
    /**
     * Displays the number of bed and bathrooms in the property
     */
    public void displaySize() {
        System.out.println(numBed + " bed / " + numBath + " bath");
    }

    /**
     * Updates the numbers of bed and bathrooms in the system for a property
     * @param numBed the number of bedrooms
     * @param numBath the number of bathrooms
     */
    public void setSize(int numBed, int numBath) {
        this.numBed = numBed;
        this.numBath = numBath;
    }
    
    /**
     * Sets a rent record for a property, allowing a rent object to be used for 
     * processing tenant payments
     * @param rent an object of the rent class
     */
    public void setRentRecord(Rent rent) {
        this.rentRecord = rent;
    }
    
    /**
     * Getter method - retrieves the rent object associated with the property
     * @return rentRecord the rent object for processing
     */
    public Rent getRentRecord() {
        if(rentRecord == null) {
            System.out.println("No active rent");
            return null;
        }
        else{
        return rentRecord;
        }
    }
}