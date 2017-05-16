package com.examples.ArraysAndStrings;

public class IsUniqueB {

	// Assuming that the string is made up of ASCII characters a-z (small letters) only
	// Since the max characters a-z is 26, we can use only 1 integer (32 bits) to check
	public static void main(String[] args) {
		String s = "abcdefgh"; // Unique
		// String s = "abcdefgg"; // Not unique
		if (s != null && !s.isEmpty()) {
			boolean result = isUnique(s);
			System.out.println("String \"" + s + "\" unique: " + result);
		} else {
			System.out.println("Input string is null/empty");
		}
	}

	private static boolean isUnique(String s) {
		int check = 0; // All 0s i.e. 0000 0000 0000 0000 0000 0000 0000 0000
		for (int i = 0; i < s.length(); i++) {
			int charVal = s.charAt(i) - 'a';
			if ((check & (1 << charVal)) != 0) { // Get bit
				return false;
			}
			check = check | (1 << charVal); // Set bit
		}
		return true;
	}
}
