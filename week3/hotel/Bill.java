package ss.week3.hotel;

import java.io.PrintStream;
import ss.week3.Format;

/**
 * The class for a Bill.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class Bill {

	//-------------------Instance Variables------------------
	private double sum; // The sum of the amounts on the Bill.
	private PrintStream stream; //The output stream of bill.
	
	//------------------Nested Interface-------------------
	/**
	 * Nested interface of an Item. Abstraction of the items on the bill. 
	 * Every item has an amount and description.
	 */
	public static interface Item {
		/**
		 * Returns the amount.
		 * @return the amount charged for the Item.
		 */
		double getAmount();
		
	}
	
	//---------------------Constructor------------------------
	/**
	 * Constructs a Bill sending the output to a given PrintStream. 
	 * If the PrintStream is null there will be no output.
	 * @param theOutStream - output stream; or null if you don't want output.
	 */
	public Bill(java.io.PrintStream theOutStream) {
		
		stream = theOutStream;
	}
	
	/**
	 * Constructs a Bill with no PrintStream for output.
	 */
	/*@ pure */ public Bill() {
	
		stream = null;
	}
	//----------------------Queries------------------------------
	/**
	 * Returns the sum of the Bill.
	 * @return the sum of the Bill
	 */
	public double getSum() {
		return sum;
	}
	
	//-----------------------------Commands------------------------
	/**
	 * Print the sum of the bill on the output stream.
	 */
	public void close() {
		
		if (this.stream != null) {
			stream.print("Bill sum: " + this.getSum());
		
			stream.flush();
		}
		
	}
	
	/**
	 * Add an item to the Bill. If there is an output, 
	 * the item will be printed on this output and the amount 
	 * will be added to the sum of the Bill
	 * @param item - the new item added to the Bill.
	 */
	public void newItem(Bill.Item item) {
		
		if (this.stream != null) {
			stream.print(Format.printLine(item.toString(), item.getAmount()));
			
		}
		
		sum = sum + item.getAmount();
	}
}
