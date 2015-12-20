package ss.week5;

import java.util.*;
/**
 * The class NaiveStrategy, which implements Strategy to 
 * determine moves the computer player should make.
 * @author Joep Huijts
 * @version 1.0
 *
 */
public class NaiveStrategy implements Strategy {

	//--------------------Instance Variables---------------------
	private String name; // Name of the strategy;
	private Set<Integer> moves;
	
	//------------------------Constructor------------------------
	
	/**
	 * Create a NaiveStrategy with the name "Naive".
	 */
	//@ ensures this.name == "Naive";
	public NaiveStrategy() {
		this.name = "Naive";
		moves = new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
		
	}
	
	/**
	 * Returns the Name of the Strategy.
	 * @return String name of the Strategy.
	 */
	/*@ pure */ public String getName() {
		return this.name;
	}
	
	/**
	 * Returns a legal move, given the Board the 
	 * move is on and the Mark of the player.
	 * @param b - the Board the move will be on.
	 * @param m - the Mark of the player making the move.
	 * @return result - a random empty integer field from 
	 * the set this.moves
	 */
	/*@ pure*/ public int determineMove(Board b, Mark m) {
		
		List<Integer> temp = new ArrayList<Integer>();
		
		for (int i = 0; i < (Board.DIM * Board.DIM); i++) {
			if (b.isEmptyField(i)) {
				temp.add(i);
			}
		}
		
		int randomIndex = (int) (Math.random() * moves.size());
		
		int result = temp.get(randomIndex);
		
		
		return result;
		
	}
}
