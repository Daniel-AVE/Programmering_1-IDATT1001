import java.util.*;

public class Student {
    private String name;
    private int numAssignments;

    /**
     * Constructor for the class containing data about a student
     * @param name name of the student
     * @param numAssignments number of assignments the student has done
     */
    public Student(String name, int numAssignments) {
        this.name = name;
        this.numAssignments = numAssignments;
    }

    /**
     * Method to get name of a student
     * @return returns the name of a student
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get number of assignments done by a student
     * @return returns number of assignments done
     */
    public int getNumAssignments() {
        return numAssignments;
    }

    /**
     * Method to increase amount of assignments done
     * @param increasement how many assignments to increase by
     */
    public void increaseNumAssignments(int increasement) {
        for (int i = 0; i < increasement; i++) { // for loop iterating through and adding 1 onto number of assignments until it reaches the value of increasement
            this.numAssignments += 1;
        //this.numAssignments += increasement;
        }
    }

    /**
     * toString method printing out necessary data from this class
     * @return returns name of student and amount of assignments done
     */
    @Override
    public String toString() {
        return this.name + ", " + this.numAssignments;
    }
}
