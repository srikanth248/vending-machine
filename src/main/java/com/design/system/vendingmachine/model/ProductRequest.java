package com.design.system.vendingmachine.model;

import java.util.Objects;

public class ProductRequest {

    private String machineId;
    private String rackId;

    public ProductRequest(String machineId, String rackId) {
        this.machineId = machineId;
        this.rackId = rackId;
    }

    public String getMachineId() {
        return machineId;
    }

    public String getRackId() {
        return rackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequest that = (ProductRequest) o;
        return Objects.equals(machineId, that.machineId) &&
                Objects.equals(rackId, that.rackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineId, rackId);
    }
}
