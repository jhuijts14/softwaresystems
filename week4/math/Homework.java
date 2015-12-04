package ss.week4.math;

/**
 * The class Homework, tests how the different functions are displayed.
 * @author Joep Huijts
 * @version 1.0
 *
 */
public class Homework {

	//----------------------Instance Variables-----------------
	private static Constant constant1 = new Constant(1.00);
	private static Constant constant2 = new Constant(2.00);
	private static Sum sum1;
	private static Exponent exponent1 = new Exponent(4);
	private static Product product1;
	private static LinearProduct linearProduct1;
	private static Polynomial polynomial1;
	private static Function f1, f2, f3, f4;
	
	private static final double[] ARRAY = new double[]{0, 1, 2};
	
	//--------------------------Method-------------------------
	
	public static void main(String[] args) {
		linearProduct1 = new LinearProduct(constant2, exponent1);
		f1 = linearProduct1.derivative();
		f2 = linearProduct1.integrand();
		
		System.out.println("f(x) = " + linearProduct1.toString() + ", f(8) =  " + 
						linearProduct1.apply(8));
		System.out.println("f(x) = " + f1.toString() + ", f(8) =  " + f1.apply(8));
		System.out.println("f(x) = " + f2.toString() + ", f(8) =  " + f2.apply(8));
		System.out.println("=========================================================");
		
		sum1 = new Sum(new LinearProduct(constant1, constant2), exponent1);
		f3 = sum1.derivative();
		
		System.out.println("f(x) = " + sum1.toString() + ", f(8) =  " + sum1.apply(8));
		System.out.println("f(x) = " + f3.toString() + ", f(8) =  " + f3.apply(8));
		System.out.println("=========================================================");
	}
}
