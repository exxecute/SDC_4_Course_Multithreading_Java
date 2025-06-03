package esdc.sem4.multithreading.restaurant;

import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.utils.JsonReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CashRegister implements Callable<Void> {
    private static final int MAX_SERVING_TIME = JsonReader.getMaxServingTimeSec();
    private final int id;
    private final List<Customer> customerQueue = new ArrayList<Customer>();
    private boolean isServing;

    public CashRegister(int id) {
        this.id = id;
        this.isServing = false;
    }

    @Override
    public Void call() throws Exception {
        System.out.println("Cash register " + this.getId() + " PID:" + Thread.currentThread().getId() +
                " is serving: " + this.getIsServing());
        while (this.getIsServing()) {
            this.serveTheCustomer();
            TimeUnit.MILLISECONDS.sleep(10);
        }
        System.out.println("Cash register " + this.getId() + " stop serving");
        return null;
    }

    public int getId() {
        return this.id;
    }

    public int getQueueLength() {
        return this.customerQueue.size();
    }

    public void addCustomer(Customer customer) {
        System.out.println("Cash register " + this.getId() + " has new Customer " + customer.getName());
        this.customerQueue.add(customer);
    }

    public void setIsServing(boolean isServing) {
        this.isServing = isServing;
    }

    public boolean getIsServing() {
        return this.isServing;
    }

    public void removeCustomer(Customer customer) {
        this.customerQueue.remove(customer);
    }

    public int getCustomersPlace(Customer customer) {
        return this.customerQueue.indexOf(customer) + 1; // TODO: refactor +1
    }

    private void serveTheCustomer() throws InterruptedException {
        if (this.customerQueue.size() > 0) { // TODO: refactor
            Customer currentCustomer = this.chooseCustomer();
            int servingTime = (int)(Math.random() * MAX_SERVING_TIME);
            // TODO: add logger that this cash register start serving and it will take n seconds
            System.out.println("Cash register " + this.getId() + " serving " + currentCustomer.getName() + " for " + servingTime + " seconds");
            TimeUnit.SECONDS.sleep(servingTime);
            currentCustomer.setIsServed(true);
            System.out.println("Cash register " + this.getId() + " served " + currentCustomer.getName());
        }
    }

    private Customer chooseCustomer() {
        for (Customer customer : this.customerQueue) {
            if (customer.isPreOrder()) {
                this.customerQueue.remove(customer);
                return customer;
            }
        }
        Customer firstCustomer = this.customerQueue.getFirst();
        this.customerQueue.removeFirst();
        return firstCustomer;
    }
}
