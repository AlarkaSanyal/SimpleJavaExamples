package com.examples.Moderate;

import java.util.Arrays;

public class SmallestDifference {

	public static void main(String[] args) {
		int[] array1 = {1,15,2,11};
		int[] array2 = {127,235,19,23,12,4};

		findMin(array1, array2);
	}

	private static void findMin(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		while (i < array1.length && j < array2.length) {
			int newMin = Math.abs(array1[i] - array2[j]);
			if (newMin == 0) {
				min = newMin;
				break;
			} else if (newMin < min) {
				min = newMin;
			}
			if (array1[i] < array2[j]) {
				i++;
			} else {
				j++;
			}
		}
		System.out.println("Min difference: " + min);
	}

}
