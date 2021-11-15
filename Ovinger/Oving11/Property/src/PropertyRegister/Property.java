package PropertyRegister;

/**
 * A class representing Property
 * @author Daniel Evensen
 */
public class Property {
    /**
     * Defining object variables
     * Final variables will not have any mutator methods, and will therefore not be changed
     * !Final variables will have a mutator method, and will be changeable
     */
    private final int munNum, lotNum, secNum;
    private final String munName, lotName;
    private final double area;
    private String nameOfOwner;

    /**
     * Constructor for class Property, contains needed information about a property, to be used in Property register
     * @param munName name of municipality
     * @param munNum number of municipality
     * @param lotNum lot number of property
     * @param secNum section number of property
     * @param lotName name of property
     * @param area area in m2
     * @param nameOfOwner owner of property
     */
    public Property(String munName, int munNum, int lotNum, int secNum, String lotName, double area, String nameOfOwner) {
        this.munName = munName;
        this.munNum = munNum;
        this.lotNum = lotNum;
        this.secNum = secNum;
        this.lotName = lotName;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
        // ThrowNewIllegal for godkjente verdier, not illegal arguments
        // Kan lage propertyID her
    }

    /**
     * Accessor-methods for class
     */
    public String getMunName() {
        return munName;
    }

    public int getMunNum() {
        return munNum;
    }

    public int getLotNum() {
        return lotNum;
    }

    public int getSecNum() {
        return secNum;
    }

    public String getLotName() {
        return lotName;
    }

    public double getArea() {
        return area;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    /**
     * Mutator-method.
     * This is the only mutator method created, due to it being the most likely variable to change.
     * And owner of a home can change when it's sold. But it's not often a property's area is expanded, or the name of a
     * property is changed. Leading to this being the only mutator-method
     * @param newOwner name of new owner
     */
    public void setNameOfOwner(String newOwner) {
        this.nameOfOwner = newOwner;
    }

    /**
     * Method for converting municipality number, lot number and section number into a unique id for property
     * @return returns unique id for property
     */
    public String getPropertyId() {
        return this.getMunNum() + "-" + this.getLotNum() + "/" + this.getSecNum();
    }

    /**
     * To string method to collect all information about property into one returnable string
     * @return if lot name is empty, then it returns a collection of information, excluding lot name
     * @return if lot name is not empty, then it returns a collection of information, including lot name
     */
    @Override
    public String toString() {
        if (this.getLotName().equals("")) {
            return "Municipality: " + this.getMunName() + ", property id: " + this.getPropertyId() + ", area: " + this.getArea() + " m2, owner: " + this.getNameOfOwner();
        } else {
            return "Municipality: " + this.getMunName() + ", property id: " + this.getPropertyId() + ", property name: " + this.getLotName() + ", area: " + this.getArea() + " m2, owner: " + this.getNameOfOwner();
        }
    }
}
