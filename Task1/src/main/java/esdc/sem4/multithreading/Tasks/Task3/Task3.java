/**
 * Task3
 * Метод join.
 * Модифицировать программу так,
 * чтобы вывод родительского потока задачи 1 производился после завершения порожденного.
 * Вывод: Первый таск наоборот.
 */
package esdc.sem4.multithreading.Tasks.Task3;

import esdc.sem4.multithreading.Tasks.Task1.T1Thread;
import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Task3 implements Taskable {
    public Task3() {}

    @Override
    public void runTask(Scanner scanner) {
        // copy of task 1 with join()
        String textLine = "That is one line of text";
        System.out.println("Print N value: ");
        int n = scanner.nextInt();
        Thread childThread = new T1Thread("childThread", n, textLine);
        childThread.start();
        try {
            childThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        for(int i = 0; i < n; i++){
            System.out.println(Thread.currentThread().getName() + textLine);
        }
    }
}
