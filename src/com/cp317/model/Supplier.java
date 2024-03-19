package com.cp317.model;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String address;
    private String phone;
    private String email;

    public Supplier(int supplierId, String supplierName, String address, String phone, String email) {

        if (supplierId < 0) throw new IllegalArgumentException("Supplier ID must be non-negative");
        if (supplierName == null || supplierName.trim().isEmpty()) throw new IllegalArgumentException("Supplier name cannot be null or empty");
        if (address == null || address.trim().isEmpty()) throw new IllegalArgumentException("Address cannot be null or empty");
        if (phone == null || phone.trim().isEmpty()) throw new IllegalArgumentException("Phone cannot be null or empty");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email cannot be null or empty");

        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }

    // Getters
    public int getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

}
