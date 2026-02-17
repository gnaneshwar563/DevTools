package com.nt.main;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.junit.jupiter.api.*;

// 1. Generate display names automatically from method names
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// 2. Order the execution based on those generated display names
@TestMethodOrder(MethodOrderer.DisplayName.class)
class ArtemeticOperationsTest3 {

    private static ArtemeticOperations obj;

    @BeforeAll
    static void init() {
        obj = new ArtemeticOperations();
    }

    @Test
    void a1_test_Large_Numbers() {
        assertEquals(30000, obj.sum(10000, 20000), 0.0001);
    }

    @Test
    void a2_test_Negative_Numbers() {
        assertEquals(-30, obj.sum(-10, -20), 0.0001);
    }

    @Test
    void a3_test_Positive_And_Negative() {
        assertEquals(30, obj.sum(50, -20), 0.0001);
    }

    @Test
    void a4_test_Decimal_Numbers() {
        assertEquals(30.8, obj.sum(10.5, 20.3), 0.0001);
    }

    @Test
    void a5_test_With_Time_Constraint() {
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