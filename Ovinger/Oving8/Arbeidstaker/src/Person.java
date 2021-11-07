public class Person {
    private final String firstName;
    private final String lastName;
    private final int birthYear;

    /**
     * constructor for person
     * @param firstName first name of person
     * @param lastName last name of person
     * @param birthYear birth year of person
     */
    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    /**
     * makes firstname callable outside of class
     * @return returns first namee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * makes last name callable outside of class
     * @return returns last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * makes birth year callable outside of class
     * @return returns birth year
     */
    public int getBirthYear() {
        return birthYear;
    }
}
