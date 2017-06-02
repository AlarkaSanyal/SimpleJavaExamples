package com.examples.ArraysAndStrings;

public class StringCompression {

	public static void main(String[] args) {
		String s = "aabbbcccddeeeaaa";
		// String s = "abcdefabc";
		compressedString(s.toCharArray());
	}

	private static void compressedString(char[] c) {
		int compressionCount = 0;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			compressionCount++;
			if (i+1 > c.length - 1 || (c[i] != c[i+1])) {
				s.append(c[i]);
				s.append(compressionCount);
				compressionCount = 0;
			}
		}
		String finalString = s.length() <= c.length ? s.toString() : new String(c);
		
		System.out.println("Final String: " + finalString);
	}
}
