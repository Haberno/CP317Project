package com.cp317.model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private String status;
    private int supplierId;


    public Product(int productId, String productName, double price, int quantity, String status, int supplierId) {
        
        if (productId < 0) throw new IllegalArgumentException("Product ID must be non-negative");
        if (productName == null || productName.trim().isEmpty()) throw new IllegalArgumentException("Product name cannot be null or empty");
        if (price < 0) throw new IllegalArgumentException("Price must be non-negative");
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be non-negative");
        if (status == null || status.trim().isEmpty()) throw new IllegalArgumentException("Status cannot be null or empty");
        if (supplierId < 0) throw new IllegalArgumentException("Supplier ID must be non-negative");

        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.supplierId = supplierId;
    }


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public int getSupplierId() {
        return supplierId;
    }
}
