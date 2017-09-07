package com.examples.Recursion;

public class RecursiveMultiply {

	// 5 X 6
	// = 6 + [(5 - 1) X 6]
	// i.e i X j = j + [(i - 1) X j]  
	
	public static void main(String[] args) {
		int result = multiply(5,4);
		System.out.println("5 X 4 = "+ result);
	}

	private static int multiply(int i, int j) {
		if (i == 0) {
			return 0;
		}
		// Returning "j + [(i - 1) X j]" part from above explanation
		return j + multiply(i - 1, j);
	}
}
