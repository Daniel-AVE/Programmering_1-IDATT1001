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
    private final int FIND_PROPERTY_BY_LOT_NUMBER = 6;
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
                case FIND_PROPERTY_BY_LOT_NUMBER -> findPropertyByLotNum();
                case CHANGE_OWNER -> changeOwner();
                case EXIT -> exit();
                default -> {
                    System.out.println("Unrecognized menu selected, please input a number between 1-8.");
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
                "8. Cancel";
        System.out.println("\n***** Property Register Application v0.1 *****\n" + menu + "\nPlease enter a number between 1-8");

        if (in.hasNextInt()) {
            menuChoice = in.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }

    public void addProperty() {
        System.out.println("Municipality name:");
        String munName = in.nextLine();
        System.out.println("Municipality number:");
        int munNum = in.nextInt();
        System.out.println("Lot number:");
        int lotNum = in.nextInt();
        System.out.println("Section number:");
        int secNum = in.nextInt();
        System.out.println("Lot name (If no lot name, press enter):");
        String lotName = in.nextLine();
        System.out.println("Area (m2):");
        double area = in.nextDouble();
        System.out.println("Name of owner:");
        String nameOfOwner = in.nextLine();

        try {
            reg.newProperty(munName, munNum, lotNum, secNum, lotName, area, nameOfOwner);
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred, property not registered");
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
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred, property not deleted");
        }
    }

    public void listProperties() {
        System.out.println(reg.allProperties());
    }

    public void searchProperty() {
        System.out.println("Municipality number:");
        int munNum = in.nextInt();
        System.out.println("Lot number:");
        int lotNum = in.nextInt();
        System.out.println("Section number:");
        int secNum = in.nextInt();

        try {
            reg.findProperty(munNum, lotNum, secNum);
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred, property not found");
        }
    }

}
