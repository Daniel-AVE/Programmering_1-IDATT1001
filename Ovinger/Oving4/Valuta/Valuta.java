/**
 * The type Valuta.
 */
public class Valuta {
    private double rate;
    private String name;

    /**
     * Instantiates a new Valuta.
     *
     * @param rate the rate
     * @param name the name
     */
    public Valuta(double rate, String name) {
        this.rate = rate;
        this.name = name;
    }

    /**
     * To nok double.
     *
     * @param amount the amount
     * @return the double
     */
    public double toNok(double amount) {
        return amount * rate;
    }

    /**
     * From nok double.
     *
     * @param amount the amount
     * @return the double
     */
    public double fromNok(double amount) {
        return amount / rate;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
