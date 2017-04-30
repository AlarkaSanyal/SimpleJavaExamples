package com.examples.Sort;

import java.util.Arrays;

public class QuickSort {

	int[] array;
	int length;
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		// Sorting an array of 20 elements
		int[] values = new int[20];
		for (int i = 0; i < 20; i++) {
			values[i] = (int) (Math.random()* 100);
		}
		q.sort(values);
	}

	private void sort(int[] values) {
		array = values;
		length = array.length;
		System.out.println("Original");
		for (int i : array) {
			System.out.print(i + " ");
		}
		quickSort(0, length - 1);
		System.out.println("\nSorted");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	private void quickSort(int start, int end) {
		if (end > start) {
			int partitionIndex = partition(start, end);
			// Sort left of pivot
			quickSort(start, partitionIndex - 1);
			// Sort right of pivot
			quickSort(partitionIndex + 1, end);
		}
	}

	private int partition(int start, int end) {
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (array[i] <= array[end]) {
				// Swap values
				swap(i, pIndex);
				pIndex++;
			}
		}
		swap(pIndex, end);
		return pIndex;
	}

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}	
}
