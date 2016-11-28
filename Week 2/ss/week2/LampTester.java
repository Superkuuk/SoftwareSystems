package ss.week2;


public class LampTester {
  
	private Lamp2 lamp;
  
  /**
   * Create a new CounterTester.
   */
	public LampTester() {
		lamp = new Lamp2();
	}
  
  /**
   * Run the test.
   */
    public void start() {
    	System.out.println("Starting mode:");
    	System.out.println(lamp.getMode());
    	lamp.switchSetting();
    	lamp.switchSetting();
    	lamp.switchSetting();
    	System.out.println("After 3 changes:");
    	System.out.println(lamp.getMode());
    	lamp.switchSetting();
    	System.out.println("After 4 changes:");
    	System.out.println(lamp.getMode());
    	lamp.reset();
    	System.out.println("After reset:");
    	System.out.println(lamp.getMode());
    }
  
}
