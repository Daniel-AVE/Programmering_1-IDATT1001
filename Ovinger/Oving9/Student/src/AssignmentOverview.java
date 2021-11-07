import java.util.*;

public class AssignmentOverview {
    private ArrayList<Student> students;
    private int numOfStudents = 0;

    /**
     * Constructor for this class, creating a new array list based on student class
     */
    public AssignmentOverview() {
        students = new ArrayList<Student>(); // creates arraylist from student class called students
    }

    /**
     * Method to make variable students available outside of this class
     * @return returns array list students
     */
    public ArrayList<Student> getStudents(){
        return this.students;
    }

    /**
     * Method to get number of students
     * @return returns size of array list, which will let us know how many students there are
     */
    public int getNumOfStudents() {
        return students.size(); // calling size of array list to get number of objects within the array list
    }

    /**
     * Method to get number of assignments done by a student
     * @param student Name of a student which later will be used to get number of assignments that student has completed
     * @return returns amount of assignments that specific student has done
     */
    public int getNumOfAssignmentStudent(Student student) {
        int amount = student.getNumAssignments();
        return amount;
    }

    /**
     * Method to increase amount of assignments a specific student has completed
     * @param student name of the specific student
     * @param increasement how much more assignments has been done
     */
    public void increaseNumOfAssignmentStudent(Student student, int increasement){
        student.increaseNumAssignments(increasement);
    }

    /**
     * Method to create a new student
     * @param name name of student being registered
     * @param numAssignments how many assignments registered student has finished
     */
    public void newStudent(String name, int numAssignments) {
        boolean existingName = false; // default boolean value for existing name. Will be used later on to not make duplicates of a student
        for (int i = 0; i < getNumOfStudents(); i++) { // for loop to iterate through number of student to check for existing student with the same name
            if (students.get(i).getName().equals(name)) { // get(i) will iterate through each object in the arraylist, get their name, and check if that name equals the name of the new student
                existingName = true; // if there is an existing student with that name, boolean will be set to true
            }
        }
        if (!existingName) { // if there is no existing student with that name, it continues on with commands in the if statement
            Student newStudent = new Student(name, numAssignments); // creates a new student with the variables used earlier for name and assignments
            students.add(newStudent); // adds the new student to the array list
        } else { // if there is an existing student with that name, it lets user know
            System.out.println("There is already a student with that name");
        }
    }

    /**
     * toString method converting array list to an easily readable string
     * @return returns string with data from array list
     */
    @Override
    public String toString() {
        String text = ""; // creates an empty string
        for (int i = 0; i < getNumOfStudents(); i++) { // iterates through number of students
            text = text + students.get(i).toString() + " | "; // for each iteration i is less than number of students, it adds the data from that index in the array list to the string
        }
        return text; // returns string with actual information
    }

    /**
     * Method to get information about a specific student
     * @param name name of student you want data about
     * @return returns which index that student is at
     */
    public int studentId(String name) {
        int index = -1; // sets index to -1 by default, to make it start/stop at last object within the arraylist
        for (int i = 0; i < getNumOfStudents(); i++) { // for loop to iterate through number of students
            if (students.get(i).getName().equals(name)) { // iterates through the array list until it finds an object with the name which user input.
                index = i; // sets value of index to value of i, where data of specific student lies
                break; // breaks for loop
            }
        }
        return index; // returns new index value, allowing user to get information about that specific student
    }
}
