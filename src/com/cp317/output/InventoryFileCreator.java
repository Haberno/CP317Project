package com.cp317.output;

import com.cp317.model.Product;
import com.cp317.model.Supplier;
import com.cp317.utils.Sorter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class InventoryFileCreator {
    public static void createInventoryFile(List<Product> products, List<Supplier> suppliers, String filePath) throws IOException {
        Objects.requireNonNull(products, "Product list cannot be null");
        Objects.requireNonNull(suppliers, "Supplier list cannot be null");
        Objects.requireNonNull(filePath, "File path cannot be null");

        if (products.isEmpty() || suppliers.isEmpty()) {
            throw new IllegalArgumentException("Product and supplier lists cannot be empty");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Sorter.sortProductsById(products);
            for (Product product : products) {
                Supplier supplier = findSupplierById(suppliers, product.getSupplierId());
                if (supplier == null) {
                    throw new IllegalStateException("Supplier with ID " + product.getSupplierId() + " not found");
                }

                String line = formatProductLine(product, supplier);
                writer.write(line);
            }
        } // try-with-resources will automatically handle writer.close()
    }

    private static Supplier findSupplierById(List<Supplier> suppliers, int supplierId) {
        return suppliers.stream()
                .filter(supplier -> supplier.getSupplierId() == supplierId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Supplier with ID " + supplierId + " not found"));
    }

    private static String formatProductLine(Product product, Supplier supplier) {
        return product.getProductId() + ", " + product.getProductName() + ", " +
               product.getQuantity() + ", $" + product.getPrice() + ", " +
               product.getStatus() + ", " + supplier.getSupplierName() + "\n";
    }
}
