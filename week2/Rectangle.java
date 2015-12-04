package ss.week2;

/**
 * The class for a Rectangle.
 * @version Version 1.0
 * @author Joep Huijts
 *
 */
public class Rectangle {
	
	//---------- Instance Variables----------
	//@ private invariant length >= 0;
	private int length; 
		
	//@ private invariant width >= 0;
	private int width;
	
	//--------------Constructor-------------
	/**
	 * Constructor for the class Rectangle
	 * with a specified length and width.
	 * @ requires length >= 0;
	 * 			  width >= 0;
	 */
	public Rectangle(int length, int width) {
		assert length >= 0 :
			"Length (" + length + ") is < 0";
		assert width >= 0 :
			"Width (" + width + ") is < 0";
		
		this.length = length;
		this.width = width;
	}
	
	//-------------Queries------------------
	/**
	 * Return the length of the Rectangle.
	 * @ ensures \result >= 0;
	 */
	/* pure */ public int length() {
		assert length >= 0 :
			"Length (" + length + ") is < 0";
		return this.length;
	}
	
	/**
	 * Return the width of the Rectangle.
	 * @ ensures \result >= 0;
	 */
	/* pure */ public int width() {

		assert width >= 0 :
			"Width (" + width + ") is < 0";
		return this.width;
	}
	
	/**
	 * Return the area of the Rectangle.
	 */
	// @ ensures \result = this.width() * this.length();
	/* pure */ public int area() {
		int area;
		
		area = width * length;
		
		assert area == width() * length() :
			"Area (" + area + ") does not equal width * length = " + width * length;
		
		return area;
	}
	
	/**
	 * Return the perimeter of the Rectangle.
	 */
	//@ ensures \result = (2 * width()) + (2 * length());
	/* pure */ public int perimeter() {

		int perimeter;
		
		perimeter = (2 * width()) + (2 * length());
		
		assert perimeter == (2 * width()) + (2 * length()) :
			"Perimeter (" + perimeter + ") does not equal (2 * width) + (2 * length) = "
				+  (2 * width) + (2 * length);

		return perimeter;
	}
}
