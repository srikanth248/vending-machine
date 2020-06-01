package com.design.system.vendingmachine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Rack {

    @Id
    @GeneratedValue
    private Integer id;
    private String machineId;
    private String rackId;
    private String productCode;
    private int numProducts;

    public Rack(String machineId, String rackId, String productCode, int numProducts) {
        this.machineId = machineId;
        this.rackId = rackId;
        this.productCode = productCode;
        this.numProducts = numProducts;
    }

    public Rack() {
    }

    public String getProductCode() {
        return productCode;
    }

    public int getNumProducts() {
        return numProducts;
    }

    public void setNumProducts(int numProducts) {
        this.numProducts = numProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rack rack = (Rack) o;
        return numProducts == rack.numProducts &&
                Objects.equals(id, rack.id) &&
                Objects.equals(machineId, rack.machineId) &&
                Objects.equals(rackId, rack.rackId) &&
                Objects.equals(productCode, rack.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, machineId, rackId, productCode, numProducts);
    }
}
