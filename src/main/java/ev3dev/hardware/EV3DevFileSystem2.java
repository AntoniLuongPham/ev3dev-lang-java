package ev3dev.hardware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * The class responsible to interact with EV3Dev file system
 *
 * @author Juan Antonio Breña Moral
 *
 */
public class EV3DevFileSystem2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(EV3DevFileSystem2.class);

    public static final String EV3DEV_TESTING_KEY = "EV3DEV_TESTING_KEY";
    public static final String EV3DEV_ROOT_PATH = "/sys/class";
    private static final String CURRENT_ROOT_PATH = retrieveRootPath();

    public static String retrieveRootPath() {

        if(Objects.nonNull(System.getProperty(EV3DevFileSystem2.EV3DEV_TESTING_KEY))) {
            final String NEW_ROOT_PATH = System.getProperty(EV3DEV_TESTING_KEY);
            LOGGER.debug("ROOT_PATH modified: {}", NEW_ROOT_PATH);
            return NEW_ROOT_PATH;
        }else {
            LOGGER.debug("Root Path: {}", EV3DEV_ROOT_PATH);
            return EV3DEV_ROOT_PATH;
        }
    }

    public static String getRootPath() {
        return CURRENT_ROOT_PATH;
    }
}
