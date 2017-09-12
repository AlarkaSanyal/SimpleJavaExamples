package com.examples.Moderate;

public class TicTacToe {

	int[][] board = {{0, 0, 1},
			         {1, 1, 0},
			         {1,-1, 0}};
	
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		boolean winner1 = ttt.isWinner(1, 1, 1);
		System.out.println("1 is winer: "+ winner1);
		boolean winner2 = ttt.isWinner(2, 2, 0);
		System.out.println("0 is winer: "+ winner2);
	}

	private boolean isWinner(int row, int col, int user) {
		if (rowWin(row, col, user) || colWin(row, col, user) || diagWin(row, col, user)) {
			return true;
		}				
		return false;
	}

	private boolean diagWin(int row, int col, int user) {
		// If last placed point is not on the diagonal, return false
		int diff = Math.abs(row - col);
		if (diff == 0 || diff == 3) { // On a diagonal
			return leftDiagWin(row, col, user) || rightDiagWin(row, col, user);
		}
		return false;
	}
	
	private boolean rightDiagWin(int row, int col, int user) {
		int len = board.length;
		// Check right diagonal
		for (int i  = 0, j = len - 1; i < len && j >= 0; i++, j--) {
			if (board[i][j] != user) {
				return false;
			}
		}
		return true;
	}

	private boolean leftDiagWin(int row, int col, int user) {
		// Check left diagonal
		for (int i  = 0; i < board.length; i++) {
			if (board[i][i] != user) {
				return false;
			}
		}
		return true;
	}

	private boolean colWin(int row, int col, int user) {
		// Check column
		for (int i  = 0; i < board.length; i++) {
			if (board[i][col] != user) {
				return false;
			}
		}
		return true;
	}

	private boolean rowWin(int row, int col, int user) {
		// Check row
		for (int i  = 0; i < board[0].length; i++) {
			if (board[row][i] != user) {
				return false;
			}
		}
		return true;
	}

}
