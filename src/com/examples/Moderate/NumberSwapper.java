package com.examples.Moderate;

public class NumberSwapper {

	int a = 5;
	int b = 3;
	
	public static void main(String[] args) {
		NumberSwapper ns = new NumberSwapper();
	
		// Initial
		ns.printNumbers("Initial");
		ns.swap();
		// After swap
		ns.printNumbers("After swap");
	}

	private void swap() {
		 	a = a + b;
		 	b = a - b;
		 	a = a - b;
	}

	private void printNumbers(String message) {
		System.out.println();
		System.out.println(message);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	
	

}
