package esdc.sem4.multithreading.Task6;

import java.math.BigInteger;

public class MinPriorityThread extends Thread {
    static String name = "MinPriorityThread";
    long startTime;
    public MinPriorityThread(long startTime) {
        super(name);
        this.startTime = startTime;
    }

    public void run() {
        long threadStartTime = System.nanoTime();
        System.out.println("MinPriorityThread time: " + (threadStartTime - startTime) / (double)1_000_000 + "ms");
    }
}