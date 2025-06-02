package esdc.sem4.multithreading.Task6;

public class MaxPriorityThread extends Thread {
    static String name = "MaxPriorityThread";
    long startTime;
    public MaxPriorityThread(long startTime) {
        super(name);
        this.startTime = startTime;
    }

    public void run() {
        long threadStartTime = System.nanoTime();
        System.out.println("MaxPriorityThread time: " + (threadStartTime - startTime) / (double)1_000_000 + "ms");
    }
}