package ss.week2.hotel;

public class Safe {

	// ========= VARIABLES =========
	private boolean open;
	private boolean activated;
	
	// ========= CONSTRUCTOR =========
	
	public Safe() {
		open = false;
		activated = false;
	}
	
	// ========= COMMANDS =========
    /**
     * Activates the safe if the password is correct.
     */
    /**@
      pure;
      ensures this.isActive() == true;
     */
	public void activate(String pass) {
	}
	
    /**
     * Closes and deactivates the safe.
     */
    /**@
      pure;
      ensures this.isActive() == false;
     */
	public void deactivate() {
	}
	
    /**
     * Opens the safe if it is active, and the password is correct.
     */
    /**@
      pure;
      ensures Password.testWord(pass) && this.isActive() ==> this.isOpen() == true;
     */
	public void open(String pass) {
	}
	
    /**
     * Closes the safe (but does not change its activity status)
     */
    /**@
      pure;
      ensures this.isOpen() == false;
     */
	public void close() {
	}
	
	// ========= Queries =========
    /**
     * Indicates whether the safe is active
     */
    /**@
      pure;
     */
	public boolean isActive() {
		return false;
	}
	
    /**
     * Indicates whether the safe is open
     */
    /**@
      pure;
     */
	public boolean isOpen() {
		return false;
	}	
	
    /**
     * Returns the password object on which the method "testWord" 
     * can be called to check the password.
     */
    /**@
      pure;
     */
	public Password getPassword() {
		return null;
	}	
}
