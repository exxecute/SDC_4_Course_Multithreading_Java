package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.restaurant.CashRegister;
import esdc.sem4.multithreading.restaurant.Restaurant;

import java.awt.geom.RectangularShape;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class CustomerComeState extends CustomerState {
    private final static int MAX_TIME_FOR_CHOOSING_FOOD_S = 5;
    public CustomerComeState(Customer customer) {
        super(customer);
    }

    @Override
    public void action() throws InterruptedException {
        int timeChoosingFoodS = (int)(Math.random() * MAX_TIME_FOR_CHOOSING_FOOD_S);
        System.out.println("Customer " + customer.getName() + " is choosing food for " + timeChoosingFoodS + " Seconds");
        TimeUnit.SECONDS.sleep(timeChoosingFoodS);
        // TODO: log
        Restaurant restaurant = Restaurant.getInstance();
        CashRegister shortest = restaurant.getCashRegisters()
                .stream()
                .min(Comparator.comparingInt(CashRegister::getQueueLength))
                .orElseThrow();
        customer.switchCashRegister(shortest.getId());
        customer.switchState(new CustomerWaitState(customer));
    }
}
