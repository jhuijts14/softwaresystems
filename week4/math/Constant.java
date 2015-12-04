package ss.week4.math;

/**
 * The class for the Constant function.
 * @author Joep Huijts
 * @version Version 1.0
 */
public class Constant implements Function, Integrandable {

	//-----------------------Instance Variables------------------
	private double constant; // The constant value;
	
	//-------------------------Constructor------------------------
	/**
	 * Create a Constant.
	 * @param number - input the number the new Constant will be.
	 */
	public Constant(double number) {
		this.constant = number;
	}
	
	/**
	 * Returns the constant of type double.
	 * @param arg - a parameter that is not used.
	 * @return \result - the constant.
	 */
	/*@ pure*/ public double apply(double arg) { 
		return this.constant;
	}
	
	/**
	 * Return the derivative of a Function object that is derivative 
	 * of the current object.
	 * @return result - The function object containing the derivative 
	 * of the current object.
	 */
	//@ ensures newConstant(0).apply == 0;
	public Function derivative() {
		Function newConstant = new Constant(0); 
		// Creating a new Function object with a constant of 0;
		
		assert newConstant.apply(0) == 0;
		
		return newConstant;
	}
	
	/**
	 * Returns a string representation of the constant.
	 * @return - String representation of the constant.
	 */
	/*@ pure */ public String toString() {
		return String.format("(%.2f)", this.apply(0));
	}
	
	/**
	 * Returns the integrand of the Constant function.
	 * @return result - the integrand of the function.
	 */
	public Function integrand() {
		Function inteConstant = new LinearProduct(new Constant(this.constant), new Exponent(1));
		
		return inteConstant;
	}

}
