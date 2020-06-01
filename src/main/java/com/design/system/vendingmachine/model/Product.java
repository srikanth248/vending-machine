package com.design.system.vendingmachine.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {

    @Id
    private String productCode;
    private double productCost;

    public Product(String productCode, double productCost) {
        this.productCode = productCode;
        this.productCost = productCost;
    }

    public Product() {
    }

    public double getProductCost() {
        return productCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.productCost, productCost) == 0 &&
                Objects.equals(productCode, product.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productCost);
    }
}
