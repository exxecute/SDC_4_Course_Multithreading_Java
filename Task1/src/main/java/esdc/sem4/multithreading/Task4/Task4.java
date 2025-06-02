package esdc.sem4.multithreading.Task4;

import esdc.sem4.multithreading.Tasks.Taskable;

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
