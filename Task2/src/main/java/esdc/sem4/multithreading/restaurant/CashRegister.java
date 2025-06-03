package esdc.sem4.multithreading.restaurant;

import esdc.sem4.multithreading.customer.Customer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Callable;

public class CashRegister implements Callable<Void> {
    private final int id;
    private final Queue<Customer> customerQueue = new PriorityQueue<Customer>();

    public CashRegister(int id) {
        this.id = id;
    }

    @Override
    public Void call() throws Exception {
        // TODO: action for state
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


}
