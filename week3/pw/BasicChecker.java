package ss.week3.pw;

/**
 * Class for the Basic Checker.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class BasicChecker implements Checker {
	
	//------------------------Instance Variables----------------------
	public static final String INITPASS = "abcdefgh1";
	
	//--------------------------Constructor-------------------------
	/**
	 * Creates a Basic Checker.
	 */
	/* pure */ public BasicChecker() {
		
	}
	
	//-------------------------Commands-------------------------
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
	 * Returns an acceptable password.
	 * @return password - a password String that is acceptable.
	 */
	//@ ensures acceptable( password) == true;
	public String generatePassword() {
		String password = INITPASS;
		
		assert acceptable(password);
		
		return password;
	}
	
}
