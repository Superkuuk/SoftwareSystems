package ss.week7.threads;

public class TestConsole implements Runnable {
	
	Thread t;
	
	public TestConsole(String name) {
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		sum();
	}
	
	private void sum() {
		String threadName = t.getName();
		int a = Console.readInt(threadName + ": Get number 1? ", "That is not an integer!");
		int b = Console.readInt(threadName + ": Get number 2? ", "That is not an integer!");
		Console.println(threadName + ": " + a + " + " + b + " = " + (a + b));
	}
	
	public static void main(String[] args) {
		new TestConsole("Thread A");
		new TestConsole("Thread B");
	}
}
