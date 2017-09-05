
package com.examples.Recursion;

public class MagicIndex {

	public static void main(String[] args) {
		MagicIndex mi = new MagicIndex();
		int[] array = {-10,-5,1,2,2,3,4,7,9,12,13};
		int magicIndex=  mi.findIndex(array, 0, array.length - 1);
		System.out.println("Magic index: " + magicIndex);
	}

	private int findIndex(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		
		int midIndex = (start + end) / 2;
		if (array[midIndex] == midIndex) {
			return midIndex;
		}
		int leftIndexEnd = Math.min(midIndex - 1, array[midIndex]);
		int left = findIndex(array, start, leftIndexEnd);
		if (left >= 0) {
			return left;
		}
		
		int rightIndexStart = Math.max(midIndex + 1, array[midIndex]);
		int right = findIndex(array, rightIndexStart, end);
		
		return right;
	}

}
