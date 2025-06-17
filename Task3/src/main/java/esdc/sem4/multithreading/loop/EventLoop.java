package esdc.sem4.multithreading.loop;

import esdc.sem4.multithreading.handler.EventHandler;
import esdc.sem4.multithreading.queue.EventQueue;

import java.util.concurrent.TimeUnit;

public class EventLoop implements Runnable {
    private final EventQueue eventQueue;
    private final EventHandler eventHandler;
    private boolean running = true;

    public EventLoop(EventQueue eventQueue, int threadPoolSize) {
        this.eventQueue = eventQueue;
        this.eventHandler = new EventHandler(threadPoolSize);
    }

    @Override
    public void run() {
        System.out.println("Event Loop started.");
        while (this.running) {
            try {
                this.eventHandler.proccessEvent(this.eventQueue.takeEvent());
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Event Loop interrupted: " + e.getMessage());
                this.running = false;
            }
        }
        this.eventHandler.shutdown();
        System.out.println("Event Loop stopped.");
    }

    public void stop() {
        this.running = false;
    }
}