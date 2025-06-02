package esdc.sem4.multithreading.Task2;

import esdc.sem4.multithreading.Tasks.Taskable;

public class Task2 implements Taskable {
    public Task2() {}

    @Override
    public void runTask() {
        new T1Thread("ExtendsThread", new ThreadRunnable()).start();
        // тут выводится реализация того класса, который реализует Thread,
        // потому что класс с интерфейсов перегружает метод в родительском классе,
        // а класс который extends Thread перегружает этот метод заново
    }
}
