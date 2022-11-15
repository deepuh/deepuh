package model.vehicles;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * BiCycle vehicle class
 * This class is extends the AbstractVehicle class
 * 
 * @author Deep Singh @deepn4
 * @version AU 21
 */

public class BiCycle extends AbstractVehicle {
    /** BigDecimal value of rental amount */
    private BigDecimal myRentalAmount;
    /** type of BiCycle */
    private String myCycleType;
    /** base fare final value */
    private static final BigDecimal BASE_FARE = new BigDecimal("10.00");
    /** cycle fare final value */
    private static final BigDecimal CYCLE_FARE = BASE_FARE;
    
    /** BigDecimal value of one percent */
    private static final BigDecimal ONE_PERCENT = new BigDecimal("1.01");
    /** BigDecimal value of two percent */
    private static final BigDecimal TWO_PERCENT = new BigDecimal("1.02");
    /** BigDecimal value of four percent */
    private static final BigDecimal FOUR_PERCENT = new BigDecimal("1.04");

    /** BiCycle constructor method initialzes fields
     * 
     * @param theVehicleID
     * @param theVIN
     * @param theName
     * @param theCanRent
     * @param theCycleType
     */
    public BiCycle(final int theVehicleID, final String theVIN, final String theName,
                   final boolean theCanRent, final String theCycleType) {
        super(theVehicleID, theVIN, theName, theCanRent);
        this.myCycleType = theCycleType;
    }
    
    /** getter method for cycle type
     * 
     * @return String 
     */
    public String getCycleType() {
        return myCycleType;
    }

    /** calculates the rental amount for each vehicle class
     * @return double value of BigDecimal
     */
    public BigDecimal calculateRentalAmount() {
        if (myCycleType.equals("Road")) {
            myRentalAmount = CYCLE_FARE;
        }
        else if (myCycleType.equals("Mountain")) {
            myRentalAmount = CYCLE_FARE.multiply(ONE_PERCENT);
        }
        else if (myCycleType.equals("Cruiser")) {
            myRentalAmount = CYCLE_FARE.multiply(TWO_PERCENT);
        }
        else if (myCycleType.equals("Hybrid")) {
            myRentalAmount = CYCLE_FARE.multiply(FOUR_PERCENT);
        }
        return myRentalAmount;
    }
    
    /** toString method for BiCycle
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
          .append(", CycleType: ")
          .append(getCycleType())
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

        final BiCycle otherBicycle = (BiCycle) theOther;
        return this.myCycleType.equals(otherBicycle.myCycleType);
    }
    
    /** override hashcode method
     * @return int
     */
    @Override
    public int hashCode() { 
        return Objects.hash(myCycleType);
    }

    
//    public class Road extends BiCycle{
//        
//        public Road(int theVehicleID, String theVIN, String theName, boolean theCanRent) {
//            super(theVehicleID, theVIN, theName, theCanRent);
//            
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            sb.append("BiCycle ")
//              .append( "(ID: ")
//              .append(getVehicleID())
//              .append(", Name: ")
//              .append(getName())
//              .append(", VIN: ")
//              .append(getVIN())
//              .append(", CanRent?: ")
//              .append(getCanRent())
//              .append(", CycleType: ")
//              .append(getClass().getSimpleName())
//              .append(")");
//            return sb.toString();
//        }
//        super.calculateRentalAmount();
//    }
//    public class Mountain extends BiCycle{
//        public Mountain(int theVehicleID, String theVIN, String theName, boolean theCanRent) {
//            super(theVehicleID, theVIN, theName, theCanRent);
//       
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            sb.append("BiCycle ")
//              .append( "(ID: ")
//              .append(getVehicleID())
//              .append(", Name: ")
//              .append(getName())
//              .append(", VIN: ")
//              .append(getVIN())
//              .append(", CanRent?: ")
//              .append(getCanRent())
//              .append(", CycleType: ")
//              .append(getClass().getSimpleName())
//              .append(")");
//            return sb.toString();
//        }
//        super.calculateRentalAmount();
//    }
//    public class Cruiser extends BiCycle{
//        public Cruiser(int theVehicleID, String theVIN, String theName, boolean theCanRent) {
//            super(theVehicleID, theVIN, theName, theCanRent);
//         
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            sb.append("BiCycle ")
//              .append( "(ID: ")
//              .append(getVehicleID())
//              .append(", Name: ")
//              .append(getName())
//              .append(", VIN: ")
//              .append(getVIN())
//              .append(", CanRent?: ")
//              .append(getCanRent())
//              .append(", CycleType: ")
//              .append(getClass().getSimpleName())
//              .append(")");
//            return sb.toString();
//        }
//        super.calculateRentalAmount();
//    }
//    public class Hybrid extends BiCycle{
//        public Hybrid(int theVehicleID, String theVIN, String theName, boolean theCanRent) {
//            super(theVehicleID, theVIN, theName, theCanRent);            
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            sb.append("BiCycle ")
//              .append( "(ID: ")
//              .append(getVehicleID())
//              .append(", Name: ")
//              .append(getName())
//              .append(", VIN: ")
//              .append(getVIN())
//              .append(", CanRent?: ")
//              .append(getCanRent())
//              .append(", CycleType: ")
//              .append(getClass().getSimpleName())
//              .append(")");
//            return sb.toString();
//        }
//        super.calculateRentalAmount();
//    }
}
