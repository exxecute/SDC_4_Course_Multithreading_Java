package esdc.sem4.multithreading.Tasks.Task8;

public class CThread extends Thread {
    final Resourse resourse;
    int m = 0;
    public CThread(Resourse resourse, int m) {
        super("CThread");
        this.resourse = resourse;
        this.m = m;
    }

    @Override
    public void run() {
        while(resourse.getTimeLeft() > 0) {
            try {
                synchronized (resourse) {

                    while (!resourse.getCondition()) {
                        resourse.wait();  // ждет пока уведомят что condition равен true
                    }

                    // тут надо уменьшать таймер и выводить время
                    resourse.decreaseTimer(m / 10);
                    System.out.println("CThread working! Timer: " + resourse.getTimeLeft());
                }

                System.out.println("CThread is sleeping for " + m / 10 + " ms");
                sleep(m / 10);

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}