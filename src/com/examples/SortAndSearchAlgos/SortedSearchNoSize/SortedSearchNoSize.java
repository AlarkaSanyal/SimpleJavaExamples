package com.examples.SortAndSearchAlgos.SortedSearchNoSize;

public class SortedSearchNoSize {

	public static void main(String[] args) {
		
		SortedSearchNoSize ss = new SortedSearchNoSize();
		
		int[] values = {2,4,5,6,7,9,11,14,17,25,36};
		
		System.out.println("Original");
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
		Listy list = new Listy(values);
		
		ss.searchList(list, 2);
		ss.searchList(list, 6);
		ss.searchList(list, 8);
		ss.searchList(list, 9);
		ss.searchList(list, 17);
		ss.searchList(list, 36);
		ss.searchList(list, 50);
	}

	private void searchList(Listy list, int i) {
		int index = 1;
		boolean found = false;
		if (list.elementAt(0) == i) {
			index = 0;
			found = true;
		} else {
			while (list.elementAt(index) != -1 && i >= list.elementAt(index) ) {
				if (list.elementAt(index) == i) {
					found = true;
					break;
				} else {
					index *= 2;
				}
			}
		}
		if (found) {
			System.out.println(i + " is found at index: " + index);
		} else {
			index = search(list, index/2, index, i);
			if (index > 0) {
				System.out.println(i + " is found at index: " + index);
			} else {
				System.out.println(i + " is not found");
			}
		} 
	}

	private int search(Listy list, int low, int high, int i) {
		int mid = low + (high - low) / 2;
		if (low <= high) {
			if (list.elementAt(mid) == i) {
				return mid;
			} else if (i < list.elementAt(mid) || list.elementAt(mid) == -1) {
				return search(list, low, mid - 1, i);
			} else {
				return search(list, mid + 1, high, i);
			}
		}
		return -1;
	}
}
