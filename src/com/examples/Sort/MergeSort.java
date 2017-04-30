package com.examples.Sort;

public class MergeSort {
	
	int[] array;
	int[] helper;
	int length;

	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		// Sorting an array of length 20
		int[] values = new int[20];
		for (int i = 0; i < 20; i++) {
			values[i] = (int) (Math.random() * 10);
		}
		m.sort(values);
	}
	

	private void sort(int[] values) {
		array = values;
		length = array.length;
		helper = new int[length];
		System.out.println("Before");
		for (int i : array) {
			System.out.print(i + " ");
		}
		mergeSort(0, length - 1);
		System.out.println("\nAfter Sorting");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	private void mergeSort(int low, int high) {
		if (low < high) {
			int midPoint = (low + high) / 2;
			mergeSort(low, midPoint);
			mergeSort(midPoint + 1, high);
			merge(low, midPoint, high);
		}		
	}

	private void merge(int low, int midPoint, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		int i = low;
		int j = midPoint + 1;
		int k = low;
		while (i <= midPoint && j <= high) {
			if (helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		while (i <= midPoint) {
			array[k] = helper[i];
			i++;
			k++;
		}
	}
}
