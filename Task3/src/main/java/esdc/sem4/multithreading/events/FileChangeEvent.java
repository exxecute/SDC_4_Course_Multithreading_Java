package esdc.sem4.multithreading.events;

import java.util.concurrent.TimeUnit;

public class FileChangeEvent implements Event {
    private final String filePath;

    public FileChangeEvent(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void process() {
        System.out.println("Event-thread-" + Thread.currentThread().getId() + " Processing file change for: " + filePath);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Finished processing file change for: " + filePath);
    }
}