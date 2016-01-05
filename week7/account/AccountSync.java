package ss.week7.account;

import java.io.InterruptedIOException;

public class AccountSync {

	
	public static void main(String[] args) {
		int times = 10;
		double amount = 150.0;
		Account account = new Account();
		
		MyThread thread1 = new MyThread(-amount, times, account);
		MyThread thread2 = new MyThread(amount, times, account);
		
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The account balance is: " + account.getBalance());
	}

}
