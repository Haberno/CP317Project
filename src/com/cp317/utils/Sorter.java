package com.cp317.utils;

import com.cp317.model.Product;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    public static void sortProductsById(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Integer.compare(p1.getProductId(), p2.getProductId());
            }
        });
    }
}
