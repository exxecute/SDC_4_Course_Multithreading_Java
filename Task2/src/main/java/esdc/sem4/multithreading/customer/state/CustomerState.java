package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;

public abstract class CustomerState {
    Customer customer;

    CustomerState(Customer customer) {
        this.customer = customer;
    }

    public abstract void action() throws InterruptedException;
}
