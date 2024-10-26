package com.incubyte.tdd.assessment1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.incubyte.tdd.assessment1.StringCalculator;

class StringCalculatorTest {

	private final StringCalculator calculator = new StringCalculator();

	@Test
	void negativeNumbersThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			calculator.add("1,-2,3,-4");
		});
		assertEquals("Negative numbers not allowed: -2, -4", exception.getMessage());
		System.out.println("NegativeNumbers throws exception test passed");
	}

	@Test
	void customDelimiterTest() {
		assertEquals(6, calculator.add("//;\n1;2;3"));
		System.out.println("Custom Delimeter Test Passed");
	}

	@Test
	void ignoringLargeNumbersTest() {
		assertEquals(2, calculator.add("1001,2"));
		System.out.println("Ignoring Larger Numbers Test Passed");
	}

	@Test
	void emptyStringTest() {
		assertEquals(0, calculator.add(""));
		System.out.println("Empty String Test Passed");
	}

	@Test
	void singleNumberTest() {
		assertEquals(1, calculator.add("1"));
		assertEquals(2, calculator.add("2"));
		System.out.println("Single Number Test Passed");
	}

	@Test
	void twoNumbersReturnsSumTest() {
		assertEquals(3, calculator.add("1,2"));
		assertEquals(6, calculator.add("4,2"));
		System.out.println("Two Numbers Returning sum Test Passed");
	}

	@Test
	void newlineAsDelimiterTest() {
		assertEquals(6, calculator.add("1\n2,3"));
		System.out.println("New Line As Delimiter Test Passed");
	}

}
