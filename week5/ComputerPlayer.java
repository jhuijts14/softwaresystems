package ss.week5;

/**
 * The class ComputerPlayer, that extends the class Player and 
 * enables a computer player to play tic-tac-toe.
 * @author Joep Huijts
 * @version 1.0
 *
 */
public class ComputerPlayer extends Player {

	//---------------------Instance Variables-------------------------------
	private Strategy strategy; // The computer players strategy;
	
	//----------------------Constructor------------------------------------
	
	/**
	 * Create a ComputerPlayer with a given name, mark and strategy.
	 * @param name - a String of the name of the ComputerPlayer.
	 * @param mark - the mark that the ComputerPlayer will associated with.
	 * @param strategy - the strategy the ComputerPlayer will play with.
	 */
	//@ requires name != null;
	//@ requires mark == Mark.OO || mark == Mark.XX;
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy + "-" + mark.name(), mark);
		this.strategy = strategy;
	}
	
	/**
	 * Create a ComputerPlayer with a given name, mark and its strategy set to the NaiveStrategy.
	 * @param name - a String of the name of the ComputerPlayer.
	 * @param mark - the mark that the ComputerPlayer will associated with.
	 */
	//@ requires name != null;
	//@ requires mark == Mark.OO || mark == Mark.XX;
	public ComputerPlayer(Mark mark) {
		super("Naive-" + mark.name(), mark);
		this.strategy = new NaiveStrategy();
	}
	
	//------------------------------------Queries-----------------------------------------------
	
	/**
	 * Returns an integer index for what move the ComputerPlayer should do next. 
	 * Uses the ComputerPlayers current strategy to get that index.
	 * @param board - the board that the ComputerPlayer is playing on.
	 * @return \result - an integer index for the next move the ComputerPlayer should make.
	 */
	//@ requires board != null;
	@Override
	/*@ pure */ public int determineMove(Board board) {
		
		return this.strategy.determineMove(board, this.getMark());
	}

	
	
	/**
	 * Return the current strategy of the ComputerPlayer.
	 * @return a String representation of the strategy.
	 */
	/*@ pure */ public String inspectStrategy() {
		return this.getName() + "is using the " + this.strategy.getName() + " strategy.";
	}
	
	//-----------------------------Commands---------------------------------------------------
	
	/**
	 * Update the ComputerPlayer's strategy to another strategy.
	 * @param other - other strategy that the ComputerPlayer's strategy will be switched to.
	 */
	public void updateStrategy(Strategy other) {
		this.strategy = other;
	}
}
