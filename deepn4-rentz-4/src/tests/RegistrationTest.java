/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Registration;
import model.User;

/**
 * This is the test class for Registration.
 * @author Deep Singh @deepn4
 * @version AU 21
 *
 */
public class RegistrationTest {
    /**
     * Registration Instance field.
     */
    private Registration myRegistration;
    
    /**
     * setup test before any other method is tested.
     * initializes the instance field
     */
    @Before
    public void setUp() {
        myRegistration = new Registration();
//        String username = "deep";
//        String password = "singh";
    }

    /**
     * Test method for registration{@link model.Registration#Registration()}.
     */
    @Test
    public void testRegistration() {
        assertNotNull("Registration object is null!", myRegistration);
    }

    /**
     * Test method for getMyUserList{@link model.Registration#getMyUserList()}.
     */
    @Test
    public void testGetMyUserList() {
        final User expectedUser = new User("Deep", "password", true);
        assertEquals("getMyUserList failed!", expectedUser, myRegistration.getMyUserList());
    }

    /**
     * Test method for Login method{@link model.Registration#login(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testLogin() {
        assertTrue(myRegistration.login("deep", "singh"));
        assertFalse(myRegistration.login("deep", "incorrectpassword"));
        assertFalse(myRegistration.login("incorrectuser", "singh"));
    }
    
    /**
     * Test method for illegal arguement in login{@link model.Registration#login(java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLogin() {
        assertFalse(myRegistration.login("deep", ""));
        assertFalse(myRegistration.login("", "singh"));
    }

    /**
     * Test method for register method{@link model.Registration#register(model.User)}.
     */
    @Test
    public void testRegister() {
        final User expectedUser = new User("newname", "password");
        myRegistration.register(expectedUser);
        assertEquals("Registration failed!", expectedUser, myRegistration.getMyUserList().get("newname"));
    }

    /**
     * Test method for clear method{@link model.Registration#clear()}.
     */
    @Test
    public void testClear() {
        assertFalse(myRegistration.getMyUserList().isEmpty());
        myRegistration.clear();
        assertTrue(myRegistration.getMyUserList().isEmpty());
    }

    /**
     * Test method for toString{@link model.Registration#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("toString() method failed", "Registered UserList" + myRegistration.getMyUserList().toString(), myRegistration.toString());
    }
//    
//    /**
//     * Test method for {@link model.Registration#toString()}.
//     */
//    @Test(expected = NullPointerException.class)
//    public void testNotNull() {
//        final Registration test = null;
//        test.getMyUserList();
//    }

}
