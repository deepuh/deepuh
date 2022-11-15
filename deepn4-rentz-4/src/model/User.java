
package model;

import java.util.Objects;


/**
 * Represents a single user for registration or sign-in. User is an immutable object.
 * 
 * Constructors and methods of this class throw NullPointerException if required parameters are
 * null.
 * 
 * @author Deep Singh @deepn4
 * @version au 2021
 */
public final class User {
    /*user name */
    private String myName;
    /*user password */
    private String myPassword;
    /*user VIP Status */
    private boolean myVIPStatus;
    
    /** This is the constructor method which takes in 2 arguements
     * 
     * @param theName
     * @param thePassword
     */
    public User(final String theName, final String thePassword) {
        this.myName = Objects.requireNonNull(theName, "Username must not be null");
        this.myPassword = Objects.requireNonNull(thePassword, "Password must not be null");
        if (myName.equals("") || myPassword.equals("")) {
            throw new IllegalArgumentException("User or Password cannot be empty");
        }
        this.myVIPStatus = false;
    }
    
    /** This is the constructor method which takes all 3 arguements
     * 
     * @param theName
     * @param thePassword
     * @param theVIPStatus
     */
    public User(final String theName, final String thePassword, final boolean theVIPStatus) {
        this.myName = Objects.requireNonNull(theName, "Username must not be null");
        this.myPassword = Objects.requireNonNull(thePassword, "Password must not be null");
//        this.myVIPStatus = Objects.requireNonNull(theVIPStatus, "VIP status must not be null");
        if(myName.equals("") || this.myPassword.equals("")) {
            throw new IllegalArgumentException("User or Password cannot be empty");     
        }
        this.myVIPStatus = theVIPStatus;
    }
    /** getter method for myName
     *  @return String myName
     */
    public String getMyName() {
        return myName;
    }
    
    /* getter method for myPassword 
     * @return String myPassword
     */
    public String getMyPassword() {
        return myPassword;
    }
    
    /** getter method for myVIPStatus
     * 
     * @return boolean true/false vip status
     */
    public boolean getMyVIPStatus() {
        return myVIPStatus;
    }
    
    /** this is the toString method which prints a readable string for user
     * @return readable string 
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()) // the class name without the package name
          .append(" (")
          .append(myName)
          .append(", " )
          .append(myPassword)
          .append(", " )
          .append(myVIPStatus)
          //.append(", " )
          .append(")");

        return sb.toString();
    }
    
    /** this method is an override equals which compares if the user
     * equals another user name
     * @return boolean if there exists 2 same usernames
     * @param Object user
     */
    @Override
    public boolean equals(final Object user) {
        User theOtherUser = (User) user;
        if (this.myName.equals(theOtherUser.myName)) { // reflexive
           return true; // ask prof if all fields are required to equal
        } 
        return false;
    }
    
    /** hashcode override
     * @return int of where the params are stored
     */
    @Override
    public int hashCode() { 
        return Objects.hash(myName, myPassword, myVIPStatus);
    }

}
