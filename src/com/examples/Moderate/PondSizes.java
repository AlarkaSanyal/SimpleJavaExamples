package com.examples.Moderate;

import java.util.ArrayList;

public class PondSizes {

	public static void main(String[] args) {
		int[][] pond = {{0,2,1,0},
						{0,1,0,1},
						{1,1,0,1},
						{0,1,0,1}};
		ArrayList<Integer> pondSizes = getPonds(pond);
		System.out.println("Ponds: " + pondSizes);
	}

	private static ArrayList<Integer> getPonds(int[][] pond) {
		ArrayList<Integer> pondSizes = new ArrayList<Integer>();
		// For each element in the matrix, check if val = 0, find the ponds related 
		for (int row = 0; row < pond.length; row++) {
			for (int col = 0; col < pond[row].length; col++) {
				if (pond[row][col] == 0) {
					int size = getSize(pond, row, col);
					pondSizes.add(size);
				}
			}
		}
		return pondSizes;
	}

	private static int getSize(int[][] pond, int row, int col) {
		// Edge condition
		if (row < 0 || row >= pond.length
			|| col < 0 || col >= pond[row].length
			|| pond[row][col] != 0)
		{
			return 0;
		}
		
		int size = 1;
		pond[row][col] = -1; // Set the value to -1 for ponds which are visited
		
		// For each pond[row][col], check the 8 adjoining positions (up, down, left, right and 4 diagonals)
		for (int newRow = -1; newRow <= 1; newRow++) {
			for (int newCol = -1; newCol <= 1; newCol++) {
				size += getSize(pond, row + newRow, col + newCol);
			}
		}
		return size;
	}

}
