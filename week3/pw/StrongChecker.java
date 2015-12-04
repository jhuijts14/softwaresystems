package ss.week3.pw;

/**
 * Class of a Strong Checker.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class StrongChecker extends BasicChecker {

	
	//---------------------Constructor-------------------
	/**
	 * Creates a Strong Checker.
	 */
	/* pure */ public StrongChecker() {
		
	}
	
	//---------------------Commands----------------------
	/**
	 * Test if a given string is an acceptable password. 
	 *  @param password - Word that will be tested 
	 *  	   if it can be used as a password
	 *  @return false if the suggestion has less
	 *          than 6 characters or it contains a space
	 *          password starts with a letter and ends with
	 *          a digit.
	 */
	public boolean acceptable(String password) {
		
		if (Character.isLetter(password.charAt(0)) 
						&& Character.isDigit(password.charAt(password.length() - 1))) {
			
			return super.acceptable(password);
			
		
		} else {
			return false;
		}
		
	}
	
}
