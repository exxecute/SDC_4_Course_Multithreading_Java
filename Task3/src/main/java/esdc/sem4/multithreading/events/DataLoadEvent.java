package esdc.sem4.multithreading.events;

import java.util.concurrent.TimeUnit;

public class DataLoadEvent implements Event {
    private final String dataToLoad;

    public DataLoadEvent(String dataToLoad) {
        this.dataToLoad = dataToLoad;
    }

    @Override
    public void process() {
        System.out.println("Event-thread-" + Thread.currentThread().getId() + " Loading data: " + dataToLoad);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Finished loading data: " + dataToLoad);
    }
}