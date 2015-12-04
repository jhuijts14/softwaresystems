package ss.week2.hotel;

import ss.week3.hotel.Password;

/**
 * The class for a Hotel.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class Hotel {

	//--------------------------INSTANCE VARIABLES--------------------
	private Room room1; // A room of the Hotel.
	private Room room2; // A room of the Hotel.
	private Password checkInPass; // Password of the Hotel's check in process.
	private String name; // Name of the hotel.
	
	//--------------------------CONSTRUCTOR----------------------------
	/**
	 * Create a Hotel with a specific password, two rooms and its name.
	 * @param password - Hotels password for its check in process.
	 */
	//@ requires name != null;
	//@ ensures this.name == name;
	public Hotel(String name) {
		assert name != null;
		
		this.name = name;
		checkInPass = new Password();
		room1 = new Room(101, Password.INITIAL);
		room2 = new Room(102, Password.INITIAL);
		
		assert this.name == name;
	}
	
	//---------------------------QUERIES---------------------------------
	/**
	 * Check if any room is free and available.
	 * @return room that is not being used by a guest.
	 */
	//@ ensures \result == null || \result == room1 || \result == room2;
	public Room getFreeRoom() {
		
		if (room1.getGuest() == null) {
			return room1;
		} else if (room2.getGuest() == null) {
			return room2;
		} else {
			return null;
		}
		
		
	}
	
	/**
	 * Returns the Hotel name.
	 * @return name - name of hotel.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns a textual description of all rooms in the hotel,
	 * including the name of the guest and the status of the 
	 * safe in that room.
	 * @return textual description of all rooms including guest's name and the state of the safe;
	 */
	public String toString() {
		String strRoom1 = room1 + " is not occupied. The safe is active: " 
						+ Boolean.toString(room1.getSafe().isActive());
		String strRoom2 = room2 + " is not occupied. The safe is active: " 
						+ Boolean.toString(room2.getSafe().isActive());
		
		if (room1.getGuest() != null) {
			strRoom1 = room1 + " is occupied by " + room1.getGuest().getName() 
					+ ". The safe is active: " + Boolean.toString(room1.getSafe().isActive());
		}
		if (room2.getGuest() != null) {
			strRoom2 = room2 + " is occupied by " + room2.getGuest().getName() 
					+ ". The safe is active: " + Boolean.toString(room2.getSafe().isActive());
		}
		
		return strRoom1 + "/n" + strRoom2;
	}
	
	/**
	 * Return the Password of the Check in process.
	 * @return checkInPass - password for the check in.
	 */
	public Password getPassword() {
		return this.checkInPass;
	}
	
	/**
	 * Return the Room of a specified guest.
	 * @param guestName - Name of a guest.
	 * @return The room that a guest is staying in.
	 */
	public Room getRoom(String guestName) {

		if (room1.getGuest() != null && room1.getGuest().getName().equals(guestName)) {
			return room1;
		} else if (room2.getGuest() != null && room2.getGuest().getName().equals(guestName)) {
			return room2;
		} else {
			return null;
		}
	}
	
	//----------------------------------COMMANDS------------------------------
	/**
	 * Check a new guest into a Room if the Room is empty and the check in password is correct.
	 * @param password - password of the Hotel.
	 * @param guestName - name of guest to be checked in.
	 */
	//@ requires  guestName != null;
	public Room checkIn(String password, String guestName) {
	assert  guestName != null :
			"The guest was not checked in, password or guestname invallid!";
		
		if (this.getFreeRoom() != null && this.getPassword().testWord(password) 
						&& getRoom(guestName) == null) {
			Guest guest;
			guest = new Guest(guestName);
			
			
			guest.checkIn(this.getFreeRoom());
			
			return guest.getRoom();
			
		} else {
			return null;
		}
		
	}
	
	/**
	 * Check a guest out of a room through finding his/her room trough their name.
	 * @param guestName - the name of a guest.
	 */
	//@ requires guestName != null;
	//@ ensures room.getGuest().getName().equals(guestName);
	public void checkOut(String guestName) {
	
		assert guestName != null : 
			"The guest name is null";
		
		if (getRoom(guestName) != null) {
			Room room;
			room = getRoom(guestName);
			
			room.getGuest().checkOut();
			room.getSafe().deactivate();
			
			assert room.getGuest().getName().equals(guestName) :
				"Input guest name does not match any guests in Hotel!";
		}
		
		
	}
		
}
