// Justin Villegas
public class Property {
    private String address;
    private float rent;
    private Tenant assignedTenant;
    private boolean occupied;
    private int numBed;
    private int numBath;

    public Property(String address, float rent, boolean occupied) {
        this.address = address;
        this.rent = rent;
        this.occupied = occupied;
    }

    public Property(String address, float rent, boolean occupied, Tenant assignedTenant) {
        this(address, rent, occupied);
        this.assignedTenant = assignedTenant;
    }

    public Property(String address, float rent, boolean occupied, Tenant assignedTenant,
                    int numBed, int numBath) {
        this(address, rent, occupied, assignedTenant);
        this.numBed = numBed;
        this.numBath = numBath;
    }

    public String getAddress() { return address; }
    public boolean getOccupiedStatus() { return occupied; }
    public float getRent() { return rent; }
    public Tenant getTenant() { return assignedTenant; }

    public void setAddress(String address) { this.address = address; }
    public void setStatus(boolean occupied) { this.occupied = occupied; }
    public void setRent(float rent) { this.rent = rent; }

    // Assigning a tenant marks the property occupied and links the tenant back to it
    public void setTenant(Tenant tenant) {
        if (assignedTenant != null) assignedTenant.setProperty(null);
        this.assignedTenant = tenant;
        this.occupied = (tenant != null);
        if (tenant != null) tenant.setProperty(this);
    }

    public void displaySize() {
        System.out.println(numBed + " bed / " + numBath + " bath");
    }

    public void setSize(int numBed, int numBath) {
        this.numBed = numBed;
        this.numBath = numBath;
    }
}
