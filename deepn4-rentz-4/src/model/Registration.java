
/*
 * This file is the registration class for the Vehicle Rental System.
 * 
 * TCSS 305 - Rentz
 */

package model;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import utility.FileLoader;

/**
 * Represents User Sign-in Object.
 * 
 * Methods of this class throw NullPointerException if required parameters are null.
 * 
 * @author Deep Singh @deepn4
 * @version AU 21
 */

public class Registration {

    /**
     * User Storage File.
     */
    public static final String USERFILE_NAME = "./resources/registeredusers.txt";

    /**
     * The registered user list for signin.
     */
    private final Map<String, User> myUserList; //Map<key, value>

    /**
     * Constructs a signin/registration system.
     * 
     * 
     */
    public Registration() {
        myUserList = FileLoader.readItemsFromFile(USERFILE_NAME);
    }

    /**
     * getter for myUserList.
     * 
     * @return myUserList
     */
    public Map<String, User> getMyUserList() {
        return myUserList;
    }

    /**
     * display sign-in or registration options.
     */
    public boolean printSignin() {
    	boolean success = false;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 1 or 2 (1. New Registration 2. Login): ");
        
        boolean result = false;
       
        int num = input.nextInt();
        System.out.println();
        System.out.println("You entered option " + num);
        System.out.println("*****************************");
        System.out.println("   Enter Details");
        System.out.println("*****************************");
        
      do { 
            switch(num) {
                case 1: {
                    
                    System.out.print("Enter UserName: ");
                    String userName = input.next();
                    //System.out.println();
                    boolean userAlreadyExists = false;
                    do {                                               //checking if username already exists
                        if(myUserList.get(userName) != null) {         //if there is already a username same as input 
                            System.out.print("User Already exists, enter different Username:");
                            userName = input.next();
                            //System.out.println();
                            userAlreadyExists = true;
                            continue;
                        } else {                                      //if username doesnt exist then break 
                            userAlreadyExists = false;
                            break;
                        }
                    } while(userAlreadyExists);
                    
                    System.out.print("Enter Password: ");
                    String userPwd = input.next();
                    //System.out.println();
                    System.out.print("Is VIP (true/false): ");
                    boolean isUserVip = input.nextBoolean();
                    //System.out.println();
                    
                    result = register(new User(userName, userPwd, isUserVip)); //true if registration is successful 
                    System.out.println("Registration Successfull !!");
                    break;
                }

                case 2: {
                    do {
                        System.out.print("Enter UserName: ");
                        String userName = input.next();
                        //System.out.println();
                        System.out.print("Enter Password: ");
                        String pwd = input.next();
                        System.out.println();
                        if(login(userName, pwd)) {
                            System.out.println("Login Successfull !!");
                            //final RentalManager rm = new RentalManager(null);
                            //rm.printOption();
                            result = true;
                            success = true;
                            break;
                        } else {
                            System.out.println("Wrong Crendetials !!");
                            continue;
                        }
                    } while((!result));
                    
                    break;
                }
                
                default: {
                    System.out.print("Wrong option selected, please enter 1 or 2 (1. New Registration 2. Login): ");
                    result = false;
                    num = input.nextInt();
                    System.out.println();
                    System.out.println("You entered option " + num);
                    continue;
                }
            }
       } while(!result);
      return success;
        
    }

    /**
     * Verify Sign-in procedure.
     * 
     * @param theUsername username for sign-in
     * @param thePassword password for signin
     * @return sign-in success
     */
    public boolean login(final String theUsername, final String thePassword) {

        //Validate Arguments
        Objects.requireNonNull(theUsername, "Username must not be null");
        Objects.requireNonNull(thePassword, "Password must not be null");
        
        //Get the User
        User userObj = myUserList.get(theUsername);
        
        //User doesn't Exists
        if(userObj == null) {
            return false;
        }

        //Match the password
        if(!thePassword.equals(userObj.getMyPassword())) {
            return false;
        }
        
        //User can login
        return true;
    }

    /**
     * Adds a user to the registered user list.
     * 
     * @param theUser an order to add to this shopping cart
     * @return true/false returns if registration is successfull
     */
    public boolean register(final User theUser) { //look over again 
        
        //Validate Arguments
        Objects.requireNonNull(theUser, "User to be registered must not be null");
              
        //Save User in the Map
        myUserList.put(theUser.getMyName(), theUser);  
        
        //Write User to File
        FileLoader.writeUserToFile(USERFILE_NAME, theUser);
        
        //User Saved successfully
        return true;

    }

    /**
     * Empties the user list.
     */
    public void clear() {

        myUserList.clear();
    }

    @Override
    /**
     * String representation of the object
     * 
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Registered UserList");
        final Set<String> key = myUserList.keySet();
        final Iterator<String> itr = key.iterator();
        while (itr.hasNext()) {
            final String s = itr.next();
            sb.append(s + "=" + myUserList.get(s).toString());
        }
        
        return sb.toString();
    }

}
