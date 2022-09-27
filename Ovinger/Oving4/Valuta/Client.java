import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/**
 * The type Client.
 */
public class Client {
    /**
     * The constant DOLLAR.
     */
    public static final int DOLLAR = 1;
    /**
     * The constant EURO.
     */
    public static final int EURO = 2;
    /**
     * The constant SGDOLLAR.
     */
    public static final int SGDOLLAR = 3;
    /**
     * The constant CANCEL.
     */
    public static final int CANCEL = 4;

    /**
     * The Usd.
     */
    static Valuta USD = new Valuta(10.04, "USD");
    /**
     * The Eur.
     */
    static Valuta EUR = new Valuta(10.14, "EURO");
    /**
     * The Sgd.
     */
    static Valuta SGD = new Valuta(6.4, "SGD)");


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        while (true) {
            showMenu();
        }

    }

    /**
     * Show menu.
     */
    public static void showMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose a menu choice");
        System.out.println("1. To NOK");
        System.out.println("2. From NOK");
        System.out.println("3. Cancel");
        int menuChoice = in.nextInt();

        switch(menuChoice) {
            case 1:
                Scanner sc = new Scanner(System.in);
                System.out.println("Choose a currency");
                System.out.println("1. Dollar");
                System.out.println("2. Euro");
                System.out.println("3. Singapore Dollar");
                System.out.println("4. Cancel");

                int choice = sc.nextInt();

                switch(choice) {
                    case DOLLAR -> toNok(USD);
                    case EURO -> toNok(EUR);
                    case SGDOLLAR -> toNok(SGD);
                    case CANCEL -> {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Please choose a value between 1-4");
                        showMenu();
                    }
                }
            case 2:
                sc = new Scanner(System.in);
                sc.reset();
                System.out.println("Choose a currency");
                System.out.println("1. Dollar");
                System.out.println("2. Euro");
                System.out.println("3. Singapore Dollar");
                System.out.println("4. Cancel");

                choice = sc.nextInt();

                switch(choice) {
                    case DOLLAR -> fromNok(USD);
                    case EURO -> fromNok(EUR);
                    case SGDOLLAR -> fromNok(SGD);
                    case CANCEL -> {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Please choose a value between 1-4");
                        showMenu();
                    }
                }
            case 3:
                System.out.println("Exiting...");
                System.exit(0);

            default:
                System.out.println("Please choose a value between 1-3");
                showMenu();
        }
    }

    /**
     * To nok.
     *
     * @param valuta the valuta
     */
    public static void toNok(Valuta valuta){
        Scanner in = new Scanner(System.in);
        System.out.println("How much " + valuta.getName() + " do you want to convert to NOK");
        double amount = in.nextDouble();

        double result = valuta.toNok(amount);

        System.out.printf(amount + " " + valuta.getName() + " is %.2f NOK\n", result);
        showMenu();
    }

    /**
     * From nok.
     *
     * @param valuta the valuta
     */
    public static void fromNok(Valuta valuta){
        Scanner in = new Scanner(System.in);
        System.out.println("How much NOK do you want to convert to " + valuta.getName());
        double amount = in.nextDouble();

        double result = valuta.fromNok(amount);

        System.out.printf(amount + " NOK is %.2f " + valuta.getName() + "\n", result);
        showMenu();

    }
}
