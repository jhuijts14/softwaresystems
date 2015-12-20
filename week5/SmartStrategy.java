package ss.week5;

import java.util.*;

public class SmartStrategy implements Strategy {
	//--------------------Instance Variables---------------------
	private String name; // Name of the strategy;
	private Set<Integer> moves;

	//------------------------Constructor------------------------

	/**
	 * Create a SmartStrategy with the name "Smart".
	 */
	//@ ensures this.name == "Smart" && moves.size() == 9;
	public SmartStrategy() {
		this.name = "Smart";
		moves = new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));

	}
	
	//------------------------------Queries-----------------------------------

	/**
	 * Returns the Name of the Strategy.
	 * @return String name of the Strategy.
	 */
	/*@ pure */ public String getName() {
		return this.name;
	}

	/**
	 * Returns a smart move, given the Board the 
	 * move is on and the Mark of the player.
	 * @param b - the Board the move will be on.
	 * @param m - the Mark of the player making the move.
	 * @return result - the index of the next move the 
	 * ComputerPlayer will make.
	 */
	/*@ pure*/ public int determineMove(Board b, Mark m) {

		// If the middle field is empty, the field is selected;
		
		if (b.isEmptyField(4)) {
			return 4;
		}


		// If there is a field that guarantees a direct win, this field is selected;
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			Board copyB = b.deepCopy();
			copyB.setField(i, m);

			if (copyB.isWinner(m) && b.isEmptyField(i)) {
				return i;
			}
		}

		// If there is a field the opponent needs to win, this field is selected;
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			Board copyB = b.deepCopy();
			copyB.setField(i, m.other());

			if (copyB.isWinner(m.other()) && b.isEmptyField(i)) {
				return i;
			}
		}

		// If none of the cases above applies, a random field is selected;
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
