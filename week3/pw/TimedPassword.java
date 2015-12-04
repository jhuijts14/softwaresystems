package ss.week3.pw;

import ss.week3.hotel.Password;

/**
 * The class of Timed Password.
 * @author Joep Huijts
 * @version Version 1.0
 */
public class TimedPassword extends Password {

	//--------------------Instance Variable---------------------
	private long validTime; // How long a password is valid.
	private long expiredTime;
	
	
	//-----------------------Constructor-------------------------
	/**
	 * Create a TimedPassword with an input expiration time for a password.
	 * @param expirTime - time till password expires.
	 */
	//@ requires expirTime >= 0;
	public TimedPassword(int expirTime) {
		super();
		
		assert expirTime >= 0;
		
		expiredTime = expirTime * 1000;
		validTime = System.currentTimeMillis() + expiredTime;
	}
	
	/**
	 * Create a TimedPassword with a default validTime of currentTimeMillis() + 160 days.
	 */
	public TimedPassword() {
		super();
		
		validTime = System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 160);
	}
	
	//-----------------------Queries-----------------------------
	
	/**
	 * Returns true or false depending if the password is expired or not.
	 */
	public boolean isExpired() {
		
		return this.validTime <= System.currentTimeMillis();
	}
	
	//-----------------------Commands---------------------------------
	/**
	 * Tests if a given word is equal to the current password.
	 * @param test - String that will be tested against the current
	 *         password
	 * @return true If test String is equal to the current password and is not expired
	 */
	public boolean testWord(String test) {
		
		boolean result = false;
		
		if (super.testWord(test)) {
			if (this.isExpired()) {
				result = true;
			} 
		}
		
		return result;
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
		
		
		boolean result = false;
		
		if (super.setWord(oldpass, newpass)) {
			validTime = System.currentTimeMillis() + expiredTime;
			result = true;
		}
		
		return result;
	}
	
	
}
