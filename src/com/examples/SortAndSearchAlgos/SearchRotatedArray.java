package com.examples.SortAndSearchAlgos;

public class SearchRotatedArray {

	int[] array;
	
	public static void main(String[] args) {
		SearchRotatedArray sra = new SearchRotatedArray();
		
		int[] values = {10, 12, 15, 20, 25, 2, 4, 5, 10, 10};
		//int[] values = {2,0,1,2,2,2,2,2,2,2}; // Case where low = mid = high & 0,1 present in left half
		//int[] values = {2,2,2,2,2,0,1,2,2}; // Case where low = mid = high & 0,1 present in right half
		//int[] values = {10, 12, 15, 20, 25, 1, 2, 2, 4, 5, 7, 9}; // Case where right half is sorted normally
		//int[] values = {10, 12, 15, 20, 22, 25, 4, 5, 7, 9}; // Case where left half is sorted normally
		//int[] values = {9, 12, 15, 2, 4, 5, 9, 9};
		//int[] values = {9, 9, 9, 9, 4, 5, 6, 9};
		
		System.out.println("Original");
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println("\n");
		sra.searchRotated(values, 0);
		sra.searchRotated(values, 1);
		sra.searchRotated(values, 2);
		sra.searchRotated(values, 4);
		sra.searchRotated(values, 7);
		sra.searchRotated(values, 9);
		sra.searchRotated(values, 10);
		sra.searchRotated(values, 15);		
	}

	private void searchRotated(int[] values, int i) {
		array = values;
		int found = search(0, array.length - 1, i);
		if (found == -1) {
			System.out.println(i + " is not found.");
		} else {
			System.out.println("Found value " + i + " at index: " + found);
		}
	}
	
	private int search(int low, int high, int val) {
		if (low <= high) {
			int mid = low + (high - low) / 2;		
			if (array[mid] == val) {
				return mid;
			} else {
				// If left half is ordered normally
				if (array[low] < array[mid]) {
					if (val >= array[low] && val < array[mid]) { // If val falls within the left half
						return search(low, mid - 1, val); // Search the left half
					} else {
						return search(mid + 1, high, val); // Search the right half
					}
				// If right half is ordered normally
				} else if (array[mid] < array[high]) {
					if (val > array[mid] && val <= array[high]) { // If val falls within the right half
						return search(mid + 1, high, val); // Search the right half
					} else {
						return search(low, mid - 1, val); // Search the left half
					}
				} else {
					if (array[low] == array[mid]) { // Left half has all duplicates
						if (array[mid] != array[high]) { // Search the right half
							return search(mid + 1, high, val);
						} else { // Search both left & right halves
							int found = search(low, mid - 1, val);
							if (found == -1) {
								found = search(mid + 1, high, val);
							}
							return found;
						}
					}
				}
			}
		}
		return -1;
	}	
}
