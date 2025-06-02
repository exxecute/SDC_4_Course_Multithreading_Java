package esdc.sem4.multithreading.customer;

import java.util.concurrent.Callable;

public class Customer implements Callable<Void> {
    private final String name;
//    private CustomerState state; TODO: add customer states
    private final boolean isPreOrder;

    public Customer(String name, boolean isPreOrder) {
        this.name = name;
        this.isPreOrder = isPreOrder;
    }

    @Override
    public Void call() throws Exception {
        return null;
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
