package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleArgumentTest {
    Utility utility;

    @BeforeEach
    public void setup() {
        utility = new Utility();
    }

    @ParameterizedTest // <- CAREFUL there is no semicolon. Instead of Test we write ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aba", "abba","radar"}) // CAREFUL <- there is no semicolon
    void isPalindromeTestCase(String word) {
        assertTrue(utility.isPalindrome(word));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 9, 15})
    void isDivisibleByThree(int input) {
        assertEquals(0, utility.isDivisibleByThree(input));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void isNullOrEmpty(String inputString) {
        assertTrue(inputString == null || inputString.isEmpty());
    }
}
