package ss.week6.voteMachine;

import java.util.HashMap;

import java.util.Map;
import java.util.Observable;

/**
 * The class VoteList, which defines a list contains votes.
 * @author Joep Huijts
 *@version 0.0
 */
public class VoteList extends Observable {

	//-----------------------------Instance Variables---------------------------
	
	private Map<String, Integer> votes; 
	// Map containing the party names and corresponding number of votes;
	
	//--------------------------------Constructor---------------------------------
	
	/**
	 * Create a new vote list. Creates an empty Map of strings and integers.
	 */
	public VoteList() {
		votes = new HashMap<String, Integer>();
	}
	
	//-----------------------------Queries-------------------------------------------
	
	/**
	 * Return the votes list.
	 * @return \result - a map<String, Integer> listing all the votes for each party.
	 */
	/*@ pure */ public Map<String, Integer> getVotes() {
		return votes;
	}
	
	//------------------------------------Commands-------------------------------------
	
	/**
	 * Make a vote by calling this method with a party name. If the party has not been voted 
	 * for before, a new element is made in the map for the party with its number of votes set 
	 * to one. It the party already has 1 or more votes, the vote count for the party is incremented
	 * by one.
	 * @param name - a string name of the party that was voted for.
	 */
	//@ ensures \result == (if int vote > 1 : 
	public void addVote(String name) {
		// If parties already has a vote, its vote count is incremented;
		if (votes.containsKey(name)) {
			int temp = votes.get(name); // A local int variable with the old vote count;
			
			votes.put(name, temp + 1);
			
		} else { // If not the party is added with a vote count of one;
			votes.put(name, 1);
		}
		
		this.setChanged();
		this.notifyObservers("vote");
	}
}
