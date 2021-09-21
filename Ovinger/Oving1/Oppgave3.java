import javax.swing.JOptionPane;
class Oppgave3 {
    public static void main(String[]args){
        String tidSekunder = JOptionPane.showInputDialog("Antall sekunder som skal bli konvertert til sekunder:");
        int sekunder = Integer.parseInt(tidSekunder); // converts input to an integer

        int timer = sekunder / 3600; // converts seconds to hours
        int restTimer = sekunder % 3600; // takes what's left over after converting seconds to hours
        int minutter = restTimer / 60; // uses what's left over in restTimer to convert those to minutes
        int restMinutter = restTimer % 60; // takes what's left over after converting restTimer to minutes. Will then show how many seconds are left.

        JOptionPane.showMessageDialog(null, sekunder + " sekunder er " + timer + "timer, " + minutter + "minutter og " + restMinutter + "sekunder.");
    }
}