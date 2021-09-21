/*
* 1. main method calls forth another method, to keep the program running, without making main method too big
* 2. the actual method called forth in main method. Contains user input if they would like to play or not,
* and continues based on what the user input was. In this case, if user wants to play, the method calls forth another
* method. Also contains a type of data control if user were to input incorrect value.
* 3. the method which is called forth if user wants to play. Connects to the Player class, and creates new
* players within this class. Most of the game is in this function, including points and if the player is done or not.
* The game itself is contained within a while loop, where player is not done, to make the game continue on until
* player is done. Exits loop when player done is true, and continues to a if else statement printing out who won.
* From there, contains the same code as starting(), to ask if the player wants to play again, or if they want to quit.
* Making this code run until the user itself cancels it */

import java.util.*;

public class DiceGame {
    public static void main(String[] args) {
        System.out.println("---Dicegame 100---");
        System.out.println("");

        starting();
    }
    public static void starting() {
        System.out.println("Press 1 to play");
        System.out.println("Press 2 to quit");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if (input == 1) {
            startGame();
        } else if (input == 2) {
            System.out.println("Quitting...");
            System.exit(0);
        } else {
            System.out.println("You've input an incorrect value. Please choose between 1 and 2\n");
            starting();
        }
    }
    public static void startGame() {
        Player[] player = new Player[2];
        player[0] = new Player(0);
        player[1] = new Player(0);

        int roundNr = 0;

        while(!player[0].done(player[0].getPoints()) && player[1].done(player[1].getPoints()) == false) {
            player[0].setPoints(player[0].throwDice(player[0].getPoints()));
            player[1].setPoints(player[1].throwDice(player[1].getPoints()));
            //player[0].setPoints() = player[0].throwDice(player[0].getPoints());
            //player[1].getPoints() = player[1].throwDice(player[1].getPoints());
            System.out.println("Round nr.: " + roundNr + ", player 1: " + player[0].getPoints() + ", player 2: " + player[1].getPoints());
            roundNr += 1;
        }

        if (player[0].done(player[0].getPoints()) == true) {
            System.out.println("\nPlayer 1 won!\n");
        } else {
            System.out.println("\nPlayer 2 won!\n");
        }
        System.out.println("Press 1 to play again");
        System.out.println("Press 2 to quit");

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if (input == 1) {
            startGame();
        } else if (input == 2) {
            System.out.println("Quitting...");
            System.exit(0);
        } else {
            System.out.println("You've input an incorrect value. Please choose between 1 or 2.\n");
            starting();
        }
    }
}
