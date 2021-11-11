package PropertyRegister;

import java.util.*;

/**
 * Class administrating a property register, with method for finding, removing and adding properties
 * @author Daniel Evensen
 */

public class PropertyRegister {
    private ArrayList<Property> properties;

    public PropertyRegister() {
        properties = new ArrayList<Property>();
    }

    public void newProperty(String munName, int munNum, int lotNum, int secNum, String lotName, double area, String nameOfOwner) {
        boolean existingProperty = false;
        String propertyId = munNum + "-" + lotNum + "/" + secNum;

        if (munNum < 0 || lotNum < 0 || secNum < 0 || area < 0) {
            throw new IllegalArgumentException("Value must be positive");
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
        ArrayList<Property> propertiesByLotNum = new ArrayList<Property>();
        for (int i = 0; i < getNumOfProperties(); i++) {
            if (properties.get(i).getLotNum() == lotNum) {
                Property property = properties.get(i);
                propertiesByLotNum.add(property);
            }
        }
        return propertiesByLotNum;
    }

    public String allProperties() {
        String allProperties = "";
        String LS = System.getProperty("line.separator");
        for (int i = 0; i < getNumOfProperties(); i++) {
            allProperties += properties.get(i).toString() + LS;
        }
        return allProperties;
    }
}
