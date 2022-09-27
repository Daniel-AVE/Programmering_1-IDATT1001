import java.util.*;

public class MinRandom {
    private static Random random = new Random();

    /**
     * Method for getting next whole numer
     * @param nedre lowest number
     * @param ovre highest number
     * @return returns a number between lowest and highest number
     */
    public static int nesteHeltall(int nedre, int ovre) {
        int max = ovre - nedre; // gir oss et tall mellom med maks grense på differansen mellom nedre og øvre grense
        int resultat = random.nextInt(max); // gir oss et tilfeldig tall med max som høyeste verdi (mellom 0 og max)
        resultat = resultat + nedre; // plusser på nedre grense for å få et tall mellom nedre og øvre grense
        return resultat;
    }

    /**
     * method for getting next decimal number
     * @param nedre lowest number
     * @param ovre highest number
     * @return returns a number with decimals between lowest number, and highest number.
     */
    public static double nesteDesimaltall(double nedre, double ovre) {
        double differanse = ovre - nedre; // får differansen mellom nedre og øvre tall
        double tilfeldig = random.nextDouble(); // lager et tilfeldig tall
        double resultat = nedre + (differanse * tilfeldig); // ganger tilfeldig tall med differansen, og plusser på nedre tall. For å å få et tall mellom nedre og øvre grense.
        return resultat;
    }
}
