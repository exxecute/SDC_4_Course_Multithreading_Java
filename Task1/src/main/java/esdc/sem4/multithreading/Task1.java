package esdc.sem4.multithreading;

public class Task1 extends Thread{
    private int n = 0;
    private String text;
    Task1(String name, int n, String text) {
        super(name);
        this.n = n;
        this.text = text;
    }
    @Override
    public void run(){
        for(int i = 0; i < n; i++){
            System.out.println(Thread.currentThread().getName() + text);
        }
    }
}