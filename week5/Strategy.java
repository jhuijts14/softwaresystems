package ss.week5;

/**
 * The interface Strategy, which defines how a 
 * computer plays Tic-Tac_Toe.
 * @author Joep Huijts
 * @version 1.0
 *
 */
public interface Strategy {

	/**
	 * Returns the Name of the Strategy.
	 * @return String name of the Strategy.
	 */
	/*@ pure */ public String getName();
	
	/**
	 * Returns a next legal move, given the Board the 
	 * move is on and the Mark of the player.
	 * @param b - the Board the move will be on.
	 * @param m - the Mark of the player making the move.
	 * @return result - the integer input used by the player 
	 * for their next move.
	 */
	public int determineMove(Board b, Mark m);
}
