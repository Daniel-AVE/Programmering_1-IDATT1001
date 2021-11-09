import java.util.*;

public class MenuRegister {
    private ArrayList<Menu> menus;
    private ArrayList<Dish> dishes;

    /**
     * Constructor for class MenuRegister
     * Initializes arraylists menus and dishes to be used onwards
     */
    public MenuRegister() {
        menus = new ArrayList<Menu>();
        dishes = new ArrayList<Dish>();
    }

    /**
     * Method to call forth arraylist menus outside of this class
     * @return returns arraylist menus
     */
    public ArrayList<Menu> getMenus() {
        return menus;
    }

    /**
     * Method to call forth arraylist dishes outside of this class
     * @return returns arraylist dishes
     */
    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    /**
     * Method to create a new dish as an object of class Dish
     * @param name name of dish
     * @param type type of dish
     * @param price price of dish
     * @param recipe dish recipe
     * @return returns the information about the new dish
     */
    public Dish newDish(String name, String type, double price, String recipe) {
        Dish newDish = new Dish(name, type, price, recipe);
        dishes.add(newDish);
        return newDish;
    }

    /**
     * Method to find a dish by a name
     * @param name name of dish to be found
     * @return returns arraylist consisting of dishes which equals the name user inputs
     */
    public ArrayList<Dish> getDishByName(String name) {
        ArrayList<Dish> dishName = new ArrayList<Dish>(); // creates new arraylist to hold objects with name equal to user input
        for (int i = 0; i < getDishes().size(); i++) { // iterates through size of arraylist dishes
            if (getDishes().get(i).getName().toLowerCase().equals(name.toLowerCase())) { // converts names from both arraylist and input to lower case, thereby not making them case sensitive
                                                                                        // also checks to see if there is a dish with the name user input within arraylist dishes
                dishName.add(getDishes().get(i)); // if dish name is found, it gets added to arraylist dishName
            }
        }
        return dishName; // returns new arraylist
    }

    /**
     * Method to find a dish by type
     * @param type type of dish to be found
     * @return returns arraylist consisting of dishes which equals the type user inputs
     */
    public ArrayList<Dish> getDishByType(String type) {
        ArrayList<Dish> dishType = new ArrayList<Dish>(); // creates new arraylist to hold object with type equal to user input
        for (int i = 0; i < getDishes().size(); i++) { // iterates through size of arraylist dishes
            if (getDishes().get(i).getType().toLowerCase().equals(type.toLowerCase())) { // converts types to lower case, and checks through dishes to find equal types
                dishType.add(getDishes().get(i)); // if dish type is found, it gets added to arraylist dishType
            }
        }
        return dishType; // returns new arraylist
    }

    /**
     * Method for creating a new menu
     * @param menuDishes uses an arraylist as an object for the method
     * @return returns new menu
     */
    public Menu newMenu(ArrayList<Dish> menuDishes) {
        Menu newMenu = new Menu(menuDishes); // creates new menu as an object of class Menu
        getMenus().add(newMenu); // adds new menu to arraylist menus
        return newMenu; // returns new menu
    }

    /**
     * Method for finding menus within a set price range
     * @param min lowest value for price range
     * @param max highest value for price range
     * @return returns objects found within price range
     */
    public ArrayList<Menu> getMenuWithinPriceRange(double min, double max) {
        ArrayList<Menu> menuPriceRange = new ArrayList<Menu>(); // creates new arraylist to hold objects found within price range
        for (int i = 0; i < getMenus().size(); i++) { // iterates through size of arraylist menus
            if (getMenus().get(i).getTotalPrice() >= min && getMenus().get(i).getTotalPrice() <= max) { // if totalprice is greater than or equal to min value, and lower than or equal to max value
                menuPriceRange.add(getMenus().get(i)); // then that menu gets added to arraylist menuPriceRange
            }
        }
        return menuPriceRange; // returns new arraylist
    }
}
