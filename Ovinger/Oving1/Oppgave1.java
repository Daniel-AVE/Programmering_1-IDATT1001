import javax.swing.JOptionPane; // imports user interface for user input
class Oppgave1 {
    public static void main(String[] args) {
        String Inches = JOptionPane.showInputDialog("Number of inches you want converted:"); // opens an interface for user asking how much they want converted
        float Inch = Float.parseFloat(Inches); // Takes in user input as a float value

        float inch_to_cm = Inch*2.54f; // new float variable for the conversion between inches and cm

        JOptionPane.showMessageDialog(null, Inch + " inches in centimeters is " + inch_to_cm + "cm" ); // shows a new interface containing the string input.
    }


}