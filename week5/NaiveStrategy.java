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
		moves = Collections.emptySet();
		
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
		
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(moves);
		
		int randomIndex = (int) (Math.random() * moves.size());
		
		return result.get(randomIndex);
		
	}
}
