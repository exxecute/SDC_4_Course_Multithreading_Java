package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;

public class CustomerWaitState extends CustomerState {
    public CustomerWaitState(Customer customer) {
        super(customer);
    }

    @Override
    public void action() {
        // TODO: wait with endurance
        // TODO: switching cash state
    }
}
