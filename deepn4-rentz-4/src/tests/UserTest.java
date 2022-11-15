/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.User;

/**
 * This is the test class for User.
 * @author Deep Singh @deepn4
 * @version AU 21
 *
 */
public class UserTest {
    
    /** User with 2 parametrized constructors. */
    private User userWithDefaultVIP;
    /** User with 3 parametrized constructors. */
    private User user2WithVIPStatus;
    
    /**
     * setup test before any other method is tested.
     */
    @Before
    public void setUp() {
        userWithDefaultVIP = new User("deep", "password");
        user2WithVIPStatus = new User("singh", "password", true);
    }

    /**
     * Test method for 2 paramaterized constructors{@link model.User#User(java.lang.String, java.lang.String)}.
     */
    @Test//(expected = IllegalArgumentException.class)
    public void testUserStringString() {
        assertNotNull("User object is null!", userWithDefaultVIP);
        //assertNotEquals("User object is null!", "", userWithDefaultVIP.getMyName());
        //assertNotEquals("User object is null!", "", userWithDefaultVIP.getMyPassword());
        assertEquals("User name is incorrect!", "Deep", userWithDefaultVIP.getMyName());
        assertEquals("Password is incorrect!", "password", userWithDefaultVIP.getMyPassword());
    }
    /**
     * Test method for 2 paramaterized constructors{@link model.User#User(java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalUserStringString() {
        final User user1 = new User("", "");
        user1.getMyName();
        user1.getMyPassword();
    }

    /**
     * Test method for 3 parametrized constructors{@link model.User#User(java.lang.String, java.lang.String, boolean)}.
     */
    @Test
    public void testUserStringStringBoolean() {
        assertNotNull("User object is null!", user2WithVIPStatus);
        assertEquals("User name is incorrect!", "Singh", user2WithVIPStatus.getMyName());
        assertEquals("Password is incorrect!", "password", user2WithVIPStatus.getMyPassword());
        assertTrue(user2WithVIPStatus.getMyVIPStatus());
    }
    /**
     * Test method for 2 paramaterized constructors{@link model.User#User(java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalUserStringStringBoolean() {
        final User user1 = new User("", "", true);
        user1.getMyName();
        user1.getMyPassword();
    }

    /**
     * Test method for myName method{@link model.User#getMyName()}.
     */
    @Test
    public void testGetMyName() {
        assertEquals("getMyName() failed!", "Singh", user2WithVIPStatus.getMyName());
    }

    /**
     * Test method for myPassword method{@link model.User#getMyPassword()}.
     */
    @Test
    public void testGetMyPassword() {
        assertEquals("getMyPassword() failed!", "password", user2WithVIPStatus.getMyPassword());
    }

    /**
     * Test method for myVIPStatus method{@link model.User#getMyVIPStatus()}.
     */
    @Test
    public void testGetMyVIPStatus() {
        assertTrue(user2WithVIPStatus.getMyVIPStatus());
    }

    /**
     * Test method for toString{@link model.User#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("toString() method failed!", "User (Singh, password, true)", user2WithVIPStatus.toString());
    }

    /**
     * Test method for equals{@link model.User#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject() {
        assertNotEquals("equals() method failed", userWithDefaultVIP, user2WithVIPStatus);
        assertEquals("equals() method failed", userWithDefaultVIP, userWithDefaultVIP);
    }

    /**
     * Test method for hashCode{@link model.User#hashCode()}.
     */
    @Test
    public void testHashCode() {
        assertEquals("HashCode() method failed", Objects.hash(user2WithVIPStatus.getMyName(), user2WithVIPStatus.getMyPassword(),
                                                              user2WithVIPStatus.getMyVIPStatus(), user2WithVIPStatus.hashCode()));
        final User userB = new User("Singh", "password", true);
        assertEquals("HashCode() method failed", user2WithVIPStatus.hashCode(), userB.hashCode());
    }
    
//    @After
//    public void endTest() {
//        userWithDefaultVIP = null;
//        user2WithVIPStatus = null;
//    }

}
