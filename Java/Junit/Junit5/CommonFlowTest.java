package com.company;

import org.junit.jupiter.api.*;

public class CommonFlowTest {
    Utility utility;

    @BeforeEach
    void setup() {
        utility = new Utility();
    }

    @AfterEach
    public void tearDown() {
    }

    @BeforeAll
    public static void beforeClas() {
    }

    @AfterAll
    public static void afterClass() {
    }

    @Test
    public void testName() {
    }
}
