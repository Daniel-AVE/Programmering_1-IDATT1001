public class Dish {
    private String name, type, recipe;
    private double price;

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

    public String toString() {
        return "Name: " + this.getName() + ", type: " + this.getType() + ", price: " + this.getPrice() + ", recipe: " + this.getRecipe();
    }

    public String toString2() {
        return this.getName() + "(" + this.getPrice() + " NOK)";
    }
}
