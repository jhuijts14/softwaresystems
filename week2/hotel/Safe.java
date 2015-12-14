package ss.week2.hotel;

import ss.week3.hotel.Password;

/**
 * Class for a Safe located in a Room in a hotel.
 * @author Joep Huijts
 *@version Version 1.0
 */
public class Safe {

	//---------------------Instance Variables----------------------
	private Password pass; // Safe's password.
	private boolean isOpen;
	private boolean isActive;
	
	//-------------------------Constructor-------------------------
	/**
	 * Creates a Safe.
	 */
	//@ requires newPass.length() >= 6 && !(newPass.contains(" "));
	//@ ensures this.password == Password.INITIAL && isActive == true && isOpen == true;
	public Safe(String newPass) {
		 assert newPass.length() >= 6 && !(newPass.contains(" ")) :
			 "Input password is invalid!";
		
		this.pass = new Password();
		this.pass.setWord(this.getPassword(), newPass);
		this.isActive = true;
		this.isOpen   = true;
		
		assert this.getPassword() == newPass && this.isActive() == true
				&& this.isOpen() == true;
	}
	
	//-----------------------Queries-------------------------------
	/**
	 * Indicates whether Safe is open or not.
	 */
	/* pure */ public boolean isOpen() {
		return this.isOpen;
	}
	
	/**
	 * Indicate whether Safe is active or not.
	 */
	/* pure */ public boolean isActive() {
		return this.isActive;
	}
	
	/**
	 * Return the password object to be used.
	 */
	/* pure */ public String getPassword() {
		return this.pass.getFactoryPassword();
	}
	
	//----------------------------Commands--------------------------
	
	/**
	 * Activates the Safe, if the correct password is used.
	 */
	//@ ensures testWord(passAttempt) == true ==> isActive() == true;
	public void activate(String passAttempt) {
		if (pass.testWord(passAttempt)) {
			this.isActive = true;
		}
		
		assert pass.testWord(passAttempt) == true && this.isActive() == true;
	}
	
	/**
	 * Closes the Safe and deactivates it.
	 */
	//@ ensures isActive() == false && isOpen() == false;
	public void deactivate() {
		this.isActive = false;
		this.isOpen   = false;
		
		assert this.isActive() == false && this.isOpen() == false;
	}
	
	/**
	 * Open the Safe, if the Safe is active and the password is correct.
	 */
	//@ ensures testWord(passAttempt) == true ==> isOpen() == true;
	public void open(String passAttempt) {
		if (pass.testWord(passAttempt) && this.isActive() == true) {
			this.isOpen = true;
		}
		
		assert pass.testWord(passAttempt) == true && this.isActive() == true
				&& this.isOpen() == true;
	}
	
	/**
	 * Closes the Safe.
	 */
	//@ ensures isOpen() == false;
	public void close() {
		this.isOpen = false;
		
		assert this.isOpen() == false;
	}
	
	/**
	 * Safe's main method.
	 */
	//@ ensures this.pass.password.length() >= 6 && !(this.pass.password.contains(" ");
	/*
	public static void main(String[] args) {
		
		Safe safe;
		safe = new Safe("wrong");
		
		safe.close();
		safe.open("wrong");
		
		
	}*/
	
}
