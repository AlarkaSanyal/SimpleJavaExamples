package com.examples.Recursion;

public class PaintFill {

	public enum Color {Red, Blue, Pink};
	
	public static void main(String[] args) {
		Color[][] screen = {{Color.Red, Color.Red, Color.Red, Color.Red, Color.Red},
							{Color.Red, Color.Red, Color.Red, Color.Pink, Color.Red},
							{Color.Pink, Color.Red, Color.Red, Color.Red, Color.Red},
							{Color.Red, Color.Red, Color.Pink, Color.Red, Color.Red},
							{Color.Red, Color.Red, Color.Red, Color.Red, Color.Pink}};
		printScreen(screen, "Original Screen");
		
		Color[][] newScreen = paintFill(screen, 1, 1, Color.Red, Color.Blue);
		printScreen(newScreen, "New Screen");
	}

	private static void printScreen(Color[][] newScreen, String message) {
		System.out.println();
		System.out.println(message);
		System.out.println();
		for (int i = 0; i < newScreen.length; i++) {
			for (int j = 0; j < newScreen[0].length; j++) {
				System.out.print(newScreen[i][j].toString() + " ");
			}
			System.out.println();
		}
	}

	private static Color[][] paintFill(Color[][] screen, int row, int col, Color oldColor, Color newColor) {
		if (row < 0 || row > screen.length - 1 || col < 0 || col > screen[0].length - 1) {
			return null;
		}
		if (screen[row][col] == oldColor) {
			screen[row][col] = newColor;
			paintFill(screen, row - 1, col, oldColor, newColor); // Up
			paintFill(screen, row + 1, col, oldColor, newColor); // Down
			paintFill(screen, row, col - 1, oldColor, newColor); // Left
			paintFill(screen, row, col + 1, oldColor, newColor); // Right
		}
		return screen;
	}

}
