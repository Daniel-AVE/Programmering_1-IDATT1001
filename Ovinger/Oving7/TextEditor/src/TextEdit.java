import java.util.*;

public class TextEdit {
    private final String text;

    /**
     * Constructor for TextEdit
     * @param word sets the private immutable String text, to word, making it possible to do something with it outside of the class
     */
    public TextEdit(String word) {
        this.text = word;
    }

    /**
     * method for counting amount of words
     * @return returns number of words in integer format
     */
    public int wordCount() {
        String text = this.text; // imports text to this method

        int counter = 0;
        String[] word = text.split(" "); //splits the text into an array. Splits at spaces, making it so one word is counted as one variable within the array.
        for (int i = 0; i < word.length; i++) { //for loop iterating as many times as i is lower than the length of the array, and adding a value onto counter
            counter++;
        }
        return counter; // returns int counter
    }

    /**
     * method for getting average word length from the text
     * @return returns average word length in integer format
     */
    public int averageWordLength() {
        String text = this.text; // imports text to this method

        String[] word = text.split(" "); // same as in last method. Splits words into variables within an array

        int numWords = word.length; // gets the number of words from the text within this method

        int letters = 0;
        for (int i = 0; i < word.length; i++) { // for loop, counting how many letters are in the text
            letters += word[i].length(); //adds the value of i to letters, until it catches up to the length of the text
        }
        int wordLength = letters / numWords; // gets average word length by dividing number of letters by number of words
        return wordLength; // returns average word length in integer format
    }

    /**
     * method for getting average number of words each period
     * @return returns average number of words each period in integer format
     */
    public int averageNumWords() {
        String text = this.text; // imports text to this method

        int wordLength = averageWordLength(); // gets average length of words from previous methods

        int wordCount = wordCount(); // gets number of words from previous word count

        String[] wordSplit = text.split("[.!?:]+"); // splits the text at either one of these symbols, and adds it to an array. Continuing till done

        int avgNumWords = wordCount / wordSplit.length; // gets average number of words per period by dividing number of words by length of array.

        return avgNumWords; // returns average number of words per period in integer format
    }

    /**
     * method to replace a word within original text, with a new word
     * @param word1 word to be replaced
     * @param word2 word to replace old word
     * @return returns string with the new word
     */
    public String replace(String word1, String word2) {
        String text = this.text; // imports original text
        String newText = text.replaceAll(word1, word2); // creates a new text with the replaced words

        return newText; // returns text in String format
    }

    /**
     * method to view text
     * @return returns text in String format
     */
    public String viewText() {
        return this.text;
    }

    /**
     * method to capitalize all letters in the text
     * @return returns the text fully capitalized in String format
     */
    public String bigText() {
        String text = this.text; // imports original text
        text = text.toUpperCase(); // capitalizes all letters in the text
        return text; // returns capitalized text in String format
    }

}
