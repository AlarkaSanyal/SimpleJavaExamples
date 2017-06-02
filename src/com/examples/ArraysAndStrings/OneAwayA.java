package com.examples.ArraysAndStrings;

public class OneAwayA {

	public static void main(String[] args) {
		String a = "pale";
		String b = "bale";
		
		boolean result = false;
		if (a.length() == b.length()) {
			result = isOneEditAway(a.toCharArray(), b.toCharArray());
		} else if (a.length() + 1 == b.length()) {
			result = isOneInsertOrDeleteAway(a.toCharArray(), b.toCharArray());
		} else if (a.length() == b.length() + 1) {
			result = isOneInsertOrDeleteAway(b.toCharArray(), a.toCharArray());
		}
		System.out.println("Strings a & b are one edit away: " + result);
	}

	private static boolean isOneEditAway(char[] a, char[] b) {
		boolean flag = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				// The second time there is a difference, it should return false
				if (flag) {
					return false;
				}
				// The first time there is a difference this will be set true
				flag = true;
			}
		}
		return flag;
	}
	
	private static boolean isOneInsertOrDeleteAway(char[] a, char[] b) {
		int pointerA = 0;
		int pointerB = 0;
		while (pointerA < a.length && pointerB < b.length) {
			if (a[pointerA] != b[pointerB]) {
				// The second time there is a difference, it should return false
				if (pointerA != pointerB) {
					return false;
				}
				// // The first time there is a difference we will move the index for the larger string by 1
				pointerB++;
			} else {
				pointerA++;
				pointerB++;
			}
		}
		return true;
	}
}
