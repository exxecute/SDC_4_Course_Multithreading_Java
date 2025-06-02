package esdc.sem4.multithreading.Task1;

public class T1Thread extends Thread{
    private int n = 0;
    private String text;
    T1Thread(String name, int n, String text) {
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
