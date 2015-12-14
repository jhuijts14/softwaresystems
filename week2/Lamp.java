
package ss.week2;
/**
 * The class for the three-way lamp.
 * @author Joep Huijts
 * @version Version 1.0
 */
public class Lamp {
	
	//---------------Instance Variables------------------
	public enum Setting { OFF, LOW, MEDIUM,	HIGH }

	private Setting setting;
	
	//------------------Constructor---------------------
	/**
	 * Create a new Lamp.
	 */
	//@ ensures this.setting == Setting.OFF;
	public Lamp() {
		this.setting = Setting.OFF;
		
		assert setting == Setting.OFF :
			"Initial Setting is not OFF!";
	}
	
	//-------------------Queries------------------------
	/**
	 * The current setting of the lamp.
	 */
	//@ ensures setting == OFF || setting == LOW || setting == MEDIUM || setting == HIGH;
	/* pure */ public Setting getSetting() {
		assert setting == Setting.OFF || setting == Setting.LOW || setting == Setting.MEDIUM 
						|| setting == Setting.HIGH :
			"Lamp setting is invalid!";
		return setting;
	}
	
	//----------------Commands---------------------------
	/** 
	 * Increment the setting of a lamp.
	 */
	//@ ensures \oldsetting == OFF ==> this.setting == LOW 
	//			|| \oldsetting == LOW ==> this.setting == MEDIUM 
	//			|| \oldsetting == MEDIUM ==> this.setting == HIGH 
	//			|| \oldsetting == HIGH ==> this.setting == OFF;
	public void switchSetting() {
		
		Setting oldSetting;
		oldSetting = setting;
		
		switch (setting) {
			case OFF: 		
				setting = Setting.LOW;
				break;
			case LOW:		
				setting = Setting.MEDIUM;
				break;
			case MEDIUM:	
				setting = Setting.HIGH;
				break;
			case HIGH:		
				setting = Setting.OFF;
				break;
			default: 		
				setting = Setting.OFF;
				break;
		}
		assert (oldSetting == Setting.LOW && setting == Setting.MEDIUM) 
			|| (oldSetting == Setting.MEDIUM && setting == Setting.HIGH)
			|| (oldSetting == Setting.HIGH && setting == Setting.OFF)
			|| (oldSetting == Setting.OFF && setting == Setting.LOW) :
				"Lamp switched to the wrong setting!";
	}
}
