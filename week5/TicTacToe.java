package ss.week5;

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
	 * 
	 * @param args - arrays of Strings containing to two players names.
	 */
    public static void main(String[] args) {
    	Player[] players = new Player[2];
    	Mark[] playerMark = new Mark[] {Mark.XX, Mark.OO};
   
    	int index = 0;
    	
    	while (index < args.length) {
    		if (args[index].equals("-N")) {
    			players[index] = new ComputerPlayer(playerMark[index]);
    		} else if (args[index].equals("-S")) {
    			players[index] = new ComputerPlayer(playerMark[index], new SmartStrategy());
    		} else {
    			players[index] = new HumanPlayer(args[index], playerMark[index]);
    		}
    		
    		index++;
    	}
    	
    	Game game = new Game(players[0], players[1]);
    	game.start();
       
    }
}
