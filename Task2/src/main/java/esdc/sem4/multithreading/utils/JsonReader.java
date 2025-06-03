package esdc.sem4.multithreading.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import esdc.sem4.multithreading.customer.Customer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public static List<Customer> loadCustomersFromJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customers = new ArrayList<>();

        try {
            // Предполагается, что файл называется customers.json
            JsonNode root = mapper.readTree(new File("resources/customers.json"));
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
}