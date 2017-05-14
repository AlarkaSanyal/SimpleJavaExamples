package com.examples.SortAndSearchAlgos;

public class SparseSearch {

	public static void main(String[] args) {
		
		String[] values = {"apple", "", "", "banana", "", "cream", "dairy", "", "", "egg", "fat", "", "ice cream", "", "yolk"};
		//String[] values = {"apple", "", "", "banana", "", "", "dairy", "", "", "egg", "fat", "", "ice cream", "", "yolk"};
		//String[] values = {"", "", "", "", "", "cream", "", "", "", "", "", "", "", "", ""};
		//String[] values = {"cream", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
		//String[] values = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "cream"};
		
		System.out.println("Original");
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + ", ");
		}		
		search(values, "cream");
	}

	private static void search(String[] array, String string) {
		if (array.length > 0 && !string.isEmpty() && string != "") {
			search(array, 0, array.length - 1, "cream");
		} else {
			System.out.println("Check input array and string");
		}		
	}

	private static void search(String[] array, int low, int high, String string) {
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low)/2; // Find mid element of array
			
			if (array[mid].isEmpty()) { // If mid element is empty, find closest non-empty index and set that as mid
				int left = mid - 1;
				int right = mid + 1;
				while(true) {
					if (left < low && right > high) { // To avoid infinite loop
						break;
					} else if (left >= low && !array[left].isEmpty()) {
						mid = left;
						break;
					} else if (right <= high && !array[right].isEmpty()) {
						mid = right;
						break;
					}
					left--;
					right++;
				}
			}
			
			if (array[mid].equals(string)) { // If mid element equals string, return index.
				index = mid;
				break;
			} else if(array[mid].compareTo(string) < 0) { // Search right
				low = mid + 1;						
			} else { // Search left
				high = mid - 1;
			}
		}
		
		System.out.println();
		if (index == -1) {
			System.out.println(string + " is not found");
		} else {
			System.out.println(string + " is found at index: " + index);
		}
	}

}
