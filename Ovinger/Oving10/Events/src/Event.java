public class Event {
    private final int eventId;
    private final double dateTime;
    private final String eventName, place, organizer, type;

    /**
     * Constructor for class Event
     * @param id id number of event
     * @param eventName name of event
     * @param place place where event is held
     * @param organizer organizer of the event
     * @param type type of event
     * @param dateTime date and time of event
     */
    public Event(int id, String eventName, String place, String organizer, String type, double dateTime) {
        this.eventId = id;
        this.eventName = eventName;
        this.place = place;
        this.organizer = organizer;
        this.type = type;
        this.dateTime = dateTime;
    }
    /*
    * Following method are methods to get variables outside of this class
    */
    public int getEventId() {
        return eventId;
    }

    public String getName() {
        return eventName;
    }

    public String getPlace() {
        return place;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getType() {
        return type;
    }

    public double getDateTime() {
        return dateTime;
    }

    /**
     * A tostring to print out information about an event
     * Substrings time to split the input format of YYYYMMDDHHMM to more easily readable format of time. Ex: 21.11.2021 kl. 19:00
     * @return returns a string of text containing information about an event
     */
    public String toString() {
        String t = String.format("%.1f", this.getDateTime());
        String time = t.substring(6, 8) + "." + t.substring(4, 6) + "." + t.substring(0, 4) + " kl. " + t.substring(8, 10) + ":" + t.substring(10, 12);
        return "Id: " + this.getEventId() + ", name: " + this.getName() + ", place: " + this.getPlace() + ", organizer: " + this.getOrganizer() + ", type: " + this.getType() + ", date and time: " + time;
    }
}
