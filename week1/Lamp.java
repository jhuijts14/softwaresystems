
package ss.week1;
/**
 * The class for the three-way lamp.
 * @author joep
 *
 */
public class Lamp {
/**
 * The current setting of the lamp. Either off, low, medium or high.
 */
	public int setting;
	public String result;
	
	/**
	 * Create a new Lamp, with the 
	 * setting initialized to "off".
	 */
	public Lamp() {
		setting = 0;
	}
	
	/**
	 * The current setting of the lamp.
	 * @return
	 */
	public String getSetting() {
		if (setting == 1) {
			result = "low";
		} else if (setting == 2) {
			result = "medium";
		} else if (setting == 3) {
			result = "high";
		} else {
			result = "off";
		}
		return result;
	}
	
	/** 
	 * Increment the setting of a lamp.
	 * @param lampSetting
	 */
	public void switchSetting() {
		setting += 1;
		
		setting = setting % 4;
		
		
	}

}
