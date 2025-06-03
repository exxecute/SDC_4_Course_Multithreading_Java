package esdc.sem4.multithreading;


import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.restaurant.Restaurant;
import esdc.sem4.multithreading.utils.JsonReader;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Customer> loadedCustomers = JsonReader.loadCustomersFromJson();
        System.out.println("===== Loaded Customers =====");
        loadedCustomers.forEach(System.out::println);

        Restaurant restaurant = Restaurant.getInstance();
        for (Customer customer : loadedCustomers) {
            restaurant.addCustomer(customer);
        }
        restaurant.startServing();
    }
}