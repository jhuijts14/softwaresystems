package ss.week4.math;

/**
 * The interface Integrandeble which defines how to integrate a function.
 * @author Joep Huijts
 * @version 1.0
 *
 */
public interface Integrandable {

	/**
	 * Returns the integrand of a function.
	 * @return result - the integrand of the function.
	 */
	public Function integrand();
}
