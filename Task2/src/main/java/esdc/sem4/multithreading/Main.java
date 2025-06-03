package esdc.sem4.multithreading;


import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.restaurant.Restaurant;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();
        Customer customer1 = new Customer("Bib", false, 5);
        Customer customer2 = new Customer("Alice", false, 5);
        Customer customer3 = new Customer("Gray", false, 5);
        Customer customer4 = new Customer("Bob", false, 5);
        Customer customer5 = new Customer("Day", false, 5);
        Customer customer6 = new Customer("Bay", false, 5);
        restaurant.addCustomer(customer1);
        restaurant.addCustomer(customer2);
        restaurant.addCustomer(customer3);
        restaurant.startServing();
    }
}