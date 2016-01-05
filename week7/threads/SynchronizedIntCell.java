package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	private int value = 0;
	private static boolean consumed = true;
	private static final Object LOCK = new Object();

	public synchronized void setValue(int valueArg) {
		while (!consumed) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		value = valueArg;
		consumed = false;
		this.notify();
	}

	public synchronized int getValue() {
		
		while (consumed) {
			try {
				this.wait(5000);
				
				if (consumed) {
					setValue(-1);
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		
		consumed = true;
		this.notify();
		return value;
		
	}

}
