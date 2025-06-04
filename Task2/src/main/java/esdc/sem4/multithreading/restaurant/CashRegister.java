package esdc.sem4.multithreading.restaurant;

import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.utils.JsonReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CashRegister implements Callable<Boolean> {
    private static final int MAX_SERVING_TIME = JsonReader.getMaxServingTimeSec();
    private final int id;
    private final List<Customer> customerQueue = new ArrayList<Customer>();
    private final ReentrantLock lock = new ReentrantLock();
    private boolean isServing;

    public CashRegister(int id) {
        this.id = id;
        this.isServing = false;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Cash register " + this.getId() + " PID:" + Thread.currentThread().getId() +
                " is serving: " + this.getIsServing());
        while (this.getIsServing()) {
            this.serveTheCustomer();
            TimeUnit.MILLISECONDS.sleep(10);
        }
        System.out.println("Cash register " + this.getId() + " stop serving");
        return true;
    }

    public int getId() {
        return this.id;
    }

    public int getQueueLength() {
        lock.lock();
        try {
            return customerQueue.size();
        } finally {
            lock.unlock();
        }
    }

    public void addCustomer(Customer customer) {
        lock.lock();
        try {
            System.out.println("Cash register " + id + " has new Customer " + customer.getName());
            customerQueue.add(customer);
        } finally {
            lock.unlock();
        }
    }

    public void removeCustomer(Customer customer) {
        lock.lock();
        try {
            customerQueue.remove(customer);
        } finally {
            lock.unlock();
        }
    }

    public int getCustomersPlace(Customer customer) {
        lock.lock();
        try {
            return customerQueue.indexOf(customer) + 1;
        } finally {
            lock.unlock();
        }
    }

    public void setIsServing(boolean isServing) {
        lock.lock();
        try {
            this.isServing = isServing;
        } finally {
            lock.unlock();
        }
    }

    public boolean getIsServing() {
        lock.lock();
        try {
            return isServing;
        } finally {
            lock.unlock();
        }
    }

    private void serveTheCustomer() throws InterruptedException {
        if (!this.customerQueue.isEmpty()) {
            Customer currentCustomer = this.chooseCustomer();
            int servingTime = (int)(Math.random() * MAX_SERVING_TIME);
            System.out.println("Cash register " + this.getId() + " serving " + currentCustomer.getName() + " for " + servingTime + " seconds");
            TimeUnit.SECONDS.sleep(servingTime);
            currentCustomer.setIsServed(true);
            System.out.println("Cash register " + this.getId() + " served " + currentCustomer.getName());
        }
    }

    private Customer chooseCustomer() {
        for (Customer customer : this.customerQueue) {
            if (customer.getIsPreOrder()) {
                this.customerQueue.remove(customer);
                return customer;
            }
        }
        Customer firstCustomer = this.customerQueue.getFirst();
        this.customerQueue.removeFirst();
        return firstCustomer;
    }
}
