package ss.week3.test;

import ss.week3.hotel.*;
import static org.junit.Assert.*;

import java.io.PrintStream;
import org.junit.Test;


public class BillTest {

	//------------------------Instance Variable----------------------
	// The variables to complete a test.
	private Bill bill;
	private TestItem item;
	private PrintStream stream;
	private String description1 = "A book";
	private String description2 = "A CD";
	private String description3 = "A movie";
	private double amount1 = 12.50D;
	private double amount2 = 7.50D;
	private double amount3 = 6.66D;
	/**
	 * Test the initial state of an instance of Bill.
	 */
	@Test
	public void testInitialState() {
		bill = new Bill(stream);
		
		assertNotNull("Stream is not null!", bill);
	}
	
	/**
	 * Test the newItem command of Bill when the output stream is not null.
	 */
	@Test
	public void testAddNewItemWithStream() {
		bill = new Bill(System.out);
		item = new TestItem(description1, amount1);
		bill.newItem(item);
		
		assertEquals("Check description of new Item added: ", "A book", item.toString());
		assertEquals("Check amount of new Item added", 12.50, bill.getSum(), 0.5);
	}
	
	/**
	 * Test the newItem command of Bill when the output stream is null.
	 * It should not crassh.
	 */
	@Test
	public void testAddNewItemWithoutStream() {
		bill = new Bill(stream);
		item = new TestItem(description1, amount1);
		bill.newItem(item);
		
	}
	
	/**
	 * Test the close command of Bill.
	 */
	@Test
	public void testclose() {
		bill = new Bill(System.out);
		item = new TestItem(description1, amount1);
		bill.newItem(item);
		item = new TestItem(description2, amount2);
		bill.newItem(item);
		item = new TestItem(description3, amount3);
		bill.newItem(item);
		bill.close();
		assertEquals("The sum of three items: ", 26.66, bill.getSum(), 0);
	}
}
