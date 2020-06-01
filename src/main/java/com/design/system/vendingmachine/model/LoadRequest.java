package com.design.system.vendingmachine.model;

import java.util.Objects;

public class LoadRequest {

    private String machineId;
    private String rackId;
    private String productCode;
    private int numProduct;

    public LoadRequest(String machineId, String rackId, String productCode, int numProduct) {
        this.machineId = machineId;
        this.rackId = rackId;
        this.productCode = productCode;
        this.numProduct = numProduct;
    }

    public String getMachineId() {
        return machineId;
    }

    public String getRackId() {
        return rackId;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getNumProduct() {
        return numProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoadRequest that = (LoadRequest) o;
        return numProduct == that.numProduct &&
                Objects.equals(machineId, that.machineId) &&
                Objects.equals(rackId, that.rackId) &&
                Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineId, rackId, productCode, numProduct);
    }
}
