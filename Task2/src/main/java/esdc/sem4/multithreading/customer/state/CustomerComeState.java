package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;

public class CustomerComeState extends CustomerState {
    public CustomerComeState(Customer customer) {
        super(customer);
    }

    @Override
    public void action() {
        // TODO: sleep (choosing food)
        // TODO: set state to waiting service
    }
}
