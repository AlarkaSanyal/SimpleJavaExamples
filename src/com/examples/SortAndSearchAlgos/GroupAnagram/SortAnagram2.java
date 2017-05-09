package com.examples.SortAndSearchAlgos.GroupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SortAnagram2 {
	
	HashMap<String, ArrayList<String>> map = new HashMap<>();
	String[] array;

	public static void main(String[] args) {
		SortAnagram2 sa = new SortAnagram2();
		String[] arr = {"apple", "banana", "orange", "paple", "kiwi", "care", "rangeo", "wiki"};
		System.out.println("Original array:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("\"" + arr[i] + "\" ");
		}
		sa.sort(arr);		
	}

	private void sort(String[] arr) {
		array = arr;
		
		// Group up the strings in the HashMap
		for (int i = 0; i < array.length; i++) {
			add(array[i]);
		}
		
		// Build the sorted array
		int j = 0;
		for (String key : map.keySet()) {
			for (String s : map.get(key)) {
				array[j] = s;
				j++;
			}
		}
		
		System.out.println("\n\nAfter sorting:");
		for (int i = 0; i < array.length; i++) {
			System.out.print("\"" + array[i] + "\" ");
		}
	}
	
	private void add(String s) {
		ArrayList<String> arrayList;
		if (map.containsKey(sortWord(s))) {
			if (map.get(sortWord(s)) == null) {
				arrayList = new ArrayList<String>();
				arrayList.add(s);
			} else {
				arrayList = map.get(sortWord(s));
				arrayList.add(s);
			}
		} else {
			arrayList = new ArrayList<String>();
			arrayList.add(s);			
		}
		map.put(sortWord(s), arrayList);
	}

	private String sortWord(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
