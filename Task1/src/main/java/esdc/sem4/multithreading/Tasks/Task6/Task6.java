/**
 * Task6
 * Priority.
 * Оценить разницу скорости выполнения потоков с различными приоритетами. На примере:
 * ```java
 * Thread walkMin = new Thread(new WalkThread(), "Min"); Thread talkMax = new Thread(new TalkThread(), "Max"); walkMin.setPriority(Thread.MIN_PRIORITY); talkMax.setPriority(Thread.MAX_PRIORITY);
 * talkMin.start();
 * walkMax.start();
 * ```
 * Вывод: максимальный приоритет выполняется быстрее, чем с минимальным приоритетом.
 */
package esdc.sem4.multithreading.Tasks.Task6;

import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Task6 implements Taskable {
    public Task6() {}

    @Override
    public void runTask(Scanner scanner) throws InterruptedException {
        long startTimeMinThread = System.nanoTime();
        Thread minPrior = new MinPriorityThread(startTimeMinThread);
        minPrior.setPriority(Thread.MIN_PRIORITY);

        long startTimeMaxThread = System.nanoTime();
        Thread maxPrior = new MaxPriorityThread(startTimeMaxThread);
        maxPrior.setPriority(Thread.MAX_PRIORITY);

        minPrior.start();
        maxPrior.start();

        maxPrior.join();
        minPrior.join();

        System.out.println("Поток с минимальным приоритетом завершается позже, потому что уступает потоку с максимальным приоритетом");
    }
}
