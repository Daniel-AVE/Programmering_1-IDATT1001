import java.util.*;

public class Client {
    public static void main(String[] args) {
        MenuRegister m = new MenuRegister(); // object created from MenuRegister class

        testClient(m); // adds a preset of dishes, to make sure everything works

        boolean done = false; // default value to make while loop more controlled

        while (!done) { // infinite loop
            showMenu(m);
        }
    }

    public static void testClient(MenuRegister m) {
        boolean ok = false;

        try {
            m.newDish("Scones", "Appetizer", 50, "https://www.matprat.no/oppskrifter/gjester/fine-scones/");
            m.newDish("Garlic Bread", "Appetizer", 70, "https://meny.no/oppskrifter/Bakst/Brod/hjemmelaget-hvitloksbrod/");
            m.newDish("Tomato Soup", "Appetizer", 60, "https://meny.no/oppskrifter/Supper/Hjemmelaget-tomatsuppe/");
            m.newDish("Pancakes", "Main course", 140, "https://www.matprat.no/oppskrifter/familien/pannekaker/");
            m.newDish("Spaghetti Bolognese", "Main course", 160, "https://www.matprat.no/oppskrifter/familien/spagetti-bolognese/");
            m.newDish("Burger and fries", "Main course", 180, "https://www.matoppskrift.no/oppskrift/hjemmelagd-hamburger-med-pommes-frites");
            m.newDish("Vanilla Ice Cream", "Dessert", 90, "https://www.tine.no/oppskrifter/desserter/is-og-sorbet/hjemmelaget-vaniljeis");
            m.newDish("Crépe", "Dessert", 95, "https://meny.no/oppskrifter/Pannekaker/crepes-med-nutella/");
            m.newDish("Banana Split", "Dessert", 80, "https://www.tine.no/oppskrifter/desserter/frukt-og-bar/banansplitt-med-bringeb%C3%A6rsaus");
            ok = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } if (ok) {
            System.out.println("Test succesfull");
        }
    }

    /**
     * Method which contains menubased interface
     * @param m references object m
     */
    public static void showMenu(MenuRegister m) {
        Scanner in = new Scanner(System.in);
        String LS = System.getProperty("line.separator"); // OS dependent line separator
        String menuChoices = "\nPress 1 to register a new dish." + LS + "Press 2 to search for a dish using a name." + LS + "Press 3 to find all dishes of one type." +
                LS + "Press 4 to register a new menu." + LS + "Press 5 to find all menus within a price range." + LS + "Press 6 to cancel."; // String with choices, instead of 6 lines with sout
        System.out.println(menuChoices);

        int menuInput = in.nextInt();

        switch(menuInput) { // enhanced switch case
            case 1 -> newDish(m);
            case 2 -> findDishByName(m);
            case 3 -> findDishByType(m);
            case 4 -> newMenu(m);
            case 5 -> findMenuWithinPriceRange(m);
            case 6 -> Cancel(m);
            default -> { // {} brackets to add multiple lines to an enhanced switch case. Loops back to menu if user enters a number outside of scope.
                System.out.println("You need to press a number between 1 and 6!");
                showMenu(m);
                break;
            }
        }
    }

    /**
     * Method for creating a new dish
     * @param m references object m
     */
    public static void newDish(MenuRegister m) {
        Scanner in = new Scanner(System.in);
        System.out.println("Name: ");
        String name = in.nextLine();
        if (m.getDishByName(name).size() > 0) { // checks to see if there's an existing dish with same name
            System.out.println("There's already a dish with that name");
        } else { // if not, continue
            System.out.println("Type: ");
            String type = in.nextLine();

            System.out.println("Price: ");
            int price = in.nextInt();
            in.nextLine();
            System.out.println("Recipe: ");
            String recipe = in.nextLine();

            Dish newDish = m.newDish(name, type, price, recipe); // adds new dish to object m
            System.out.println("This dish was registered: \n" + newDish.toString()); // prints out information using tostring from class Dish
        }
    }

    /**
     * Method for finding a dish by its name
     * @param m references object m
     */
    public static void findDishByName(MenuRegister m) {
        Scanner in = new Scanner(System.in);
        System.out.println("Name: ");
        String name = in.nextLine();

        ArrayList<Dish> dishes = m.getDishByName(name); // creates arraylist from object m
        if (dishes.size() > 0) { // if size of arraylist dishes equals 1 or greater
            for (int i = 0; i < dishes.size(); i++) {
                System.out.println(dishes.get(i).toString()); // prints out information in arraylist dishes using tostring from class Dish for every iteration
            }
        } else { // if size of arraylist dishes is equal to 0 or lower
            System.out.println("No dishes found with the name " + name);
        }
    }

    /**
     * Method for finding a dish by its type
     * @param m references object m
     */
    public static void findDishByType(MenuRegister m) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type: ");
        String type = in.nextLine();

        ArrayList<Dish> dishes = m.getDishByType(type); // creates new arraylist from object m
        if (dishes.size() > 0) { // if size of arraylist equals 1 or greater
            for (int i = 0; i < dishes.size(); i++) {
                System.out.println(dishes.get(i).toString()); // prints out information in arraylist dishes using tostring from class Dish for every iteration
            }
        } else { // if size of arraylist is equal to 0 or lower
            System.out.println("No " + type + " dishes found");
        }
    }

    /**
     * Method for creating a new menu
     * @param m references object m
     */
    public static void newMenu(MenuRegister m) {
        Scanner in = new Scanner(System.in);
        boolean done1 = false; // sets a boolean preset to be used for a controlled while loop
        ArrayList<Dish> dishes = new ArrayList<Dish>(); // creates new arraylist from class Dish

        String allDishes = ""; // creates empty string
        for (int i = 0; i < m.getDishes().size(); i++) { // iterates through size of arraylist dishes within class MenuRegister
            if (i != 0) { // if iteration number is not 0 (i.e. 1 or greater). Gets ignored on first iteration
                allDishes = allDishes + ", "; // adds a comma after information
            }
            allDishes = allDishes + m.getDishes().get(i).toString2(); // adds information about an object from arraylist dishes within class MenuRegister, using the shortened tostring from class Dish
        }
        System.out.println("Registered dishes: \n" + allDishes); // prints out all dishes which were registered

        while (!done1) { // while loop, running until boolean done1 is set to true
            if (dishes.size() < 1) { // for first iteration, print this
                System.out.println("Enter name for dish to add to menu");
            } else { // for every iteration after first iteration, print this instead
                System.out.println("Press 1 to register the menu, or enter name for dish to add to menu");
            }
            String name = in.nextLine();

            if (name.equals("1")) { // if 1 is entered, boolean done1 gets set to true, and program exits this while loop
                done1 = true;
            } else { // if not 1, continue
                ArrayList<Dish> newDish = m.getDishByName((name)); // creates a new arraylist from class Dish, by referencing object m
                if (newDish.size() > 0) { // if size of arraylist newDish is greater than 0 (i.e. not empty)
                    dishes.add(newDish.get(0)); // adds new dish, by grabbing first object of newly created arraylist
                    System.out.println(name + " was added to the menu"); // lets user know what dish was added to the menu
                } else { // if size of newDish arraylist is 0
                    System.out.println("Found no dishes with the name " + name); // lets user know there are no registered dishes with that name, thereby being unable to add it to the menu
                }
            }
        }
        System.out.println("The menu has been registered");
        m.newMenu(dishes); // adds new menu to arraylist menus in class MenuRegister
    }

    /**
     * Method for finding menus within a price range
     * @param m references object m
     */
    public static void findMenuWithinPriceRange(MenuRegister m) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter lowest price: ");
        int min = in.nextInt();

        System.out.println("Enter highest price: ");
        int max = in.nextInt();

        ArrayList<Menu> menus = m.getMenuWithinPriceRange(min, max); // creates new arraylist from class Menu, by referencing method getMenuWithinPriceRange within object m
        System.out.println("Menus with a price range between " + min + " and " + max + ":");
        for (int i = 0; i < menus.size(); i++) { // iterates through size of arraylist menus
            System.out.println("Menu nr " + (i + 1) + ":"); // iteration number starts at 0, so adds 1 to numerate menus
            System.out.println(menus.get(i).toString() + "\n"); // prints menu for each iteration using tostring fromMenu
        }
    }

    /**
     * Method for cancelling/exiting infinite while loop
     * @param m references object m
     */
    public static void Cancel(MenuRegister m) {
        System.out.println("Cancelling...");
        System.exit(0);
    }
}
