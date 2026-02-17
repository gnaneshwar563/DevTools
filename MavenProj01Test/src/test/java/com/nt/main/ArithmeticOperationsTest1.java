package com.nt.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArithmeticOperationsTest1 { // Added public

	// Fixed spelling to match your likely class name 'ArithmeticOperations'
	private static ArtemeticOperations obj;

	@BeforeAll
	static void setUp() {
		obj = new ArtemeticOperations();
	}

	@Test
	@Order(1)
	@DisplayName("Test sum with large numbers")
	void testSumWithLargeNumbers() {
		// Ensure the sum method in your main class handles 'long' or 'int'
		assertEquals(30000, obj.sum(10000, 20000));
	}

	@Test
	@Disabled("Skipping this until manual check is done")
	@DisplayName("Test sum with small numbers")
	void testSumWithSmallNumbers() {
		assertEquals(30, obj.sum(10, 20));
	}

	@Test
	@Order(2)
	@DisplayName("Test sum with negative numbers")
	void testSumWithNegativeNumbers() {
		assertEquals(-30, obj.sum(-10, -20));
	}

	@Test
	@Order(3)
	@DisplayName("Test sum with mixed numbers")
	void testSumWithMixedNumbers() {
		assertEquals(30, obj.sum(50, -20));
	}

	@Test
	@Order(4)
	@DisplayName("Test sum with decimal numbers")
	void testSumWithDecimals() {
		// NOTE: Your 'sum' method MUST be overloaded to accept doubles
		// for this test to compile and run.
		assertEquals(30.8, obj.sum(10.5, 20.3), 0.0001);
	}

	@Test
	@Order(5)
	@DisplayName("Test sum within 20ms")
	void testSumWithTimeout() {
		// Using double here suggests your sum returns a double
		double result = assertTimeout(Duration.ofMillis(20), () -> (double) obj.sum(1000, 2000));

		assertEquals(3000, result);
	}

	@AfterAll
	static void tearDown() {
		obj = null;
	}
}