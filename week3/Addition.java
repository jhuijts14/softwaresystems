package ss.week3;
/**
 * The class for the operation Addition with its identity.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class Addition implements OperatorWithIdentity {
	
	//---------------------INSTANCE VARIABLES----------------------
	
	
	//----------------------Constructor------------------------------
	/**
	 * Create an Addition operation.
	 */
	public Addition() {
		
	}
	
	//--------------------------Queries-------------------------------

	/**
	 * Perform this operation, Addition.
	 */
	//@ ensures left + right == right + left;
	/*@ pure */ public int operate(int left, int right) {
		int result;
		result = left + right;
		
		assert result == right + left;
		
		return result;
	}
	
	/**
	 * The identity for this operator. For any integer i,
	 * this.operate(this.identity, i) == i
	 * this.operate(i, this.identity) == i
	 */
	/*@ pure */ public int identity() {
		return 0;
	}
	//---------------------------Commands--------------------------------

	

}
