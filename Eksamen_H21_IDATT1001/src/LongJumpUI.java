import java.util.Scanner;
import java.util.ArrayList;


/**
 * Represents the text based user interface of the application.
 * This class makes use of the Scanner-class to get input from the
 * user via the standard console.
 *
 * @author 10054
 */
public class LongJumpUI {
    /**
     * String VERSION contains information of the version of the program
     * String LS contains a line separator which changes property depending on how the operating system uses line separators
     * creates an object of class LongJumpRegister
     */
    private static final String VERSION = "v1.0-SNAPSHOT";
    private static final String LS = System.getProperty("line.separator");
    private final LongJumpRegister jumpRegister;

    private static Scanner in = new Scanner(System.in);

    /**
     * Uses a list to contain String of the menu choices presented to user
     */
    String[] menuItems
            = {
            "1. Register a long jump result",
            "2. List all results",
            "3. Show all results by a given athlete",
            "4. Show the best result",
            "5. Calculate the average result"
    };

    // Constants defining the different menu options, to be used in the
    // switch-case.
    private static final int ADD_RESULT = 1;
    private static final int LIST_ALL_RESULTS = 2;
    private static final int SHOW_RESULT_BY_ATHLETE = 3;
    private static final int SHOW_BEST_RESULT = 4;
    private static final int CALCULATE_AVERAGE_RESULT = 5;
    private static final int EXIT = 6;

    /**
     * Creates an instance of the LongJumpUI User interface.
     */
    public LongJumpUI() {
        this.jumpRegister = new LongJumpRegister();
    }

    /**
     * Test client.
     * Inputs dataset specified within the task to fill in a number of results, and checks if they
     * are added correctly
     */
    void testClient() {
        boolean ok = false;
        try {
            jumpRegister.newResult(210, "Malaika Mihambo", 6.98, false, "10:15");
            jumpRegister.newResult(211, "Tara Davis", 6.85, false, "10:17");
            jumpRegister.newResult(204, "Brittney Reese", 6.52, false, "10:19");
            jumpRegister.newResult(224, "Khaddi Sagnia", 6.76, false, "10:21");
            jumpRegister.newResult(211, "Tara Davis", 6.42, true, "10:24");
            jumpRegister.newResult(210, "Malaika Mihambo", 6.56, false, "10:30");
            jumpRegister.newResult(204, "Brittney Reese", 6.86, false, "10:34");
            jumpRegister.newResult(224, "Khaddi Sagnia", 6.65, true, "10:37");
            jumpRegister.newResult(210, "Malaika Mihambo", 6.12, false, "10:40");
            jumpRegister.newResult(222, "Sander Johansen", 6.99, false, "10:42");
            jumpRegister.newResult(269, "Håkon Bergrem", 7.0, true, "10:45");
            ok = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } if (ok) {
            System.out.println("Test succesful");
        }
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user. Continues until the user decides to exit the application.
     */
    void start() {

        boolean quit = false;

        while (!quit) {
            int menuSelection = this.getMenuChoice();
            switch (menuSelection) {
                case ADD_RESULT -> addResult();
                case LIST_ALL_RESULTS -> listResult();
                case SHOW_RESULT_BY_ATHLETE -> listResultByAthlete();
                case SHOW_BEST_RESULT -> listBestResult();
                case CALCULATE_AVERAGE_RESULT -> calcAvgResult();
                case EXIT -> {
                    System.out.println("\nThank you for using the Long Jump Application "
                            + VERSION + ". Bye!\n");
                    quit = true;
                    break;
                }
                default -> {
                    System.out.println(
                            "\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
                }
            }
        }
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items..
     * The method returns the input from the user. If the input from the user is
     * invalid, 0 is returned.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     */
    private int getMenuChoice() {
        int menuSelection = 0;

        System.out.println("\n**** Long Jump Results Tool " + VERSION + " ****\n");
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");

        Scanner reader = new Scanner(System.in);
        if (reader.hasNextInt()) {
            menuSelection = reader.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuSelection;
    }

    /**
     * Method for adding a new results.
     */
    public void addResult() {
        System.out.println("Enter starting number:");
        int startNumber = in.nextInt();
        in.nextLine();
        System.out.println("Enter name of athlete (firstname lastname):");
        String nameOfAthlete = in.nextLine();
        System.out.println("Enter result (meter):");
        double result = in.nextDouble();
        in.nextLine();
        System.out.println("Is the jump valid? (Yes or No)");
        String valid = in.nextLine();
        boolean foul = false;
        if (valid.trim().toLowerCase().equals("yes")) { // checks user input to know if boolean foul should be true or false
            foul = false;
        } else if (valid.trim().toLowerCase().equals("no")) { // checks user input to know if boolean foul should be true or false
            foul = true;
        }
        System.out.println("Enter time (hh:mm)");
        String time = in.nextLine();

        try { // try / catch while trying to add a new result. Catches errors, and prints error message
            jumpRegister.newResult(startNumber,nameOfAthlete, result, foul, time);
            System.out.println("Result was added");
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred, result not added" + LS + e);
        }
    }

    /**
     * Method for printing all results
     */
    public void listResult() {
        System.out.println(jumpRegister.print(jumpRegister.getLongJumps()));;
    }

    /**
     * Method for printing all results by one athlete
     */
    public void listResultByAthlete() {
        System.out.println("Enter name of athlete you want results of:");
        String nameOfAthlete = in.nextLine();

        System.out.println(jumpRegister.print(jumpRegister.findJumpByName(nameOfAthlete)));
    }

    /**
     * Method for printing out best result
     */
    public void listBestResult() {
        System.out.println(jumpRegister.findBestJump().toString());
    }

    /**
     * Method for printing out average result
     */
    public void calcAvgResult() {
        if (jumpRegister.getNumOfLongJumps() == 0) {
            System.out.println("There are currently no registered results. Please register results before calculating average result");
        } else {

            System.out.printf("Total area of all registered results: %.2f meters", jumpRegister.averageResult());
        }
    }

    /**
     * The main start method of the application.
     *
     * @param args Commandline arguments as an array of String
     */
    public static void main(String[] args) {
        LongJumpUI longJumpUI = new LongJumpUI();
        longJumpUI.testClient();
        longJumpUI.start();
    }

}
