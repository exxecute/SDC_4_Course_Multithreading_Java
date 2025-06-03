package esdc.sem4.multithreading.restaurant;

import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.customer.state.CustomerComeState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Restaurant {
    private static Restaurant instance;
    private final List<CashRegister> registers = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    private Restaurant() {
        int numberOfRegisters = 2; // TODO: load data from data loader
        for (int i = 0; i < numberOfRegisters; i++) {
            CashRegister register = new CashRegister(i);
            registers.add(register);
        }
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public List<CashRegister> getCashRegisters() {
        return this.registers;
    }

    public void switchCustomerToCashRegister(Customer customer, int cashRegisterId) {
        registers.get(customer.getCurrentCashRegisterId()).removeCustomer(customer);
        registers.get(cashRegisterId).addCustomer(customer);
    }

    public void addCustomer(Customer customer) {
        System.out.println("Add customer " + customer.getName());
        this.customers.add(customer);
    }

    public void startServing() {
        System.out.println("Customers are coming");
        for (Customer customer : this.customers) {
            customer.switchState(new CustomerComeState(customer));
            this.executor.submit(customer);
        }
        System.out.println("Start serving");
        for (CashRegister cashRegister : this.registers) {
            cashRegister.setIsServing(true);
            this.executor.submit(cashRegister);
        }

        while (!this.customers.isEmpty()) {
            this.customers.removeIf(Customer::getIsServed);
        }

        System.out.println("All customers served, closing cash registers");
        for (CashRegister cashRegister : this.registers) {
            cashRegister.setIsServing(false);
        }

        executor.shutdown();
    }
}
