package esdc.sem4.multithreading.Tasks.Task8;

public class PThread extends Thread {
    final Resourse resourse;
    int m = 0;
    public PThread(Resourse resourse, int m) {
        super("PThread");
        this.resourse = resourse;
        this.m = m;
    }

    @Override
    public void run() {
        while (resourse.getTimeLeft() > 0) {

            synchronized (resourse) {
                resourse.setCondition(!resourse.getCondition()); // меняем на противоположное
                System.out.println("PThread working! Condition: " + resourse.getCondition() + " TimeLeft: " + resourse.getTimeLeft());

                if(resourse.getCondition())
                    resourse.notifyAll();  // должен будить потоки когда resourse.condition становится true
            }

            try {
                System.out.println("Phread is sleeping for " + m + " ms");
                sleep(m + 1); // засыпает на m секунд
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}