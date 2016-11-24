package ss.week2.hotel;

public class Safe {

	// ========= VARIABLES =========
	private boolean open;
	private boolean activated;
	private Password password;
	
	public static void main(String[] args) {
		Safe safe = new Safe();
		safe.activate("kip");
	}
	
	// ========= CONSTRUCTOR =========
    /**@
      ensures this.isActive() == false;
      ensures this.isOpen() == false;
     */	
	public Safe() {
		open = false;
		activated = false;
		password = new Password();
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
		assert password.acceptable(pass);
		if (password.testWord(pass)) {
			activated = true;
		}
	}
	
    /**
     * Closes and deactivates the safe.
     */
    /**@
      pure;
      ensures this.isActive() == false;
      ensures this.isOpen() == false;
     */
	public void deactivate() {
		activated = false;
		open = false;
	}
	
    /**
     * Opens the safe if it is active, and the password is correct.
     */
    /**@
      pure;
      ensures password.testWord(pass) && this.isActive() ==> this.isOpen() == true;
     */
	public void open(String pass) {
		assert password.acceptable(pass);
		if (password.testWord(pass) && this.isActive()) {
			open = true;
		}
	}
	
    /**
     * Closes the safe (but does not change its activity status)
     */
    /**@
      pure;
      ensures this.isOpen() == false;
     */
	public void close() {
		open = false;
	}
	
	// ========= Queries =========
    /**
     * Indicates whether the safe is active
     */
    /**@
      pure;
     */
	public boolean isActive() {
		return activated;
	}
	
    /**
     * Indicates whether the safe is open
     */
    /**@
      pure;
     */
	public boolean isOpen() {
		return open;
	}	
	
    /**
     * Returns the password object on which the method "testWord" 
     * can be called to check the password.
     */
    /**@
      pure;
     */
	public Password getPassword() {
		return password;
	}	
}
