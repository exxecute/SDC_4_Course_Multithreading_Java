package esdc.sem4.multithreading.Tasks.Manager;

import esdc.sem4.multithreading.Tasks.Task1.Task1;
import esdc.sem4.multithreading.Tasks.Task2.Task2;
import esdc.sem4.multithreading.Tasks.Task3.Task3;
import esdc.sem4.multithreading.Tasks.Task4.Task4;
import esdc.sem4.multithreading.Tasks.Task5.Task5;
import esdc.sem4.multithreading.Tasks.Task6.Task6;
import esdc.sem4.multithreading.Tasks.Task7.Task7;
import esdc.sem4.multithreading.Tasks.Task8.Task8;
import esdc.sem4.multithreading.Tasks.Taskable.Taskable;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Taskable> tasksList;

    public TaskManager() {
        this.tasksList = new ArrayList<Taskable>();
        this.tasksList.add(new Task1());
        this.tasksList.add(new Task2());
        this.tasksList.add(new Task3());
        this.tasksList.add(new Task4());
        this.tasksList.add(new Task5());
        this.tasksList.add(new Task6());
        this.tasksList.add(new Task7());
        this.tasksList.add(new Task8());
        }

    public Taskable getTask(int taskNumber) {
        int taskId = taskNumber - 1;
        if (this.tasksList.size() < taskId) {
            throw new IndexOutOfBoundsException();
        }
        return this.tasksList.get(taskId);
    }
}
