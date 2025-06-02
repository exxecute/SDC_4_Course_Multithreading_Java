package esdc.sem4.multithreading.Tasks.Task5;

public class Thread5 extends Thread {
    public Thread5(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Thread " + getName() + " is running.");
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}