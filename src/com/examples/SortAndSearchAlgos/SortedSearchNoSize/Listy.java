package com.examples.SortAndSearchAlgos.SortedSearchNoSize;

public class Listy {

	private int[] array;
	
	public Listy (int[] arr) {
		array = arr;
	}
	
	public int elementAt(int i) {
		if (i < 0 || i > array.length - 1) {
			return -1;
		}
		return array[i];
	}
}
