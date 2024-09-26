package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testCalculateAddition() {
        Number result = calculator.calculate(Operation.ADD, 2, 3);
        assertEquals(5.0, result);
    }

    @Test
    public void testCalculateSubtraction() {
        Number result = calculator.calculate(Operation.SUBTRACT, 5, 3);
        assertEquals(2.0, result);
    }

    @Test
    public void testCalculateMultiplication() {
        Number result = calculator.calculate(Operation.MULTIPLY, 2, 3);
        assertEquals(6.0, result);
    }

    @Test
    public void testCalculateDivision() {
        Number result = calculator.calculate(Operation.DIVIDE, 6, 3);
        assertEquals(2.0, result);
    }

    @Test
    public void testCalculateDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 1, 0);
        });
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    public void testChainOperations() {
        Number result = calculator.chainOperations(5.0,
                List.of(Operation.ADD, Operation.MULTIPLY),
                List.of(3.0, 2.0));
        assertEquals(16.0, result); // (5 + 3) * 2 = 16
    }

    @Test
    public void testChainOperationsSizeMismatch() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.chainOperations(5.0, List.of(Operation.ADD),
                    List.of(3.0, 2.0));
        });
        assertEquals("Operations and numbers size must match.", exception.getMessage());
    }
}