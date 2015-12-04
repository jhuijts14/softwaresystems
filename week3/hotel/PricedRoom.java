package ss.week3.hotel;

/**
 * The class for a PricedRoom.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class PricedRoom extends Room implements Bill.Item {


	//------------------------------Instance Variable---------------------------
	private double price; // The amount the PricedRoom costs per day.
	
	//-------------------------------Constructor--------------------------------
	
	/**
	 * Create a PricedRoom, need to input a number, room price and safe price.
	 * @param no - the room number.
	 * @param roomPrice - the price of the room.
	 * @param safePrice - the price of the safe in the room.
	 */
	public PricedRoom(int no, double roomPrice, double safePrice) {
		super(no, new PricedSafe(safePrice));
		this.price = roomPrice;
		
	}
	
	//---------------------------------Queries-----------------------------------

	/**
	 * Return the price per day of renting a PricedRoom.
	 * @return price - the amount charge for a PricedSafe.
	 */
	/*@ pure */ public double getAmount() {
		return this.price;
	}
	
	/**
	 * Return a string that contains the price of using a PricedRoom per day.
	 * @return string with item price.
	 */
	/*@ pure */ public String toString() {
		return "This price per day of renting the room is " + this.price;
	}
}
