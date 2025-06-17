package esdc.sem4.multithreading.events;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LongRunningEvent implements Event {
    private static final Logger logger = LogManager.getLogManager().getLogger(LongRunningEvent.class.getSimpleName());
    private final String taskName;

    public LongRunningEvent(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void process() {
        logger.info("Event-thread-" + Thread.currentThread().getId() + " Starting long-running task: " + taskName);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.info("Long-running task interrupted: " + taskName);
        }
        logger.info("Finished long-running task: " + taskName);
    }
}