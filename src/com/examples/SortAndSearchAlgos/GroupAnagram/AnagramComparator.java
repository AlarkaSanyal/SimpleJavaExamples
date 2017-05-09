package com.examples.SortAndSearchAlgos.GroupAnagram;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {

	private String sortWord(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	@Override
	public int compare(String str1, String str2) {
		return sortWord(str1).compareTo(sortWord(str2));
	}

}
