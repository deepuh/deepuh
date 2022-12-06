import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO; // Might not need.

public class Profile {
	private String username;
	private boolean admin;
	private Project[] projects;
	private File profilePic = null;
	
	/**
	 * Parameterized Constructor for the Profile Class.
	 * @param theName
	 * @param theAdmin
	 * @param theNum
	 * @throws IOException
	 */
	public Profile(String theName, boolean theAdmin, int theNum) throws IOException {
		String filePath = "/files/profilePicUser" + theNum; // EXAMPLE ONLY!
		this.username = theName;
		this.admin = theAdmin;
		// Insert read command using custom filepath.
	}
	
	/**
	 * Retrieves Project Information under This Profile. Creates List of Projects.
	 */
	public void buildProjects() {
		
	}
	
	/**
	 * Returns Profile Administrative Status.
	 * @return
	 */
	public boolean isAdmin() {
		return this.admin;
	}
	
	public static boolean setAdmin(boolean result) {
		return result;
	}
	
	/**
	 * Returns Profile Username.
	 * @return
	 */
	public String getUserName() {
		return this.username;
	}
	
	/**
	 * Returns Project list to Higher-Level Program.
	 * @return
	 */
	public Project[] getProjects() {
		return this.projects;
	}
	
	/**
	 * Possible Return for Profile Pic to GUI / Display.
	 * @return
	 */
	public File getProfilePic() {
		return this.profilePic;
	}
}