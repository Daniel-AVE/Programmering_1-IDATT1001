public class Dish {
    private String name, type, recipe;
    private double price;

    /**
     * Constructor for class Dish
     * @param name name of dish
     * @param type type of dish
     * @param price price of dish
     * @param recipe dish recipe
     */
    public Dish(String name, String type, double price, String recipe) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getRecipe() {
        return recipe;
    }

    /**
     * To string method containing all information within class Dish. To be used for checking dishes within the menu
     * @return returns name, type, price and recipe of a dish
     */
    public String toString() {
        return "Name: " + this.getName() + ", type: " + this.getType() + ", price: " + this.getPrice() + ", recipe: " + this.getRecipe();
    }

    /**
     * Shorter to string method containing shortened information from this class. To be used to show in restaurant menu.
     * @return returns name and price of a dish
     */
    public String toString2() {
        return this.getName() + "(" + this.getPrice() + " NOK)";
    }
}
