package ss.week3.pw;

/**
 * The interface of Checker.
 * @author Joep Huijts
 *@version Version 1.0
 */
public interface Checker {

	/**
	 * Returns true or false depending if the password is acceptable.
	 * @param password - The input password to be checked to see if acceptable.
	 * @return true || false if password acceptable.
	 */
	public boolean acceptable(String password);
	
	/**
	 * Returns an acceptable password.
	 * @return password - a password String that is acceptable.
	 */
	//@ ensures acceptable( password) == true;
	public String generatePassword();
	
}
