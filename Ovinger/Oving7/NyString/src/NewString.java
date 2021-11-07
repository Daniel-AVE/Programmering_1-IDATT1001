import java.util.*;

public class NewString {
    private final String text;

    /**
     * constructor for the class NewString
     * @param word makes it possible to create an object from this constructor using an immutable private string from this class
     */
    public NewString(String word) {
        this.text = word;
    }

    /**
     * method to shorten the string
     * @return returns new text after shortening
     */
    public String shorten() {
        String newText = ""; // creates an empty new text
        String original = this.text; // takes care of the original text

        String[] word = original.split(" "); //Creates a new string table, which splits strings into new table object for every space
        for (int i = 0; i < word.length; i++) { // as long as i is lower than the value of the length of the table, it reiterates the loop
            newText += word[i].charAt(0); // for every time the loop is reiterated, it adds the first character of every object in the table to the new text
        }
        return newText; // returns new text
    }

    /**
     * method for removing a letter from a text
     * @param c uses char since we'll only be removing a letter
     * @return returns new text after removing the letter from the text
     */
    public String remove(char c) {
        String original = this.text; // creates an original text, to preserve it
        String newText = original; // creates a new text from the original text

        while (newText.indexOf(c) > -1) { // while loop to iterate through the text, to remove a letter, if it finds it. As long as it is higher than -1 (higher than last object in table).
            newText = newText.substring(0, newText.indexOf(c)) + newText.substring(newText.indexOf(c) + 1); /* creates a substring within new text, starting from 0, to where input char is. When it's found, it adds
        another substring, starting from where the first substring stopped, + 1. Meaning, it will continue to go through the text until it reaches the end.*/
        }
        return newText;
    }



}
