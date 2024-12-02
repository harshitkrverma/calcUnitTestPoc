package com.harsh;

import com.harsh.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTests {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void testAdd() {
        assertEquals(5.0, calculatorService.add(2.0, 3.0));
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, calculatorService.subtract(3.0, 2.0));
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calculatorService.multiply(2.0, 3.0));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculatorService.divide(6.0, 3.0));
    }

    @Test
    void testDivideByZero() {
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(6.0, 0.0);
        });
        assertEquals("Cannot divide by zero", thrown.getMessage());
    }
}
