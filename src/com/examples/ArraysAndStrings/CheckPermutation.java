package com.examples.ArraysAndStrings;

public class CheckPermutation {

	public static void main(String[] args) {
		// Assuming string are made up of ASCII characters 0-127
		String a = "hello";
		String b = "world";
		
		boolean isPerm = checkperm(a, b);
		if (isPerm) {
			System.out.println("String a is a permutation of String b");
		} else {
			System.out.println("String a is NOT a permutation of String b");
		}
	}

	private static boolean checkperm(String a, String b) {
		// If lengths are not equal, the strings cannot be permutation of each other
		if (a.length() != b.length()) {
			return false;
		}
		
		// Initializing an empty array
		int[] c = new int[128];
		
		// Looping over chars of string "a" and incrementing the count for each char
		for (int i = 0; i <a.length(); i++) {
			c[a.charAt(i)]++;
		}
		
		// Looping over chars of string "a" and incrementing the count for each char
		for (int i = 0; i < b.length(); i++) {
			c[b.charAt(i)]--;
			if (c[b.charAt(i)] < 0) {
				return false; // Break here since count did not match
			}
		}
		return true;
	}
}
