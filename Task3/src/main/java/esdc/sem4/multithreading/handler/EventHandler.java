package esdc.sem4.multithreading.handler;

import esdc.sem4.multithreading.events.Event;
import esdc.sem4.multithreading.events.LongRunningEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class EventHandler {
    private static final Logger logger = LogManager.getLogManager().getLogger(EventHandler.class.getSimpleName());
    private final ExecutorService executorService;
    public EventHandler(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }
    public void proccessEvent(Event event) throws InterruptedException {
        if(event instanceof LongRunningEvent) {
            logger.info("Processing event in other thread: " + event.getClass().getSimpleName());
            executorService.submit(event::process);
        } else {
            logger.info("Processing event: " + event.getClass().getSimpleName());
            event.process();
        }
    }

    public void shutdown() {
        this.executorService.shutdown();
    }
}
