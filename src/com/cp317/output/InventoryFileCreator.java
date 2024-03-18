package com.cp317.output;

import com.cp317.model.Product;
import com.cp317.model.Supplier;
import com.cp317.utils.Sorter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class InventoryFileCreator {
    public static void createInventoryFile(List<Product> products, List<Supplier> suppliers, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            Sorter.sortProductsById(products);
            for (Product product : products) {
                Supplier supplier = findSupplierById(suppliers, product.getSupplierId());
                if (supplier != null) {
                    String line = product.getProductId() + ", " + product.getProductName() + ", " +
                            product.getQuantity() + ", $" + product.getPrice() + ", " +
                            product.getStatus() + ", " + supplier.getSupplierName() + "\n";
                    writer.write(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Supplier findSupplierById(List<Supplier> suppliers, int supplierId) {
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplierId() == supplierId) {
                return supplier;
            }
        }
        return null; // Or throw an exception if a supplier should always be found
    }
}
