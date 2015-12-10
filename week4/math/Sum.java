package ss.week4.math;

/**
 * The class for Sum, which defines the sum of two Functions.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class Sum implements Function, Integrandable {

	//-----------------Instance Variables----------------------
	private Function func1; // One of the Functions to be used;
	private Function func2; // One of the Functions to be used;
	
	//-----------------Constructor-----------------------------
	/**
	 * Create the Sum of two Functions.
	 * @param func1 - a Function object to be used.
	 * @param func2 - another Function object to be used.
	 */
	public Sum(Function function1, Function function2) {
		
		this.func1 = function1;
		this.func2 = function2;
	}
	
	//------------------Queries-----------------------
	
	/**
	 * Return the Sum of two Functions.
	 * @param arg - a value of type double.
	 * @return result - the sum of the two Functions.
	 */
	public double apply(double arg) {
		return func1.apply(arg) + func2.apply(arg); // The sum of the two Functions;
	}
	
	/**
	 * Return the derivative of the Sum of two Function objects.
	 * @return result - The function object containing the derivative 
	 * of the Sum.
	 */
	public Function derivative() {
		// New Sum object using the derivatives of the two functions as parameters;
		Sum derivSum = new Sum(this.func1.derivative(), this.func2.derivative());
		
		return derivSum;
	}
	
	/**
	 * Returns a string representation of the sum value.
	 * @return - String representation of the sum value.
	 */
	public String toString() {
		return String.format("%s + %s", this.func1.toString(), this.func2.toString());
	}
	
	/**
	 * Returns the integrand of the Sum function.
	 * @return result - the integrand of the function.
	 */
	public Function integrand() {
		
		if (!(this.func1 instanceof Integrandable && this.func2 instanceof Integrandable)) {
			return null;
		}
		
		Function inteSum = new Sum(((Integrandable) this.func1).integrand(), 
						((Integrandable) this.func2).integrand());
		
		return inteSum;
	}
	
}
