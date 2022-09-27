import java.util.Scanner;

public class Brokregning {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Test addition
        Fraction fraction1 = new Fraction(1, 10); // tries to create a fraction from user input.
        int newNumerator1 = 2;
        int newDenominator1 = 5;
        fraction1.doPlus(newNumerator1, newDenominator1);
        fraction1.doReduce();
        if (fraction1.getNumerator() == 1 && fraction1.getDenominator() == 2) {
            System.out.println("Test successful");
        } else {
            System.out.println("Test failed");
        }
        // end of test
        System.out.println("Input numerator");
        int numerator = in.nextInt();

        System.out.println("Input denominator");
        int denominator = in.nextInt();
        Fraction fraction = new Fraction(numerator, denominator); // creates fraction from user input


        /**
         * test set to check for exceptions, or errors.
          */
        try {
            Fraction fraction2 = new Fraction(numerator, denominator); // tries to create a fraction from user input.
        } catch (IllegalArgumentException invalid) { // if it's unable to, this argument happens
            System.out.println(invalid); // throws exception since something's wrong
        }
        /**
         * While loop to keep the program running for however long user wants
         */
        while (true) {
            System.out.println("Your current fraction is: " + fraction.getNumerator() + "/" + fraction.getDenominator()); // tells user what the current fraction is
            System.out.println("Choose which operation you want to do:\n" +
                    "1. Addition\n" +
                    "2. Subtraction\n" +
                    "3. Multiplication\n" +
                    "4. Division\n" +
                    "5. Cancel");
            int menuChoice = in.nextInt(); // user menu

            /**
             * Exits program if user cancels by typing 5
             */
            if (menuChoice == 5) {
                System.out.println("Cancelling");
                System.exit(0);
            }

            System.out.println("Input your new numerator");
            int newNumerator = in.nextInt();

            System.out.println("Input your new denominator");
            int newDenominator = in.nextInt();

            /**
             * Switch statement for every case from user input
             */
            switch (menuChoice) {
                case 1 -> doPlus(fraction, newNumerator, newDenominator);
                case 2 -> doMinus(fraction, newNumerator, newDenominator);
                case 3 -> doMulti(fraction, newNumerator, newDenominator);
                case 4 -> doDivide(fraction, newNumerator, newDenominator);
                default -> {
                    System.out.println("Unexpected entry, please try again after restarting program");
                    System.exit(0);
                }
            }
            /**
             * gives user option to continue or cancel.
             */
            System.out.println("Do you want to continue?\n" +
                    "1. Yes\n" +
                    "2. No");
            int newMenuChoice = in.nextInt();
            if (newMenuChoice == 2) {
                System.out.println("Cancelling...");
                System.exit(0);
            } else if (newMenuChoice == 1) {
                continue;
            }

        }
    }

    public static void doPlus(Fraction fraction, int newNumerator, int newDenominator) {
        System.out.println(fraction.getNumerator() + "/" + fraction.getDenominator() + " + " + newNumerator + "/" + newDenominator);
        fraction.doPlus(newNumerator, newDenominator);
        fraction.doReduce();
        System.out.println("The anser is:\n" + fraction.getNumerator() + "/" + fraction.getDenominator());
    }

    public static void doMinus(Fraction fraction, int newNumerator, int newDenominator) {
        System.out.println(fraction.getNumerator() + "/" + fraction.getDenominator() + " - " + newNumerator + "/" + newDenominator);
        fraction.doMinus(newNumerator, newDenominator);
        fraction.doReduce();
        System.out.println("The anser is:\n" + fraction.getNumerator() + "/" + fraction.getDenominator());
    }

    public static void doMulti(Fraction fraction, int newNumerator, int newDenominator) {
        System.out.println(fraction.getNumerator() + "/" + fraction.getDenominator() + " * " + newNumerator + "/" + newDenominator);
        fraction.doMulti(newNumerator, newDenominator);
        fraction.doReduce();
        System.out.println("The anser is:\n" + fraction.getNumerator() + "/" + fraction.getDenominator());
    }

    public static void doDivide(Fraction fraction, int newNumerator, int newDenominator) {
        System.out.println(fraction.getNumerator() + "/" + fraction.getDenominator() + " / " + newNumerator + "/" + newDenominator);
        fraction.doDivide(newNumerator, newDenominator);
        fraction.doReduce();
        System.out.println("The anser is:\n" + fraction.getNumerator() + "/" + fraction.getDenominator());
    }
}
