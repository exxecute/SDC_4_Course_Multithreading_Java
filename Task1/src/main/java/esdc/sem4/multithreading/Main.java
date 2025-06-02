package esdc.sem4.multithreading;

import esdc.sem4.multithreading.Tasks.Task1.Task1;
import esdc.sem4.multithreading.Tasks.Task2.Task2;
import esdc.sem4.multithreading.Tasks.Task3.Task3;
import esdc.sem4.multithreading.Tasks.Task4.Task4;
import esdc.sem4.multithreading.Tasks.Task5.Task5;
import esdc.sem4.multithreading.Tasks.Task6.Task6;
import esdc.sem4.multithreading.Tasks.Task7.Task7;
import esdc.sem4.multithreading.Tasks.Task8.Task8;
import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int taskNumber = 0;
        System.out.println("Print which task you want to run: ");
        Scanner scanner = new Scanner(System.in);
        taskNumber = scanner.nextInt();

        switch (taskNumber){
            case 1:
                Taskable Task1 = new Task1();
                Task1.runTask(scanner);
                break;
            case 2:
                Taskable Task2 = new Task2();
                Task2.runTask(scanner);
                break;
            case 3:
                Taskable Task3 = new Task3();
                Task3.runTask(scanner);
                break;
            case 4:
                Taskable Task4 = new Task4();
                Task4.runTask(scanner);
                break;
            case 5:
                Taskable Task5 = new Task5();
                Task5.runTask(scanner);
                break;
            case 6:
                Taskable Task6 = new Task6();
                Task6.runTask(scanner);
                break;
            case 7:
                Taskable Task7 = new Task7();
                Task7.runTask(scanner);
                break;
            case 8:
                Taskable Task8 = new Task8();
                Task8.runTask(scanner);
                break;
            default:
                System.out.println("POWEL NAHUI!");
        }
    }
}