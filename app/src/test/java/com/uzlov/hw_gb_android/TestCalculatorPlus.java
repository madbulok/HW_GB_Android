package com.uzlov.hw_gb_android;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCalculatorPlus {
    private final Double result;
    private final Double a;
    private final Double b;

    CalculatorDouble calculator;

    public TestCalculatorPlus(Double result, Double a, Double b) {
        this.result = result;
        this.a = a;
        this.b = b;
    }


    @Before
    public void init(){
        calculator = new CalculatorDouble();
    }

    @Parameterized.Parameters(name = "{index}:sumOf({1}+{2})={0}")
    public static Collection<Double[]> data(){
        return Arrays.asList(new Double[][]{
                {5d, 2d, 3d},
                {44d, 33d, 11d},
                {56d, 15d, 41d},
                {72d ,51d, 21d},
                {35d, 1d, 34d}
        });
    }

    @Test
    public void testCalcSumm(){
        assertEquals(result, calculator.plus(a,b));
    }

}
