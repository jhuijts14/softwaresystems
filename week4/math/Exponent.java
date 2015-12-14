package ss.week4.math;

public class Exponent implements Function, Integrandable {


	//---------------------Instance Variables--------------------
	private int exponent; // The exponent integer used in the function;
	
	//-------------------------Constructor-----------------------
	
	/**
	 * Create an Exponent function with a given exponent.
	 * @param value - the integer that will become the exponent.
	 */
	public Exponent(int value) {
		this.exponent = value;
	}
	
	//----------------------Queries------------------------------
	/**
	 * Executes the function to an argument of type double.
	 * @param arg - a value of type double that the Exponent is 
	 * applied to.
	 * @return \result - the value created after applying the Exponent.
	 */
	//@ ensures index == this.exponent;
	public double apply(double arg) {
		return Math.pow(arg, exponent);
	}
	
	/**
	 * Return the derivative of an Exponent object.
	 * @return \result - The functional object containing the derivative 
	 * of the current object.
	 */
	public Function derivative() {
		
		if (this.exponent != 0) {
			
		
			// New LinearProduct object is created using the following formula:
			// If f(x) = g(x) ^ (this.exponent) ==> 
			//							f'(x) = (g(x) ^ (this.exponent - 1)) * this.exponent;
			LinearProduct derivLinearProduct = new LinearProduct(new Constant(this.exponent), 
							new Exponent(this.exponent - 1));

			return derivLinearProduct;
		}
		
		return new Constant(0);
	}
	
	
	/**
	 * Returns a string representation of the Exponent.
	 * @return - String representation of the Exponent.
	 */
	public String toString() {
		return "(xˆ" + this.exponent + ")";
	}
	
	/**
	 * Returns the integrand of the Exponent function.
	 * @return result - the integrand of the function.
	 */
	public Function integrand() {
		
		
		Function inteExponent = new LinearProduct(new Constant(1.0 / (this.exponent + 1)), 
						new Exponent(this.exponent + 1));
		
		return inteExponent;
	}

}
