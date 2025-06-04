/**
 * Task5
 * InterruptedException.
 * Создать ситуацию, чтобы возникло исключение InterruptedException.
 * Объяснить причины его генерации.
 * Вывод: Поток спит 10 секунд, в это время основной поток прерывает его поэтому возникает exception
 */
package esdc.sem4.multithreading.Tasks.Task5;

import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Task5 implements Taskable {
    public Task5() {}

    @Override
    public void runTask(Scanner scanner) {
        Thread thread = new Thread5("Sigma");
        thread.start();
        thread.interrupt();
    }
}
