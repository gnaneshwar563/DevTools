package com.nt.main;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.junit.jupiter.api.*;

// This tells JUnit to run tests based on the alphabetical order of @DisplayName
@TestMethodOrder(MethodOrderer.DisplayName.class)
class ArtemeticOperationsTest2 {

    private static ArtemeticOperations obj;

    @BeforeAll
    static void init() {
        obj = new ArtemeticOperations();
    }

    @Test
    @DisplayName("01. Should correctly sum two large positive integers")
    void testLargeNumbers() {
        assertEquals(30000, obj.sum(10000, 20000), 0.0001);
    }

    @Test
    @DisplayName("02. Should correctly sum two negative integers")
    void testNegativeNumbers() {
        assertEquals(-30, obj.sum(-10, -20), 0.0001);
    }

    @Test
    @DisplayName("03. Should correctly sum a positive and a negative integer")
    void testPositiveAndNegative() {
        assertEquals(30, obj.sum(50, -20), 0.0001);
    }

    @Test
    @DisplayName("04. Should correctly sum two decimal (double) numbers")
    void testDecimalNumbers() {
        assertEquals(30.8, obj.sum(10.5, 20.3), 0.0001);
    }

    @Test
    @DisplayName("05. Should complete the sum operation within 20 milliseconds")
    void testWithTimeConstraint() {
        double result = assertTimeout(
                Duration.ofMillis(20),
                () -> obj.sum(1000, 2000)
        );
        assertEquals(3000, result, 0.0001);
    }

    @AfterAll
    static void destroy() {
        obj = null;
    }
}