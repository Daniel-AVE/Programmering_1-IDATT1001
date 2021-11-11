package PropertyRegister;

/**
 * A class representing Property
 * @author Daniel Evensen
 */
public class Property {
    private final int munNum, lotNum, secNum;
    private final String munName;
    private final double area;
    private String nameOfOwner, lotName;

    public Property(String munName, int munNum, int lotNum, int secNum, String lotName, double area, String nameOfOwner) {
        this.munName = munName;
        this.munNum = munNum;
        this.lotNum = lotNum;
        this.secNum = secNum;
        this.lotName = lotName;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

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

    public void setNameOfOwner(String newOwner) {
        this.nameOfOwner = newOwner;
    }

    public String getPropertyId() {
        return this.getMunNum() + "-" + this.getLotNum() + "/" + this.getSecNum();
    }

    @Override
    public String toString() {
        if (this.getLotName().equals("")) {
            return "Municipality: " + this.getMunName() + ", property id: " + this.getPropertyId() + ", area: " + this.getArea() + "m2, owner: " + this.getNameOfOwner();
        } else {
            return "Municipality: " + this.getMunName() + ", property id: " + this.getPropertyId() + ", property name: " + this.getLotName() + ", area: " + this.getArea() + "m2, owner: " + this.getNameOfOwner();
        }
    }
}
