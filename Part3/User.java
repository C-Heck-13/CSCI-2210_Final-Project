/**
 * This class establishes the base properties of system users. Expanded on by
 * Manager, Staff, and Tenant subclasses.
 * @author connor.heck
 */
public class User {
    private int id;
    private String name;
    private String phone;
    
    /**
     * Constructor method. Sets the initial values of the user in the system.
     * @param id the system ID number for the user
     * @param name the user's name
     * @param phone  the user's phone number
     */
    public User(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    
    /**
     * Getter method - retrieves the user's ID
     * @return id the ID of the user
     */
    public int getID() {
        return id;
    }

    /**
     * Getter method - retrieves the user's name
     * @return name the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method - retrieves the user's phone number
     * @return phone the phone number of the user
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter method - sets the ID number of the user
     * @param id the updated ID number of the user
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Setter method - sets the name of the user
     * @param name the updated name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method - sets the phone number of the user
     * @param phone the updated phone number of the user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * This method prints the user's information
     */
    public void displayInfo() {
        System.out.println("System ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Phone Number: " + getPhone());
    }
}
