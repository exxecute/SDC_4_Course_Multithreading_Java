package esdc.sem4.multithreading.queue;

import esdc.sem4.multithreading.events.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class EventQueue {
    private static final Logger logger = LogManager.getLogManager().getLogger(EventQueue.class.getSimpleName());
    private final BlockingQueue<Event> queue = new LinkedBlockingQueue<>();

    public void addEvent(Event event) {
        try {
            queue.put(event);
            logger.info("Event added to queue: " + event.getClass().getSimpleName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.info("Failed to add event to queue: " + e.getMessage());
        }
    }

    public Event takeEvent() throws InterruptedException {
        return queue.take();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}