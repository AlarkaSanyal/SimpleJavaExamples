package com.examples.Moderate;

public class FactZero {

	public static void main(String[] args) {
		int num = 1000;
		int zeros = findZeros(num);
		System.out.println(num + "!: " + zeros);
	}

	private static int findZeros(int num) {
		if (num < 1) {
			return 0;
		}
		int count = 0;
		
		// Step function formula -> zeros = n/(5^1) + n/(5^2) + ... + n/(5^x), while n/(5^x) > 0 
		for (int i = 5; num/i > 0; i *= 5) {
			count += num/i;
		}
		return count;
	}

}
