package ss.week4.math;


/**
 * The interface Function modeling different mathematical functions.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public interface Function {

	
	/**
	 * Executes the function to an argument of type double.
	 * @param arg - a value of type double that the function is 
	 * applied to.
	 * @return \result - the value created when the function is 
	 * performed on the parameter.
	 */
	public double apply(double arg);
	
	/**
	 * Return the derivative of a Function object that is derivative 
	 * of the current object.
	 * @return result - The function object containing the derivative 
	 * of the current object.
	 */
	public Function derivative();
	
	/**
	 * Returns a string representation of the function.
	 * @return - String representation of the function.
	 */
	public String toString();
}
