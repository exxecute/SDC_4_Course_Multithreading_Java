package esdc.sem4.multithreading.loop;

import esdc.sem4.multithreading.events.Event;
import esdc.sem4.multithreading.events.LongRunningEvent;
import esdc.sem4.multithreading.queue.EventQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EventLoop implements Runnable {
    private final EventQueue eventQueue;
    private final ExecutorService executorService;
    private boolean running = true;

    public EventLoop(EventQueue eventQueue, int threadPoolSize) {
        this.eventQueue = eventQueue;
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    @Override
    public void run() {
        System.out.println("Event Loop started.");
        while (running) {
            try {
                Event event = eventQueue.takeEvent();
                if(event instanceof LongRunningEvent) {
                    System.out.println("Processing event in other thread: " + event.getClass().getSimpleName());
                    executorService.submit(event::process);
                } else {
                    System.out.println("Processing event: " + event.getClass().getSimpleName());
                    event.process();
                }
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Event Loop interrupted: " + e.getMessage());
                running = false;
            }
        }
        executorService.shutdown();
        System.out.println("Event Loop stopped.");
    }

    public void stop() {
        running = false;
    }
}