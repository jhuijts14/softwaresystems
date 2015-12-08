package ss.week4.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	
	/**
	 * Play a Tic-Tac-Toe game after this method executes.
	 */
    public static void main(String[] args) {
    	Player player1 = new HumanPlayer("Joep", Mark.OO);
    	Player player2 = new HumanPlayer("Test", Mark.XX);
    	
    	Game game = new Game(player1, player2);
    	game.start();
       
       
    }
}
