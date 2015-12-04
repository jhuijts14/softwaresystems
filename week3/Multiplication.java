package ss.week3;

/**
 * The class for the Multiplication identity operation.
 * @author Joep Huijts
 *@version Version 1.0
 */
public class Multiplication implements OperatorWithIdentity {

	//---------------------------Queries---------------------------
	 /**
	 * Perform this operation using Multiplication.
	 */
	//@ ensures left * right == right * left;
	public int operate(int left, int right) {
		int result;
		result = left * right;
		
		assert result == right * left;
		
		return result;
	}
	
	/**
	 * The identity for this operator. For any integer i,
	 * this.operate(this.identity, i) == i
	 * this.operate(i, this.identity) == i
	 */
	public int identity() {
		return 1;
	}
	 
}
