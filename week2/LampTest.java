package ss.week2;
/**
 * A tester for the lamp class and switching settings.
 * @author Joep Huijts
 *@version Version 1.0
 */
public class LampTest {

	
	/**
	 * Create a lamp to test.
	 */
	private Lamp testLamp;
	
	public LampTest() {
		testLamp = new Lamp();
	}
	
	/**
	 * Test the initial setting of the lamp.
	 */
	private void testInitialState() {
		System.out.println("testInitialState: ");
		System.out.println("Initial setting: " + testLamp.getSetting());
	}
	
	
	
	/**
	 * Test a change is a lamp's setting.
	 */
	private void testChange() {
		System.out.println("testChange: ");
		System.out.println("Starting setting: " + testLamp.getSetting());
		testLamp.switchSetting();
		System.out.println("After 1 change: " + testLamp.getSetting());
		testLamp.switchSetting();
		System.out.println("After 2 changes: " + testLamp.getSetting());
		testLamp.switchSetting();
		System.out.println("After 3 changes: " + testLamp.getSetting());
		testLamp.switchSetting();
		System.out.println("After 4 changes: " + testLamp.getSetting());
		
	}
	
	/**
	 * Test the switch setting method.
	 * 
	 */
	public void runTest() {
		this.testInitialState();
		this.testChange();
		
	}
}
