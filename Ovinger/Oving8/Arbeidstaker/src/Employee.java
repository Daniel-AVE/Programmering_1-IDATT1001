import java.util.*;

public class Employee {
    private final Person personalia; // creates object from class Person
    private final int employeeNr, yearHired;
    private double monthlySalary, taxPercent;
    GregorianCalendar calendar = new GregorianCalendar(); // makes it possible to work with years in this calendar

    /**
     * constructor containing new objects, and object from class Person
     * @param personalia calls forth constructor from class Person, and uses it in this constructor
     * @param employeeNr employee nr for employee
     * @param yearHired which year employee was hired
     * @param monthlySalary employee's monthly salary
     * @param taxPercent how much employee pays in tax
     */
    public Employee(Person personalia, int employeeNr, int yearHired, double monthlySalary, double taxPercent) {
        this.personalia = personalia;
        this.employeeNr = employeeNr;
        this.yearHired = yearHired;
        this.monthlySalary = monthlySalary;
        this.taxPercent = taxPercent;
    }

    /**
     * makes personalia callable outside of class
     * @return returns personalia
     */
    public Person getPersonalia() {
        return personalia;
    }

    /**
     * makes employeenr callable outside of class
     * @return returns personalia
     */
    public int getEmployeeNr() {
        return employeeNr;
    }

    /**
     * makes year hired callable outside of class
     * @return returns yearHireed
     */
    public int getYearHired() {
        return yearHired;
    }

    /**
     * method to call forth monthlySalary outside of class
     * @return returns monthlySalary
     */
    public  double getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * makes taxPercent callable outside of class
     * @return returns taxPercent
     */
    public  double getTaxPercent() {
        return taxPercent;
    }

    /**
     * method to change monthlySalary, contains a double variable for new salary
     * @param newSalary sets monthly salary to new salary
     */
    public void setMonthlySalary(double newSalary) {
        this.monthlySalary = newSalary;
    }

    /**
     * method to change taxPercent, contains a double variable for new tax percent
     * @param newTaxPercent sets taxPercent to new tax percent
     */
    public void setTaxPercent(double newTaxPercent) {
        this.taxPercent = newTaxPercent;
    }

    /**
     * method for calculating how much employee pays in tax each month
     * @return returns how much employee payed in tax
     */
    public double getTaxPayed() {
        //getMonthlySalary(); // calls forth monthly salary
        //getTaxPercent(); // calls forth taxPercent
        double taxPayed = monthlySalary * (taxPercent / 100); // taxPercent/100 to get decimal value, then multiplying with salary to get how much tax was payed
        return taxPayed;
    }

    /**
     * Method to get monthly salary after tax
     * @return returns monthly salary after tax
     */
    public double getNetMonthlySalary() {
        getMonthlySalary();
        getTaxPayed();
        double netMonthlySalary = monthlySalary - getTaxPayed(); // subtracts pax payed from monthly salary to get net salary
        return netMonthlySalary;
    }

    /**
     * Method for calculating employee's gross yearly salary
     * @return returns yearlySalary
     */
    public double getGrossYearlySalary() {
        getMonthlySalary(); // calls forth monthly salary
        double yearlySalary = monthlySalary * 12; // multiplies monthly salary by 12 to get gross yearly salary
        return yearlySalary;
    }

    /**
     * Method for calculating employee's yearly salary after tax
     * @return returns yearlySalary after paying tax
     */
    public double getNetYearlySalary() {
        double yearlySalary = (monthlySalary * 12) - this.getYearlyTaxPayed(); // gets yearly salary, and subtracts yearly tax payed from that
        return yearlySalary;
    }

    /**
     * Method to calculate how much employee pays in tax each year. Including no tax in June, and half tax in December
     * @return returns yearlyTaxPayed
     */
    public double getYearlyTaxPayed() {
        //getMonthlySalary(); // calls forth monthly salary
        //getTaxPayed(); // calls forth taxPayed each month
        double yearlyTaxPayed = (this.getTaxPayed() * 10) + (this.getTaxPayed() * 0.5); // calculates how much is payed in tax
        return yearlyTaxPayed;
    }

    /**
     * Method to get employee's name in a Lastname, Firstname format
     * @return returns name in Lastname, Firstname format
     */
    public String getName() {
        String name = this.getPersonalia().getLastName() + ", " + this.getPersonalia().getFirstName();
        return name;
    }

    /**
     * Method for getting employee's age
     * @return returns age
     */
    public int getAge() {
        int currentYear = calendar.get(java.util.Calendar.YEAR); //gets current year
        int age = currentYear - this.getPersonalia().getBirthYear(); // subtracts employee's birth year from current year to get age
        return age;
    }

    /**
     * Method for getting how long employee has worked in the company
     * @return returns yearsHired
     */
    public int getYearsHired() {
        int currentYear = calendar.get(java.util.Calendar.YEAR); // gets current year
        int yearsHired = currentYear - this.getYearHired(); // subtracts year hired from current year to get years hired
        return yearsHired;
    }

    /**
     * Method to check if employee has been employd longer than a set amount of time
     * @param years number of years to check if employee has worked longer than
     * @return returns true or false for if employee has been employed longer than int years
     */
    public boolean getEmployedLongerThan(int years) {
        boolean longerThan = false; // sets false as default value

        if (this.getYearsHired() >= years) { // if employee has worked longer than, or equal to int years
            longerThan = true; // sets true if if-statement is true
        }
        return longerThan; // if if-statement is false, then returns default value, which is false
    }

    @Override
    public String toString() {
        return "\nEmployee information:" +
            "\nName: " + getName() +
            "\nAge: " + getAge() +
            "\nMonthly income: " + getMonthlySalary() +
            "\nTax payed per month: " + getTaxPayed() +
            "\nMonthly income after tax: " + getNetMonthlySalary() +
            "\nYearly tax payed: " + getYearlyTaxPayed() +
            "\nYearly gross salary: " + getGrossYearlySalary() +
            "\nYearly net salary: " + getNetYearlySalary() +
            "\nYears hired: " + getYearsHired() +
            "\nEmployed more than 5 years? " + getEmployedLongerThan(5);
    }
}

