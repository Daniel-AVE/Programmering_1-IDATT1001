import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        while (true) { // infinite loop until cancelled
            testClient(); // calls forth testClient method
        }
    }

    /**
     * Method for testing every method from TextEdit class. Stops program if test does not suceed
     */
    public static void testClient() {
        //test 1
        TextEdit wordLength = new TextEdit("This sentence should contain 6 words");
        wordLength.wordCount();
        if (wordLength.wordCount() == 6) { // Test if word counter counts correct amount of words
            System.out.println("Test 1 success");
        } else {
            System.out.println("Test 1 failed");
            System.exit(0);
        }
        //test 2
        TextEdit averageWordLength = new TextEdit("The average word length of this text should be 3");
        averageWordLength.averageWordLength();
        if (averageWordLength.averageWordLength() == 3) { // tests if program counts correct average word length
            System.out.println("Test 2 success");
        } else {
            System.out.println("Test 2 failed");
            System.exit(0);
        }
        //test 3
        TextEdit averageNumWords = new TextEdit("We are checking average number of words each period! Are you ready? Let's get too it. The average number here should be: 4");
        averageNumWords.averageNumWords();
        if (averageNumWords.averageNumWords() == 4) { // tests if program counts correct average words per period
            System.out.println("Test 3 success");
        } else {
            System.out.println("Test 3 failed");
            System.exit(0);
        }
        //test 4
        TextEdit replaceWord = new TextEdit("Clock. I'm going to replace the first word, with the word 'wåtch'");
        replaceWord.replace("Clock.", "Wåtch.");
        String word = "Wåtch. I'm going to replace the first word, with the word 'wåtch'";
        if (replaceWord.replace("Clock", "Wåtch").equals(word)) { // tests if the replaced word is correctly replaced
            System.out.println("Test 4 success");
        } else {
            System.out.println("Test 4 failed");
            System.exit(0);
        }
        //test 5
        TextEdit text = new TextEdit("This text will be printed next. ø");
        text.viewText();
        if (text.viewText().equals("This text will be printed next. ø")) { // tests if the viewText method works, and program shows the original text
            System.out.println("Test 5 success");
        } else {
            System.out.println("Test 5 failed");
            System.exit(0);
        }
        //test 6
        TextEdit bigText = new TextEdit("This sentence will be capitalized. æ");
        bigText.bigText();
        if (bigText.bigText().equals("THIS SENTENCE WILL BE CAPITALIZED. Æ")) { // tests if bigText method works, and program prints a capitalized sentence
            System.out.println("Test 6 success");
        } else {
            System.out.println("Test 6 failed");
            System.exit(0);
        }

        textInput(); // if all tests were successful, this calls forth the textInput method where user can input text.
    }

    /**
     * method for inputting text, so that we can continue using same text for multiple purposes within menu
     */
    public static void textInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String input = in.nextLine();
        TextEdit textEdit = new TextEdit(input);

        showMenu(textEdit); // calls forth showMenu method, containing the text which was just entered
    }

    public static void showMenu(TextEdit textEdit) {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Press 1 to get number of words in your text");
        System.out.println("Press 2 to get average word length of your text");
        System.out.println("Press 3 to get average number of words each period");
        System.out.println("Press 4 to replace a word in your text with another word");
        System.out.println("Press 5 to view your text");
        System.out.println("Press 6 to view your text capitalized");
        System.out.println("Press 7 to cancel");

        int menuInput = in.nextInt();

        switch (menuInput) {
            case 1: // gets number of words
                System.out.println("Number of words in your text: " + textEdit.wordCount());
                showMenu(textEdit);
                break;

            case 2: // gets average word length
                System.out.println("Average word length of your text: " + textEdit.averageWordLength());
                showMenu(textEdit);
                break;

            case 3: // gets average number of words each period
                System.out.println("Average number of words per period in your text: " + textEdit.averageNumWords());
                showMenu(textEdit);
                break;

            case 4: // replaces one word with another
                System.out.print("Enter the word you want to replace: "); String word1 = in.next();
                System.out.print("Enter word to replace your old word: "); String word2 = in.next();
                System.out.println(textEdit.replace(word1, word2));
                showMenu(textEdit);
                break;

            case 5: // shows the original text
                System.out.println(textEdit.viewText());
                showMenu(textEdit);
                break;

            case 6: // shows original text capitalized
                System.out.println(textEdit.bigText());
                showMenu(textEdit);
                break;

            case 7: // cancels loop
                System.out.println("Cancelling...");
                System.exit(0);
                break;

            default: // in case user inputs an unexpected value
                System.out.println("You must choose between 1-7");
                showMenu(textEdit);
                break;
        }
    }
}
