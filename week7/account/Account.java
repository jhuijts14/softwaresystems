package ss.week7.account;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;

	public void transaction(double amount) {
		synchronized (this) {
			try {
				while (balance + amount < -1000 && amount < 0) {

					this.wait();

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			balance = balance + amount;
			System.out.println(balance);
			this.notifyAll();
		}
	}
	public double getBalance() {
		return balance;

	}
}
