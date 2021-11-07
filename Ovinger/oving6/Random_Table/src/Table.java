import java.util.*;

public class Table {
    private Random rand = new Random();
    private int size;
    private int[] table = new int[10];
    private String star = "*";

    /**
     * Constructor containing size, which will be how many times numbers are repeated
     * @param size
     */
    Table(int size) {
        this.size = size;
    }

    /**
     * Method containing a for-loop which repeats feeding a random number into array called table for as long as i < size
     */
    public void getTable() {
        for (int i = 0; i < size; i++) {
            table[rand.nextInt(10)]++;
        }
    }

    /**
     * Method containing a for-loop which prints out a star for every time a number is repeated 10 times.
     */
    public void display() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + star.repeat(table[i] / (size / 100)));
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(table);
    }
}