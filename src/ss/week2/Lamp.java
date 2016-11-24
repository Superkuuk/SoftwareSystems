package ss.week2;
/**
 * Hello World class.
 * @author Rutger Frieswijk
 */

public class Lamp {
	
	// constants:
	public static final int OUT = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;

	//@ private invariant mode == OUT || mode == LOW || mode == MEDIUM || mode == HIGH;
	private int mode;      // current light

    /**
     * Create a new lamp, with mode OUT.
     */
    /**@
      ensures this.getMode() == OUT;
     */
	public Lamp() {		// Constructor
		mode = OUT;
	}
	
    /**
     * The mode of the lamp.
     */
    /**@
      pure;
      ensures \result == OUT || \result == LOW || \result == MEDIUM || \result == HIGH;
     */
	public int getMode() { // getter
		return mode;
	}
 
	/**
     * Switch the mode of the lamp to the next.
     */
    /**@
      pure;
      ensures this.getMode() == old(this.getMode()) + 1;
      ensures \old(this.getMode()) == OUT ==> this.getMode() == LOW;
      ensures \old(this.getMode()) == Low ==> this.getMode() == MEDIUM;
      ensures \old(this.getMode()) == MEDIUM ==> this.getMode() == HIGH;
      ensures \old(this.getMode()) == HIGH ==> this.getMode() == OUT;
     */
	public void switchSetting() {
		assert mode == OUT || mode == LOW || mode == MEDIUM || mode == HIGH;
		mode = (mode + 1) % 4;
	}
	
	/**
     * Reset the lamp to OUT.
     */
    /**@
      pure;
      ensures this.getMode() == OUT;
     */	
	public void reset() {
		mode = OUT;
	}
	
}
