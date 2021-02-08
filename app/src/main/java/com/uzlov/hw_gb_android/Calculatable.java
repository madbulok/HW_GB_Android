package com.uzlov.hw_gb_android;

public interface Calculatable<T extends Number> {
    T plus(T v1, T v2);
    T minus(T v1, T v2);
    T divide(T v1, T v2);
    T multiply(T v1, T v2);
}
