import java.util.*;

public class Menu {
    private ArrayList<Dish> menuDishes; // creates an arraylist from class Dish

    /**
     * Constructor for class Menu
     * @param menuDishes uses object made from Dish class
     */
    public Menu(ArrayList<Dish> menuDishes) {
        this.menuDishes = menuDishes;
    }

    /**
     * Makes arraylist menuDishes callable outside of this class
     * @return
     */
    public ArrayList<Dish> getMenuDishes() {
        return menuDishes;
    }

    /**
     * Method to get a total price of dishes in a menu
     * @return returns total price
     */
    public double getTotalPrice() {
        double price = 0; // sets default price value
        for (int i = 0; i < menuDishes.size(); i++) { // iterates through how many objects there are in arraylist menuDishes
            price = price + getMenuDishes().get(i).getPrice(); // adds price gotten from object for every iteration
        }
        return price;
    }

    /**
     * toString method to print out a menu
     * @return
     */
    public String toString() {
        String menuDishes = ""; // creates a string to add arraylist information to
        for (int i = 0; i < getMenuDishes().size(); i++) { // iterates through arraylist
            if (i != 0) { // by setting i != 0, we start adding a comma after every iteration but not the first
                menuDishes = menuDishes + ", ";
            }
            menuDishes = menuDishes + getMenuDishes().get(i).toString2(); // for every iteration, the shortened toString from class Dish, with information from arraylist gets added to string
        }
        menuDishes = menuDishes + "\nTotal price: " + getTotalPrice(); // when loop has finished iterating, it adds the total price of all dishes in the menu
        return menuDishes; // returns string
    }
}
