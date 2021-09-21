public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Constructor for creating fraction objects
     * @param numerator the numerator of the fraction
     * @param denominator the denominator of the fraction
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) { // if statement in case numerator is 0
            throw new IllegalArgumentException("Denominator can not be 0"); // Throws an illegal argument exception if numerator is 0
        }
        this.numerator = numerator; // Tells the machine that this numerator should be the same as private int, making it reachable outside of the class
        this.denominator = denominator; // Same as above
    }

    /**
     * Another constructor where the only argument is the numerator. As stated by the task.
     * @param numerator the numerator of the fraction
     */
    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1; // sets denominator to 1 by default.
    }

    /**
     * method to call forth the numerator within another class
     * @return returns numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Method to call forth the denominator whithin another class
     * @return returns denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * method for doing the addition of the fractions.
     * @param newNumerator the new numerator to be used for the math calculation
     * @param newDenominator the new denominator to be used for the math calculation
     */
    public void doPlus(int newNumerator, int newDenominator) {
        numerator = (numerator * newDenominator) + (newNumerator * denominator);
        denominator = (newDenominator * denominator);
    }

    /**
     * method for doing the subtraction of the fractions
     * @param newNumerator the new numerator to be used for the math calculation
     * @param newDenominator the new denominator to be used for the math calculation
     */
    public void doMinus(int newNumerator, int newDenominator) {
        numerator = (numerator * newDenominator) - (newNumerator * denominator);
        denominator = (newDenominator * denominator);
    }

    /**
     * method for doing the multiplication of the fractions
     * @param newNumerator new numerator
     * @param newDenominator new denominator
     */
    public void doMulti(int newNumerator, int newDenominator) {
        numerator *= newNumerator; // multiplies the numerator with the new numerator
        denominator *= newDenominator; // multiplies the denominator with the new denominator
    }

    /**
     * method for doing the division of the fractions. Instead of dividing, we're simulating having flipped the new fraction upside down.
     * @param newNumerator new numerator
     * @param newDenominator new denominator
     */
    public void doDivide(int newNumerator, int newDenominator) {
        numerator *= newDenominator; // multiplies the numerator with the new denominator
        denominator *= newNumerator; // multiplies the denominator with the new numerator
    }
    public void doReduce() {
        int d;
        d = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / d;
        this.denominator = this.denominator / d;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
