package com.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeConversionTest {
    @ParameterizedTest
    @CsvSource("John Doe")
    public void fallBackStringConversion(Person person) {
        assertEquals("John Doe", person.getName());
    }
}
