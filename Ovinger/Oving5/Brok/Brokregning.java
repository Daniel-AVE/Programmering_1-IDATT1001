import static javax.swing.JOptionPane.*;

public class Brokregning {
    public static void main(String[] args) {
        int numerator = Integer.parseInt(showInputDialog("Input your numerator"));
        int denominator = Integer.parseInt(showInputDialog("Input your denumerator"));
        Fraction fraction = new Fraction(numerator, denominator);
        try {
            Fraction fraction1 = new Fraction(numerator, denominator);
        } catch (IllegalArgumentException invalid) {
            showMessageDialog(null, invalid);
        }
        while (true) {
            showMessageDialog(null, "Your current fraction is: " + fraction.getNumerator() + "/" + fraction.getDenominator());
            int menuChoice = Integer.parseInt(showInputDialog("Choose which operation you want to do:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Cancel"));
            if (menuChoice == 5) {
                showMessageDialog(null, "Cancelling");
                System.exit(0);
            }
            int newNumerator = Integer.parseInt(showInputDialog("Input your new numerator"));
            int newDenominator = Integer.parseInt(showInputDialog("Input your new denumerator"));

            switch (menuChoice) {
                case 1:
                    showMessageDialog(null, fraction.getNumerator() + "/" + fraction.getDenominator() + " + " + newNumerator + "/" + newDenominator + " = ");
                    fraction.doPlus(newNumerator, newDenominator);
                    fraction.doReduce();
                    showMessageDialog(null, "The answer is:\n" + fraction.getNumerator() + "/" + fraction.getDenominator());
                    break;

                case 2:
                    showMessageDialog(null, fraction.getNumerator() + "/" + fraction.getDenominator() + " - " + newNumerator + "/" + newDenominator + " = ");
                    fraction.doMinus(newNumerator, newDenominator);
                    fraction.doReduce();
                    showMessageDialog(null, "The answer is:\n" + fraction.getNumerator() + "/" + fraction.getDenominator());
                    break;

                case 3:
                    showMessageDialog(null, fraction.getNumerator() + "/" + fraction.getDenominator() + " * " + newNumerator + "/" + newDenominator + " = ");
                    fraction.doMulti(newNumerator, newDenominator);
                    fraction.doReduce();
                    showMessageDialog(null, "The answer is:\n" + fraction.getNumerator() + "/" + fraction.getDenominator());
                    break;

                case 4:
                    showMessageDialog(null, fraction.getNumerator() + "/" + fraction.getDenominator() + " / " + newNumerator + "/" + newDenominator + " = ");
                    fraction.doDivide(newNumerator, newDenominator);
                    fraction.doReduce();
                    showMessageDialog(null, "The answer is:\n" + fraction.getNumerator() + "/" + fraction.getDenominator());
                    break;

                default:
                    showMessageDialog(null, "Cancelling...");
                    System.exit(0);
                    break;
            }
            int newMenuChoice = Integer.parseInt(showInputDialog("Do you want to continue?\n1. Yes\n2. No"));
            if (newMenuChoice == 2) {
                showMessageDialog(null, "Cancelling");
                System.exit(0);
            } else if (newMenuChoice == 1) {
                continue;
            }

        }
    }
}
