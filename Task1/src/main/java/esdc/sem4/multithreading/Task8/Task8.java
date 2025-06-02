package esdc.sem4.multithreading.Task8;

import esdc.sem4.multithreading.Tasks.Taskable;

import java.util.Scanner;

public class Task8 implements Taskable {
    public Task8() {}

    @Override
    public void runTask(Scanner scanner) throws InterruptedException {
        int m = 0;
        int k = 0;
        System.out.println("Print full time until end(ms): ");
        k = scanner.nextInt();
        System.out.println("Print pause time(ms): ");
        m = scanner.nextInt();

        Resourse resourse = new Resourse(k, true);

        PThread p = new PThread(resourse, m);
        Thread c = new CThread(resourse, m);
        p.start();
        c.start();
    }
}
