package com.calculator.entity;

import java.io.Serializable;

public class PriceDetails implements Serializable {
    double netPrice;

    public PriceDetails() {

    }

    public PriceDetails(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }
    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }
}
