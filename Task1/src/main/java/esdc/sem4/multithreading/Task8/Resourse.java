package esdc.sem4.multithreading.Task8;

public class Resourse {
    private volatile int timeLeft;
    private volatile boolean condition;
    //private Object lock = new Object();
    //private volatile boolean done;
    public Resourse(int timLeft, boolean condition) {
        this.timeLeft = timLeft;
        this.condition = condition;
    }

    public synchronized void setCondition(boolean condition) {
        this.condition = condition;
    }

    public boolean getCondition() {
        return condition;
    }

//    public Object getLock() {
//        return lock;
//    }

//    public void setDone() {
//        this.done = true;
//    }
//
//    public boolean getDone() {
//        return done;
//    }

    public int getTimeLeft() {
        return timeLeft;
    }
    public synchronized void decreaseTimer(int value) {
        if (timeLeft > 0) {
            timeLeft = Math.max(0, timeLeft - value);
        }
    }
}