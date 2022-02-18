package com.company;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class CommonFlowTest{

    Utility utility;

    @Before
    void setup() {
        utility = new Utility();
    }

    @After
    public void tearDown() {
    }

    @BeforeClass
    public static void beforeClas() {
    }

    @AfterClass
    public static void afterClass() {
    }

    @Test
    void testName() {
    }

    @Test(expected=ArithmeticException.class)
    void divideByZero() {
        utility.divide(56, 0);
    }
}
