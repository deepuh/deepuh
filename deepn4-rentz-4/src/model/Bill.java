package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import model.vehicles.AbstractVehicle;
/**
 * This class creates the Bill object that is used to print
 * total bill amount in rental manager class.
 * 
 * @author Deep Singh @deepn4
 * @version AU 21
 */
public class Bill {
    /** bill ID int */
    private int myBillID;
    /** User object */
    private User myPrimaryUser;
    /** AbstractVehicle object */
    private AbstractVehicle myVehicle;
    /** int for days vehicle is being rented */
    private int myNumDays;
    /** BigDecimal value for bill amount */
    private BigDecimal myBillAmount;
    
    /** Constructor method for Bill which initializes fields.
     * 
     * @param theBillID
     * @param thePrimaryUser
     * @param theVehicle
     * @param theNumDays
     */
    public Bill(final int theBillID, final User thePrimaryUser, final AbstractVehicle theVehicle, final int theNumDays) {
        this.myBillID = theBillID;
        this.myNumDays = theNumDays;
        this.myPrimaryUser = thePrimaryUser;
        this.myVehicle = theVehicle;
        
        this.myBillAmount = new BigDecimal("0");
        
    }
    /** Calculates and prints the bill amount
     * 
     */
    public void computeAndPrintAmount() {
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        
        BigDecimal rentalAmount = BigDecimal.valueOf(myNumDays).multiply(myVehicle.calculateRentalAmount());
        BigDecimal insurance = rentalAmount.multiply(new BigDecimal(".01"));
        BigDecimal vipDiscount = new BigDecimal("0");
        if(myPrimaryUser.getMyVIPStatus()) {
            vipDiscount = rentalAmount.multiply(new BigDecimal(".01"));
        }
        BigDecimal tax = rentalAmount.multiply(new BigDecimal(".1"));
        myBillAmount = rentalAmount.add(insurance).subtract(vipDiscount).add(tax);
        
        final String stars = "***********************";
        String nl = "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(stars + nl)
          .append("Rental Bill Summary" + nl)
          .append(stars + nl)
          .append("User Name: " + myPrimaryUser.getMyName() + nl)
          .append("----Vehicle Information----" + nl)
          .append("Vehicle Name: " + myVehicle.getName() + nl)
          .append("VehicleID: " + myVehicle.getVehicleID() + nl)
          .append("VehicleType: " + myVehicle.getVIN() + nl)
          .append("VIN: " + myVehicle.getVIN() + nl)
          .append("---Cost Information----" + nl)
          .append("RentalPerDay:" + nl)
          .append("Cost Per Day: $" + myVehicle.calculateRentalAmount() + nl)
          .append("No. of Rental Days: " + myNumDays + nl)
          .append("Total Amount: " + nf.format(rentalAmount) + nl)
          .append("Insurance: " + nf.format(insurance) + nl)
          .append("VIPDiscount: -" + nf.format(vipDiscount) + nl)
          .append("Tax: " + nf.format(tax) + nl)
          .append("Total Rent: " + nf.format(myBillAmount) + nl)
          .append("Rent Successfull" + nl)
          .append(stars);
        System.out.println(sb.toString());
    }

}
