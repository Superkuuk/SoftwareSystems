package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	private int value = 0;
	private boolean used = false;
	
	public void setValue(int valueArg) {
		synchronized (this) {
			while (!used) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.notify();
			used = false;
			this.value = valueArg;
		}
		
		
	}

	public int getValue() {
		synchronized (this) {
			while (used) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.notifyAll();
			used = true;
			return value;
		}
		
	}
}