package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Calculator {

    public Number calculate(Operation op, Number num1, Number num2) throws IllegalArgumentException {
        switch (op) {
            case ADD:
                return num1.doubleValue() + num2.doubleValue();
            case SUBTRACT:
                return num1.doubleValue() - num2.doubleValue();
            case MULTIPLY:
                return num1.doubleValue() * num2.doubleValue();
            case DIVIDE:
                if (num2.doubleValue() == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero.");
                }
                return num1.doubleValue() / num2.doubleValue();
            default:
                throw new IllegalArgumentException("Operation not supported.");
        }
    }

    public Number chainOperations(Number initialValue, List<Operation> operations, List<Number> numbers) throws IllegalArgumentException {
        if (operations.size() != numbers.size()) {
            throw new IllegalArgumentException("Operations and numbers size must match.");
        }
        Number result = initialValue;
        for (int i = 0; i < operations.size(); i++) {
            result = calculate(operations.get(i), result, numbers.get(i));
        }
        return result;
    }
}
