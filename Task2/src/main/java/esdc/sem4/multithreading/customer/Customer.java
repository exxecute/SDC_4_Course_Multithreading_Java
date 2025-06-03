package esdc.sem4.multithreading.customer;

import esdc.sem4.multithreading.customer.state.CustomerState;
import esdc.sem4.multithreading.restaurant.Restaurant;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Customer implements Callable<Void> {
    private final String name;
    private final int maxEndurance;
    private final boolean isPreOrder;
    private final ReentrantLock lock = new ReentrantLock();
    private CustomerState state;
    private int currentCashRegisterId;
    private boolean isServed;

    public Customer(String name, boolean isPreOrder, int maxEndurance) {
        this.name = name;
        this.isPreOrder = isPreOrder;
        this.maxEndurance = maxEndurance;
        this.isServed = false;
    }

    @Override
    public Void call() throws Exception {
        System.out.println("Customer " + this.getName() + " PID:" + Thread.currentThread().getId());
        while( !this.getIsServed()) {
            state.action();
            TimeUnit.MILLISECONDS.sleep(10);
        }
        System.out.println("Customer " + this.getName() + " had gone");
        return null;
    }

    public void switchState(CustomerState newState) {
        lock.lock();
        try {
            this.state = newState;
        } finally {
            lock.unlock();
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsPreOrder() {
        return this.isPreOrder;
    }

    public int getMaxEndurance() {
        return this.maxEndurance;
    }

    public void switchCashRegister(int id) {
        Restaurant.getInstance().switchCustomerToCashRegister(this, id);
        lock.lock();
        try {
            this.currentCashRegisterId = id;
        } finally {
            lock.unlock();
        }
    }

    public int getCurrentCashRegisterId() {
        lock.lock();
        try {
            return this.currentCashRegisterId;
        } finally {
            lock.unlock();
        }
    }

    public boolean getIsServed() {
        lock.lock();
        try {
            return this.isServed;
        } finally {
            lock.unlock();
        }
    }

    public void setIsServed(boolean isServed) {
        lock.lock();
        try {
            this.isServed = isServed;
        } finally {
            lock.unlock();
        }
    }

    public int getPlaceInTheQueue() {
        return Restaurant.getInstance()
                .getCashRegisters()
                .get(getCurrentCashRegisterId())
                .getCustomersPlace(this);
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', isPreOrder=" + isPreOrder + ", maxEndurance=" + maxEndurance + '}';
    }
}
