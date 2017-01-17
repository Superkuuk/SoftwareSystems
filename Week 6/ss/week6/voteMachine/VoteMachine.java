package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {
	
	PartyList parties;
	VoteList votes;
	VoteView view;
	
	public VoteMachine() {
		parties = new PartyList();
		votes = new VoteList();
		view = new VoteGUIView(this);
		parties.addObserver(view);
		votes.addObserver(view);
	}
	
	public void start() {
		view.start();
	}

	/** 
	 * Gets the parties from the model and passes it through to the TUI.
	 */
	public List<String> getParties() {
		return parties.getParties();
	}
	
	/** 
	 * Gets the votes from the model and passes it through to the TUI.
	 */
	public Map<String, Integer> getVotes() {
		return votes.getVotes();
	}
	
	/** 
	 * Adds a new party to the machine.
	 * @param   party name of the party which can be voted on
	 */
	public void addParty(String party) {
		parties.addParty(party);
	}

	/** 
	 * Adds a new vote to a specific party.
	 * @param   party name of the party which to voted on
	 */
	public void vote(String party) {
		votes.addVote(party);
	}
}
