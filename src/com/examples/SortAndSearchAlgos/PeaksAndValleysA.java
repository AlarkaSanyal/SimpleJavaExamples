package com.examples.SortAndSearchAlgos;

import java.util.Arrays;

public class PeaksAndValleysA {

	public static void main(String[] args) {
		//int[] array = {9,1,0,4,8,7};
		//int[] array = {9,1,0,4,8,7, 4,2,8,4,6,2,6,4};
		int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
		System.out.println("Original");
		printArray(array);
		System.out.println();
		sortAlternate(array);
	}

	private static void sortAlternate(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length; i+=2) {
			swap(array, i-1, i);
		}
		System.out.println("Sorted");
		printArray(array);
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
