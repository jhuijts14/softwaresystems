package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	
	private static final ReentrantLock MY_LOCK = new ReentrantLock();

	public TestSyncConsole(String name) {
		super(name);

	}

	public  void run() {
		
		this.sum(this.getName());
	}



	/**
	 * Calculate the sum of two numbers from input and write said sum to output.
	 * 
	 */
	private void sum(String name) {
		MY_LOCK.lock();
		
		try {
			int a = SyncConsole.readInt("Thread " + name + ": get number 1? ");
			int b = SyncConsole.readInt("Thread " + name + ": get number 2? ");

			int sum = a + b;

			SyncConsole.println("Thread " + name + ": " + a + " + " + b + " = " + sum);
		} finally {
			MY_LOCK.unlock();
		}
	
	}


}
