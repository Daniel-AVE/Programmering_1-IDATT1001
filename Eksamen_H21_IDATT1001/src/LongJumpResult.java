import java.util.*;

/**
 * A class representing Long Jump Result
 * @author 10054
 */
public class LongJumpResult {
    /**
     * Defining object variables
     * No variables should be changed, and won't have any mutator methods for that reason
     */
    private final int startNumber;
    private final String nameOfAthlete;
    private final double result;
    private final boolean foul;
    private final String time; // uses String instead of local date time for more ease when client inputs numbers

    /**
     * Instantiates a new Long jump result.
     * Contains constructor for the class, with the information about a long jump result
     * @param startNumber   the starting number for athlete
     * @param nameOfAthlete the name of athlete
     * @param result        the result
     * @param foul          if jump is faulty or valid
     * @param time          the time in String format (hh:mm)
     */
    public LongJumpResult(int startNumber, String nameOfAthlete, double result, boolean foul, String time) {
        if (startNumber < 0) {
            throw new IllegalArgumentException("start number must be a positive number"); // makes sure start number is positive
        } if (nameOfAthlete.trim().isEmpty()) {
            throw new IllegalArgumentException("You must input name of athlete"); // makes sure athlete name is input
        }
        this.startNumber = startNumber;
        this.nameOfAthlete = nameOfAthlete;
        this.result = result; // meter
        this.foul = foul;
        foul = false; // sets boolean to false by default. Will make user decide if it's true or not later
        this.time = time;
    }

    /**
     * Gets start number.
     *
     * @return the start number
     */
    public int getStartNumber() {
        return startNumber;
    }

    /**
     * Gets name of athlete.
     *
     * @return the name of athlete
     */
    public String getNameOfAthlete() {

        return nameOfAthlete;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * Is foul boolean.
     *
     * @return the boolean
     */
    public boolean isFoul() {
        return foul;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * toString method for the information within this class
     * @return if isFoul: if the jump is not valid, this line will be returned with "faulty jump"
     * @return if !isFoul: if the jump is valid, this line will be returned with "valid jump"
     */
    @Override
    public String toString() {
        if (isFoul()) {
            return this.getStartNumber() + " | " +  this.getNameOfAthlete() + " | " + this.getResult() + "m | faulty jump | " + this.getTime();
        } else {
            return this.getStartNumber() + " | " + this.getNameOfAthlete() + " | " + this.getResult() + "m | valid jump | " + this.getTime();
        }
    }
}
