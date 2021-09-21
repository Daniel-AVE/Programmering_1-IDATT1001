/* Creating a class for the player, which holds the constructors to be used.
* 1. constructor player which contains how many points the player has
* 2. method to get points in another class where it'll return the private variable from this class
* 3. method to set points to be able to use sumPoints in another class, and edit the value
* 4. method for throwing the dice, containing the mathematical formulas needed and other "rules" for the game
* 5. a boolean method to determine if the player is done or not */

import java.util.*;

public class Player {
    private Random dice = new Random();
    private int sumPoints;

    public Player(int points) {
        sumPoints = points;
    }
    public int getPoints() {
        return sumPoints;
    }
    public void setPoints(int sumPoints) {
        this.sumPoints = sumPoints;
    }

    public int throwDice(int points) {
        int newSum;

        int n = dice.nextInt(6);
        n += 1;
        if (n == 1) {
            newSum = 0;
        } else if (points > 100) {
            newSum = points - n;
        } else {
            newSum = points + n;
        }
        return newSum;
    }
    public static boolean done(int points) {
        if (points == 100) {
            return true;
        } else {
            return false;
        }
    }
}
