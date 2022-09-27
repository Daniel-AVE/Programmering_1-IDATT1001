import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        menyValg(); // kaller opp en metode hvor mesteparten foregår. Gjør det lettere å loope.
    }
    public static void menyValg() {
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn laveste tall");
        int nedre = in.nextInt(); // gir oss tallet fra brukeren i en int nedre
        System.out.println("Skriv inn høyeste tall");
        int ovre = in.nextInt(); // gir oss tallet fra brukeren i en int øvre

        System.out.println("Tast 1 for heltall");
        System.out.println("Tast 2 for desimaltall");
        System.out.println("Tast 3 for å avbryte");

        int input = in.nextInt();
        if (input == 1) {
            System.out.println(MinRandom.nesteHeltall(nedre,ovre)); // gir oss et random tall fra nesteHeltall metoden
            menyValg(); // kaller opp menyvalg funksjonen igjen for å repetere
        } else if (input == 2) {
            System.out.println(MinRandom.nesteDesimaltall(nedre,ovre)); // gir oss et random tall fra nesteDesimaltall metoden
            menyValg(); // kaller opp menyvalg funksjonen igjen for å repetere
        } else if (input == 3) {
            System.out.println("Avbryter...");
            System.exit(0); // avbryter programmet
        } else {
            System.out.println("Du må velge mellom 1, 2 eller 3.");
            menyValg(); // kaller opp menyValg funksjonen igjen.
        }
    }
}
