package ss.week1;
/**
 * Class for Password.
 * @author Joep Huijts
 *@version Revision 1.0
 */
public class Password {

	//------------------Instance Variables-------------------
	public static final String INITIAL = "abcdefgh";
	public String password;
	
	//------------------Constructor-------------------------
	/**
	 * Creates a <code>Password</code> with the initial password set to INITIAL.
	 */
	public Password() {
		password = INITIAL;
	}
	
	//--------------------Commands--------------------------
	/**
	 * Test if a given string is an acceptable password. 
	 *  @param suggestion - Word that will be tested 
	 *  	   if it can be used as a password
	 *  @return false if the suggestion has less
	 *          than 6 characters or it contains a space.
	 */
	public boolean acceptable(String suggestion) {
		if (suggestion.length() < 6 || suggestion.contains(" ")) {
			System.out.println("Input password is invalid!");
			return false;
		} else {
			return true;
		}
	
	}
	
	/**
	 * Tests if a given word is equal to the current password.
	 * @param test - String that will be tested against the current
	 *         password
	 * @return true If test String is equal to the current password
	 */
	public boolean testWord(String test) {
		if (this.password.equals(test)) {
			return true;
		}
		System.out.println("Input does not match password");
		return false;

	}
	
	/**
	 * Changes the current password to a new password.
	 * @param oldpass - The String of the old password
	 * @param newpass - The String of the new password
	 * @return true if oldpass is equal to the current 
	 *         password and that newpass is an acceptable 
	 *         password
	 */
	public boolean setWord(String oldpass, String newpass) {
		
		if (testWord(oldpass) == true && acceptable(newpass) == true) {
			this.password = newpass;
			return true;
		}
		return false;
	}
	
}
