package com.examples.Search;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		// Values in the array are sorted 
		int[] values = {23, 34, 45, 56, 67, 78, 89, 100, 107, 167, 231, 267};		
		System.out.println("Original");
		for (int i : values) {
			System.out.print(i + " ");
		}
		// Search for the following values
		System.out.println("\n\n---Searching for 27---");
		b.search(27, values);
		System.out.println("---Searching for 45---");
		b.search(45, values);
		System.out.println("---Searching for 231---");
		b.search(231, values);
	}

	private void search(int val, int[] values) {
		boolean found = binarySearch(val, values, 0, values.length - 1);
		if (found) {
			System.out.println("Value " + val + " is found in array.");
		} else {
			System.out.println("Value " + val + " is not found in array.");
		}		
	}
	
	private boolean binarySearch(int i, int[] array, int low, int high) {
		boolean found = false;
		if (low <= high) {
			int mid = low + ((high - low) / 2);
			if (i == array[mid]) {
				found = true;
			} else if (i < array[mid]) {
				found = binarySearch(i, array, low, mid - 1);
			} else {
				found = binarySearch(i, array, mid + 1, high);
			}
		}
		return found;
	}
}
