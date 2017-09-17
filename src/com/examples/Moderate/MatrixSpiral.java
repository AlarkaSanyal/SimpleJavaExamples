package com.examples.Moderate;

public class MatrixSpiral {

	public static void main(String[] args) {
		String[][] matrix= {{"a","b","c","d"},
							{"e","f","g","h"},
							{"i","j","k","l"},
							{"m","n","o","p"}};
		
		printSpiralInward(matrix);
	}

	private static void printSpiralInward(String[][] matrix) {
		int row = matrix.length;
		int col=  matrix[0].length;
		
		int rowFirst = 0;
		int colFirst = 0;
		
		int rowLast = row - 1;
		int colLast = col - 1;
		
		while (rowFirst <= rowLast && colFirst <= colLast) {
			// Print top row, left to right
			for(int i = colFirst; i <= colLast; i++) {
				System.out.print(matrix[rowFirst][i] + ", ");
			}
			rowFirst++;
			
			// Print last col, top to bottom
			for (int i = rowFirst; i <= rowLast; i++) {
				System.out.print(matrix[i][colLast] + ", ");
			}
			colLast--;
			
			// Print last row, right to left
			for (int i = colLast; i >= colFirst; i--) {
				System.out.print(matrix[rowLast][i] + ", ");
			}
			rowLast--;
			
			// Print first col, bottom to top
			for (int i = rowLast; i >= rowFirst; i--) {
				System.out.print(matrix[i][colFirst] + ", ");
			}
			colFirst++;
		}
		
	}

}
