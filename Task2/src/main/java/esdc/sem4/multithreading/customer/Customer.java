package esdc.sem4.multithreading.customer;

import esdc.sem4.multithreading.customer.state.CustomerState;

import java.util.concurrent.Callable;

public class Customer implements Callable<Void> {
    private final String name;
    private CustomerState state;
    private final boolean isPreOrder;

    public Customer(String name, boolean isPreOrder) {
        this.name = name;
        this.isPreOrder = isPreOrder;
    }

    @Override
    public Void call() throws Exception {
        state.action();
        return null;
    }

    public void switchState(CustomerState state) {
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
}
