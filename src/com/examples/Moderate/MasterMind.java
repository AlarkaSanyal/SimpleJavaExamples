package com.examples.Moderate;

import java.util.ArrayList;
import java.util.List;

public class MasterMind {

	public static void main(String[] args) {
		MasterMind mm = new MasterMind();
		String slots = "RBYG";
		String guess = "BRBG";
		Result result = mm.findResult(slots, guess);
		System.out.println("Slots: " + slots);
		System.out.println("Guess: " + guess);
		System.out.println("Hits: " + result.hits + ", PseudoHits: " + result.pseudoHits);
	}

	private Result findResult(String slots, String guess) {
		if (slots.length() != guess.length()) {
			return null;
		}
		
		List<Character> slotsList = getList(slots.toCharArray());
		List<Character> guessList = getList(guess.toCharArray());
		
		int hits = getHits(slotsList, guessList);
		int pseudoHits = getPseudoHits(slotsList, guessList);
		return new Result(hits, pseudoHits);
	}

	private static List<Character> getList(char[] array) {
		List<Character> list = new ArrayList<Character>();
		for (char c : array) {
			list.add(c);
		} 
		return list;
	}

	private static int getPseudoHits(List<Character> slotsList, List<Character> guessList) {
		int count = 0;
		List<Character> visited = new ArrayList<Character>();
		for (int i = 0; i < slotsList.size(); i++) {
			int indexOfChar = slotsList.indexOf(guessList.get(i));
			if (!visited.contains(guessList.get(i))
				&& slotsList.contains(guessList.get(i))
				&& slotsList.get(indexOfChar) != guessList.get(indexOfChar))
			{
				count++;
				visited.add(guessList.get(i));
			}
		}		
		return count;
	}

	private static int getHits(List<Character> slots, List<Character> guess) {
		int count = 0;
		for (int i = 0; i < slots.size(); i++) {
			if (slots.get(i) == guess.get(i)) {
				count++;
			}
		}
		return count;
	}

	class Result {
		int hits = 0;
		int pseudoHits = 0;
		
		public Result(int hits, int pseudoHits) {
			this.hits = hits;
			this.pseudoHits = pseudoHits;
		}
	}
}
