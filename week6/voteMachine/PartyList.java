package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The class PartyList, which the list of different strings for the parties in the voting machine.
 * @author Joep Huijts
 * @version 0.0
 *
 */
public class PartyList extends Observable  {

	
	//-------------------------Instance variables---------------------------
	
	private List<String> parties; // The list of string names of all the parties;
	
	//----------------------------Constructor-------------------------------
	
	/**
	 * Create a party list with the string names of the parties.
	 * 
	 */
	public PartyList() {
		parties = new ArrayList<String>();
	}
	
	//------------------------------Queries----------------------------------
	
	/**
	 * Retrieve all the parties from the party list.
	 * @return \result - a list containing string names of all the parties.
	 */
	/*@ pure */ public List<String> getParties() {
		return parties;
	}
	
	/**
	 * Return true or false depending on if party is in the party list with a given name.
	 * @param name - a string party name to search the party list for.
	 * @return true || false - depending on whether party is in the party list.
	 */
	//@ ensures \result == parties.contains(name);
	/*@ pure */ public boolean hasParty(String name) {
		
		return parties.contains(name);
	}
	
	//--------------------------Commands------------------------------------------
	
	/**
	 * Add a party to the party list.
	 * @param name - a string name of the party to add to the list.
	 */
	//@ ensures true == this.parties.contains(name);
	public void addParty(String name) {
		this.parties.add(name);
		
		this.setChanged();
		this.notifyObservers("party");
	}
}
