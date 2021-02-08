package com.uzlov.hw_gb_android;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCalculatorDivide {
    private final Double result;
    private final Double a;
    private final Double b;

    CalculatorDouble calculator;

    public TestCalculatorDivide(Double result, Double a, Double b) {
        this.result = result;
        this.a = a;
        this.b = b;
    }


    @Before
    public void init(){
        calculator = new CalculatorDouble();
    }

    @Parameterized.Parameters(name = "{index}:minus({1}-{2})={0}")
    public static Collection<Double[]> data(){
        return Arrays.asList(new Double[][]{
                {1.5d, 9d, 6d},
                {3d, 33d, 11d},
                {1d, 41d, 41d},
                {2d ,50d, 25d},
                {-33d, -99d, 3d}
        });
    }

    @Test
    public void testCalcMinus(){
        assertEquals(result, calculator.divide(a,b));
    }
}
