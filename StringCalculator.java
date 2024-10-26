package com.incubyte.tdd.assessment1;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}

		String delimiter = ",|\n";
		
		if (numbers.startsWith("//")) {
			int delimiterEndIndex = numbers.indexOf('\n');
			delimiter = numbers.substring(2, delimiterEndIndex);
			numbers = numbers.substring(delimiterEndIndex + 1);
		}

		String[] numberArray = numbers.split(delimiter);
		List<Integer> negatives = new ArrayList<>();
		int sum = 0;

		for (String number : numberArray) {
			int num = Integer.parseInt(number.trim());
			if (num < 0) {
				negatives.add(num);
			} else if (num <= 1000) {
				sum += num;
			}
		}

		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException(
					"Negative numbers not allowed: " + negatives.toString().replaceAll("[\\[\\]]", ""));
		}

		return sum;
	}
}
