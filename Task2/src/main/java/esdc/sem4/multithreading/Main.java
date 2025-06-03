package esdc.sem4.multithreading;


import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.restaurant.Restaurant;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();
        Customer customer1 = new Customer("Bib", false, 5);
        restaurant.addCustomer(customer1);
        restaurant.startServing();
    }
}