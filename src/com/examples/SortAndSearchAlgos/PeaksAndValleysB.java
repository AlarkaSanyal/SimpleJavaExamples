package com.examples.SortAndSearchAlgos;

public class PeaksAndValleysB {

	public static void main(String[] args) {
		
		//int[] array = {1,2,3,4,5,6,7,8,9};
		//int[] array = {9,8,7,6,5,4,3,2,1};
		int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
		
		System.out.println("Original");
		printArray(array);
		System.out.println();
		sortAlternate(array);
	}
	
	private static void sortAlternate(int[] array) {
		for (int i = 1; i < array.length; i +=2) {
			int highIndex = findHigher(array, i-1, i, i+1);
			swap(array, i, highIndex);
		}
		System.out.println("Sorted");
		printArray(array);
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int findHigher(int[] array, int i, int j, int k) {
		int valA = i >= 0 && i < array.length ? array[i] : -1;
		int valB = j >= 0 && j < array.length ? array[j] : -1;
		int valC = k >= 0 && k < array.length ? array[k] : -1;
		int high = Math.max(valA, Math.max(valB, valC));
		if (valA == high) {
			return i;
		} else if (valB == high) {
			return j;
		} else {
			return k;
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
