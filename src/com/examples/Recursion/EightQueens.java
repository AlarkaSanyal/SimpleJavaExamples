package com.examples.Recursion;

public class EightQueens {
	
	boolean[][] board = {{false,false,false,false,false,false,false,false},
                         {false,false,false,false,false,false,false,false},
                         {false,false,false,false,false,false,false,false},
                         {false,false,false,false,false,false,false,false},
                         {false,false,false,false,false,false,false,false},
                         {false,false,false,false,false,false,false,false},
                         {false,false,false,false,false,false,false,false},
                         {false,false,false,false,false,false,false,false}};
	static boolean done = false;
	
	public static void main(String[] args) {
		
		EightQueens eq = new EightQueens();
		
		// placeQueens(chess board, row, number of queens to be placed);
		placeQueens(eq.board, 0, 8);		
	}

	private static void placeQueens(boolean[][] board, int row, int n) {
		for (int col = 0; col < n; col++) {
			if (safeToPlace(board, row, col, n)) {
				board[row][col] = true; // Place Queen
				if ((row+1) == n && !EightQueens.done) {
					printBoard(board, "Queens Placed");// Print board
					EightQueens.done = true; // Done
				} else {
					placeQueens(board, row + 1, n);
					board[row][col] = false;
				}
			}			
		}		
	}

	private static boolean safeToPlace(boolean[][] board, int row, int col, int n) {
		// Check column on top for {row = 1 to row = (row - 1)}
		for (int i = 0; i < row; i++) {
			if (board[i][col]) {
				return false;
			}
		}
		// Check row on left for {column = 1 to column = (column - 1)}
		for (int i = 0; i < col; i++) {
			if (board[row][i]) {
				return false;
			}
		}
		// Check left diagonal for rows on top
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}
		// Check right diagonal for rows on top
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}
		return true;
	}
	
	private static void printBoard(boolean[][] newBoard, String message) {
		System.out.println();
		System.out.println(message);
		System.out.println();
		for (int i = 0; i < newBoard.length; i++) {
			for (int j = 0; j < newBoard[0].length; j++) {
				if (newBoard[i][j]) {
					System.out.print("O ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
}
