package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;

public class CustomerSwitchState extends CustomerState {
    public CustomerSwitchState(Customer customer) {
        super(customer);
    }

    @Override
    public void action() {
        // TODO: find smaller queue
        // TODO: if has smaller go to smaller
    }
}
