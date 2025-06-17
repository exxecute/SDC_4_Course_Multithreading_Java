package esdc.sem4.multithreading.events;

import java.util.concurrent.TimeUnit;

public class LongRunningEvent implements Event {
    private final String taskName;

    public LongRunningEvent(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void process() {
        System.out.println("Starting long-running task: " + taskName);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Long-running task interrupted: " + taskName);
        }
        System.out.println("Finished long-running task: " + taskName);
    }
}