package esdc.sem4.multithreading.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import esdc.sem4.multithreading.customer.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    private static final JsonNode configRoot;

    static {
        try (InputStream is = JsonReader.class.getClassLoader().getResourceAsStream("config.json")) {
            if (is == null) {
                throw new RuntimeException("config.json not found in resources");
            }
            ObjectMapper mapper = new ObjectMapper();
            configRoot = mapper.readTree(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.json", e);
        }
    }

    public static List<Customer> loadCustomersFromJson() throws Exception { // TODO: refactor name

        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customers = new ArrayList<>();
        InputStream inputStream = JsonReader.class.getClassLoader().getResourceAsStream("customers.json");

        if (inputStream == null) {
            throw new FileNotFoundException("customers.json not found in resources");
        }
        try {
            JsonNode root = mapper.readTree(inputStream);
            for (JsonNode node : root) {
                String name = node.get("name").asText();
                boolean preOrder = node.get("preOrder").asBoolean();
                int maxEndurance = node.get("maxEndurance").asInt();
                customers.add(new Customer(name, preOrder, maxEndurance));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static int getMaxServingTimeSec() {
        return configRoot.get("maxServingTimeSec").asInt();
    }

    public static int getNumberOfCashRegisters() {
        return configRoot.get("numberOfCashRegisters").asInt();
    }

    public static int getMaxTimeForChoosingFoodSec() {
        return configRoot.get("maxTimeForChoosingFoodSec").asInt();
    }
}