package ss.week3;

/**
 * The class of Format.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class Format {

	//-------------------Instance Variables-----------------------
	// test variables;
	private static String test0  = "Test";
	private static String test1 = "Test1";
	private static String test2 = "Test2";
	private static double testa = 2.50D, testb = 1.00D, testc = -12.50D;
	
	//--------------------Constructor-----------------------
	/**
	 * Constructor to test Format.
	 */
	public Format() {
		
	}
	//--------------------Commands---------------------------
	/**
	 * Print a line on Bill with the item and amount it costs.
	 * @param text - text naming the item on the Bill.
	 * @param amount - amount the item costs.
	 */
	/*@ pure */ public static String printLine(String text, double amount) {
		
		return String.format("%-10s %10.2f %n", text, amount);
		
	}
	
	/**
	 * The main method tests the string format.
	 */
	public static void main(String[] args) {
		
		System.out.print(printLine(test0, testa));
		System.out.printf(printLine(test1, testb));
		System.out.format(printLine(test2, testc));
	}
}
