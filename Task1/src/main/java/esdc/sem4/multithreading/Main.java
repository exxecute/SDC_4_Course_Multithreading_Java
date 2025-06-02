package esdc.sem4.multithreading;

import esdc.sem4.multithreading.Task1.Task1;
import esdc.sem4.multithreading.Task2.Task2;
import esdc.sem4.multithreading.Task4.ThreadWithText;
import esdc.sem4.multithreading.Task5.Thread5;
import esdc.sem4.multithreading.Task6.MaxPriorityThread;
import esdc.sem4.multithreading.Task6.MinPriorityThread;
import esdc.sem4.multithreading.Task7.WithYield;
import esdc.sem4.multithreading.Task7.WithoutYield;
import esdc.sem4.multithreading.Task8.CThread;
import esdc.sem4.multithreading.Task8.PThread;
import esdc.sem4.multithreading.Task8.Resourse;
import esdc.sem4.multithreading.Tasks.Taskable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int taskNumber = 0;
        System.out.println("Print which task you want to run: ");
        Scanner scanner = new Scanner(System.in);
        taskNumber = scanner.nextInt();

        String textLine = "That is one line of text";
        int n = 0;
        int stringFreq = 0;

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
                // copy of task 1 with join()
//                System.out.println("Print N value: ");
//                n = scanner.nextInt();
//                Thread childThread = new T1Thread("childThread", n, textLine); TODO: fix
//                childThread.start();
//                try {
//                    childThread.join();
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                for(int i = 0; i < n; i++){
//                    System.out.println(Thread.currentThread().getName() + textLine);
//                }
                break;
            case 4:
                System.out.println("Print how many threads you want to run(4 <= n <= 6): ");
                stringFreq = scanner.nextInt();
                System.out.println("Print N value: ");
                n = scanner.nextInt();
                scanner.nextLine();
                for(int i = 0; i < stringFreq; i++) {
                    System.out.println("Print string you want to be shown by threads: ");
                    String textValue = scanner.nextLine();
                    Thread th = new ThreadWithText("Thread " + i, textValue, n);
                    th.start();
                    try {
                        th.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 5:
                Thread thread = new Thread5("Sigma");
                thread.start();
                thread.interrupt();
                // поток спит 10 секунд, в это время основной поток прерывает его
                // поэтому возникает exception
                break;
            case 6:
                long startTimeMinThread = System.nanoTime();
                Thread minPrior = new MinPriorityThread(startTimeMinThread);
                minPrior.setPriority(Thread.MIN_PRIORITY);

                long startTimeMaxThread = System.nanoTime();
                Thread maxPrior = new MaxPriorityThread(startTimeMaxThread);
                maxPrior.setPriority(Thread.MAX_PRIORITY);

                minPrior.start();
                maxPrior.start();

                maxPrior.join();
                minPrior.join();


                System.out.println("Поток с минимальным приоритетом завершается позже, потому что уступает потоку с максимальным приоритетом");
                break;
            case 7:
                long startTime = System.nanoTime();
                Thread minThread = new WithYield(startTime);
                Thread maxThread = new WithoutYield(startTime);

                minThread.start();
                maxThread.start();

                minThread.join();
                maxThread.join();

                System.out.println("Поток, который вызывает yield() не всегда будет заканчиваться после потока," +
                        " который не вызывает yield(), потому что не факт что он найдет поток равного приоритета и уступит ему");
                break;
            case 8:
                int m = 0;
                int k = 0;
                System.out.println("Print full time until end(ms): ");
                k = scanner.nextInt();
                System.out.println("Print pause time(ms): ");
                m = scanner.nextInt();

                Resourse resourse = new Resourse(k, true);

                PThread p = new PThread(resourse, m);
                Thread c = new CThread(resourse, m);
                p.start();
                c.start();
                break;
            default:
                System.out.println("POWEL NAHUI!");
        }
    }
}