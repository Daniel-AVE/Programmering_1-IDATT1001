import java.util.*;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 to convert from NOK");
        System.out.println("Press 2 to convert to NOK");
        System.out.println("Press 3 to cancel");;

        Valuta USD = new Valuta(8.57f);
        Valuta EUR = new Valuta(10.14f);
        Valuta SGD = new Valuta(6.39f);

        int menyValg = in.nextInt();
        if (menyValg == 3) {
            System.out.println("Cancelling...");
            System.exit(0);
        } if (menyValg != 1 && menyValg != 2) {
            System.out.println("You've input an incorrect value. Please run the program and try again.");
            System.exit(0);
        }

        while (menyValg != 3) {
            switch (menyValg){
                case 1:
                Scanner sc = new Scanner(System.in);
                System.out.println("Press 1 to convert to USD");
                System.out.println("Press 2 to convert to EUR");
                System.out.println("Press 3 to convert to SGD");
                System.out.println("Press 4 to cancel.");

                int menyInput = sc.nextInt();
                switch (menyInput) {
                    case 1:
                    Scanner amount1 = new Scanner(System.in);
                    System.out.println("How much NOK do you want to convert to USD?");

                    int antall1 = amount1.nextInt();
                    float sum1 = USD.fraNok(antall1);

                    System.out.println(antall1 + " NOK i USD er: " + sum1 + "\n");
                    break;

                    case 2:
                    Scanner amount2 = new Scanner(System.in);
                    System.out.println("How much NOK do you want to convert to EUR?");

                    int antall2 = amount2.nextInt();
                    float sum2 = EUR.fraNok(antall2);

                    System.out.println(antall2 + " NOK i EUR er: " + sum2 + "\n");
                    break;

                    case 3:
                    Scanner amount3 = new Scanner(System.in);
                    System.out.println("How much NOK do you want to convert to SGD?");

                    int antall3 = amount3.nextInt();
                    float sum3 = SGD.fraNok(antall3);

                    System.out.println(antall3 + " NOK i SGD er: " + sum3 + "\n");
                    break;

                    case 4:
                    System.out.println("Cancelling...");
                    System.exit(0);
                    break;

                    default:
                    System.out.println("You've input an incorrect value. Please run the program and try again.");
                    System.exit(0);
                    break;
                }
                break;

                case 2:
                Scanner st = new Scanner(System.in);
                System.out.println("Press 1 to convert from USD");
                System.out.println("Press 2 to convert from EUR");
                System.out.println("Press 3 to convert from SGD");
                System.out.println("Press 4 to cancel.");

                int menyInput1 = st.nextInt();
                switch (menyInput1) {
                    case 1:
                    Scanner amount1 = new Scanner(System.in);
                    System.out.println("How much USD do you want to convert to NOK?");//h

                    int antall1 = amount1.nextInt();
                    float sum1 = USD.tilNok(antall1);

                    System.out.println(antall1 + " USD i NOK er: " + sum1 + "\n");
                    break;

                    case 2:
                    Scanner amount2 = new Scanner(System.in);
                    System.out.println("How much EUR do you want to convert to NOK?");

                    int antall2 = amount2.nextInt();
                    float sum2 = EUR.tilNok(antall2);

                    System.out.println(antall2 + " EUR i NOK er: " + sum2 + "\n");
                    break;

                    case 3:
                    Scanner amount3 = new Scanner(System.in);
                    System.out.println("How much SGD do you want to convert to NOK?");

                    int antall3 = amount3.nextInt();
                    float sum3 = SGD.tilNok(antall3);

                    System.out.println(antall3 + " SGD i NOK er: " + sum3 + "\n");
                    break;

                    case 4:
                    System.out.println("Cancelling...");
                    System.exit(0);
                    break;

                    default:
                    System.out.println("You've input an incorrect value. Please run the program and try again.");
                    System.exit(0);
                    break;
                }
                break;
            }
            in.reset();
            System.out.println("Press 1 to convert from NOK");
            System.out.println("Press 2 to convert to NOK");
            System.out.println("Press 3 to cancel");

            menyValg = in.nextInt();
            if (menyValg == 3) {
                System.out.println("Cancelling...");
                System.exit(0);
            } if (menyValg != 1 && menyValg != 2) {
                System.out.println("You've input an incorrect value. Please run the program and try again.");
                System.exit(0);
            }
        }
    }
}