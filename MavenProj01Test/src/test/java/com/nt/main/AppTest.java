package com.nt.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AppTest {

	App obj = new App();

	@Test
	public void testCalcSimpleInterestAmount_ValidInputs() {
		double result = obj.calcSimpleInterestAmount(10000, 5, 2);
		assertEquals(1000.0, result);
	}

	@Test
	public void testCalcSimpleInterestAmount_InvalidInputs() {
		assertThrows(IllegalArgumentException.class, () -> {
			obj.calcSimpleInterestAmount(-10000, 5, 2);
		});
	}
}