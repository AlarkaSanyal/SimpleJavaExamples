package com.examples.Recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotGrid {

	public static void main(String[] args) {
		RobotGrid rg = new RobotGrid();
		boolean[][] grid = {{true, true, false, true},
							{true, true, true, true},
							{true, false, true, false},
							{true, true, false, true},
							{false, true, true, true},
							{true, true, true, true}};
		ArrayList<Box> path = rg.findPath(grid);
		if (path != null) {
			for (int i = 0; i < path.size(); i++) {
				System.out.print("(" + path.get(i).row + "," + path.get(i).col + "), ");
			}		
		} else {
			System.out.println("Path not found");
		}
	}

	private ArrayList<Box> findPath(boolean[][] grid) {
		if (grid == null) {
			return null;
		}
		if (grid.length == 0 && grid[0].length == 0) {
			return null;
		}
		ArrayList<Box> path = new ArrayList<Box> ();
		HashSet<Box> visited = new HashSet<Box>();
		if (findPath(grid, (grid.length - 1), (grid[0].length - 1), path, visited)) {
			return path;
		}
		return null;
	}

	private boolean findPath(boolean[][] grid, int row, int col, ArrayList<Box> path, HashSet<Box> visited) {
		// If obstacle is hit, return false
		if (row < 0 || col < 0 || !grid[row][col]) {
			return false;
		}
		
		Box b = new Box(row, col);
		
		// If box is already visited and did not result in a through path, as the hashset comment says below
		// there is no point in moving forward. Return false. 
		if (visited.contains(b)) {
			return false;
		}
		
		// Return true when Origin is reached while backtracking
		boolean isOrigin = (row == 0) && (col == 0);
		
		// Recursive call
		if (isOrigin ||
			findPath(grid, row, col - 1, path, visited) ||
			findPath(grid, row - 1, col, path, visited)
		) {
			path.add(b); // Adds the boxes of path traversal
			return true;
		}
		visited.add(b); // Adds the boxes which have already been visited but DID NOT result in a through path
		return false;
	}

	class Box {
		int row;
		int col;
		
		public Box(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}
}
