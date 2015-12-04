package ss.week1;

import ss.week1.test.DollarsAndCentsCounterTest;

public class TestCounter {

	/**
	 * A system to test the dollars and cents counter.
	 */
	public static void main(String[] args) {
		DollarsAndCentsCounterTest test;
		test = new DollarsAndCentsCounterTest();
		
		test.setUp();
		test.testDollars();
		test.setUp();
		test.testCents();
		test.setUp();
		test.testAdd();
		test.testReset();
		

	}

}
