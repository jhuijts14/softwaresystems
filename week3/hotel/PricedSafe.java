package ss.week3.hotel;

/**
 * The class for a PricedSafe.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class PricedSafe extends Safe implements Bill.Item {

	//---------------------------Instance Variables------------------------
	private double price; // The amount charged for the PricedSafe.

	//-----------------------------Constructor-------------------------------
	/**
	 * Create a PricedSafe with a specified Bill price.
	 * @param price - the amount charged for a PricedSafe.
	 */
	//@ ensures this.price == price;
	public PricedSafe(double price) {
		super();
		
		this.price = price;
		
		assert this.price == price;
	}
	
	//----------------------------Queries------------------------------------
	/**
	 * Return the price of the PricedSafe.
	 * @return price - the amount charge for a PricedSafe.
	 */
	/*@ pure */ public double getAmount() {
		return price;
	}
	
	/**
	 * Return a string that contains the price of a PricedSafe.
	 * @return string with item price.
	 */
	/*@ pure */ public String toString() {
		return "This price of the safe is " + this.getAmount();
	}
}
