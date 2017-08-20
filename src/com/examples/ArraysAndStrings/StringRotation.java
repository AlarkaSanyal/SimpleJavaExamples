package com.examples.ArraysAndStrings;

public class StringRotation {

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		boolean rotated = false;
		// Check if length are equal and not zero
		if (s1.length() == s2.length() && s1.length() > 0) {
			String s1s1 = s1 + s1;
			rotated = isSubString(s1s1, s2);
		}
		System.out.println("String rotated: " + rotated);
	}

	private static boolean isSubString(String s1s1, String s2) {
		if (s1s1.contains(s2)) {
			return true;
		}
		return false;
	}

}
