package com.examples.Recursion;

import java.util.ArrayList;

public class PowerSet {

	/*	Step 1 -> For set {_}: {_} i.e. NULL set has NULL subset
		Step 2 -> For set {0} : {{_} + ------------> part A (from previous step)
								 {_,0}} -----------> part B (for each of Step 1, add the new value "0")
							  == {{_},{_,0}} i.e. (Step 1) + for each of Step 1, add the new value "0"
							  
		Step 3 -> For set {0,1} : {{_},  {_,0} + ------------> part A (from previous step)
								   {_,1},{_,0,1}} -----------> part B (for each of Step 2, add the new value "1")
							  == {{_},{_,0},{_,1},{_,0,1}} i.e. (Step 2) + for each of Step 2, add the new value "1"
							  
		Step 4 -> For set {0,1,2}: {{_},  {_,0},  {_,1},  {_,0,1} + ------------> part A (from previous step)
									{_,2},{_,0,2},{_,1,2},{_,0,1,2}} -----------> part B (for each of Step 3, add the new value "2")
							  == {{_},{_,0},{_,1},{_,0,1},{_,2},{_,0,2},{_,1,2},{_,0,1,2}} i.e. (Step 3) + for each of Step 3, add the new value "2"
	*/
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			array.add(i);
		}
		ArrayList<ArrayList<Integer>> powerSet = powerSet(array, array.size() - 1);
		System.out.println(powerSet);
	}

	private static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> array, int index) {
		ArrayList<ArrayList<Integer>> allSubs;
		
		// For base case, i.e. null set, add null subset
		if (index < 0) { // Step 1 from above
			allSubs = new ArrayList<ArrayList<Integer>>();
			allSubs.add(new ArrayList<Integer>()); // Adding NULL subset
		} else {
			allSubs = powerSet(array, index - 1); // ---> Building part A from above
			int itemAtIndex = array.get(index);
			ArrayList<ArrayList<Integer>> moreSubs = new ArrayList<ArrayList<Integer>>(); // ---> Building part B from above
			for (ArrayList<Integer> subset : allSubs) {
				ArrayList<Integer> newSubSet = new ArrayList<Integer>();
				newSubSet.addAll(subset);
				newSubSet.add(itemAtIndex);
				moreSubs.add(newSubSet);
			}
			allSubs.addAll(moreSubs); // Adding part A & B
		}
		return allSubs;
	}

}
