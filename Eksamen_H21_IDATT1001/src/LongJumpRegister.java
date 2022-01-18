import java.util.*;

/**
 * A class administrating a Long Jump Register, with methods for finding results and adding results
 *
 * Methods:
 * A method for making the information of arraylist available outside of class
 * A method for getting the size of the arraylist, without accessing the arraylist in itself. Also making this information available outside of class
 * A method for adding a new result. Needed for solving the task from client
 * A method for finding the best result out of all results. Should be needed to determine a winner
 * A method for finding results of all jumps by one athlete, which should be needed to compare one athlete's jumps to their previous jumps
 * A method for finding the average result, which should be needed to compare a new jump to all previous jumps.
 * A method for printing out / converting all arraylist information to a string, which is to be presented to the client through UI class
 * @author 10054
 */
public class LongJumpRegister {
    /**
     * Private ArrayList made from LongJumpResult class
     * Uses ArrayList because it is the Java Collection Framework which works with most ease.
     * If results would need to be sorted, it would be possible to do with ArrayList, as opposed to HashMap and HashSet.
     * List Framework is out of the questions, since it would need you to manually increase list size for every item
     * HashMap requires a key to every value, which would make this program bigger than needed
     * HashSet does not maintain the order of inputs, as opposed to ArrayList, which makes me think ArrayList would be easier to use in this occation,
     * seeing as new results should be registered after every jump. This would make the list come out orderly, according to times.
     */
    private ArrayList<LongJumpResult> longJumps;

    /**
     * Instantiates a new Long jump register.
     * Constructor for LongJumpRegister class
     * Creates a new arraylist
     */
    public LongJumpRegister() {
        this.longJumps = new ArrayList<>();
    }

    /**
     * Creates a deep copy of ArrayList, and returns the deep copy
     * Does this because we don't want to use the original list to make changes, and possibly ruining the original arraylist
     * This method is needed to share this information outside of this class
     * @return the long jumps
     */
    public ArrayList<LongJumpResult> getLongJumps() {
        ArrayList<LongJumpResult> longJumpsCopy = new ArrayList<>(); // empty arraylist for the copy
        for (LongJumpResult longJump : longJumps) {
            longJumpsCopy.add(new LongJumpResult(longJump.getStartNumber(), longJump.getNameOfAthlete(), longJump.getResult(), longJump.isFoul(), longJump.getTime())); // adds info from LongJumpResult to the deep copy
        }
        return longJumpsCopy;
    }

    /**
     * Gets num of long jumps.
     * Uses deep copy to return the number of objects within the arraylist.
     * Uses this instead of using .size() for looser coupling, sharing this information outside of this class, without having
     * to access the arraylist in itself
     * @return the size of long jumps arraylist
     */
    public int getNumOfLongJumps() {
        int numOfLongJumps = getLongJumps().size();
        return numOfLongJumps;
    }

    /**
     * Method for finding the best result of a jump
     * Creates new ArrayList to contain new information, and adds a dummy result to that arraylist
     * iterates through size of longJumps arraylist
     * Checks each iteration if jump is valid, and if the result is larger than last iteration
     * If it's larger, it removes the index (which should be the only object in the arraylist), before adding the jump with higher result into the new arraylist
     * @return the array list
     */
    public ArrayList<LongJumpResult> findBestJump() {
        ArrayList<LongJumpResult> longestJump = new ArrayList<>();
        longestJump.add(new LongJumpResult(111, "name", 0, false, "10:10")); // dummy result to start off the longestJump array
        for (int i = 0; i < getNumOfLongJumps(); i++) {
            if (longJumps.get(i).getResult() > longestJump.get(0).getResult() && !longJumps.get(i).isFoul()) {
                LongJumpResult longJump = longJumps.get(i);
                longestJump.remove(0);
                longestJump.add(longJump);
            }
        }
        return longestJump;
    }

    /**
     * Method for finding jumps by athlete name
     * creates new arraylist to contain jumps made by athlete
     * iterates through the objects longJump of class LongJumpRegister in arraylist longJumps
     * checks each iteration if the athlete name of that iteration is equal to input
     * if equals, adds to the newly created arraylist
     * @param nameOfAthlete the name of athlete
     * @return the array list
     */
    public ArrayList<LongJumpResult> findJumpByName(String nameOfAthlete) {
        ArrayList<LongJumpResult> foundJumps = new ArrayList<>();

        for (LongJumpResult longJump : getLongJumps()) {
            if (longJump.getNameOfAthlete().equals(nameOfAthlete)) {
                foundJumps.add(longJump);
            }
        }
        return foundJumps;
    }

    /**
     * Method for registering a new result
     * Uses boolean "existingResult" to check for already existing results. If existing result, it lets user know.
     * Uses time to check for existing results. There should be no jumps happening at the same time, according to logic.
     * if existing result is not found, then it proceeds to register it
     * if existing result is found, it throws a new illegal argument exception
     * @param startNumber   the start number of the athlete
     * @param nameOfAthlete the name of athlete
     * @param result        the result of the jump
     * @param foul          if the jump is faulty or valid
     * @param time          the time of the jump
     */
    public void newResult(int startNumber, String nameOfAthlete, double result, boolean foul, String time) {
        boolean existingResult = false;

        for (LongJumpResult longJump : getLongJumps()) { // Logically, there should be no jumps happening at the same time. Can then use time to separate jumps.
            if (longJump.getTime().equals(time)) {
                existingResult = true;
            }
        }
        if (!existingResult) {
            LongJumpResult longJump = new LongJumpResult(startNumber, nameOfAthlete, result, foul, time);
            longJumps.add(longJump);
        } else {
            throw new IllegalArgumentException("There is already a registered result for that time");
        }
    }

    /**
     * Method for calculating the average result of the jump
     * Iterates through every object of lonJump in longJumps arraylist, and adds every results to a double datatype
     * @return returns total result divided by number of objects in arraylist longJumps. Gives the average area of all registered properties
     */
    public double averageResult() {
        double totalResult = 0;
        for (LongJumpResult longJump : getLongJumps()) {
            totalResult += longJump.getResult();
        }
        return totalResult / getNumOfLongJumps();
    }

    /**
     * Method for printing out the information contained within the arraylist
     * Creates empty string
     * Checks if the arraylist list is empty. If it is, it lets user know
     * If list is not empty, then it starts iterating through objects of longJump in the arraylist list, and adds all objects to a string, using toString method from LongJumpResult class
     * @param list an arraylist created from LongJumpResult class
     * @return the string
     */
    public String print(ArrayList<LongJumpResult> list) {
        String longjumps = "";

        if (list.isEmpty()) {
            longjumps = "There are currently no results registered";
        } else {
            longjumps = "\nResults: \n";
            for (LongJumpResult longJump : list) {
                longjumps += longJump.toString() + "\n";
            }
            return longjumps;
        }
        return longjumps;
    }
}
