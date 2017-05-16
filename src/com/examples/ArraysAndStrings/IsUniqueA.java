package com.examples.ArraysAndStrings;

public class IsUniqueA {

	// Assuming the string is made up of ASCII values (0-127)
	public static void main(String[] args) {
		//String s = "abcdefghijk"; // Unique
		String s = "abcdeefghijk"; // Not unique
		//String s = ""; // Empty string
		//String s = null; // Null string
		if (s != null && !s.isEmpty()) {
			boolean result = isUnique(s);
			System.out.println("String \"" + s + "\" unique: " + result);			
		} else {
			System.out.println("Input string is null/empty");
		}		
	}

	private static boolean isUnique(String s) {
		// A string using 128 ASCII characters cannot be of
		// length more than 128 without having duplicates
		if (s.length() > 127) {
			return false;
		} else {
			boolean[] chars = new boolean[128];
			for (int i = 0; i< s.length(); i++) {
				int charIndex = s.charAt(i);
				// If the value is set as TRUE in the charIndex-th index,
				// it means the character was already present once before 
				if (chars[charIndex]) {
					return false;
				}
				// Set the charIndex-th index as TRUE 
				chars[charIndex] = true;
			}
		}
		return true;
	}
}
