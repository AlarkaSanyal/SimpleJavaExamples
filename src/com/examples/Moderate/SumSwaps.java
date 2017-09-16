package com.examples.Moderate;

import java.util.ArrayList;

public class SumSwaps {

	public static void main(String[] args) {
		int[] arr1 = {4,1,2,1,1,2};
		int[] arr2 = {3,6,3,3};
		
		ArrayList<Integer> pair = findPair(arr1, arr2);
		System.out.println("Pair: "+ pair);
	}

	private static ArrayList<Integer> findPair(int[] arr1, int[] arr2) {
		ArrayList<Integer> pair = new ArrayList<Integer>();
		int sum1 = getSum(arr1);
		int sum2 = getSum(arr2);
		int target = (sum1 - sum2)/2;
		ArrayList<Integer> arrList1 = new ArrayList<Integer>();
		for (int i =0; i < arr1.length; i++) {
			arrList1.add(arr1[i]);
		}
		for (int j = 0; j < arr2.length; j++) {
			int temp = arr2[j] + target;
			if (arrList1.contains(temp)) {
				pair.add(arr2[j]);
				int arr1Val = arrList1.indexOf(temp);
				pair.add(arr1Val);
				break;
			}
		}
		return pair;
	}

	private static int getSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
