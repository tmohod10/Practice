package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SharingArgumentsBetweenTest {
    Utility utility;

    @BeforeEach
    public void setup() {
        utility = new Utility();
    }

    @ParameterizedTest
    @MethodSource("com.company.MonthsProvider#monthName2Source")
    void monthName2(int month, String name) {
        assertEquals(name, utility.getMonthName(month));
    }


    @ParameterizedTest
    @ArgumentsSource(MonthsProvider1.class)
    void monthName3(int month, String name) {
        assertEquals(name, utility.getMonthName(month));
    }
}
