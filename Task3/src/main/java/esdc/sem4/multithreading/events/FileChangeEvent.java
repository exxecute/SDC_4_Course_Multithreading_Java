package esdc.sem4.multithreading.events;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FileChangeEvent implements Event {
    private static final Logger logger = LogManager.getLogManager().getLogger(FileChangeEvent.class.getSimpleName());
    private final String filePath;

    public FileChangeEvent(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void process() {
        logger.info("Event-thread-" + Thread.currentThread().getId() + " Processing file change for: " + filePath);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        logger.info("Finished processing file change for: " + filePath);
    }
}