package com.cp317.model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private String status;
    private int supplierId;


    public Product(int productId, String productName, double price, int quantity, String status, int supplierId) {
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
