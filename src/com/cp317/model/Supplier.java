package com.cp317.model;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String address;
    private String phone;
    private String email;

    public Supplier(int supplierId, String supplierName, String address, String phone, String email) {
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
