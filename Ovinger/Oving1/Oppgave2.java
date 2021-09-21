import javax.swing.JOptionPane;
class Oppgave2 {
    public static void main(String[]args){
        String timer = JOptionPane.showInputDialog("Antall timer som skal bli konvertert til sekunder:"); // Input dialog asking user for input
        Long tidTimer = Long.parseLong(timer); // converts input from String timer to Long variable
        Long timer_til_sekunder = tidTimer*3600L; // new Long variable containing conversion of hours to seconds.

        String minutter = JOptionPane.showInputDialog("Antall minutter som skal bli konvertert til sekunder:"); 
        Long tidMinutter = Long.parseLong(minutter);
        Long minutter_til_sekunder = tidMinutter*60L; // converts minutes to seconds

        String sekunder = JOptionPane.showInputDialog("Antall sekunder som skal være med i konverteringen:");
        Long tidSekunder = Long.parseLong(sekunder);
        Long sekunder_til_sekunder = tidSekunder; // contains the same as the variable above

        Long tid = timer_til_sekunder + minutter_til_sekunder + sekunder_til_sekunder; // creates new variable containing how many seconds in total from earlier variables.

        JOptionPane.showMessageDialog(null, tidTimer + " timer, " + tidMinutter + "minutter, og " + tidSekunder + " i sekunder er "  +tid + " sekunder");
    }
}