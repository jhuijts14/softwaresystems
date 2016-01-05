package ss.week7.account;

public class MyThread extends Thread {

	private double theAmount;
	private int theFrequency;
	private Account theAccount;
	
	public MyThread(double amount, int frequency, Account account) {
		this.theAccount = account;
		this.theFrequency = frequency;
		this.theAmount = amount;
	}
	
	public void run() {
		
		for (int i = 0; i < this.theFrequency; i++) {
			theAccount.transaction(theAmount);
		}
	}
}
