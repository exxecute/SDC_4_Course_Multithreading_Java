package esdc.sem4.multithreading.Tasks.Task2;

import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Task2 implements Taskable {
    public Task2() {}

    @Override
    public void runTask(Scanner scanner) {
        new T1Thread("ExtendsThread", new ThreadRunnable()).start();
        // тут выводится реализация того класса, который реализует Thread,
        // потому что класс с интерфейсов перегружает метод в родительском классе,
        // а класс который extends Thread перегружает этот метод заново
    }
}
