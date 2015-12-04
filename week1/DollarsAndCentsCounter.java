package ss.week1;
/**
 * The class for a dollars and cents counter.
 * @author joep
 *
 */
public class DollarsAndCentsCounter {

	public int dollars;
	public int cents;
	
	/**
	 * The constructer for the dollars and cents counter.
	 * @param dollars
	 * @param cents
	 */
	public DollarsAndCentsCounter() {
		
	}
	
	public int dollars() {
		if (this.dollars < 0) {
			this.dollars = 0;
		}
		
		return this.dollars;
	}
	
	public int cents() {
		if (this.cents < 0) {
			this.cents = 0;
		}
		
		
		return this.cents;
	}
	
	/**
	 * Method to add dollar or cents to the counter.
	 * @param dollars
	 * @param cents
	 */
	public void add(int dollars1, int cents1) {
		this.dollars = this.dollars + dollars1;
		
		this.cents = this.cents + cents1;
		
		if (this.cents > 99) {
			this.dollars = this.dollars + (this.cents - (this.cents % 100)) / 100;
			this.cents = this.cents % 100;
		}
		
	}
	
	/**
	 * Method to reset the counter.
	 */
	public void reset() {
		if (this.dollars != 0 || this.cents != 0) {
			this.dollars = 0;
			this.cents   = 0;
		}
	}
	
	/**
	 * Method to subtract dollars and cents from the counter.
	 */
	public void subtract(int dollars1, int cents1) {
		this.dollars = this.dollars - dollars1;
		this.cents = this.cents - cents1;
		
		if (this.dollars < 0) {
			this.dollars = 0;
		} else if (this.cents < 0) {
			this.cents = 0;
		}
	}
	
}
