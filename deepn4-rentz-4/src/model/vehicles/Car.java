package model.vehicles;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Car vehicle class
 * This class is extends the AbstractVehicle class
 * 
 * @author Deep Singh @deepn4
 * @version AU 21
 */
public class Car extends AbstractVehicle {

    /** BigDecimal value of rental amount */
    private BigDecimal myRentalAmount;
    /** boolean if vehicle is luxury */
    private boolean myLuxury;
    /** boolean if vehicle has navigation */
    private boolean myNavigation;
    /** boolean if vehicle has driving assistance */
    private boolean myDrivingAssistance;
    /** base fare final value */
    private static final BigDecimal BASE_FARE = new BigDecimal("10.00");
    /** car fare final value */
    private static final BigDecimal CAR_FARE = BASE_FARE.multiply(new BigDecimal("3"));
    
    /** luxury final value */
    private static final BigDecimal LUXURY = new BigDecimal("10");
    /** navigation final value */
    private static final BigDecimal NAVIGATION = new BigDecimal("1");
    /** driving assistance final value */
    private static final BigDecimal DRIVINGASSISTANCE = new BigDecimal("2");
    
    /** Car constructor method initializes fields
     * 
     * @param theVehicleID
     * @param theVIN
     * @param theName
     * @param theCanRent
     * @param theLuxury
     * @param theNavigation
     * @param theDrivingAssistance
     */
    public Car(final int theVehicleID, final String theVIN, final String theName, final boolean theCanRent,
               final boolean theLuxury, final boolean theNavigation, final boolean theDrivingAssistance) {
        super(theVehicleID, theVIN, theName, theCanRent);
        this.myDrivingAssistance = theDrivingAssistance;
        this.myLuxury = theLuxury;
        this.myNavigation = theNavigation;
    }
    /** getter method for driving assistance
     * 
     * @return boolean
     */
    public boolean getDrivingAssistance() {
        return myDrivingAssistance;
    }
    
    /** getter method for luxury
     * 
     * @return boolean
     */
    public boolean getLuxury() {
        return myLuxury;
    }
    
    /** getter method for navigation
     * 
     * @return boolean
     */
    public boolean getNavigation() {
        return myNavigation;
    }

    /** calculates the rental amount for each vehicle class
     * @return double value of BigDecimal
     */
    public BigDecimal calculateRentalAmount() {
        if (getLuxury() == true) {
            myRentalAmount = CAR_FARE.add(LUXURY);
        }
        if (getNavigation() == true) {
            myRentalAmount = CAR_FARE.add(NAVIGATION);
        }
        if (getDrivingAssistance() == true) {
            myRentalAmount = CAR_FARE.add(DRIVINGASSISTANCE);
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
          .append(", IsLuxury?: ")
          .append(getLuxury())
          .append(", HasNavigation?: ")
          .append(getNavigation())
          .append(", HasAssistance?: ")
          .append(getDrivingAssistance())
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

        final Car otherCar = (Car) theOther;
        return this.myLuxury == otherCar.myLuxury && this.myNavigation == otherCar.myNavigation &&
               this.myDrivingAssistance == otherCar.myDrivingAssistance;
        
    }
    /** override hashcode method
     * @return int
     */
    @Override
    public int hashCode() { 
        return Objects.hash(myLuxury, myNavigation, myDrivingAssistance);
    }

}