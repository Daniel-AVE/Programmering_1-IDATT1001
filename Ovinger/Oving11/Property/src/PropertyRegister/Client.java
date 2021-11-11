package PropertyRegister;

import java.util.*;

/**
 * Client for property
 * @author Daniel Evensen
 */

public class Client {
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


    public static void main(String[] args) {
        Client c = new Client();

        c.testClient();
        c.start();
    }

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

    public void listProperties() {
        print(reg.getProperties());
    }

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

    public void calcAvgArea() {
        if (reg.getNumOfProperties() == 0) {
            System.out.println("There are currently no registered properties. Please register a property before calculating average area");
        } else {
            System.out.println("Total area of all registered properties: " + reg.averageArea() + " m2");
        }
    }

    public void findPropertiesByLotNum() {
        System.out.println("Enter lot number");
        int lotNum = in.nextInt();
        try {
            print(reg.findPropertiesByLotNum(lotNum));
        } catch (IllegalArgumentException e) {
            System.out.println("Lot number must be a positive number!" + LS + e);
        }
    }

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
