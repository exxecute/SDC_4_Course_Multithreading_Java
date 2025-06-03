package esdc.sem4.multithreading.customer;

import esdc.sem4.multithreading.customer.state.CustomerServedState;
import esdc.sem4.multithreading.customer.state.CustomerState;
import esdc.sem4.multithreading.restaurant.Restaurant;

import java.util.concurrent.Callable;

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
        while(!this.getIsServed()) {
            state.action();
        }
        return null;
    }

    public void switchState(CustomerState state) {
//        System.out.println("Customer switching state to " + state.getClass());
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public boolean isPreOrder() {
        return this.isPreOrder;
    }

    public long getPID() {
        return 10; // TODO: get pid
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
}
