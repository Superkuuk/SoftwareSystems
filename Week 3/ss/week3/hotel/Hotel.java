package ss.week3.hotel;

public class Hotel {
	
	private Room room101;
	private Room room102;
	private String name;
	private Password password;
	
	// Contructor
	
	public Hotel(String name) {
		room101 = new Room(101);
		room102 = new Room(102);
		this.name = name;
		password = new Password();
	}
	
	// Commands:
	
	/**
	 * Check a guest in a room. The room must be empty and the password must be OK.
	 * The room where the guest is checked in is returned.
	 */
	/**@ 
	 pure
	 ensures this.getRoom(name) == \result;
	 */
	public Room checkIn(String pass, String guestName) {	
		assert password.acceptable(pass);
		Room freeRoom = this.getFreeRoom();
		if (freeRoom != null && password.testWord(pass)) {
			Guest g = new Guest(guestName);
			freeRoom.setGuest(g);
			return freeRoom;
		}
		return null;
	}
	
	/**
	 * Check out a guest in a room. The guest is checked out, and the safe
	 * in his room is deactivated If there is no guest with this name, nothing happens.
	 */
	/**@ 
	 pure
	 ensures this.getRoom(name) == null;
	 */
	public void checkOut(String guestName) {	
		if (this.getRoom(guestName) != null){
			Room r = this.getRoom(guestName);
			r.getSafe().deactivate();
			r.setGuest(null);		
		}
	}
	
	// Queries:
	
	/**
	 * Gets a room where no guest is checked in. Or null if there is no free room available.
	 */
	/**@ 
	 pure
	 */
	public Room getFreeRoom() {	
		if (room101.getGuest() == null) {
			return room101;
		} else if (room102.getGuest() == null) {
			return room102;
		}
		return null;
	}
	
	/**
	 * Receiving the name of a guest as parameter, returning the Room object
	 * where the guest is checked in, or null if there is no such room.
	 */
	/**@ 
	 pure 
	 */
	public Room getRoom(String guestName) {	
		if (room101.getGuest() != null && room101.getGuest().getName() == guestName) {
			return room101;
		} else if (room102.getGuest() != null && room102.getGuest().getName() == guestName) {
			return room102;
		}
		return null;
	}
	
	/**
	 * Return the password object of the hotel, which is used by checkIn()
	 */
	/**@ 
	 pure 
	 */
	public Password getPassword() {	
		return password;
	}
	
	/**
	 * A textual description of all rooms in the hotel, including the name 
	 * of the guest and the status of the safe in that room.
	 */
	/**@ 
	 pure 
	 */
	public String toString() {
		String returnString = "";
		if (room101.getGuest() != null) {
			returnString = "Room 101 has guest " + room101.getGuest().getName() + " and "
					+ "safe status (active, open): (" + room101.getSafe().isActive() + ", " 
					+ room101.getSafe().isOpen() + ")";
		}
		if (room102.getGuest() != null) {
			returnString = returnString + " <br>" + "Room 102 has guest " 
				+ room102.getGuest().getName() + " and safe status "
				+ "(active, open): (" + room102.getSafe().isActive() + ", " 
				+ room102.getSafe().isOpen() + ")";
		}
		return returnString;
	}
}
