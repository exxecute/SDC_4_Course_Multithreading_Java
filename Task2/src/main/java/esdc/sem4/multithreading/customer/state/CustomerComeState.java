package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;

import java.util.concurrent.TimeUnit;

public class CustomerComeState extends CustomerState {
    private final static int MAX_TIME_FOR_CHOOSING_FOOD_S = 5;
    public CustomerComeState(Customer customer) {
        super(customer);
    }

    @Override
    public void action() throws InterruptedException {
        int timeChoosingFoodS = (int)(Math.random() * MAX_TIME_FOR_CHOOSING_FOOD_S);
        TimeUnit.SECONDS.sleep(timeChoosingFoodS);
        // TODO: log
        customer.switchState(new CustomerWaitState(customer));
    }
}
