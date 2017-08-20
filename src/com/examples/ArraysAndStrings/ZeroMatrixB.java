package com.examples.ArraysAndStrings;

public class ZeroMatrixB {

	public static void main(String[] args) {
		int[][] mat = {{0,2,3,4},{5,6,0,8},{9,10,11,12},{13,14,15,16}};
		ZeroMatrixB zm  = new ZeroMatrixB();
		System.out.println("Original");
		zm.printMatrix(mat);
		int[][] replaced = zm.replace(mat);
		System.out.println();
		System.out.println("Replaced");
		zm.printMatrix(replaced);
	}
	
	private int[][] replace(int[][] mat) {
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		// First column has a zero
		for (int i = 0; i < mat.length; i++) {
			if (mat[i][0] == 0) {
				colHasZero = true;
				break;
			} 
		}
		
		// First row has a zero
		for (int j = 0; j < mat[0].length; j++) {
			if (mat[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		// Set the first row and column values to zero for the rest of the matrix
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}
		
		// Set the rest of matrix with zeros based on first row
		for (int j = 1; j < mat[0].length; j++) {
			if (mat[0][j] == 0) {
				nullifyCol(mat, j);
			}
		}
		
		// Set rest of the matrix with zeros based on first column
		for (int i = 1; i < mat.length; i++) {
			if (mat[i][0] == 0) {
				nullifyRow(mat, i);
			}
		}
		
		if (rowHasZero) {
			nullifyRow(mat, 0);
		}
		
		if (colHasZero) {
			nullifyCol(mat, 0);
		}
		
		return mat;
	}

	private void nullifyCol(int[][] mat, int j) {
		for (int i = 1; i < mat.length; i++) {
			mat[i][j] = 0;
		}
	}

	private void nullifyRow(int[][] mat, int i) {
		for (int j = 1; j < mat[0].length; j++) {
			mat[i][j] = 0;
		}
	}

	private void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
