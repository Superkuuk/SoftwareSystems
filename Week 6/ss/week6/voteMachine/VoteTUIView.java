package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer, VoteView {
	
	VoteMachine vm;
	
	public VoteTUIView(VoteMachine vm) {
		this.vm = vm;
	}
	
	/** 
	 * Starts the TUI, multiple commands are then available through command prompt.
	 */
	public void start() {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("Command: ");
			String a = in.next();
			if (a.equals("EXIT")) {
				break;
			} else if (a.equals("HELP")) {
				System.out.println("Use commands:");
				System.out.println("EXIT - exit the program");
				System.out.println("HELP - this help message");
				System.out.println("VOTES - to view all votes");
				System.out.println("PARTIES - to view all parties");
				System.out.println("VOTE <party> - to vote for a certain party");
				System.out.println("ADD PARTY <party> - to add a certain party");
			} else if (a.equals("VOTES")) {
				showVotes(vm.getVotes());
			} else if (a.equals("PARTIES")) {
				showParties(vm.getParties());
			} else if (a.equals("VOTE")) {
				String arg = in.next();
				vm.vote(arg);
			} else if (a.equals("ADD") && in.next().equals("PARTY")) {
				String arg = in.next();
				vm.addParty(arg);
			}
		}
		System.out.println("End of programme.");
		in.close();
	}

	/** 
	 * Shows a list of all the parties voted upon and their number of votes.
	 * @param   votes a Map of the parties and votes
	 */
	public void showVotes(Map<String, Integer> votes) {
		for (Map.Entry<String, Integer> entry : votes.entrySet()) {
		    System.out.println("Party = " + entry.getKey() + ", # of Votes = " + entry.getValue());
		}
	}

	/** 
	 * Shows a list of all the parties.
	 * @param   parties a List of the parties
	 */
	public void showParties(List<String> parties) {
		for (String entry : parties) {
		    System.out.println("Party:" + entry);
		}
	}
	
	/** 
	 * Shows an error message in the system prompt.
	 * @param   message a message to display
	 */
	public void showError(String message) {
		System.out.println(message);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
	}
	
}
