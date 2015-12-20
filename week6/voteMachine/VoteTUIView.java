package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * The class VoteTUIView, contains different methods to build the TUI.
 * @author Joep Huijts
 * @version 0.0
 *
 */
public class VoteTUIView implements Observer, VoteView {

	//-----------------------------Instance Variables--------------------
	private VoteMachineController voteMachine;
	
	//-----------------------------Constructor-------------------------
	
	/**
	 * Create a TUI view for a input vote machine.
	 * @param voteMach - a vote machine that will be displayed and used by this TUI.
	 */
	public VoteTUIView(VoteMachineController voteMach) {
		voteMachine = voteMach;
	}
	
	
	//-----------------------------Commands-----------------------------
	
	/**
	 * Starts the loop requesting a user for input in the console.
	 */
	public void start() {
		
		boolean commands = true;
		
		while (commands) {
			
			Scanner in = new Scanner(System.in);
			
			
			System.out.println("Select one of these options (with the corresponding integers):");
			System.out.println("(1): Vote for a specific party.");
			System.out.println("(2): Add a party.");
			System.out.println("(3): View all the parties.");
			System.out.println("(4): View all the votes for parties.");
			System.out.println("(5): Exit the Vote Machine.");
			System.out.println("(6): Help manual of the Vote Machine");
			System.out.println("What do you want to do?");
			
			int answer = in.nextInt();
			
			if (answer < 1 || answer > 6) {
				System.out.println("Input is invalid! Pick again.");
			} else {
				
				// Vote for a specific party;
				if (answer == 1) {
					System.out.println("What party would you like to vote for?"
									+ " (Enter party name) ");
					String party = in.next();
					
					if (voteMachine.getParties().contains(party)) {
						voteMachine.vote(party);
					} else {
						System.out.println("Can not vote for a party not on the partylist!");
					}
					
				// Add a new Party;
				} else if (answer == 2) {
					System.out.println("What party would you like to add to the "
									+ "party list? (Enter party name) ");
					String party = in.next();
					
					if (!voteMachine.getParties().contains(party)) {
						voteMachine.addParty(party);
					} else {
						System.out.println("Input party name alread on the list! "
										+ "Can not add a party already on the list");
					}
					
				// View all parties being voted on;
				} else if (answer == 3) {
					this.showParties(voteMachine.getParties());
				
				// View all the parties votes;
				} else if (answer == 4) {
					this.showVotes(voteMachine.getVotes());
				
				// Exit the voting machine;
				} else if (answer == 5) {
					System.out.println("Exiting vote machine...");
					in.close();
					commands = false;
					System.exit(0);
					
				// Vote machine help
				} else {
					System.out.println("Help");
					this.showError("No Error");
				}
			}
		}
	}
	
	/**
	 *Display information about the votes in the vote list.
	 *@param voteList - the votes to be displayed. 
	 */
	public void showVotes(Map<String, Integer> voteList) {
		System.out.println("Votes (party name and their vote count):");
		System.out.println(voteList.toString());
	}
	
	/**
	 * Display all the parties participating in the vote.
	 * @param partyList - the list of all parties being voted on.
	 */
	public void showParties(List<String> partyList) {
		System.out.println("Parties:");
		System.out.println(partyList.toString());
	}
	
	/**
	 * Show information about the errors that occurred.
	 * @param
	 */
	public void showError(String error) {
		System.out.println(error);
	}


	@Override
	public void update(Observable o, Object change) {
	
		System.out.println("A " + change + " was added!");
	
		
		
	}
}
