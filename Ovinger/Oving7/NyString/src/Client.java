import java.util.*;

public class Client {
    public static void main(String[] args) {
        while (true) { // while loop to be able to continue for as long as we wish
            menu(); // calls forth method
        }
    }

    /**
     * method for showing a menu, asking user for an input, and acting based on that input
     */
    public static void menu() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your text");
        String input = in.nextLine();

        NewString line = new NewString(input); // creates new object from constructor, based on user input


        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to shorten your text");
        System.out.println("Press 2 to remove a letter from your text");
        System.out.println("Press 3 to cancel");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println(line.shorten()); // prints out shortened text
                break;

            case 2:
                System.out.println("Enter which letter you want to remove from your text");
                char remove = in.next().charAt(0); // removes letter based on input
                System.out.println(line.remove(remove)); // prints out text with removed letter
                break;

            case 3:
                System.out.println("Cancelling...");
                System.exit(0);
                break;

            default: // default case if user inputs unexpected value
                System.out.println("You must enter a number between 1 and 3");
                menu();
                break;
        }
    }
}
