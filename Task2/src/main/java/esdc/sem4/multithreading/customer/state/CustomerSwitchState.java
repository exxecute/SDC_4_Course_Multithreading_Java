package esdc.sem4.multithreading.customer.state;

import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.restaurant.CashRegister;
import esdc.sem4.multithreading.restaurant.Restaurant;

import java.util.Comparator;

public class CustomerSwitchState extends CustomerState {
    public CustomerSwitchState(Customer customer) {
        super(customer);
    }

    @Override
    public void action() {
        Restaurant restaurant = Restaurant.getInstance();
        int customerPlace = customer.getPlaceInTheQueue();
        if (customerPlace > 2) {
            CashRegister shortest = restaurant.getCashRegisters()
                    .stream()
                    .min(Comparator.comparingInt(CashRegister::getQueueLength))
                    .orElseThrow();
            if (shortest.getQueueLength() < customerPlace) {
                customer.switchCashRegister(shortest.getId());
            }
        }
        customer.switchState(new CustomerWaitState(customer));
    }
}
