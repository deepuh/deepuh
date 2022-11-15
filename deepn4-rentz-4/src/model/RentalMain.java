
/*
 * Main class for the Vehicle Rental System TCSS 305
 * 
 * TCSS 305 - Rentz
 */

package model;

/**
 * RentalMain provides the main method for a simple VehicleRental application.
 * 
 * @author Deep Singh @deepn4
 * @version AU 2021
 */
public final class RentalMain {

    /**
     * A private constructor, to prevent external instantiation.
     */
    private RentalMain() {

    }

    /**
     * Main method for Rentz.
     * 
     * @param theArgs argument for main method.
     */
    public static void main(final String[] theArgs) {
        final Registration reg = new Registration();
        if(reg.printSignin()) {
            final RentalManager rm = new RentalManager(reg);
            rm.printOption();
        }
        
    }

}
