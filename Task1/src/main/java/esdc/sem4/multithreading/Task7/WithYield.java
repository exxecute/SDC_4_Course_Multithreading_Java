package esdc.sem4.multithreading.Task7;

import java.math.BigInteger;

public class WithYield extends Thread {
    static String name = "WithYieldThread";
    long startTime;
    public WithYield(long startTime) {
        super(name);
        this.startTime = startTime;
    }

    public void run() {
        for(int i = 1; i <= 1000; i++) {
            Thread.yield();  // Многократный вызов
        }
        long threadStartTime = System.nanoTime();
        System.out.println("WithYield Thread time: " + (threadStartTime - startTime) / (double)1_000_000 + "ms");
    }
}