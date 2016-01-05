package ss.week7.threads;


public class TestConsole extends Thread {

	
	public TestConsole(String name) {
		super(name);

	}
	
	public void run() {
		sum();
	}
	
	
	
	/**
	 * Calculate the sum of two numbers from input and write said sum to output.
	 * 
	 */
	private void sum() {
		int a = Console.readInt("Thread " + this.getName() + ": get number 1? ");
		int b = Console.readInt("Thread " + this.getName() + ": get number 2? ");
		
		int sum = a + b;
		
		Console.println("Thread " + this.getName() + ": " + a + " + " + b + " = " + sum);
	}

}
