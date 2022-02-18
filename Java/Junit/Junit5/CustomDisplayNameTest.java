package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomDisplayNameTest {
    Utility utility;

    @BeforeEach
    public void setup() {
        utility = new Utility();
    }

    @ParameterizedTest(name = "{index} => month number {0} is {1}")
    @MethodSource("com.company.MonthsProvider#monthName2Source")
    void customMonthName(int month, String name) {
        assertEquals(name, utility.getMonthName(month));
    }
}
