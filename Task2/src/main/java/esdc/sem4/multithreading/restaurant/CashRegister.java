package esdc.sem4.multithreading.restaurant;

import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.customer.state.CustomerServedState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CashRegister implements Callable<Void> {
    private static final int MAX_SERVING_TIME = 5; // TODO: get data from data loader
    private final int id;
    private final List<Customer> customerQueue = new ArrayList<Customer>();
    private boolean isServing;

    public CashRegister(int id) {
        this.id = id;
        this.isServing = false;
    }

    @Override
    public Void call() throws Exception {
        while(this.getIsServing()) {
            this.serveTheCustomer();
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public int getQueueLength() {
        return this.customerQueue.size();
    }

    public void addCustomer(Customer customer) {
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
        Customer currentCustomer = this.customerQueue.getFirst();
        this.customerQueue.removeFirst();
        int servingTime = (int)(Math.random() * MAX_SERVING_TIME);
        // TODO: add logger that this cash register start serving and it will take n seconds
        TimeUnit.SECONDS.sleep(servingTime);
        currentCustomer.switchState(new CustomerServedState(currentCustomer));
    }
}
