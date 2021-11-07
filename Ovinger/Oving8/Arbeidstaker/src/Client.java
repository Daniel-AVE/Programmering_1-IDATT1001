import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your first name: "); String firstName = in.nextLine();
        System.out.print("Enter your last name: "); String lastName = in.nextLine();
        System.out.print("Enter your birthyear: "); int birthYear = in.nextInt();
        Person person = new Person(firstName, lastName, birthYear); // creates object from class Person

        System.out.print("Enter your employee nr.: "); int employeeNr = in.nextInt();
        System.out.print("Enter the year you were hired: "); int yearHired = in.nextInt();
        System.out.print("Enter your monthly salary: "); double monthlySalary = in.nextDouble();
        System.out.print("Enter your tax percentage: "); double taxPercentage = in.nextDouble();
        Employee employee = new Employee(person, employeeNr, yearHired, monthlySalary, taxPercentage); // creates object from class Employee

        printText(employee); //  calls forth method to print out information based on employee

        while (true) { // while-loop to loop for how long user wants to
            showMenu(employee); //calls forth a menu with the information from employee
        }
    }

    /**
     * method to show menu, containing most of the functions
     * @param employee uses employee from class Employee as a variable in the method
     */
    public static void showMenu(Employee employee) {
        Scanner in = new Scanner(System.in);
        System.out.println("\nPress 1 to edit monthly salary");
        System.out.println("Press 2 to edit tax percentage");
        System.out.println("Press 3 to see employee information");
        System.out.println("Press 4 to cancel");

        int input = in.nextInt();

        switch (input) {
            case 1: // edits monthly salary
                System.out.print("What is your new monthly salary? ");
                double newSalary = in.nextDouble();
                employee.setMonthlySalary(newSalary); // sets new salary
                System.out.println("New salary is: " + employee.getMonthlySalary());
                showMenu(employee); // goes back to menu
                break;

            case 2: // edits tax percentage
                System.out.print("What is your new tax percentage? ");
                double newTax = in.nextDouble();
                employee.setTaxPercent(newTax); // sets new tax percentage
                System.out.println("New tax percentage is: " + employee.getTaxPercent());
                showMenu(employee); // goes back to menu
                break;

            case 3: // shows current information
                printText(employee); // prints information
                showMenu(employee); // goes back to menu
                break;

            case 4: // cancels
                System.out.println("Cancelling...");
                System.exit(0); // exits program
                break;

            default: // default case to control user input
                System.out.println("You need to input a number between 1-4");
                showMenu(employee); // goes back to menu
                break;
        }
    }

    /**
     * Method to print out all information
     * @param employee uses employee from class Employee as a variable
     */
    public static void printText(Employee employee) {
        System.out.println(employee);
    }
}
