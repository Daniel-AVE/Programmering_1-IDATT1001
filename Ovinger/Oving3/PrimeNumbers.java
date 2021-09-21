import javax.swing.JOptionPane;

import jdk.vm.ci.code.CodeUtil.NumberedRefMapFormatter;

class PrimeNumbers {
    public static void main(String[] args) {
        // creates an int connected to a user input in one line which asks user how many times the code is to be repeated.
        int antall = Integer.parseInt(JOptionPane.showInputDialog("Input how many times you want to check for a prime number."));
        int count = 0; //starts count at 0

        boolean prime = true; // makes it so prime = true is the default value, and following code will prove it wrong

        do {
            // creates user input for which number to test for
            int number = Integer.parseInt(JOptionPane.showInputDialog("Input which number you want to check if is a prime number."));
            for (int i = 2; i < number; i++) { // creates a loop which has a starting value of 2, and also says that the int is lower than user input number
                if (number % i == 0) { // if the rest after dividing number by i is 0, continue prime is false
                    prime = false; // Proves the default value of boolean wrong, and says it is a prime number
                }
            }

            if (prime == true) { 
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
            count++;
        } while (count < antall);
    }
}