package ss.week3.hotel;

/**
 * Hotel room with number and possibly a guest.
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class Room {
    // ------------------ Instance variables ----------------

    private int number;
    private Guest guest;
    private Safe safe;
    

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     */
    public Room(int no) {
    	number = no;
    	safe = new Safe();
    	guest = null;
    }
    
    /**
     * Creates a <code>Room</code> with the given number and price for its safe, without a guest.
     */
    public Room(int no, Safe safe) {
    	number = no;
    	this.safe = safe;
    	guest = null;
    }

    // ------------------ Queries --------------------------

    /**
     * Returns the number of this <code>Room</code>.
     */
    public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     * @return the guest of this <code>Room</code>;
     *         <code>null</code> if this <code>Room</code> 
     *         is not currently rented
     */
    public Guest getGuest() {
    	return guest;
    }
    
    /**
     * Return the Safe located in the Room.
     */
    /* pure */  public Safe getSafe() {
    	return safe;
    }

    // ------------------ Commands --------------------------

    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     * @param g the next guest renting this <code>Room</code>;
     *        if <code>null</code> is passed, this <code>Room</code>
     *        is empty afterwards
     */
    public void setGuest(Guest g) {
    	guest = g;
    }
    
    /**
	 * Presents <code>Room</code>'s state in a string.
	 */
	public String toString() {
		return "Room Number: " + this.number;
	}
}
