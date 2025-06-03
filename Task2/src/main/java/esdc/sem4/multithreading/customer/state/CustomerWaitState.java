package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;

import java.util.concurrent.TimeUnit;

public class CustomerWaitState extends CustomerState {
    public CustomerWaitState(Customer customer) {
        super(customer);
    }

    @Override
    public void action() throws InterruptedException {
        int customerEnduranceS = (int)(Math.random() * customer.getMaxEndurance());
        TimeUnit.SECONDS.sleep(customerEnduranceS);
        customer.switchState(new CustomerSwitchState(customer));
    }
}
