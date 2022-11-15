package model.vehicles;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * MotorBike vehicle class
 * This class is extends the AbstractVehicle class
 * 
 * @author Deep Singh @deepn4
 * @version AU 21
 */
public class MotorBike extends AbstractVehicle{

    /** BigDecimal value of rental amount */
    private BigDecimal myRentalAmount;
    /** boolean if vehicle is touring */
    private boolean myIsTouring;
    /** base fare final value */
    private static final BigDecimal BASE_FARE = new BigDecimal("10.00");
    /** bike fare final value */
    private static final BigDecimal BIKE_FARE = BASE_FARE.multiply(new BigDecimal("2"));
    
    /** touring final value */
    private static final BigDecimal TOURING = new BigDecimal("5");

    /** MotorBike constructor method initializes fields
     * 
     * @param theVehicleID
     * @param theVIN
     * @param theName
     * @param theCanRent
     * @param theIsTouring
     */
    public MotorBike(final int theVehicleID, final String theVIN, final String theName, 
                     final boolean theCanRent, final boolean theIsTouring) {
        super(theVehicleID, theVIN, theName, theCanRent);
        this.myIsTouring = theIsTouring;
    }
    
    /** getter method for isTouring
     * 
     * @return boolean
     */
    public boolean getIsTouring() {
        return myIsTouring;
    }

    /** calculates the rental amount for each vehicle class
     * @return double value of BigDecimal
     */
    public BigDecimal calculateRentalAmount() {
        if (getIsTouring() == true) {
            myRentalAmount = BIKE_FARE.add(TOURING);
        }
        else {
            myRentalAmount = BIKE_FARE;
        }
        return myRentalAmount;
    }
    
    /** toString method for MotorBike
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
          .append( " (ID: ")
          .append(getVehicleID())
          .append(", Name: ")
          .append(getName())
          .append(", VIN: ")
          .append(getVIN())
          .append(", CanRent?: ")
          .append(getCanRent())
          .append(", IsTouring?: ")
          .append(getIsTouring())
          .append(")");
        return sb.toString();
    }
    
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

        final MotorBike otherMotorBike = (MotorBike) theOther;
        return this.myIsTouring == otherMotorBike.myIsTouring;
    }
    
    /** override hashcode method
     * @return int
     */
    @Override
    public int hashCode() { 
        return Objects.hash(myIsTouring);
    }

}
