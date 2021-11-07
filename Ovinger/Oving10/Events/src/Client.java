import java.util.*;

public class Client {
    public static void main(String[] args) {
        EventRegister e = new EventRegister();

        while (true) { // infinite while loop
            showMenu(e); // calls forth method by using information from object e
        }
    }

    public static void showMenu(EventRegister e) {
        Scanner in = new Scanner(System.in);
        System.out.println("\nPress 1 to register a new event");
        System.out.println("Press 2 to find events happening at a specific place");
        System.out.println("Press 3 to find events happening at a specific date");
        System.out.println("Press 4 to find events happening between to specific dates");
        System.out.println("Press 5 to see a list of events");
        System.out.println("Press 6 to cancel");

        int input = in.nextInt();

        switch(input) {
            case 1: // case for registering a new event
                in.nextLine();
                System.out.println("Enter name of event: ");
                String eventName = in.nextLine();

                System.out.println("Enter place of event: ");
                String place = in.nextLine();

                System.out.println("Enter organizer of event: ");
                String organizer = in.nextLine();

                System.out.println("Enter type of event: ");
                String type = in.nextLine();

                System.out.println("Enter date and time of event YYYYMMDDHHMM (year, month, date, hour, minute: ");
                double dateTime = in.nextDouble();

                e.newEvent(eventName, place, organizer, type, dateTime); // creates new event
                showMenu(e); // goes back to menu after finishing operations
                break;

            case 2: // case for looking at events happening at specific places
                in.nextLine();
                System.out.println("Which place would you like to look for events?");
                place = in.nextLine();
                Print(e.eventPlace(place)); // calls forth method called print with information from object e, by using place as a variable
                showMenu(e); // goes back to menu after finishing operations
                break;

            case 3: // case for looking at events happening at specific dates
                in.nextLine();
                System.out.println("What date would you like to look for events? (YYYYMMDD)");
                double date = in.nextDouble();
                Print(e.eventDate(date)); // calls fort method called print with the information just gathered
                showMenu(e); // goes back to menu after finishing operations
                break;

            case 4: // case for looking at events happening between two specific dates
                in.nextLine();
                System.out.println("Enter start date (YYYYMMDD)");
                double date1 = in.nextDouble();
                System.out.println("Enter end date (YYYYMMDD)");
                double date2 = in.nextDouble();
                Print(e.eventBetweenDates(date1,date2)); // calls forth method called print with the information just gathered
                showMenu(e); // goes back to menu after finishing operations
                break;

            case 5: // case for showing the current list of events. Invokes a new switch case depending on what user wants
                in.nextLine();
                System.out.println("Press 1 to sort after event name");
                System.out.println("Press 2 to sort after event type");
                System.out.println("Press 3 to sort after event date");
                System.out.println("Press 4 to cancel");
                int choice = in.nextInt();

                switch(choice) {
                    case 1: // case for sorting list by event name
                        Comparator<Event> sortByPlace = (Event e1, Event e2) -> e1.getPlace().compareTo(e2.getPlace()); // compares places within arraylist
                        ArrayList<Event> event1 = e.getEvents(); // creates a new arraylist from arraylist events
                        Collections.sort(event1, sortByPlace); // sorts new arraylist event1 by comparator sortByPlace
                        Print(event1); // Calls forth method called print with the information just gathered
                        showMenu(e); // goes back to menu after finishing operations
                        break;

                    case 2: // case for sorting list by event type
                        Comparator<Event> sortByType = (Event e1, Event e2) -> e1.getType().compareTo(e2.getType()); // compares types within arraylist
                        ArrayList<Event> event2 = e.getEvents(); // creates a new arraylist from arraylist events
                        Collections.sort(event2, sortByType); // sorts new arraylist event2 by comparator sortByType
                        Print(event2); // calls forth method called print with the information just gathered
                        showMenu(e); // goes back to menu after finishing operations
                        break;

                    case 3: // case for sorting list by event date
                        Comparator<Event> sortByDate = (Event e1, Event e2) -> (int)e1.getDateTime() - (int)e2.getDateTime(); // compares dates within arraylist
                        ArrayList<Event> event3 = e.getEvents(); // creates a new arraylist from arraylist events
                        Collections.sort(event3, sortByDate); // sorts new arraylist event3 by comparator sortByDate
                        Print(event3); // calls forth method called print with information just gathered
                        showMenu(e); // goes back to menu after finishing operations
                        break;

                    case 4: // case for cancelling program
                        System.out.println("Cancelling...");
                        System.exit(0);
                        break;

                    default: // default case in case user inputs a number out of scope
                        System.out.println("You need to enter a number between 1 and 4");
                        showMenu(e); // goes back to menu
                        break;
                }

            case 6: // case for cancelling program
                System.out.println("Cancelling...");
                System.exit(0);
                break;

            default: // default case in case user inputs a number out of scope
                System.out.println("You need to enter a number between 1 and 6");
                showMenu(e); // goes back to menu
                break;
        }
    }

    /**
     * Method to print out everything within arraylist
     * @param list creates a new arraylist which copies information from object e
     */
    public static void Print(ArrayList<Event> list) {
        System.out.println("");
        if (list.size() < 1) { // if size of arraylist list is less than one, it lets user know there are no events
            System.out.println("There are no events");
        } else { // if size of list is 1 or more
            System.out.println("Events:");
            for (int i = 0; i < list.size(); i++) { // iterates through size of list
                Event event = list.get(i); // for every iteration, it creates a new object of class Event and prints that out
                System.out.println(event.toString()); // uses toString method from class Event to print out information from object event for every iteration
            }
        }
    }
}
