package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleArgumentsTest {
    /*
    If the unit test method and source method have different names then we
    need to mention the source method name in the annotation
    Example: @MethodSource("monthSourceMethod")
     */

    Utility utility;

    @BeforeEach
    public void setup() {
        utility = new Utility();
    }

    @ParameterizedTest
    @MethodSource("monthSourceMethod")
    void monthName(int month, String name) {
        Utility utility = new Utility();
        assertEquals(name, utility.getMonthName(month));
    }

    // input source method should be static
    private static Stream<Arguments> monthSourceMethod() {
        return Stream.of(
                Arguments.of(1, "January"),
                Arguments.of(2, "February"),
                Arguments.of(12, "December"));
    }

    @ParameterizedTest
    @MethodSource
    void monthName1(int month, String name) {
        assertEquals(name, utility.getMonthName(month));
    }

    private static Stream<Arguments> monthName1() {
        return Stream.of(
                Arguments.of(1, "January"),
                Arguments.of(2, "February"),
                Arguments.of(12, "December"));
    }
}
