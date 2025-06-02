package esdc.sem4.multithreading.Tasks.Task7;

import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Task7 implements Taskable {
    public Task7() {}

    @Override
    public void runTask(Scanner scanner) throws InterruptedException {
        long startTime = System.nanoTime();
        Thread minThread = new WithYield(startTime);
        Thread maxThread = new WithoutYield(startTime);

        minThread.start();
        maxThread.start();

        minThread.join();
        maxThread.join();

        System.out.println("Поток, который вызывает yield() не всегда будет заканчиваться после потока," +
                " который не вызывает yield(), потому что не факт что он найдет поток равного приоритета и уступит ему");
    }
}
