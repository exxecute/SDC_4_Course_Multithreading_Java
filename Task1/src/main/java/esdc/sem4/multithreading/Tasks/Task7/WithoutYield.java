package esdc.sem4.multithreading.Tasks.Task7;

public class WithoutYield extends Thread {
    static String name = "WithoutYieldThread";
    long startTime;
    public WithoutYield(long startTime) {
        super(name);
        this.startTime = startTime;
    }

    public void run() {
        long threadStartTime = System.nanoTime();
        System.out.println("WithoutYield Thread time: " + (threadStartTime - startTime) / (double)1_000_000 + "ms");
    }
}