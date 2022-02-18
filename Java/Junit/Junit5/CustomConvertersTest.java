package com.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomConvertersTest {
    @ParameterizedTest
    @CsvSource({
            "15, F",
            "16, 10",
            "233, E9"
    })
    void convertWithCustomHexConverter(int decimal, @ConvertWith(HexConverter.class) Integer hex) {
        assertEquals(decimal, hex);
    }

    @ParameterizedTest
    @CsvSource({
            "15, F",
            "16, 10",
            "233, E9"
    })
    void convertWithCustomHexConverter1(int decimal, @HexValue Integer hex) {
        assertEquals(decimal, hex);
    }

    @ParameterizedTest
    @CsvSource({
            "Write a Blog Post, IN_PROGRESS, 2022-05-01",
            "Wash car, OPENED, 2022-03-01"
    })
    public void readAsObject(@AggregateWith(TaskAggregator.class) Task task) {
        System.out.println(task);
    }
}
