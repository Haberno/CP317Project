package com.cp317.utils;

import com.cp317.model.Product;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductFileReader implements FileReader<Product> {

    @Override
    public List<Product> readFromFile(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                Product product = new Product(
                        Integer.parseInt(parts[0]), parts[1],
                        Double.parseDouble(parts[3].replace("$", "")),
                        Integer.parseInt(parts[4]),
                        parts[5],
                        Integer.parseInt(parts[6])
                );
                products.add(product);
            }
        } catch (NumberFormatException e) {
            // Log the error, provide feedback, or set default values
            e.printStackTrace();
        }

        return products;
    }
}
