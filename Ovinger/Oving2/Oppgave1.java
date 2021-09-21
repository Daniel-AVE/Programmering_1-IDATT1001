import javax.swing.JOptionPane;

class Oppgave1 {
    public static void main(String[] args) {
        int aar = Integer.parseInt(JOptionPane.showInputDialog("Tall som skal deles på 4 for å sjekke etter skuddår")); //ved å kjøre en integer parse sammen med showInputDialog kan vi forkorte en 2 linjers kode til 1 linjes. Og vi slipper og stringe.

        if (aar % 4 == 0 && aar % 100 != 0) { //Hvis antall år, delelig på 4 er lik 0 samtidig som antall år, delelig på 100 er ulik 0 vil vi få tilbake at tallet er et skuddår.

            JOptionPane.showMessageDialog(null, aar+" er et skuddår.");

        } else if (aar%400 == 0){ //Hvis antall år delelig på 400 er lik 0, tatt forige "if" i betraktning, får vi tilbake at tallet er et skuddår.

                JOptionPane.showMessageDialog(null, aar+" er et skuddår.");

            } else { // hvis ingen av ovennevnte tilfeller skjer. Utføres denne operasjonen.
                JOptionPane.showMessageDialog(null, aar+" er ikke et skuddår.");}
    }

}
