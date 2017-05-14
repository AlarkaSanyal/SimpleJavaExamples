package com.examples.SortAndSearchAlgos.MatrixSearch;

public class MatrixSearchB {

	public static void main(String[] args) {
		int[][] matrix = {
				{15,20,31,35,39,45,46},
				{25,35,36,37,40,47,48},
				{30,41,42,43,45,50,51},
				{40,43,45,48,50,52,53},
				{42,45,50,52,55,60,61}
			};

			System.out.println("Original");
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			search(matrix, 43);
	}

	private static void search(int[][] matrix, int x) {
		int row = 0;
		int column = matrix[0].length - 1;
		boolean found = false;
		while (row < matrix.length && column >= 0) {
			if (x == matrix[row][column]) {
				found = true;
				break;
			}
			if (matrix[row][column] > x) {
				column--;
			}
			if (matrix[row][column] < x) {
				row++;
			}			
		}
		if (found) {
			System.out.println(x + " is found at coordinates: (" + row + ", " + column + ")");
		} else {
			System.out.println(x + " is not found in matrix");
		}
	}
}
