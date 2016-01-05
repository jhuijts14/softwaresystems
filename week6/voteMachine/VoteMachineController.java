package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import ss.week6.voteMachine.gui.VoteGUIView;

/**
 * The class VoteMachine, which uses the VoteList and PartyList classes.
 * @author Joep Huijts
 * @version 0.0
 *
 */
public class VoteMachineController {

	//------------------------------Instance Variables-----------------
	private PartyList parties; // This list of all parties to be voted upon;
	private VoteList votes; // The list of the amount of votes for each party;
	private VoteView voteView;
	
	
	//-----------------------------Constructor---------------------------
	
	/**
	 * Create a vote machine with an empty party list and vote list.
	 */
	public VoteMachineController() {
		votes = new VoteList();
		
		parties = new PartyList();
		
		voteView = new VoteGUIView(this);
		
		// Observers for the party list and vote list;
		parties.addObserver(voteView);
		votes.addObserver(voteView);
	}

	//------------------------------Queries----------------------------

	/**
	 * Returns the list of all the parties in the vote machine.
	 * @return \result - the PartyList of all the parties.
	 */
	/*@ pure */ public void getParties() {
		voteView.showParties(parties.getParties());
	}

	/**
	 * Returns the list of all the votes of the parties in the vote machine.
	 * @return \result - the VoteList of all the vote machine.
	 */
	/*@ pure */ public void getVotes() {
		voteView.showVotes(votes.getVotes());
		
	}

	//-----------------------------Commands----------------------------------
	
	/**
	 * Add a party with a input name to the party list.
	 * @param party - a string name of a new party to add.
	 */
	//@ ensures parties.hasParty(name);
	public void addParty(String party) {
		parties.addParty(party);
	}
	
	/**
	 * Vote for a specified party. The vote will be added to the vote list.
	 * @param party - the string name of the party to vote for.
	 */
	//@ requires parties.hasParty(party);
	public void vote(String party) {
		if (parties.hasParty(party)) {
			votes.addVote(party);
		} else {
			voteView.showError("Party is not on party list!");
		}
	}
	
	public void start() {
		voteView.start();
	}
	

	/**
	 * Main method that starts the TUI and allows the user to use the vote machine.
	 */
	public static void main(String[] args) {
		VoteMachineController voteMachine = new VoteMachineController();
		
		
		// Start the TUI;
		voteMachine.start();
	}

	
}
