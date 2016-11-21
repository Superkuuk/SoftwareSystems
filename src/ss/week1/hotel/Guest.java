package ss.week1.hotel;

/**
 * Program Guest.
 * Lab Exercise SoftwareSystems
 * @author Rutger Frieswijk
 * @version 1.0
 */
public class Guest {
	
	// ------------------ Instance variables ----------------	
	private String name;
	private Room room;
	
	
    // ------------------ Constructor ------------------------
	/**
     * Creates a <code>Guest</code> with the given name.
	* @param n, the name of the new <code>Guest</code>.
	*/
	public Guest(String n) {
		name = n;
	}

    // ------------------ Queries --------------------------

    /**
     * Returns the name of this <code>Guest</code>.
     */
	public String getName() {
		return name;
	}

    /**
     * Returns the current room of the <code>Guest</code>.
     * @return the room of this <code>Guest</code>.
     */
	public Room getRoom() {
		return room;
	}
   
	
	// ------------------ Commands --------------------------

    /**
     * Assigns a <code>Room</code> to this <code>Guest</code>.
     * @param r the <code>Room</code> for the this <code>Guest</code>.
     */	
	public boolean checkin(Room r) {
		if (r.getGuest() == null) {
			room = r;
			room.setGuest(this);
			return true;
		}
		return false;
	}
	
    /**
     * Removes a <code>Guest</code> from its <code>Room</code>.
     */		
	public boolean checkout() {
		if (this.getRoom() != null) {					// Unknown guest (has no room rented)
			room.setGuest(null);
		} else {
			return false;
		}
		room = null;
		return true;
	}
	
	public String toString() {
		return "Guest: " + name;
	}
	
}
