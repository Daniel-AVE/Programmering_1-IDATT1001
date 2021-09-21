import javax.swing.JOptionPane;

class Oppgave2 {
    public static void main(String[] args) {

        // Følgende 4 linjer spør bruker om å inputte verdier.
        Double priceMeatA = Double.parseDouble(JOptionPane.showInputDialog("Price of meat A")); 
        Double weightMeatA = Double.parseDouble(JOptionPane.showInputDialog("Weight of meat A (kg)"));
        Double priceMeatB = Double.parseDouble(JOptionPane.showInputDialog("Price of meat B"));
        Double weightMeatB = Double.parseDouble(JOptionPane.showInputDialog("Weight of meat B (kg)"));

        Double valueMeatA = priceMeatA / weightMeatA; //Gir pris per kilogram tatt med pris og vekt i betraktning.
        Double valueMeatB = priceMeatB / weightMeatB;

        String cheaperPrice; //Stringer en variabel til å gi oss flere valg av sluttresultat som vil komem frem i messageDialog.

        if(valueMeatA > valueMeatB) {
            cheaperPrice = "Meat B is cheaper.";
        } else if(valueMeatA < valueMeatB) {
            cheaperPrice = "Meat A is cheaper.";
        } else {
            cheaperPrice = "They are the same price.";
        }
        JOptionPane.showMessageDialog(null, String.format("The total price of meat A is %.2f nok." + "\nThe total price of meat B is %.2f nok.",valueMeatA, valueMeatB) + "\n" + cheaperPrice ); 
    }
}