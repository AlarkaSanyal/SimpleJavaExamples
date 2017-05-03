package com.examples.SortAndSearchAlgos;
/*
 * Given 2 sorted arrays A & B, where A has a large enough buffer at the end to hold B,
 * merge B into A in sorted order without using any buffer or additional memory.
 */
public class SortedMerge {
	
	int[] arrayA;
	int[] arrayB;

	public static void main(String[] args) {
		SortedMerge sm = new SortedMerge();
		// Assuming that the buffer at the end of A is equal to the size of B
		int[] valuesA = {23, 34, 45, 50, 67, 0, 0, 0, 0, 0};
		int[] valuesB = {21, 37, 38, 50, 55};
		
		System.out.println("Array A");
		for (int i = 0; i < valuesA.length; i++) {
			System.out.print(valuesA[i] + " ");
		}
		System.out.println("\nArray B");
		for (int i = 0; i < valuesB.length; i++) {
			System.out.print(valuesB[i] + " ");
		}
		
		if (valuesA.length < valuesB.length) {
			System.out.println("\nArray A is smaller than array B");
		} else {
			sm.merge(valuesA, valuesB, valuesA.length, valuesB.length);
		}
	}

	private void merge(int[] valuesA, int[] valuesB, int lengthA, int lengthB) {
		arrayA = valuesA;
		arrayB = valuesB;
		
		int ptrA = lengthA - lengthB - 1; // To point the actual last value of array A
		int ptrB = lengthB - 1; // To point the last value of array B
		int ptrC = lengthA - 1; // To point the end of array A including buffer
		
		while (ptrB >= 0 && ptrA >= 0) {
			if (arrayA[ptrA] > arrayB[ptrB]) {
				arrayA[ptrC] = arrayA[ptrA];
				ptrA--;
			} else {
				arrayA[ptrC] = arrayB[ptrB];
				ptrB--;
			}
			ptrC--;
		}
		
		// This is required in case array B has values smaller than the smallest value in array A,
		// in which case, ptrA will become -1 from the previous loop and exit 
		while (ptrB >= 0) {
			arrayA[ptrC] = arrayB[ptrB];
			ptrB--;
			ptrC--;
		}
		
		System.out.println("\n\nMerged sorted array");
		for (int i = 0; i < arrayA.length; i++) {
			System.out.print(arrayA[i] + " ");
		}
	}

}
