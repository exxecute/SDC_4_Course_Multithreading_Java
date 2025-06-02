package esdc.sem4.multithreading.Tasks.Task1;

import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Task1 implements Taskable {
    public Task1() {}
    @Override
    public void runTask(Scanner scanner) {
        String textLine = "That is one line of text";
        System.out.println("Print N value: ");
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println(Thread.currentThread().getName() + textLine);
        }
        new T1Thread("childThread", n, textLine).start();
    }
}