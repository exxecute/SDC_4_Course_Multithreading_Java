package esdc.sem4.multithreading.restaurant;

import esdc.sem4.multithreading.customer.Customer;
import esdc.sem4.multithreading.customer.state.CustomerComeState;
import esdc.sem4.multithreading.utils.JsonReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public final class Restaurant {
    private static final ReentrantLock lock = new ReentrantLock();
    private static Restaurant instance;
    private final List<CashRegister> registers = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    private Restaurant() {
        int numberOfRegisters = JsonReader.getNumberOfCashRegisters();
        for (int i = 0; i < numberOfRegisters; i++) {
            CashRegister register = new CashRegister(i);
            registers.add(register);
        }
    }

    public static Restaurant getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Restaurant();
            }
            return instance;
        } finally {
            lock.unlock();
        }
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
