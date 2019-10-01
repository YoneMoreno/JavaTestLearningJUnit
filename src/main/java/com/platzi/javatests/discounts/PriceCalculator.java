package com.platzi.javatests.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();
    private int discount = 0;

    public double getTotal() {
        return prices.stream().mapToDouble(Double::doubleValue).sum() * ((100 - discount)/100.0);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
