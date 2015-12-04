package ss.week4.math;

/**
 * The class Polynomial, which defines arbitrary polynamial functions.
 * @author Joep Huijts
 * @version 1.0
 *
 */
public class Polynomial implements Function, Integrandable {


	//---------------------Instance Variables--------------------
	private LinearProduct[] polynomials; // The array used in the function;
	
	//-------------------------Constructor-----------------------
	
	/**
	 * Create an Polynomial function with a given array of numbers.
	 * @param array - the values that will be used in the function.
	 */
	public Polynomial(double[] array) {
		// The array of the polynomial function;
		polynomials = new LinearProduct[array.length];
		
		// For loop that creates a new LinearProduct for every element of array;
		for (int i = 0; i < array.length; i++) {
			Exponent exponent = new Exponent(i);
			Constant constant = new Constant(array[i]);
			
			polynomials[i] = new LinearProduct(constant, exponent);
		}
	}
	
	//----------------------Queries------------------------------
	
	/**
	 * Executes the function to an argument of type double.
	 * @param arg - a value of type double that the Polynomial is 
	 * applied to.
	 * @return \result - the value created after applying the Polynomial.
	 */
	public double apply(double arg) {
		
		double elementProduct; // Store the temporary double when LinearProduct's method is used;
		double sum = 0; // The sum of the different LinearProduct elements;
		
		// For loop to calculate and add the linear product for every LinearProduct object;
		for (int i = 0; i < polynomials.length; i++) {
			elementProduct = polynomials[i].apply(arg);
//			System.out.println(String.format("%d: %f", i, elementProduct));
			sum = sum + elementProduct;
		}
		
		return sum;
	}
	
	/**
	 * Return the derivative of the Polynomial object.
	 * @return \result - The functional object containing the derivative 
	 * of the current object.
	 */
	public Function derivative() {
		// New LinearProduct object is created using the following formula:
		// If f = (g ^ (constant)) * constant +... + constant ==> 
		//									f' = (g(x) ^ (constant - 1)) * (constant * constantn) 
		//									+ ... + constant1;
			
		if (polynomials == null) {
			return null;
		}
		
		Sum derivPolynomial = null;  //Create a new Sum function.
		Function firstSum = polynomials[0].derivative();
		
		
		for (int i = 1; i < polynomials.length; i++) {
			
			Function temp =  polynomials[i].derivative();
			
			if (derivPolynomial == null) {
				derivPolynomial = new Sum(firstSum, temp);
			} else {
	
				derivPolynomial = new Sum(derivPolynomial, temp);
			}
			System.out.println(String.format("%s", derivPolynomial.toString()));
		}
		
		
		return derivPolynomial;
	}
	
	
	/**
	 * Returns a string representation of the Polynomial.
	 * @return - String representation of the Polynomial.
	 */
	public String toString() {
		return "Polynomial";
	}
	
	/**
	 * Returns the integrand of the Polynomial function.
	 * @return result - the integrand of the function.
	 */
	public Function integrand() {
		
		Sum intePolynomial = null;  //Create a new Sum function.
		Function firstTemp = polynomials[0].integrand();
		
		
		for (int i = 1; i < polynomials.length; i++) {
			 
			Function temp =  polynomials[i].integrand();
			
			if (intePolynomial == null) {
				intePolynomial = new Sum(firstTemp, temp);
			} else {
	
				intePolynomial = new Sum(intePolynomial, temp);
			}
			
		}
		
		return intePolynomial;
	}

}
