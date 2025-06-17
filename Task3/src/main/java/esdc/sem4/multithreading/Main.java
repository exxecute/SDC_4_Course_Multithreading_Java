package esdc.sem4.multithreading;

import esdc.sem4.multithreading.events.DataLoadEvent;
import esdc.sem4.multithreading.events.FileChangeEvent;
import esdc.sem4.multithreading.events.LongRunningEvent;
import esdc.sem4.multithreading.loop.EventLoop;
import esdc.sem4.multithreading.queue.EventQueue;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EventQueue eventQueue = new EventQueue();
        EventLoop eventLoop = new EventLoop(eventQueue, 5);

        Thread eventLoopThread = new Thread(eventLoop, "EventLoopThread");
        eventLoopThread.start();

        System.out.println("Simulating user interactions and system events");

        eventQueue.addEvent(new DataLoadEvent("1 Minecraft world"));
        eventQueue.addEvent(new FileChangeEvent("2 /home/user/project/src/code.java"));
        eventQueue.addEvent(new LongRunningEvent("3 DIFFICULT CALCULATION FOR HUMANITY"));
        eventQueue.addEvent(new DataLoadEvent("4 JetBrains account"));
        eventQueue.addEvent(new FileChangeEvent("5 /app/config.xml"));
        eventQueue.addEvent(new LongRunningEvent("6 Compiling chatGpt 2000"));

        System.out.println("\nAll simulated events added. Waiting for processing to finish");

        TimeUnit.SECONDS.sleep(5);

        eventLoop.stop();
        eventLoopThread.join();

        System.out.println("Application shutting down");
    }
}