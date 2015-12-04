package ss.week2.test;

import ss.week2.Rectangle;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * The class that tests the Rectangle class.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class RectangleTest2 {

	// Rectangle objects to be tested.
	private Rectangle rect;
	
	/**
	 * Test whether Rectangle can be set up. 
	 */
	@Test
	public void testSetUp() {
		rect = new Rectangle(10, 20);
		assertEquals("Length: ", 10, rect.length());
		assertEquals("Width: ", 20, rect.width());
	}
	
	/**
	 * Test if area is calculated correctly.
	 */
	@Test
	public void testArea() {
		rect = new Rectangle(5, 10);
		assertEquals("Area: ", 50, rect.area());
	}
	
	/**
	 * Test if perimeter is calculated correctly.
	 */
	@Test
	public void testPerimeter() {
		rect = new Rectangle(5, 10);
		assertEquals("Perimeter: ", 30, rect.perimeter());
	}
	
}
