package ss.week4.math;

/**
 * The class Product, which defines the product of two Functions.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class Product implements Function {
	
	//-----------------Instance Variables----------------------
	protected Function func1; // One of the Functions to be used;
	protected Function func2; // One of the Functions to be used;
		
	//-----------------Constructor-----------------------------
	/**
	 * Create the Product of two Functions.
	 * @param func1 - a Function object to be used.
	 * @param func2 - another Function object to be used.
	 */
	public Product(Function function1, Function function2) {
			
		this.func1 = function1;
		this.func2 = function2;
	}
		
	//------------------Queries-----------------------
		
	/**
	 * Return the Product of two Functions.
	 * @param arg - a value of type double.
	 * @return result - the product of the two Functions.
	 */
	public double apply(double arg) {
		return func1.apply(arg) * func2.apply(arg); // The product of the two Functions;
	}
		
	/**
	 * Return the derivative of the Product of two Function objects.
	 * @return result - The function object containing the derivative.
	 */
	public Function derivative() {
		// New Product object using the derivatives of the two functions as well as 
		// the functions themselves as parameters;
		// Both Sum and Product functions are used as if f = g * h then
		//													f' = (g' * h) + (h' * g);
		Sum derivProduct = new Sum(new Product(this.func1.derivative(), this.func2), 
						new Product(this.func2.derivative(), this.func1));
		
		return derivProduct;
	}
		
	/**
	 * Returns a string representation of the product value.
	 * @return - String representation of the product value.
	 */
	public String toString() {
		return String.format("%3s * %3s", this.func1.toString(), this.func2.toString());
	}

}
