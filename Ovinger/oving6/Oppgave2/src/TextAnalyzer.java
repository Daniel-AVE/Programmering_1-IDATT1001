import java.util.*;

public class TextAnalyzer {
    private static int[] characters;
    private static String[] alphabet = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","æ","ø","å"};

    public TextAnalyzer(String input) {
        characters = new int[30];
        for (int a = 0; a < 30; a++) {
            characters[a] = 0;
        }
        input = input.toLowerCase();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char indexChar = input.charAt(i);
            String letter = Character.toString((char)indexChar);
            int index = Arrays.asList(alphabet).indexOf(letter);
            if (index == -1) {
                index = 29;
            }
            characters[index] +=1;
        }
    }

    public static int getDifferent() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
            if (characters[i] > 0) {
                sum++;
            }
        }
        return sum;
    }

    public static int getLetters() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
            sum = characters[i] + sum;
        }
        return sum;
    }

    public static double getPercentOfSymbols() {
        int letters = getLetters();
        int symbols = characters[29];
        double total = letters + symbols;
        double percent = (symbols / total) * 100;

        percent = Math.round((percent * 100.0) / 100.0);
        return percent;
    }

    public static int getNumOfSpecificLetters(String letter) {
        int index = Arrays.asList(alphabet).indexOf(letter);
        int sum = 0;
        if (index > -1) {
            sum = characters[index];
        }
        return sum;
    }

    public static String getNumOfOccurences() {
        int highest = -1;
        String highestLetter = "";
        for (int i = 0; i < 29; i++) {
            if (characters[i] > highest) {
                highest = characters[i];
                highestLetter = alphabet[i];
            } else if (characters[i] == highest) {
                highestLetter = highestLetter + ", " + alphabet[i];
            }
        }
        return "The letter(s) occuring most is \"" + highestLetter + "\" (" + highest + " times)";
    }
}
