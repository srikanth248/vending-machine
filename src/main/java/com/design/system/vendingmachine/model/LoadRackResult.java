package com.design.system.vendingmachine.model;

import java.util.Objects;

public class LoadRackResult {

    private String previousProductCode;
    private int previousProductCount;
    private String currentProductCode;
    private int currentProductCount;

    public LoadRackResult(String previousProductCode, int previousProductCount, String currentProductCode, int currentProductCount) {
        this.previousProductCode = previousProductCode;
        this.previousProductCount = previousProductCount;
        this.currentProductCode = currentProductCode;
        this.currentProductCount = currentProductCount;
    }

    public LoadRackResult() {

    }

    public String getPreviousProductCode() {
        return previousProductCode;
    }

    public int getPreviousProductCount() {
        return previousProductCount;
    }

    public String getCurrentProductCode() {
        return currentProductCode;
    }

    public int getCurrentProductCount() {
        return currentProductCount;
    }

    public void setPreviousProductCode(String previousProductCode) {
        this.previousProductCode = previousProductCode;
    }

    public void setPreviousProductCount(int previousProductCount) {
        this.previousProductCount = previousProductCount;
    }

    public void setCurrentProductCode(String currentProductCode) {
        this.currentProductCode = currentProductCode;
    }

    public void setCurrentProductCount(int currentProductCount) {
        this.currentProductCount = currentProductCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoadRackResult that = (LoadRackResult) o;
        return previousProductCount == that.previousProductCount &&
                currentProductCount == that.currentProductCount &&
                Objects.equals(previousProductCode, that.previousProductCode) &&
                Objects.equals(currentProductCode, that.currentProductCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(previousProductCode, previousProductCount, currentProductCode, currentProductCount);
    }
}
