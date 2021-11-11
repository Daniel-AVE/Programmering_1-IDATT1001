package PropertyRegister;

import java.util.*;

/**
 * Client for property
 * @author Daniel Evensen
 */

public class Client {
    /**
     * Defining variables for client
     * LS is a line separator which follows the line separator behavior of the OS which is running the program
     * Scanner to be used for reading user inputs
     * Creates a new object of class PropertyRegister
     * private final integers are variables to be used in menu interface
     */
    private static final String LS = System.getProperty("line.separator");
    private static Scanner in = new Scanner(System.in);

    PropertyRegister reg = new PropertyRegister();

    private final int ADD_PROPERTY = 1;
    private final int REMOVE_PROPERTY = 2;
    private final int LIST_ALL_PROPERTIES = 3;
    private final int FIND_PROPERTY = 4;
    private final int CALCULATE_AVERAGE_AREA = 5;
    private final int FIND_PROPERTIES_BY_LOT_NUMBER = 6;
    private final int CHANGE_OWNER = 7;
    private final int EXIT = 8;

    /**
     * main method for this program
     * Creates a new object of class client. Helps to not make object static, and makes it easier to work with following
     * methods without having to reference object created from PropertyRegister in every method
     * @param args args
     */
    public static void main(String[] args) {
        Client c = new Client();

        c.testClient();
        c.start();
    }

    /**
     * Testclient for data values. Defines a boolean "ok" and sets it to false
     * Tries to register a few objects within arraylist. If no illegal arguments are detected, it sets ok to true
     * Catches illegal arguments, and lets user know by printing out error message
     * if ok = true, lets user know that test was succesful
     */
    public void testClient() {
        boolean ok = false;
        try {
            reg.newProperty("Gloppen", 1445, 77, 631, "", 1017.6, "Jens Olsen");
            reg.newProperty("Gloppen", 1445, 77, 131, "Syningom", 661.3, "Nicolay Madsen");
            reg.newProperty("Gloppen", 1445, 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
            reg.newProperty("Gloppen", 1445, 74, 188, "", 1457.2, "Karl Ove Bråten");
            reg.newProperty("Gloppen", 1445, 69, 47, "Høiberg", 1339.4, "Elsa Indregård");
            ok = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } if (ok) {
            System.out.println("Test succesful");
        }
    }

    /**
     * Method for starting the program. Creates a boolean finished to be used for a controlled while loop.
     * While loop keeps looping until boolean finished is set to true
     * Uses values from showMenu method in an enhanced switch case, where it connects to other methods, depending on
     * what user wants.
     * If case = exit, boolean "finished" is set to true, and while loop is exited.
     * Lets user know if wrong argument is used
     */
    public void start() {
        boolean finished = false;

        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case ADD_PROPERTY -> addProperty();
                case REMOVE_PROPERTY -> removeProperty();
                case LIST_ALL_PROPERTIES -> listProperties();
                case FIND_PROPERTY -> searchProperty();
                case CALCULATE_AVERAGE_AREA -> calcAvgArea();
                case FIND_PROPERTIES_BY_LOT_NUMBER -> findPropertiesByLotNum();
                case CHANGE_OWNER -> changeOwner();
                case EXIT -> {
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                }
                default -> {
                    System.out.println("Unrecognized menu selected, please input a number between 1-8.");
                    break;
                }
            }
        }
    }

    /**
     * Method containing menu interface for user. Menu interface is contained in one string, instead of multiple prints,
     * and uses line separators to keep them on a new line.
     * Uses if statement to check if an integer was registered. If so, it defines that registered integer as the value of
     * menuChoice. If anything other than an integer was detected, it lets user know to input a number
     * @return returns user input value as a stored integer
     */
    private int showMenu() {
        int menuChoice = 0;
        String menu =
                "1. Add property" + LS +
                "2. Remove a property" + LS +
                "3. List all properties" + LS +
                "4. Search for property" + LS +
                "5. Calculate average area of properties" + LS +
                "6. Find properties with a lot number" + LS +
                "7. Change owner of property" + LS +
                "8. Exit";
        System.out.println("\n***** Property Register Application v0.1 *****\n" + menu + "\nPlease enter a number between 1-8");

        if (in.hasNextInt()) {
            menuChoice = in.nextInt();
        } else {
            System.out.println("You must enter a number, not text");

        }
        return menuChoice;
    }

    /**
     * Method for adding property to the register.
     * Standalone "in.nextLine()"s are there to consume newline left-overs, or the program would skip taking user input
     * for a string coming right after reading an integer input.
     * Uses try catch method to check the inputs for any defined illegal arguments. If not found, the property is added.
     * If illegal argument is found, it lets user know the property was not registered, and prints the illegal argument it catched.
     */
    public void addProperty() {
        in.nextLine();
        System.out.println("Municipality name:");
        String munName = in.nextLine();
        System.out.println("Municipality number:");
        int munNum = in.nextInt();
        System.out.println("Lot number:");
        int lotNum = in.nextInt();
        System.out.println("Section number:");
        int secNum = in.nextInt();
        in.nextLine();
        System.out.println("Lot name (If no lot name, press enter):");
        String lotName = in.nextLine();
        System.out.println("Area (m2):");
        double area = in.nextDouble();
        in.nextLine();
        System.out.println("Name of owner:");
        String nameOfOwner = in.nextLine();

        try {
            reg.newProperty(munName, munNum, lotNum, secNum, lotName, area, nameOfOwner);
            System.out.println("Property was registered");
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect values input, property not registered" + LS + e);
        }
    }

    /**
     * Method for removing an object from the arraylist. Uses property id to find the property to remove, and continues
     * to a try-catch statement. If any illegal arguments are found, it lets user know. If not found, it removes the
     * property from the arraylist
     */
    public void removeProperty() {
        System.out.println("Municipality number:");
        int munNum = in.nextInt();
        System.out.println("Lot number:");
        int lotNum = in.nextInt();
        System.out.println("Section number:");
        int secNum = in.nextInt();

        try {
            reg.removeProperty(munNum, lotNum, secNum);
            System.out.println("Property was deleted");
        } catch (IllegalArgumentException e) {
            System.out.println("Property not found, please check if your input values are correct" + LS + e);
        }
    }

    /**
     * Method for printing out all properties. References the getProperties() method from PropertyRegister in a print() method
     */
    public void listProperties() {
        print(reg.getProperties());
    }

    /**
     * Method for searching for a property. Uses property id to look for matches in arraylist.
     * Uses try-catch method to look for any illegal arguments. If found, lets user know. If not found, prints said property
     */
    public void searchProperty() {
        System.out.println("Municipality number:");
        int munNum = in.nextInt();
        System.out.println("Lot number:");
        int lotNum = in.nextInt();
        System.out.println("Section number:");
        int secNum = in.nextInt();

        try {
            print(reg.findProperty(munNum, lotNum, secNum));
        } catch (IllegalArgumentException e) {
            System.out.println("Couldn't find property, please check that your input values are correct" + LS + e);
        }
    }

    /**
     * Method for calculating average area of all properties.
     * Checks to see if arraylist has any objects stored. If it does, it prints out average area. If not found, it let's user
     * know there are no properties registered
     */
    public void calcAvgArea() {
        if (reg.getNumOfProperties() == 0) {
            System.out.println("There are currently no registered properties. Please register a property before calculating average area");
        } else {
            System.out.println("Total area of all registered properties: " + reg.averageArea() + " m2");
        }
    }

    /**
     * Method for finding all properties with a specific lot number.
     * If no illegal arguments are found, it prints a list of all properties found with the lot number.
     * If illegal arguments are found, it lets user know
     */
    public void findPropertiesByLotNum() {
        System.out.println("Enter lot number");
        int lotNum = in.nextInt();
        try {
            print(reg.findPropertiesByLotNum(lotNum));
        } catch (IllegalArgumentException e) {
            System.out.println("Lot number must be a positive number!" + LS + e);
        }
    }

    /**
     * Method for changing owner of a property. Uses property id to find matching property.
     * Tries to executed method for changing owner with given variables, if any illegal arguments are found,
     * it doesn't change owner, and let's user know.
     */
    public void changeOwner() {
        System.out.println("Municipality number:");
        int munNum = in.nextInt();
        System.out.println("Lot number:");
        int lotNum = in.nextInt();
        System.out.println("Section number:");
        int secNum = in.nextInt();
        in.nextLine();
        System.out.println("Name of new owner:");
        String newOwner = in.nextLine();

        try {
            reg.changeOwner(munNum, lotNum, secNum, newOwner);
        } catch (IllegalArgumentException e) {
            System.out.println("Couldn't find property, please check that your input values are correct!" + LS + e);
        }
    }

    /**
     * Method for printing. References class Property, and creates a new arraylist as an object of that class.
     * If the size of new arraylist is empty, it lets user know. If arraylist is not empty, it uses an enhanced for loop
     * to iterate through each Property property in arraylist list, and uses toString from Property to print out information
     * for each iteration
     * @param list
     */
    public void print(ArrayList<Property> list) {
        if (list.size() <= 0) {
            System.out.println(LS +"There are currently no properties registered");
        } else {
            System.out.println(LS + "Properties:");
            for (Property property : list) {
                System.out.println(property.toString());
            }
        }
    }
}
