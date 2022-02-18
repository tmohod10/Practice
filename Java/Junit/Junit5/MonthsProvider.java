package com.company;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MonthsProvider {
    private static Stream<Arguments> monthName2Source() {
        return Stream.of(
                Arguments.of(1, "January"),
                Arguments.of(2, "February"),
                Arguments.of(12, "December"));
    }
}
