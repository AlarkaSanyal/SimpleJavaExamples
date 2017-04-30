package com.examples.Sort;

import java.util.ArrayList;

public class RadixSort {

	int[] array;
	ArrayList<ArrayList<Integer>> bucket;
	int length;
	
	public static void main(String[] args) {
		RadixSort r = new RadixSort();
		// Sorting an array of 20 elements
		int[] values = new int[20];
		for (int i = 0; i < 20; i++) {
			values[i] = (int) (Math.random() * 1000);
		}
		r.sort(values);		
	}

	private void sort(int[] values) {
		array = values;
		length = array.length;
		int max = findMax(array);
		resetBucket();
		System.out.println("Original");
		for (int x : array) {
			System.out.print(x + " ");
		}
		for (int i = 1; max/i > 0; i*=10) {
			radixSort(i);
			resetBucket();
		}
		System.out.println("\nSorted");
		for (int x : array) {
			System.out.print(x + " ");
		}
	}
	
	private void resetBucket() {
		bucket = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10; i++) {
			bucket.add(i, new ArrayList<Integer>());
		}
	}

	private void radixSort(int i) {
		for (int value : array) {
			// Get index of bucket to put value into
			int bucketIndex = (value/i)%10;
			// Get the arrayList from 0th to 10th bucket
			ArrayList<Integer> temp = bucket.get(bucketIndex);
			// Add the value to correct bucket arrayList
			temp.add(value);
		}
		int index = 0;
		for (ArrayList<Integer> buck : bucket) {
			for (int val : buck) {
				array[index] = val;
				index++;
			}
		}
	}

	private int findMax(int[] arr) {
		int max = arr[0];
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

}
