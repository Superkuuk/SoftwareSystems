package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {

	public Map<String, Integer> votes = new HashMap<>();
	
	public VoteList() {
	}
	
	/** 
	 * Adds a new vote to the file.
	 * @param   p name of the party to vote on
	 */
	public void addVote(String p) {
		if (votes.containsKey(p)) {
			votes.put(p, votes.get(p) + 1);
		} else {
			votes.put(p, 1);
		}
		setChanged();
		notifyObservers("vote");
	}
	
	/** 
	 * Gets the current votes from a file.
	 */
	public Map<String, Integer> getVotes() {
		return votes;
	}
	
}
