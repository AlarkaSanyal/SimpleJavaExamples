package com.examples.Moderate;

import java.util.HashMap;

public class WordFreq {

	public static void main(String[] args) {
		String string = "The quick brown fox jumpded over the brown cat and the cat purred. The dog barked.";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map = getMap(map, string);
		System.out.println("Freq of \"the\": " + getFreq(map, "the"));
		System.out.println("Freq of \"Brown\": " + getFreq(map, "Brown"));
		System.out.println("Freq of \"cat\": " + getFreq(map, "cat"));
		System.out.println("Freq of \"horse\": " + getFreq(map, "horse"));
	}

	private static int getFreq(HashMap<String, Integer> map, String word) {
		if (map.containsKey(word.toLowerCase())) {
			return map.get(word.toLowerCase());
		}
		return -1;
	}

	private static HashMap<String, Integer> getMap(HashMap<String, Integer> map, String string) {
		String[] array = string.split(" ");
		for (String word : array) {
			word = word.toLowerCase();
			if (word.trim() != "") {
				if (!map.containsKey(word)) {
					map.put(word, 1);
				} else {
					map.put(word, map.get(word) + 1);
				}
			}
		}
		return map;
	}

}
