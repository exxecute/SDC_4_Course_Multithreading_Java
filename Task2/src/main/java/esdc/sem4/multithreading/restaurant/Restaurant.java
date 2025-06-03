package esdc.sem4.multithreading.restaurant;

import java.util.ArrayList;
import java.util.List;

public final class Restaurant {
    private static Restaurant instance;
    private final List<CashRegister> registers = new ArrayList<>();

    private Restaurant() {
        int numberOfRegisters = 2; // TODO: load data from data loader
        for (int i = 0; i < numberOfRegisters; i++) {
            CashRegister register = new CashRegister(i);
//            register.serveCustomers();
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
}
