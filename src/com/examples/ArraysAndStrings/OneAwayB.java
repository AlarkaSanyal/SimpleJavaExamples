package com.examples.ArraysAndStrings;

public class OneAwayB {

	public static void main(String[] args) {
		String a = "pale";
		String b = "bale";
		
		boolean result = false;
		if (Math.abs(a.length() - b.length()) <= 1) {
			result = isOneEditAway(a.toCharArray(), b.toCharArray());
		}
		System.out.println("Strings a & b are one edit away: " + result);
	}

	private static boolean isOneEditAway(char[] a, char[] b) {
		int pointerA = 0;
		int pointerB = 0;
		boolean flag = false;
		while (pointerA < a.length && pointerB < b.length) {
			if (a[pointerA] != b[pointerB]) {
				// The second time there is a difference, it should return false
				if (flag) {
					return false;
				}
				// The first time there is a difference we will move the index for the larger string by 1 (if length is not equal)
				if (b.length > a.length) {
					pointerB++;	
				} else if (a.length > b.length) {
					pointerA++;
				// If lenght is equal, we move both pointers
				} else {
					pointerA++;
					pointerB++;
				}
				flag = true;
			} else {
				pointerA++;
				pointerB++;
			}
		}
		return true;
	}

}
