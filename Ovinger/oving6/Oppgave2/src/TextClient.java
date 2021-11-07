import org.w3c.dom.Text;

import java.util.*;

public class TextClient {
    private static boolean True = true;

    public static void main(String[] args) {
        while (True) {
            start();
        }
    }

    public static void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text you want analyzed");
        String input = in.nextLine();
        TextAnalyzer textAnalyze = new TextAnalyzer(input);
        analyze(textAnalyze);
    }

    public static void analyze(TextAnalyzer textAnalyze) {
        System.out.println("Number of different letters: " + textAnalyze.getDifferent());
        System.out.println("Number of letters: " + textAnalyze.getLetters());
        System.out.println("Percentage of symbols: " + textAnalyze.getPercentOfSymbols() + "%");
        System.out.println(textAnalyze.getNumOfOccurences());
    }
}
