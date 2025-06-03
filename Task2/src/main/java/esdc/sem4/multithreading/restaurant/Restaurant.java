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
            register.setIsServing(true);
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
        this.customers.add(customer);
    }

    public void startServing() {
        for(Customer customer : this.customers) {
            customer.switchState(new CustomerComeState(customer));
            this.executor.submit(customer);
        }
    }
}
