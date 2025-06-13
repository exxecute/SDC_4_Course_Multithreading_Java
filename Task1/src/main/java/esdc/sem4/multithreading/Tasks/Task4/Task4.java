/**
 * Task4
 * Параметры потока.
 * Разработать программу, которая создает N потоков 4<= N <=6, исполняющие один и тот же метод.
 * Этот метод должен выводить последовательность текстовых строк, переданных как параметр.
 * Каждый из созданных потоков должен выводить различные последовательности строк.
 * Вывод: несколько потоков, вывыводящее строку.
 */
package esdc.sem4.multithreading.Tasks.Task4;

import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Task4 implements Taskable {
    public Task4() {}

    @Override
    public void runTask(Scanner scanner) {
        System.out.println("Print how many threads you want to run(4 <= n <= 6): ");
        int stringFreq = scanner.nextInt();
        System.out.println("Print N value: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < stringFreq; i++) {
            System.out.println("Print string you want to be shown by threads: ");
            String textValue = scanner.nextLine();
            Thread th = new ThreadWithText("Thread " + i, textValue, n);
            th.start();
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
