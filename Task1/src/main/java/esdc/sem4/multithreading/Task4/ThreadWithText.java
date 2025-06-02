package esdc.sem4.multithreading.Task4;

public class ThreadWithText extends Thread {
    String text;
    int n;
    public ThreadWithText(String name, String text, int n) {
        super(name);
        this.text = text;
        this.n = n;
    }

    public void run() {
        for(int i = 0; i < n; i++) {
            System.out.println(text);
        }
    }
}