import java.util.Scanner;

/**
 * This class contains the main method of the system. Its sole purpose is
 * the initialization and display of the main menu. All other functions follow
 * from there.
 * @author Connor Heck
 * Created on 11/3/26
 */
public class PropertyManagementSystem {

    /**
     * The sole purpose of the main method in this system is to execute and display 
     * the main menu. All other functions follow from there.
     * @param args Command line arguments not used
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MainMenu mainMenu = new MainMenu(scanner);

        mainMenu.showMenu();

        scanner.close();
    }
    
}
