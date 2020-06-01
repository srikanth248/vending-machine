package com.design.system.vendingmachine.model;

import java.util.Objects;

public class PaymentRequest {

    private String machineId;
    private double paymentAmount;

    public PaymentRequest(String machineId, double paymentAmount) {
        this.machineId = machineId;
        this.paymentAmount = paymentAmount;
    }

    public String getMachineId() {
        return machineId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRequest that = (PaymentRequest) o;
        return Double.compare(that.paymentAmount, paymentAmount) == 0 &&
                Objects.equals(machineId, that.machineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineId, paymentAmount);
    }
}
