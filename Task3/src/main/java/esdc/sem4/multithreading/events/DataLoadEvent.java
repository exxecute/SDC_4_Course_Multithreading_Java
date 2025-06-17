package esdc.sem4.multithreading.events;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DataLoadEvent implements Event {
    private static final Logger logger = LogManager.getLogManager().getLogger(DataLoadEvent.class.getSimpleName());
    private final String dataToLoad;

    public DataLoadEvent(String dataToLoad) {
        this.dataToLoad = dataToLoad;
    }

    @Override
    public void process() {
        logger.info("Event-thread-" + Thread.currentThread().getId() + " Loading data: " + dataToLoad);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        logger.info("Finished loading data: " + dataToLoad);
    }
}