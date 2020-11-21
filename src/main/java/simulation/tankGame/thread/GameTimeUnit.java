package simulation.tankGame.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/20 18:35
 */
public class GameTimeUnit {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameTimeUnit.class);

    public static void sleepMillis(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            LOGGER.error(e.toString(), e);
        }
    }
}
