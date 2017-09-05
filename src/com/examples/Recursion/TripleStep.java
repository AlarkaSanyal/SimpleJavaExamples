package com.examples.Recursion;

import java.util.Arrays;

public class TripleStep {

	public static void main(String[] args) {
		TripleStep ts = new TripleStep();
		
		int count;
		System.out.println("Simple recusion");
		for (int i = 0; i <= 6; i++) {
			count = ts.countStepsSimpleRecursion(i);
			System.out.println("Combinations for " + i + " steps : " + count);
		}
		System.out.println();
		System.out.println("A little optimized");
		for (int i = 0; i <= 6; i++) {
			count = ts.countSteps(i);
			System.out.println("Combinations for " + i + " steps : " + count);
		}		
	}

	private int countSteps(int i) {
		int[] array = new int[i+1];
		Arrays.fill(array, -1);
		return countSteps(i, array);
	}

	private int countSteps(int i, int[] array) {
		if (i < 0) {
			return 0;
		// Assuming baseline for standing on step, i.e. no more steps to go is 1
		} else if (i == 0) {
			return 1;
		} else if (array[i] == -1) {
			array[i] = countSteps(i - 1, array) + countSteps(i - 2, array) + countSteps(i - 3, array);
		}
		return array[i];
	}

	private int countStepsSimpleRecursion(int i) {
		if (i < 0) {
			return 0;
		// Assuming baseline for standing on step, i.e. no more steps to go is 1
		} else if (i == 0) {
			return 1;
		} else {
			return countStepsSimpleRecursion(i -1) + countStepsSimpleRecursion(i - 2) + countStepsSimpleRecursion(i - 3);
		}
	}

}
