package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole implements Runnable {
	
	Thread t;
	public static ReentrantLock lock=  new ReentrantLock();
	
	
	public TestSyncConsole(String name) {		
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		lock.lock();
		try {
			sum();
		} finally {
			lock.unlock();
		}
		
	}
	
	private void sum() {
		
		String threadName = t.getName();
		int a = SyncConsole.readInt(threadName + ": Get number 1? ", "That is not an integer!");
		int b = SyncConsole.readInt(threadName + ": Get number 2? ", "That is not an integer!");
		SyncConsole.println(threadName + ": " + a + " + " + b + " = " + (a + b));
	}
	
	public static void main(String[] args) {
		new TestSyncConsole("Thread A");
		new TestSyncConsole("Thread B");
	}
}