package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;

public class CustomerServedState extends CustomerState {
    public CustomerServedState(Customer customer) {
        super(customer);
    }

    @Override
    public void action() {    }
}
