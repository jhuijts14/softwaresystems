package ss.week1.hotel;

/**
 * The class of a hotel guest.
 * @author Joep Huijts
 *@version Revision: 1.0 
 *
 */
public class Guest {

	// ------------------ Instance variables ----------------
	private Room room;
	private String name;
	
	  // ------------------ Constructor ------------------------
	/**
	 * Creates a <code> Guest </code> with the given name and without a Room.
	 *  @param n name of the new <code>Guest</code>
	 */
	public Guest(String n) {
		this.name = n;
	}
	
	// ------------------ Queries --------------------------
	/**
	 * Method that returns the name of this <code>Guest</code>.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Method that returns the Room that is rented by this <code>Guest</code>. 
	 * Room can be null.
	 */
	public Room getRoom() {
		return room;
	}
	
	// ------------------ Commands --------------------------
	/**
	 * Method to rent a Room to this <code>Guest</code>.
	 * @param r the Room the <code>Guest</code> is renting.
	 * 		  If r is not null, the checkIn method returns false.
	 */
	public boolean checkIn(Room r) {
		if (r.getGuest() != null) {
			return false;
		} else {
			r.setGuest(this);
			this.room = r;
			return true;
		}
		
	}
	
	/**
	 * Sets the Room of this <code>Guest</code> to null.
	 */
	public boolean checkOut() {
		if (this.room != null) {
			this.room.setGuest(null);
			this.room = null;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Presents <code>Guest</code>'s state in a string.
	 */
	public String toString() {
		return "Guest: " + this.name + " and the room number: " + this.room.getNumber();
	}
}
