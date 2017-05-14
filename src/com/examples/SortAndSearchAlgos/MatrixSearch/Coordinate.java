package com.examples.SortAndSearchAlgos.MatrixSearch;

public class Coordinate {

	public int row;
	public int col;
	
	public Coordinate(int r, int c) {
		row = r;
		col = c;
	}
	
	public boolean isInside(int[][] matrix) {
		return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length);
	}
	
	public Coordinate clone() {
		return new Coordinate(row, col);
	}

	public boolean isBefore(Coordinate c) {
		return row <= c.row && col <= c.col;
	}

	public void setAverage(Coordinate start, Coordinate end) {
		row = start.row + (end.row - start.row)/2;
		col = start.col + (end.col - start.col)/2;
	}
}
