package com.examples.ArraysAndStrings;

public class ZeroMatrixA {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3,4},{5,6,0,8},{9,10,11,12},{13,14,15,16}};
		ZeroMatrixA zm  = new ZeroMatrixA();
		System.out.println("Original");
		zm.printMatrix(mat);
		int[][] replaced = zm.replace(mat);
		System.out.println();
		System.out.println("Replaced");
		zm.printMatrix(replaced);
	}
	
	private int[][] replace(int[][] mat) {
		// Store the zero positions for row and column
		boolean[] row = new boolean[mat.length];
		boolean[] col = new boolean[mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				} 
			}
		}
		
		// Loop through to replace zero rows
		for (int i = 0; i < mat.length; i++) {
			if (row[i]) {
				nullifyRow(mat, i);
			}
		}
		
		// Loop through to replace zero columns
		for (int j = 0; j < mat[0].length; j++) {
			if (col[j]) {
				nullifyCol(mat, j);
			}
		}
		
		return mat;
	}

	private void nullifyCol(int[][] mat, int j) {
		for (int i = 0; i < mat.length; i++) {
			mat[i][j] = 0;
		}
	}

	private void nullifyRow(int[][] mat, int i) {
		for (int j = 0; j < mat[0].length; j++) {
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
