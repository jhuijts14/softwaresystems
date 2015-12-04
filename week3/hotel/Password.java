package ss.week3.hotel;

import ss.week3.pw.*;

/**
 * Class for Password.
 * @author Joep Huijts
 *@version Revision 1.0
 */
public class Password {

	//------------------Instance Variables-------------------
	
	private String password;
	private Checker checker;
	private String factoryPassword;
	
	//------------------Constructor-------------------------
	/**
	 * Creates a <code>Password</code> with a checker and the 
	 * initial password set to INITIAL.
	 * @param checker - A checker to be used for a password;
	 * 
	 */
	//@ ensures checker.acceptable(factoryPassword) == true;
	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = this.checker.generatePassword();
		password = factoryPassword;
	}
	
	/**
	 * Creates a Password using Password's other constructor.
	 */
	public Password() {
		this(new BasicChecker());
		
	}
	
	//--------------------Queries--------------------------
	
	/**
	 * Return the Checker.
	 * @return checker - the checker for the password;
	 */
	/* pure */ public Checker getChecker() {
		return checker;
	}
	
	/**
	 * Return the factory password string.
	 * @return factoryPassword - the string of the factory password.
	 */
	/* pure */ public String getFactoryPassword() {
		return factoryPassword;
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
	//@ requires newpass.length() >= 6 && !(newpass.contains(" "));
	public boolean setWord(String oldpass, String newpass) {
		
		assert newpass.length() >= 6 && !(newpass.contains(" ")) :
			"newpass is not acceptable";
		
		if (testWord(oldpass) && acceptable(newpass)) {
			this.password = newpass;
			return true;
		}
		return false;
	}
	
}
