package esdc.sem4.multithreading.customer;

import esdc.sem4.multithreading.customer.state.CustomerState;
import esdc.sem4.multithreading.restaurant.Restaurant;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Customer implements Callable<Void> {
    private final String name;
    private final int maxEndurance;
    private CustomerState state;
    private final boolean isPreOrder;
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

    public void switchState(CustomerState state) {
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public boolean isPreOrder() { // TODO: refactor name
        return this.isPreOrder;
    }

    public int getMaxEndurance() {
        return this.maxEndurance;
    }

    public void switchCashRegister(int id) {
        Restaurant.getInstance().switchCustomerToCashRegister(this, id);
        this.currentCashRegisterId = id;

    }

    public int getCurrentCashRegisterId() {
        return this.currentCashRegisterId;
    }

    public boolean getIsServed() {
        return this.isServed;
    }

    public void setIsServed(boolean isServed) {
        this.isServed = isServed;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', isPreOrder=" + isPreOrder + ", maxEndurance=" + maxEndurance + '}';
    }
}
