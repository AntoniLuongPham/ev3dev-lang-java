package ev3dev.hardware;

/**
 * The class Battery interacts with EV3Dev to get information about battery used. 
 * 
 * @see <a href="https://www.kernel.org/doc/Documentation/power/power_supply_class.txt">https://www.kernel.org/doc/Documentation/power/power_supply_class.txt</a>
 * @see <a href="https://github.com/ev3dev/ev3dev-lang/blob/develop/wrapper-specification.md#direct-attribute-mappings-5">https://github.com/ev3dev/ev3dev-lang/blob/develop/wrapper-specification.md#direct-attribute-mappings-5</a>
 * 
 * @author Juan Antonio Breña Moral
 *
 */
public class Battery extends EV3DevSysfs{

	private final static String DEVICE_ROOT_PATH = "/sys/class/";
	private final static String BATTERY_PATH = DEVICE_ROOT_PATH + "power_supply/legoev3-battery/";

    private static Battery sInstance;

    public static Battery getInstance() {
        if (sInstance == null) {
            sInstance = new Battery();
        }

        return sInstance;
    }

    // Prevent duplicate objects
    private Battery() {

    }
	
	/**
	 * Returns voltage of the battery in microvolts.
	 * @return
	 */
	public float getVoltage() {
		final String attribute = "voltage_now";
		return readInteger(BATTERY_PATH +  attribute);
	}

	/**
	 * Returns the current of the battery in microamps.
	 * @return
	 */
	public float getBatteryCurrent() {
		final String attribute = "current_now";
		return readInteger(BATTERY_PATH +  attribute);
	}

}
