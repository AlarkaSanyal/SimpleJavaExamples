package com.examples.Moderate;

import java.util.Arrays;

public class PairWithSum {

	public static void main(String[] args) {
		int[] array = {3, 5, 6, 1, 2, 9, -3, 0, 7, -5, 8};
		printPairs(array, 5);
	}

	private static void printPairs(int[] array, int target) {
		// Sort the array
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int sum = array[first] + array[last];
			if (sum == target) {
				System.out.println(array[first] + ", "+ array[last]);
			}
			// If SUM is less than target, move the "first" because
			// moving the "last" would yield TARGET even smaller.
			// This is only because the array is now sorted.
			if (sum < target) {
				first++;
			} else {
				last--;
			}
		}
	}

}
