import com.cp317.utils.*;
import com.cp317.model.Product;
import com.cp317.model.Supplier;
import com.cp317.output.InventoryFileCreator;
import com.cp317.utils.ProductFileReader;
import com.cp317.utils.SupplierFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Replace with actual file paths
        String productFilePath = "src/ProductFile.txt";
        String supplierFilePath = "src/SupplierFile.txt";
        String inventoryFilePath = "src/inventoryFile.txt";

        if (productFilePath == null || productFilePath.trim().isEmpty() ||
            supplierFilePath == null || supplierFilePath.trim().isEmpty() ||
            inventoryFilePath == null || inventoryFilePath.trim().isEmpty()) {
            System.err.println("File paths must not be null or empty.");
            return;
        }

        try {
            if (!Files.exists(Paths.get(productFilePath)) || !Files.exists(Paths.get(supplierFilePath))) {
                System.err.println("File not found.");
                return;
            }

            ProductFileReader productReader = new ProductFileReader();
            SupplierFileReader supplierReader = new SupplierFileReader();

            List<Product> products = productReader.readFromFile(productFilePath);
            List<Supplier> suppliers = supplierReader.readFromFile(supplierFilePath);

            // Creating the inventory file using the refactored method
            InventoryFileCreator.createInventoryFile(products, suppliers, inventoryFilePath);

            System.out.println("Inventory file created successfully.");
        } catch (IOException e) {
            System.err.println("There was an error processing the files: " + e.getMessage());
            e.printStackTrace();
            // Implement additional error handling or cleanup if necessary
        }
    }
}
