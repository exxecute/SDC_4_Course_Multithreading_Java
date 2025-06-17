package esdc.sem4.multithreading;

import esdc.sem4.multithreading.events.DataLoadEvent;
import esdc.sem4.multithreading.events.Event;
import esdc.sem4.multithreading.events.FileChangeEvent;
import esdc.sem4.multithreading.events.LongRunningEvent;
import esdc.sem4.multithreading.loop.EventLoop;
import esdc.sem4.multithreading.queue.EventQueue;

import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogManager().getLogger(Main.class.getSimpleName());
    public static void main(String[] args) throws InterruptedException {
        EventQueue eventQueue = new EventQueue();
        EventLoop eventLoop = new EventLoop(eventQueue, 5);

        Thread eventLoopThread = new Thread(eventLoop, "EventLoopThread");
        eventLoopThread.start();

        userController(eventQueue);

        eventLoopThread.interrupt();
        eventLoopThread.join();
    }

    public static void userController(EventQueue eventQueue) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
//            System.out.println("Enter event:" +
//                    "\n1 - data load [Data load argument]" +
//                    "\n2 - file change event [file path]" +
//                    "\n3 - long running event [Long running data argument]" +
//                    "\n4 - exit");
//            int userCommand = scanner.nextInt();
//            if (userCommand == 4) {
//                break;
//            }
//            System.out.println("Enter arguments for event");
//            String userArgs = scanner.nextLine();
//            Event userEvent = null;
//            switch (userCommand) {
//                case 1: {
//                    userEvent = new DataLoadEvent(userArgs);
//                    break;
//                }
//                case 2: {
//                    userEvent = new FileChangeEvent(userArgs);
//                    break;
//                }
//                case 3: {
//                    userEvent = new LongRunningEvent(userArgs);
//                    break;
//                }
//            }
//            if (userEvent != null) {
//                eventQueue.addEvent(userEvent);
//            }
        }

//        logger.info("Application shutting down");
    }
}