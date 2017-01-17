package ss.week7.threads;

import java.util.concurrent.locks.*;

public class FinegrainedIntCell implements IntCell {

	final Lock lock = new ReentrantLock();
	final Condition notFull  = lock.newCondition(); 
	final Condition notEmpty = lock.newCondition();
	private int value = 0;
	private boolean used = false;
	
	@Override
	public void setValue(int val) {
	    lock.lock();
	    try {
	    	while (!used) {
	    		notFull.await();
	        }
	        notEmpty.signal();
			used = false;
			this.value = val;
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
		} finally {
	        lock.unlock();
	    }
	}

	@Override
	public int getValue() {
	    lock.lock();
	    try {
	    	while (used) {
	    		notEmpty.await();
	    	}
	        notFull.signal();
			used = true;
			return value;
	    } catch (InterruptedException e) {
			e.printStackTrace();
			return 0;
		} finally {
	        lock.unlock();
	    }
	}

}
