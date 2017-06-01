package com.examples.ArraysAndStrings;

public class PalindromePermutation {
	
	private static int low = Character.getNumericValue('a');
	private static int high = Character.getNumericValue('z');

	public static void main(String[] args) {
		String s = "taco act";
		boolean result = findPalindrome(s.toCharArray());
		System.out.println("Input string palindrome: " + result);
	}

	private static boolean findPalindrome(char[] cs) {
		int i = 0;
		for (int j = 0; j < cs.length; j++) {
			if (getCharIndex(cs[j]) >= 0) {
				// Toggle bit
				int mask = 1 << getCharIndex(cs[j]);
				i = i ^ mask;
			}
		}
		// [(i & (i - 1)) == 0] checks if only one bit(any) is set or not.
		return i == 0 || (i & (i - 1)) == 0;
	}

	// Returns the relative numeric value of char c w.r.t. 'a' i.e. (c - 'a')
	private static int getCharIndex(char c) {
		int val = Character.getNumericValue(c);
		// If alphabets a-z
		if (low <= val && val <= high) {
			return (val - low);
		}
		// Else
		return -1;
	}
}
