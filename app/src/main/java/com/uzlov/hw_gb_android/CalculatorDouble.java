package com.uzlov.hw_gb_android;

public class CalculatorDouble implements Calculatable<Number> {

    @Override
    public Number plus(Number v1, Number v2) {
        return v1.doubleValue() + v2.doubleValue();
    }

    @Override
    public Number minus(Number v1, Number v2) {
        return v1.doubleValue() - v2.doubleValue();
    }

    @Override
    public Number divide(Number v1, Number v2) {
        if (v2.doubleValue() == 0) throw  new IllegalArgumentException("You pass incorrect value: " + v2);
        return v1.doubleValue()/v2.doubleValue();
    }
    @Override
    public Number multiply(Number v1, Number v2) {
        return v1.doubleValue() * v2.doubleValue();
    }
}
