package com.examples.ArraysAndStrings;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		RotateMatrix rm  = new RotateMatrix();
		System.out.println("Original");
		rm.printMatrix(mat);
		System.out.println();
		int[][] rotatedMat = rm.rotate(mat);
		System.out.println("Rotated");
		rm.printMatrix(rotatedMat);
	}

	private int[][] rotate(int[][] matrix) {
		RotateMatrix rm  = new RotateMatrix();
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		return matrix;
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
