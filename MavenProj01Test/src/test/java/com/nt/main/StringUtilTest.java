package com.nt.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringUtilTest {

	public StringUtil ops;

	// Runs once before all test cases
	@BeforeAll
	void init() {
		System.out.println("BeforeAll: Creating object");
		ops = new StringUtil();
	}

	// Runs before each test case
	@BeforeEach
	void setUp() {
		System.out.println("BeforeEach: Test starting...");
	}

	// 1️⃣ Valid Palindrome
	@Test
	void testValidPalindrome() {
		assertTrue(ops.isPallendrome("madam"));
	}

	// 2️⃣ Not a Palindrome
	@Test
	void testInvalidPalindrome() {
		assertFalse(ops.isPallendrome("hello"));
	}

	// 3️⃣ Single Character
	@Test
	void testSingleCharacter() {
		assertTrue(ops.isPallendrome("a"));
	}

	// 4️⃣ Case Sensitive Check
	@Test
	void testCaseSensitive() {
		assertFalse(ops.isPallendrome("Madam"));
	}

	// 5️⃣ Null Input
	@Test
	void testNullInput() {
		assertThrows(IllegalArgumentException.class, () -> ops.isPallendrome(null));
	}

	// 6️⃣ Empty String
	@Test
	void testEmptyString() {
		assertThrows(IllegalArgumentException.class, () -> ops.isPallendrome(""));
	}

	// ==============================
	// LocalDate Test Cases
	// ==============================

	// 7️⃣ Valid Date
	@Test
	void testValidDate() {
		LocalDate expected = LocalDate.of(2025, 1, 15);
		assertEquals(expected, ops.createDate(2025, 1, 15));
	}

	// 8️⃣ Year less than 1900
	@Test
	void testInvalidYear() {
		assertNull(ops.createDate(1899, 1, 10));
	}

	// 9️⃣ Invalid Month
	@Test
	void testInvalidMonth() {
		assertNull(ops.createDate(2025, 0, 10));
	}

	// 🔟 Invalid Day
	@Test
	void testInvalidDay() {
		LocalDate Id = ops.createDate(2000, 10, 20);
		assertNull(Id);
		assertEquals(LocalDate.of(2000, 10, 20), Id);
	}

	// 11️⃣ Boundary Year = 1900
	@Test
	void testBoundaryYear() {
		LocalDate expected = LocalDate.of(1900, 1, 1);
		assertEquals(expected, ops.createDate(1900, 1, 1));
	}

	// 12️⃣ Leap Year Case
	@Test
	void testLeapYear() {
		LocalDate expected = LocalDate.of(2024, 2, 29);
		assertEquals(expected, ops.createDate(2024, 2, 29));
	}

	@Test
	void createDate_shouldExecuteWithin20Milliseconds() {
		// Assert that createDate() completes within 20 milliseconds
		LocalDate result = assertTimeout(Duration.ofMillis(20), () -> ops.createDate(2025, 5, 20));

		// Optional: verify correctness
		assertEquals(LocalDate.of(2025, 5, 20), result);
	}

	@Test
	public void testSingleTonClass() {
		Runtime rt1 = Runtime.getRuntime();
		Runtime rt2 = Runtime.getRuntime();
		System.out.println(rt1.hashCode() + "...." + rt2.hashCode());
		assertSame(rt1, rt2);

	}

	@Test
	public void testNonSingleTonClass() {
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.now();
		System.out.println(d1.hashCode() + "...." + d2.hashCode());
		assertNotEquals(d1, d2);

	}

	// Runs after each test case
	@AfterEach
	void tearDown() {
		System.out.println("AfterEach: Test finished.");
	}

	// Runs once after all test cases
	@AfterAll
	void destroy() {
		System.out.println("AfterAll: All tests completed.");
		ops = null;
	}
}
