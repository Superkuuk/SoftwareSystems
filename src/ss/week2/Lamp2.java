package ss.week2;
/**
 * Hello World class.
 * @author Rutger Frieswijk
 */

public class Lamp2 {
	
	public enum Mode { OUT, LOW, MEDIUM, HIGH };
	private Mode mode;

    /**
     * Create a new lamp, with mode OUT.
     */
    /**@
      ensures this.getMode() == Mode.OUT;
     */
	public Lamp2() {		// Constructor
		mode = Mode.OUT;
	}
	
    /**
     * The mode of the lamp.
     */
    /**@
      pure;
     */
	public Mode getMode() { // getter
		return mode;
	}
 
	/**
     * Switch the mode of the lamp to the next.
     */
    /**@
      pure;
      ensures this.getMode() == old(this.getMode()) + 1;
      ensures \old(this.getMode()) == Mode.OUT ==> this.getMode() == Mode.LOW;
      ensures \old(this.getMode()) == Mode.LOW ==> this.getMode() == Mode.MEDIUM;
      ensures \old(this.getMode()) == Mode.MEDIUM ==> this.getMode() == Mode.HIGH;
      ensures \old(this.getMode()) == Mode.HIGH ==> this.getMode() == Mode.OUT;
     */
	public void switchSetting() {
		assert mode == Mode.OUT || mode == Mode.LOW || mode == Mode.MEDIUM || mode == Mode.HIGH;
		switch (mode) {
			case OUT: 		mode = Mode.LOW;
							break;
							
			case LOW:		mode = Mode.MEDIUM;
							break;
							
			case MEDIUM: 	mode = Mode.HIGH;
							break;
							
			case HIGH: 		mode = Mode.OUT;
							break;
		}
		
	}
	
	/**
     * Reset the lamp to OUT.
     */
    /**@
      pure;
      ensures this.getMode() == Mode.OUT;
     */	
	public void reset() {
		mode = Mode.OUT;
	}
	
}
