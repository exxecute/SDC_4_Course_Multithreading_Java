/**
 * Task8
 * (*)Producer/Consumer.
 * Разработать программу, в которой создаются и запускаются на выполнение потоки P и C.
 * Поток P выполняет переключение с задержкой в M миллисекунд из состояния true в состояние false и наоборот.
 * Поток C ожидает состояния true потока P, выводит на консоль обратный отсчет от времени K миллисекунд
 * с задержкой M/10 миллисекунд и приостанавливает свое действие, как только поток P переключен в состояние false.
 * Условием завершения работы потоков является достижение отсчета нулевой отметки.
 */
package esdc.sem4.multithreading.Tasks.Task8;

import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.Scanner;

public class Task8 implements Taskable {
    public Task8() {}

    @Override
    public void runTask(Scanner scanner) throws InterruptedException {
        System.out.println("Print full time until end(ms): ");
        int k = scanner.nextInt();
        System.out.println("Print pause time(ms): ");
        int m = scanner.nextInt();

        Resourse resourse = new Resourse(k, true);

        PThread p = new PThread(resourse, m);
        Thread c = new CThread(resourse, m);
        p.start();
        c.start();
    }
}
