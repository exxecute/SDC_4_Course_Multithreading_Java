package esdc.sem4.multithreading.Task2;

public class T1Thread extends Thread {
    public T1Thread(String name, Runnable runnable) {
        super(runnable, name);
    }
    public void run() {
        System.out.println("I am class T1Thread which extends Thread");
    }
}