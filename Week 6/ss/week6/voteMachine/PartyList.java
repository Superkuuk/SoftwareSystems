package ss.week6.voteMachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {
	
	List<String> parties = new ArrayList<>();
	
	public PartyList() {
		parties.clear();
		try {
            PrintWriter writer = new PrintWriter(new FileWriter("parties.txt"));     
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
	

	/** 
	 * Adds a new party to the file.
	 * @param   p name of the new party
	 */
	public void addParty(String p) {
        getParties();
		try {
            PrintWriter writer = new PrintWriter(new FileWriter("parties.txt")); 
    		for (String party : parties) {
    			writer.println(party);
    		}          
            writer.println(p);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
		setChanged();
		notifyObservers("party");
	}


	/** 
	 * Checks if the list of parties contains a certain party.
	 * @param   p name of the party to search for
	 */
	public boolean hasParty(String p) {
		getParties();
		boolean found = false;
		for (String party : parties) {
			if (party.equals(p)) {
				found = true;
				break;
			}
		}
		return found;
	}

	/** 
	 * Returns a list of all the parties.
	 */
	public List<String> getParties() {
		parties.clear();
		try {
        	BufferedReader reader = new BufferedReader(new FileReader("parties.txt"));
            String line;
        	while ((line = reader.readLine()) != null) {
        		parties.add(line);
            }
        	reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    
		return parties;
	}
	
}
