package PropertyRegister;

import java.util.*;

/**
 * Class administrating a property register, with method for finding, removing and adding properties
 * @author Daniel Evensen
 */
public class PropertyRegister {
    /**
     * private ArrayList made from Property class
     */
    private ArrayList<Property> properties;

    /**
     * Constructor for PropertyRegister class.
     * Creates a new arraylist
     */
    public PropertyRegister() {
        properties = new ArrayList<Property>();
    }

    /**
     * Method for making arraylist properties reachable outside of class
     * @return returns arraylist
     */
    public ArrayList<Property> getProperties(){
        return properties;
    }

    /**
     * Method for creating a new property
     * Checks input for illegal arguments, and throws new IllegalArgumentException depending on which illegal argument it finds
     * If no illegal arguments, then it continues
     * Uses boolean "existingProperty" to check for already existing properties. If exising property is found, then it lets user know
     * if existing property not found, then it proceeds to register it
     * @param munName name of municipality
     * @param munNum number of municipality
     * @param lotNum lot number
     * @param secNum section number
     * @param lotName lot name
     * @param area area of property in m2
     * @param nameOfOwner Name of the property owner
     */
    public void newProperty(String munName, int munNum, int lotNum, int secNum, String lotName, double area, String nameOfOwner) {
        boolean existingProperty = false;
        String propertyId = munNum + "-" + lotNum + "/" + secNum;

        if (munNum < 0 || lotNum < 0 || secNum < 0 || area < 0) {
            throw new IllegalArgumentException("Value must be positive");
        } else if (munNum < 101 || munNum > 5054){
            throw new IllegalArgumentException("Municipality number must be between 101 and 5054!");
        } else {
            for (int i = 0; i < getNumOfProperties(); i++) {
                if (properties.get(i).getPropertyId().equals(propertyId)) {
                    existingProperty = true;
                }
            }

            if (!existingProperty) {
                Property property = new Property(munName, munNum, lotNum, secNum, lotName, area, nameOfOwner);
                properties.add(property);
            } else {
                System.out.println("There is already a property with that lot name");
            }
        }
    }

    /**
     * Method for removing property from arraylist.
     * Uses illegal argument exception to look for illegal arguments used by user
     * Converts values to string propertyId to make it easier to work with
     * Uses boolean "propertyExists" to check if input propertyId exists or not. If it exists, it gets removed
     * if it does not exist, it lets user know.
     * Iterates through number of objects within arraylist property using previously created method, and looks for
     * the first object within the arraylist matching the input property id, then removes it from the arraylist.
     * Uses break to cancel loop once found and removed.
     * @param munNum municipality number
     * @param lotNum lot number
     * @param secNum section number
     */
    public void removeProperty(int munNum, int lotNum, int secNum) {
        String propertyId = munNum + "-" + lotNum + "/" + secNum;
        boolean propertyExists = false;

        if (munNum < 0 || lotNum < 0 || secNum < 0) {
            throw new IllegalArgumentException("Value must be positive");
        } else {
            for (int i = 0; i < getNumOfProperties(); i++) {
                if (properties.get(i).getPropertyId().equals(propertyId)) {
                    propertyExists = true;
                    Property property = properties.get(i);
                    properties.remove(property);
                    break;
                }
            }
            if (!propertyExists) {
                throw new IllegalArgumentException("Found no properties with that property id");
            }
        }
    }

    /**
     * Method for getting number of objects within arraylist properties
     * @return returns integer value of number of objects
     */
    public int getNumOfProperties() {
        int numOfProperties = properties.size();
        return numOfProperties;
    }

    /**
     * Method for finding a property. Creates a new arraylist of the class Property, uses property id to search for a property.
     * Throws new illegal argument exception if it detects set illegal argument from user.
     * Iterates through size of arraylist until it finds a matching object, before adding it to the new arraylist and cancelling loop.
     * Throws new illegal argument exception if it cannot find a matching object
     * @param munNum municipality number
     * @param lotNum lot number
     * @param secNum section number
     * @return returns newly created arraylist
     */
    public ArrayList<Property> findProperty(int munNum, int lotNum, int secNum) {
        String propertyId = munNum + "-" + lotNum + "/" + secNum;
        boolean propertyExists = false;
        ArrayList<Property> foundProperty = new ArrayList<Property>();

        if (munNum < 0 || lotNum < 0 || secNum < 0) {
            throw new IllegalArgumentException("Value must be positive");
        } else {
            for (int i = 0; i < getNumOfProperties(); i++) {
                if (properties.get(i).getPropertyId().equals(propertyId)) {
                    propertyExists = true;
                    Property property = properties.get(i);
                    foundProperty.add(property);
                    break;
                }
            }
            if (!propertyExists) {
                throw new IllegalArgumentException("Found no properties with that property id");
            }
        }
        return foundProperty;
    }

    /**
     * Method for calculating average area of all registered properties
     * Iterates through size of arraylist properties, and adds the area of each object to a double totalArea for each iteration
     * @return returns total area divided by number of objects in arraylist properties. Gives the average area of all registered properties
     */
    public double averageArea() {
        double totalArea = 0;
        for (int i = 0; i < getNumOfProperties(); i++) {
            totalArea += properties.get(i).getArea();
        }
        return totalArea / getNumOfProperties(); // returns average area
    }

    /**
     * Method for finding all properties sharing a lot number. Creates a new arraylist as an object of the class Property.
     * Throws new illegal argument exception if it detects set illegal argument by user
     * iterates through size of arraylist properties, and adds all objects with the same lot number to a new arraylist,
     * before returning the new arraylist
     * @param lotNum lot number
     * @return returns new arraylist
     */
    public ArrayList<Property> findPropertiesByLotNum(int lotNum) {
        if (lotNum < 0) {
            throw new IllegalArgumentException("Lot number must be positive");
        } else {
            ArrayList<Property> propertiesByLotNum = new ArrayList<Property>();
            for (int i = 0; i < getNumOfProperties(); i++) {
                if (properties.get(i).getLotNum() == lotNum) {
                    propertiesByLotNum.add(properties.get(i));
                }
            }
            return propertiesByLotNum;
        }
    }

    /**
     * Method for changing owner of a property. Uses property id to find specific property, and a string for the new owner
     * Throws new illegal argument exception if it detects an illegal argument by user
     * uses boolean propertyExists to give user information if it doesn't exist
     * iterates through number of objects in arraylist properties until it finds an object with matching property id
     * if it finds a matching id, it sets boolean to true, changes name of owner for that object, then exits loop
     * if it doesn't find a matching id, it throws a new illegal argument exception and lets user know that there is no property with that id
     * @param munNum
     * @param lotNum
     * @param secNum
     * @param newOwner
     */
    public void changeOwner(int munNum, int lotNum, int secNum, String newOwner) {
        String propertyId = munNum + "-" + lotNum + "/" + secNum;
        boolean propertyExists = false;

        if (munNum < 0 || lotNum < 0 || secNum < 0) {
            throw new IllegalArgumentException("Value must be positive");
        } else {
            for (int i = 0; i < getNumOfProperties(); i++) {
                if (properties.get(i).getPropertyId().equals(propertyId)) {
                    propertyExists = true;
                    properties.get(i).setNameOfOwner(newOwner);
                    break;
                }
            }
            if (!propertyExists) {
                throw new IllegalArgumentException("There are no properties with that property id");
            }
        }
    }
}
