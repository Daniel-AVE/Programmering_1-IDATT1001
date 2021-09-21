import java.util.Scanner;

class Gangetabell {
    public static void main(String[] args) {
        Scanner newNum1 = new Scanner(System.in); // creates new scanner object
        System.out.println("Input which timetable you want to start from"); // prints line asking user to input a value
        int num1 = newNum1.nextInt(); // connects the user input value to an int
        
        Scanner newNum2 = new Scanner(System.in); // same as above
        System.out.println("Input which timetable you want to end on"); // same as above
        int num2 = newNum2.nextInt(); // same as above

        final int MIN = Math.min(num1,num2); // creates a maximum lower value, and forces lowest value
        final int MAX = Math.max(num1,num2); // creates a maximum value, and forces maximum value

        for (int n = MIN; n <= MAX; n++){ // first loop which will loop whatever is inside from minimum value, to maximum value.
            System.out.println("\n" + "Timetable for: " + n + "*X");
            for (int i = 1; i <= 10; i++) { // second loop which loops values between 1 and 10
                System.out.println(i + " * " + n + " = " + i*n);
            }
        }
    }
}