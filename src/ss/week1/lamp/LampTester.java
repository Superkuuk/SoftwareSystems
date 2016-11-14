package ss.week1.lamp;


public class LampTester {
  
  private Lamp lamp;
  
  /**
   * Create a new CounterTester.
   */
  public LampTester () {
    lamp = new Lamp();
  }
  
  /**
   * Run the test.
   */
  public void start () {
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
