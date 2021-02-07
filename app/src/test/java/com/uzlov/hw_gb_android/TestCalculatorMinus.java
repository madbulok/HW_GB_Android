package com.uzlov.hw_gb_android;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCalculatorMinus {
    private final Double result;
    private final Double a;
    private final Double b;

    CalculatorDouble calculator;

    public TestCalculatorMinus(Double result, Double a, Double b) {
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
                {5d, 8d, 3d},
                {22d, 33d, 11d},
                {24d, 65d, 41d},
                {30d ,51d, 21d},
                {-33d, 1d, 34d}
        });
    }

    @Test
    public void testCalcMinus(){
        assertEquals(result, calculator.minus(a,b));
    }
}
