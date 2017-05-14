package com.examples.SortAndSearchAlgos.MatrixSearch;

public class MatrixSearchA {

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
		search(matrix, 61);
	}
	
	private static void search(int[][] matrix, int i) {
		Coordinate origin = new Coordinate(0,0);
		Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
		Coordinate found = searchInt(matrix, i, origin, dest);
		if (found != null) {
			System.out.println(i + " is found at coordinates: (" + found.row + ", " + found.col + ")");
		} else {
			System.out.println(i + " is not found in matrix");
		}
	}

	private static Coordinate searchInt(int[][] matrix, int i, Coordinate origin, Coordinate dest) {
		if (!origin.isInside(matrix) || !dest.isInside(matrix)) {
			return null;
		}
		
		if (matrix[origin.row][origin.col] == i) {
			return origin;
		} else if (!origin.isBefore(dest)) {
			return null;
		}
		
		Coordinate pivotStart = origin.clone();
		int diagonalEnd = Math.min(dest.row - origin.row, dest.col - origin.col); // Diagonal of largest square matrix
		Coordinate pivotEnd = new Coordinate(pivotStart.row + diagonalEnd, pivotStart.col + diagonalEnd);
		Coordinate avg = new Coordinate(0,0);
		
		// Using binary search to find the first element on the diagonal which is greater than i
		while (pivotStart.isBefore(pivotEnd)) {
			avg.setAverage(pivotStart, pivotEnd);
			if (i > matrix[avg.row][avg.col]) { // Pointing pivot to one block down the diagonal
				pivotStart.row = avg.row + 1;
				pivotStart.col = avg.col + 1;
			} else { // Pointing pivot to one block up the diagonal
				pivotEnd.row = avg.row - 1;
				pivotEnd.col = avg.col - 1;
			}
		}
		
		return searchQuadrant(matrix, i, origin, dest, pivotStart);
	}

	private static Coordinate searchQuadrant(int[][] matrix, int i, Coordinate origin, Coordinate dest,	Coordinate pivotStart) {
		// Setting Origin and Dest for sub-block left & lower of pivot
		Coordinate lowerLeftOrigin = new Coordinate(pivotStart.row, origin.col);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivotStart.col - 1);
		// Setting Origin and Dest for sub-block right & upper of pivot
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivotStart.col);
		Coordinate upperRightDest = new Coordinate(pivotStart.row - 1, dest.col);
		
		// Searching the left sub-block
		Coordinate found = searchInt(matrix, i, lowerLeftOrigin, lowerLeftDest);
		if (found == null) {
			// Searching the right sub-block
			found = searchInt(matrix, i, upperRightOrigin, upperRightDest);
		}
		
		return found;
	}
}
