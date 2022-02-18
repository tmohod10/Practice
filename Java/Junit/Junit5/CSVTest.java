package com.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVTest {
    @ParameterizedTest
    @CsvSource({
            "Write a Blog Post, IN PROGRESS, 2022-05-01",
            "Wash car, OPENED, 2022-03-01"
    })
    public void readCSV(String title, String status, LocalDate date) {
        System.out.println(title + " - " + status + " -" + date);
    }

    @ParameterizedTest
    @CsvSource({
            ", OPENED, 2022-03-01" // <- title is null
    })
    public void readCSVNull(String title, String status, LocalDate date) {
        assertNull(title);
    }

    @ParameterizedTest
    @CsvSource({
            "'', OPENED, 2022-03-01" // <- title is empty
    })
    public void readCSVEmpty(String title, String status, LocalDate date) {
        assertTrue(title.isEmpty());
    }

    @ParameterizedTest
    @CsvFileSource(resources="Tasks.csv")
    public void readCSVusingResouceFile(String title, String status, LocalDate date) {
        System.out.println(title + " - " + status + " -" + date);
    }
}
