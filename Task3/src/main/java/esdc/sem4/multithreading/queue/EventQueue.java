package esdc.sem4.multithreading.queue;

import esdc.sem4.multithreading.events.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventQueue {
    private final BlockingQueue<Event> queue = new LinkedBlockingQueue<>();

    public void addEvent(Event event) {
        try {
            queue.put(event);
            System.out.println("Event added to queue: " + event.getClass().getSimpleName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Failed to add event to queue: " + e.getMessage());
        }
    }

    public Event takeEvent() throws InterruptedException {
        return queue.take();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}