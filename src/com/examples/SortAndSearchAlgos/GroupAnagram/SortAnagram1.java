package com.examples.SortAndSearchAlgos.GroupAnagram;

import java.util.Arrays;

public class SortAnagram1 {

	public static void main(String[] args) {
		String[] array = {"apple", "banana", "orange", "paple", "kiwi", "care", "rangeo", "wiki"};
		System.out.println("Original array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print("\"" + array[i] + "\" ");
		}
		Arrays.sort(array, new AnagramComparator());
		System.out.println("\n\nAfter sorting:");
		for (int i = 0; i < array.length; i++) {
			System.out.print("\"" + array[i] + "\" ");
		}
	}
}
