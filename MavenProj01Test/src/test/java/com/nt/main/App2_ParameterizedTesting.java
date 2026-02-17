package com.nt.main;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // allows @BeforeAll to be non-static
public class App2_ParameterizedTesting {

	private static App2_Parameterized app; // static object as requested

	// =============================
	// Lifecycle Methods
	// =============================

	@BeforeAll
	static void initAll() {
		System.out.println("BeforeAll: Initialize resources once before all tests");
		app = new App2_Parameterized(); // create static object
	}

	@BeforeEach
	void initEach() {
		System.out.println("BeforeEach: Runs before every test");
	}

	@AfterEach
	void tearDownEach() {
		System.out.println("AfterEach: Runs after every test");
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("AfterAll: Cleanup resources once after all tests");
		app = null; // cleanup static object
	}

	// =============================
	// Parameterized Test: Add Method
	// =============================

	@ParameterizedTest
	@CsvSource({ "2,3,5", "0,0,0", "-1,1,0", "-5,-3,-8", "100.5,200.5,301.0", "1.234,5.678,6.912" })
	void testAdd(double a, double b, double expectedSum) {
		double result = app.add(a, b);
		assertEquals(expectedSum, result, 0.0001, a + " + " + b + " should equal " + expectedSum);
	}

	// =============================
	// Palindrome Tests - All True
	// =============================

	@ParameterizedTest
	@ValueSource(strings = { "madam", "racecar", "malayalam", "level", "noon" })
	void testPalindrome_AllTrue(String str) {
		assertTrue(app.isPallendrome(str), str + " should be a palindrome");
	}

	// =============================
	// Palindrome Tests - All False
	// =============================

	@ParameterizedTest
	@ValueSource(strings = { "hello", "world", "openai", "java", "chatgpt" })
	void testPalindrome_AllFalse(String str) {
		assertFalse(app.isPallendrome(str), str + " should NOT be a palindrome");
	}

	// =============================
	// Palindrome Tests - Mixed True/False with If-Else
	// =============================

	@ParameterizedTest
	@CsvSource({ "madam,true", "racecar,true", "hello,false", "openai,false", "noon,true", "java,false" })
	void testPalindrome_IfElse(String str, boolean expected) {
		if (expected) {
			assertTrue(app.isPallendrome(str), str + " should be a palindrome");
		} else {
			assertFalse(app.isPallendrome(str), str + " should NOT be a palindrome");
		}
	}
}
