package com.design.system.vendingmachine.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "vending_machine")
public class VendingMachine {

    @Id
    private String machineId;
    private double totalCash;
    private String rackRequested;
    private double sessionAmount;

    public VendingMachine(String machineId, double totalCash, String rackRequested, double sessionAmount) {
        this.machineId = machineId;
        this.totalCash = totalCash;
        this.rackRequested = rackRequested;
        this.sessionAmount = sessionAmount;
    }

    public VendingMachine() {
    }

    public void setRackRequested(String rackRequested) {
        this.rackRequested = rackRequested;
    }

    public String getRackRequested() {
        return rackRequested;
    }

    public double getSessionAmount() {
        return sessionAmount;
    }

    public void setSessionAmount(double sessionAmount) {
        this.sessionAmount = sessionAmount;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachine that = (VendingMachine) o;
        return Double.compare(that.totalCash, totalCash) == 0 &&
                Double.compare(that.sessionAmount, sessionAmount) == 0 &&
                Objects.equals(machineId, that.machineId) &&
                Objects.equals(rackRequested, that.rackRequested);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineId, totalCash, rackRequested, sessionAmount);
    }
}
