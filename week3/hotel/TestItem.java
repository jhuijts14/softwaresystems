package ss.week3.hotel;

/**
 * The test class of the interface Bill.Item.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class TestItem implements Bill.Item {
	
	//-------------------------Instance Variable------------------
	private double amount; // The amount charged for an item.
	private String description; // Description of the item.
	
	//-------------------------Constructor------------------------
	/**
	 * Creates a TestItem with a description and price (amount).
	 * @param text - the input description of the item.
	 * @param amount - the price of the item.
	 */
	//@ ensures this.amount == amount;
	public TestItem(String text, double amount) {
		description = text;
		this.amount = amount;
		
		assert this.amount == amount;
	}

	//-------------------------Queries---------------------------
	/**
	 * Returns the amount.
	 * @return amount - amount the Item costs.
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * Returns the item description.
	 * @return description - the description of the item.
	 */
	public String toString() {
		return this.description;
	}

}
