package model.vehicles;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Abstract Vehicle parent class
 * This class is extended by BiCycle, MotorBike and Car classes
 * 
 * @author Deep Singh @deepn4
 * @version AU 21
 */
public abstract class AbstractVehicle {
    /** vehicle ID */
    private int myVehicleID;
    /** vehicle VIN */
    private String myVIN;
    /** vehicle name */
    private String myName;
    /** boolean if vehicle is avaliable */
    private boolean myCanRent;
    
    /** constructor method for AbstractVehicle
     * initializes field values
     * 
     * @param theVehicleID
     * @param theVIN
     * @param theName
     * @param theCanRent
     */
    public AbstractVehicle(int theVehicleID, String theVIN, String theName, boolean theCanRent) {
        this.myName = theName;
        this.myVehicleID = theVehicleID;
        this.myVIN = theVIN;
        this.myCanRent = theCanRent;
    }
    
    /** getter method for vehicleID
     * 
     * @return int vehicle ID
     */
    public int getVehicleID() {
        return myVehicleID;
    }
    
    /** getter method for VIN
     * 
     * @return String VIN
     */
    public String getVIN() {
        return myVIN;
    }
    
    /** getter method for vehicle name
     * 
     * @return String name
     */
    public String getName() {
        return myName;
    }
    
    /** getter method for canRent
     * 
     * @return boolean canRent
     */
    public boolean getCanRent() {
        return myCanRent;
    }
    /** setter method for canRent
     * @param boolean value theCanRent
     */
    public void setCanRent(boolean theCanRent) {
    	this.myCanRent = theCanRent;
    }
    
    /** abstract method for calculate rental amount
     * 
     * @return double value of rental amount
     */
    public abstract BigDecimal calculateRentalAmount();
    
    /** override equals method
     * @return boolean
     */
    @Override
    public boolean equals(final Object theOther) {

        if (this == theOther) { // reflexive
            return true;
        }

        if (theOther == null) { // null
            return false;
        }

        if (getClass() != theOther.getClass()) { // same class
            return false;
        }

        final AbstractVehicle otherVehicle = (AbstractVehicle) theOther;
        return this.myVehicleID == otherVehicle.myVehicleID && this.myVIN.equals(otherVehicle.myVIN) 
               && this.myName.equals(otherVehicle.myName) && this.myCanRent == otherVehicle.myCanRent;
    }
    
    /** override hashcode method
     * 
     * @return int
     */
    @Override
    public int hashCode() { 
        return Objects.hash(myVehicleID, myVIN, myName, myCanRent);
    }
}
