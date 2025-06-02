package esdc.sem4.multithreading.Tasks.Taskable;

import java.util.Scanner;

public interface Taskable {
    void runTask(Scanner scanner) throws InterruptedException;
}
