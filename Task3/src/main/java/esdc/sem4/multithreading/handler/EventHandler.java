package esdc.sem4.multithreading.handler;

import esdc.sem4.multithreading.events.Event;
import esdc.sem4.multithreading.events.LongRunningEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventHandler {
    private final ExecutorService executorService;
    public EventHandler(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }
    public void proccessEvent(Event event) throws InterruptedException {
        if(event instanceof LongRunningEvent) {
            System.out.println("Processing event in other thread: " + event.getClass().getSimpleName());
            executorService.submit(event::process);
        } else {
            System.out.println("Processing event: " + event.getClass().getSimpleName());
            event.process();
        }
    }

    public void shutdown() {
        this.executorService.shutdown();
    }
}
