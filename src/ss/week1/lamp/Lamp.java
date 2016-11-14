package ss.week1.lamp;
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

	private int mode;      // current light

	
	public Lamp() {		// Constructor
		mode = OUT;
	}

	public int getMode() { // getter
		return mode;
	}

	public void switchSetting() { 			// change mode of the lamp to the next
		mode = (mode + 1) % 4;
	}
	
	public void reset() {
		mode = 0;
	}
	
}
