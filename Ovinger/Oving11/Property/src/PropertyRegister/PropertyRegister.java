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

    public int getNumOfProperties() {
        int numOfProperties = properties.size();
        return numOfProperties;
    }

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

    public double averageArea() {
        double totalArea = 0;
        for (int i = 0; i < getNumOfProperties(); i++) {
            totalArea += properties.get(i).getArea();
        }
        return totalArea / getNumOfProperties(); // returns average area
    }

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
