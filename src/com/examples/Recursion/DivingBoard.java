package com.examples.Recursion;

import java.util.ArrayList;

public class DivingBoard {

	public static void main(String[] args) {
		int k = 5;
		int smaller = 2;
		int bigger = 3;
		
		ArrayList<Integer> lengths = new ArrayList<Integer> ();
		lengths = findAllLengths(k, smaller, bigger, lengths);
		System.out.println(lengths.toString());
	}

	// {(0 of A) + (k of B)},{(1 of A) + (k-1 of B)},{(2 of A) + (k-2 of B)}...
	private static ArrayList<Integer> findAllLengths(int k, int smaller, int bigger, ArrayList<Integer> lengths) {
		
		for (int newSmaller = 0; newSmaller <= k; newSmaller++) {
			int newBigger = k - newSmaller;
			int length = newSmaller * smaller + newBigger * bigger;
			lengths.add(length);
		}
		return lengths;
	}

}
