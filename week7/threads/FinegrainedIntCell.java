package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
	private int value = 0;
	private boolean isConsumed = true;
	private ReentrantLock myLock = new ReentrantLock();
	private Condition consumed = myLock.newCondition();
	private Condition notConsumed = myLock.newCondition();

	public void setValue(int valueArg) {
		myLock.lock();
		try {
			while (!isConsumed) {
				try {
					notConsumed.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			this.value = valueArg;
			this.isConsumed = false;
			
			consumed.signalAll();
		} finally {
			myLock.unlock();
		}
	
		
	}

	public int getValue() {
		myLock.lock();
		try {
			while (isConsumed) {
				try {
					consumed.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			this.isConsumed = true;
			

			notConsumed.signalAll();
		} finally {
			myLock.unlock();
		}

		return value;
	}

}
