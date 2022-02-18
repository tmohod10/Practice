package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHandlingTest {
    Utility utility;

    @BeforeEach
    public void setup() {
        utility = new Utility();
    }
    @Test
    void divideByZeroJunit5() {
        assertThrows(ArithmeticException.class, () -> {
            utility.divide(234, 0);
        });
    }
}
