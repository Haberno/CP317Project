package com.cp317.utils;

import com.cp317.model.Supplier;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SupplierFileReader implements FileReader<Supplier> {

    @Override
    public List<Supplier> readFromFile(String filePath) throws IOException {
        List<Supplier> suppliers = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                Supplier supplier = new Supplier(
                        Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]
                );
                suppliers.add(supplier);
            }
        } catch (NumberFormatException e) {
            // Log the error, provide feedback, or set default values
            e.printStackTrace();
        }

        return suppliers;
    }
}
