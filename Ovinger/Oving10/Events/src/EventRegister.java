import java.util.*;

public class EventRegister {
    private ArrayList<Event> events;

    /**
     * Constructor for class EventRegister. Creates an arraylist from the class Event
     */
    public EventRegister() {
        events = new ArrayList<Event>();
    }

    /**
     * Method to call forth arraylist events in another class
     * @return returns arraylist events
     */
    public ArrayList<Event> getEvents(){
        return events;
    }

    /**
     * Method to register a new event
     * Checks to see if there is an existing event with that same name
     * @param eventName name of event
     * @param place place where event is held
     * @param organizer oragnizer of event
     * @param type type of event
     * @param dateTime date and time of event
     */
    public void newEvent(String eventName, String place, String organizer, String type, double dateTime) {
        boolean existingEvent = false; // boolean of existing event set to false by default
        int id = events.size(); // creates an integer from size of arraylist to be used to numerate events
        for (int i = 0; i < events.size(); i++){ // iterates through array list and checks for existing names, for however many object the array list contains
            if (events.get(i).getName().equals(eventName)) {
                existingEvent = true; // sets boolean existing event to true if it finds a similar name
            }
        }
        if (!existingEvent) { // if not existing event, then continue to create the new event
            Event newEvent = new Event(id, eventName, place, organizer, type, dateTime); // creates name with an id attached to it
            events.add(newEvent); // adds new event to arraylist
        } else {
            System.out.println("That event already exists"); // prints if there is an event with that existing name
        }
    }

    /**
     * Method to check for events happening at a specific place
     * @param place Place to check for events
     * @return returns an arraylist consisting of events happening at that specific place
     */
    public ArrayList<Event> eventPlace(String place){
        ArrayList<Event> eventPlace = new ArrayList<Event>(); // creates new arraylist to hold information for a specific place
        for (int i = 0; i < events.size(); i++) { // iterates through size of arraylist events
            if (events.get(i).getPlace().equals(place)) { // if it finds any objects with same place as the place input by user, it adds that event to eventPlace
                eventPlace.add(events.get(i));
            }
        }
        return eventPlace;
    }

    /**
     * Method to check for events happening at a specific date
     * @param date date to check for events
     * @return returns an arraylist consisting of events happening at that specific date
     */
    public ArrayList<Event> eventDate(double date) {
        ArrayList<Event> eventDate = new ArrayList<Event>(); // creates new arraylist to hold information for a specific date
        for (int i = 0; i < events.size(); i++) { // iterates through size of arraylist events
            int dateOfEvent = (int)Math.floor(events.get(i).getDateTime() / 10000); // Math.floor will round a double value to it's nearest integer value. In this case, we divide DateTime by 10000 to get rid of the time of event, and only have the date left
            if (dateOfEvent == (int)date) { // if date gotten from dateOfEvent is equal to date user put in,
                eventDate.add(events.get(i)); // then add the event to eventDate
            }
        }
        return eventDate;
    }

    /**
     * Method to check for events happening between two dates
     * @param date1 start date
     * @param date2 end date
     * @return returns an arraylist consisting of events happening between two specific dates
     */
    public ArrayList<Event> eventBetweenDates(double date1, double date2) {
        ArrayList<Event> eventDate = new ArrayList<Event>(); // creates new arraylist to hold information for events between dates
        for (int i = 0; i < events.size(); i++) { // iterates through size of events
            int dateOfEvent = (int)Math.floor(events.get(i).getDateTime() / 10000); // gets rid of time of event, and sit left with only date in a YYYYMMDD format
            if (dateOfEvent >= (int)date1 && dateOfEvent <= (int)date2){ // if date gotten from dateOfEvent is greater than or equal to start date, and lesser than or equal to end date,
                eventDate.add(events.get(i)); // then add that event to eventDate
            }
        }
        Comparator<Event> sortByTime = Comparator.comparingInt((Event e) -> (int) e.getDateTime()); /* comparator to sort the dates from start date to end date
        gets the integer value of DateTime for 1 variable minus integer value of dateTime another variable */
        eventDate.sort(Comparator.comparing(Event::getDateTime)); // sorts eventDate after the comparator sortByTime
        return eventDate;
    }
}
