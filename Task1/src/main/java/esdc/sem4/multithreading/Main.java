package esdc.sem4.multithreading;

import esdc.sem4.multithreading.Tasks.Manager.TaskManager;

import java.util.Scanner;

public class Main {
    private static final TaskManager taskManager = new TaskManager();
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Print which task you want to run: ");
        Scanner scanner = new Scanner(System.in);
        taskManager.getTask(scanner.nextInt()).runTask(scanner);
    }
}