package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import model.vehicles.AbstractVehicle;
import model.vehicles.BiCycle;
import model.vehicles.Car;
import model.vehicles.MotorBike;

/**
 * RentalManager class puts the vehicles in a Map 
 * and prints the available vehicles out 
 * 
 * @author Deep Singh @deepn4
 * @version AU 21
 */
public class RentalManager {
    
    /** instance field for myVehicleList */
    private Map<Integer, AbstractVehicle> myVehicleList = null;
    /** instance field for myRegistration */
    private Registration myRegistration = new Registration();
    /** instance field for myBills */
    private Map<Integer, Bill> myBills = null;
    /** instance field for myBillID */
    private int myBillID = 1;
    
    /** RentalManager constructor method initializes fields
     * 
     * @param theRegistration
     */
    public RentalManager(final Registration theRegistration) {
    	Objects.requireNonNull(theRegistration);
        myRegistration = theRegistration;
        myVehicleList = generateInventory();
        myBills = new HashMap<Integer, Bill>();
    }
    
    /** generates the inventory for available vehicles
     * 
     * @return Map<Integer, AbstractVehicle>
     */
    public Map<Integer, AbstractVehicle> generateInventory() {
        final Map<Integer, AbstractVehicle> vehicleList = new HashMap<Integer, AbstractVehicle>();
        int id = 1;
        final Car vehicle1 = new Car(id, "V100", "Fiat", true, false, false, false);
        vehicleList.put(vehicle1.getVehicleID(), vehicle1);
        final Car vehicle2 = new Car(id++, "V101", "Outback", true, true, true, false);
        vehicleList.put(vehicle2.getVehicleID(), vehicle2);
        final Car vehicle3 = new Car(id++, "V102", "BMW", true, true, true, true);
        vehicleList.put(vehicle3.getVehicleID(), vehicle3);
        final MotorBike vehicle4 = new MotorBike(id++, "B100", "Bike1", true, false);
        vehicleList.put(vehicle4.getVehicleID(), vehicle4);
        final MotorBike vehicle5 = new MotorBike(id++, "B101", "Bike2", true, true);
        vehicleList.put(vehicle5.getVehicleID(), vehicle5);
        final BiCycle vehicle6 = new BiCycle(id++, "C100", "Roadies", true, "Road");
        vehicleList.put(vehicle6.getVehicleID(), vehicle6);
        final BiCycle vehicle7 = new BiCycle(id++, "C101", "Cruiser", true, "Cruiser");
        vehicleList.put(vehicle7.getVehicleID(), vehicle7);
        final BiCycle vehicle8 = new BiCycle(id++, "C102", "Mountain", true, "Mountain");
        vehicleList.put(vehicle8.getVehicleID(), vehicle8);
        
        return vehicleList;
    }
    
    /** getter method for vehicleList
     * 
     * @return Map<Integer, AbstractVehicle>
     */
    public Map<Integer, AbstractVehicle> getVehicleList() {
        return myVehicleList;
    }
    /** getter method for Registration object
     * 
     * @return Registration object
     */
    public Registration getRegistration() {
        return myRegistration;
    }
    /**
     * Selects and prints available vehicles based on the inventory
     * 
     */
    public void printOption() {
    	final String stars = "***********************";
    	final Scanner input = new Scanner(System.in);
    	System.out.println("Enter 1 or 2 or 3 (1. Rent 2. Drop-off 3. Exit):");
    	int billcount = 1;
    	int num = input.nextInt();
    	
    	switch(num) {
    	case 1: {
    		System.out.println("You entered option 1\n" + stars);
            printVehicles(); 
            System.out.println(stars);
            System.out.print("Enter Vehicle ID: ");
            int ID = input.nextInt();
            System.out.print("Enter User Name: ");
            String username = input.next();
            System.out.print("Enter NumDays to Rent: ");
            int numdays = input.nextInt();
            
            while (!rent(ID, username, numdays, billcount)) {
                if (!myRegistration.getMyUserList().containsKey(username)) {
                    System.out.println("No User Name Found!");
                    System.out.println(stars);
                    System.out.print("Enter Vehicle ID: ");
                    ID = input.nextInt();
                    System.out.print("Enter User Name: ");
                    username = input.next();
                    System.out.print("Enter NumDays to Rent: ");
                    numdays = input.nextInt();
                    billcount++;
                }
                else if(!myVehicleList.containsKey(ID) || myVehicleList.containsKey(ID) 
                        && !myVehicleList.get(ID).getCanRent()) {
                	System.out.println("Vehicle is not availible!");
                	System.out.println(stars);
                	System.out.print("Enter Vehicle ID: ");
                    ID = input.nextInt();
                    System.out.print("Enter User Name: ");
                    username = input.next();
                    System.out.print("Enter NumDays to Rent: ");
                    numdays = input.nextInt();
                    billcount++;
                    continue;
                }
            }
            System.out.println("Do you want to continue? (true/false):");
            if (input.nextBoolean() == true) {
                printOption();
            } else if (input.nextBoolean() == false){
            	break;
            }
    	}
    	case 2: {
    		System.out.println("You entered option 2");
    		System.out.println(stars + stars);
    		System.out.println(stars);
    		System.out.println("Enter Drop-off Details:\n" + stars
                               + "\nEnter Drop-off Vehicle ID: ");
    		int vehicleID = input.nextInt();
            while (myVehicleList.get(vehicleID).getCanRent()) {
                System.out.println("Vehicle is not rented already\n"
                                   + "Enter Drop-off Vehicle ID:");
                vehicleID = input.nextInt();
            }
            System.out.println("Drop-off Successful\n" + stars
                    + "\nDo you want to continue? (true/false):");
            if (input.nextBoolean() == true) {
                printOption();
            } else if (input.nextBoolean() == false) {
            	break;
            }
        }
    	case 3: {
    		break;
    	}
    	}
    	input.close();
    	
    }
    
    /** This method prints out the available vehicles
     * 
     */
    public void printVehicles() {
        //Iterator<Map.Entry<Integer, AbstractVehicle>> itr = myVehicleList.entrySet().iterator();
    	final Set<Integer> keys = myVehicleList.keySet();
        final Iterator<Integer> itr = keys.iterator();
        int key = itr.next();
        System.out.println();
        System.out.println("***************List of Avaliable Vehicles***************");

        for (int i = 0; i < keys.size(); i++) {
        	if(isRentable(key)) {
            System.out.println(myVehicleList.get(key).toString());
        	}
        	if (itr.hasNext()) {
                key = itr.next();
            }
        }
    }
    /** This method lets user know if vehicle can be rented.
     * 
     * @param theVehicleID
     * @return boolean 
     */
    public boolean isRentable(final int theVehicleID) {
    	boolean result = false;
    	if (myVehicleList.containsKey(theVehicleID) && myVehicleList.get(theVehicleID).getCanRent()) {
    		result = true;
    	}
    	return result;
    }
    /** This method rents a vehicle, makes a bill for that vehicle
     * and adds the Bill object into myBills
     * @param theVehicleID
     * @param theUserName
     * @param theNumDays
     * @param theBillID
     * @return boolean 
     */
    public boolean rent(final int theVehicleID, final String theUserName,
    		            final int theNumDays, final int theBillID) {
    	boolean result = false;
    	Objects.requireNonNull(theVehicleID);
    	Objects.requireNonNull(theUserName);
    	Objects.requireNonNull(theNumDays);
    	Objects.requireNonNull(theBillID);
    	if(theVehicleID <= 0 || theNumDays <= 0 || theBillID <= 0 || theUserName.isEmpty()) {
    		throw new IllegalArgumentException("Invalid value for Vehicle ID, Number of Days, Bill ID or UserName");
    	}
    	if(isRentable(theVehicleID) && myRegistration.getMyUserList().containsKey(theUserName)) {
    		myVehicleList.get(theVehicleID).setCanRent(false);
    		final Bill theBill = new Bill(theBillID, myRegistration.getMyUserList().get(theUserName),
    				                      myVehicleList.get(theVehicleID), theNumDays);
    		theBill.computeAndPrintAmount();
    		myBills.put(myBillID, theBill);
    		myBillID++;
    		result = true;
    	}
    	return result;
    }
    /**
     * This method checks if vehicle is not available for rent and drops it off
     * 
     * @param theVehicleID 
     * @return boolean 
     */
    public boolean drop(final int theVehicleID) {
    	boolean result = false;
    	if (myVehicleList.containsKey(theVehicleID) && !isRentable(theVehicleID)) {
    		myVehicleList.get(theVehicleID).setCanRent(true);
    		result = true;
    	}
    	return result;
    }
    /**
     * This method clears myVehicleList and myBillsList.
     */
    public void clearLists() {
        myVehicleList.clear();
        myBills.clear();
    }
    
}
