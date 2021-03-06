package ss.week4.math;

/**
 * The class LinearProduct, which defines the product of a Function and a Constant.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class LinearProduct extends Product implements Integrandable {

	
	//------------------------Constructor-------------------------------
	/**
	 * Create a LinearProduct with a given function and constant.
	 * @param function1 - a Function object.
	 * @param constant - a Constant object.
	 */
	//@ ensures this.function == function1 && this.constant == constant;
	public LinearProduct(Constant constant, Function function1) {
		super(function1, constant); 
		// Uses the constructor of Product while specifying 
		// that the second function is a Constant function object;
		
		
	}
	
	/**
	 * Return the derivative of the Product of two Function objects.
	 * @return result - The function object containing the derivative.
	 */
	public Function derivative() {
		// New LinearProduct object is created using the derivative of the 
		// function as a parameter along with the constant;
		// If f(x) = g(x) * constant ==> f'(x) = g'(x) * constant;
		LinearProduct derivLinearProduct = new LinearProduct((Constant) this.func2, 
						this.func1.derivative());
		System.out.println("Function derivative got called with; " + derivLinearProduct);
		return derivLinearProduct;
	}
	
	/**
	 * Returns the integrand of the LinearProduct function.
	 * @return result - the integrand of the function.
	 */
	public Function integrand() {
		
		if (!(this.func1 instanceof Integrandable)) {
			return null;
		}
		
		Function inteLinearProduct = 
						new LinearProduct((Constant) (this.func2), ((Integrandable) 
							this.func1).integrand());
		
		return inteLinearProduct;
	}

}
