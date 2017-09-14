package com.examples.Recursion;

public class Operations {

	public static void main(String[] args) {
		int a = 3;
		int b = -7;
		int subtraction = subtract(a, b);
		System.out.println("a - b = " + subtraction);
		int multiplication = multiply(a, b);
		System.out.println("a * b = " + multiplication);
		int division = divide(b, a);
		System.out.println("b / a = " + division);
	}

	// if (b / a) = x, then b = (x * a)
	// We know (x * a) = (a + a + a + ...) upto "x" times
	// We loop through and keep adding "a" to itself till the sum is less than "b"
	private static int divide(int b, int a) throws ArithmeticException {
		if (a == 0) {
			throw new ArithmeticException();
		}
		if (b == 0) {
			return 0;
		}
		
		int absA = abs(a);
		int absB = abs(b);
		
		int val = 0;
		int counter = 0;
		while (val + absA < absB) { // Add val to absA such that it does not go over the expected value
			counter++;
			val += absA;			
		}
		if ((a < 0 && b > 0) || (b < 0 && a > 0)) {
			return negate(counter);
		}
		return counter;
	}

	// (a * b) = (b + b + b + ...) upto "a" times
	private static int multiply(int a, int b) {
		// If either is zero, return 0
		if (a == 0 || b == 0) {
			return 0;
		}
		// It is smaller number of additions for  a times b, than b times a, when a is smaller than b.
		if (b < a) {
			return multiply(b, a);
		}	
		int multi = 0;
		int newA = abs(a);
		for (int i = 0; i < newA; i++) {
			multi += b;
		}
		if (a < newA) {
			return negate(multi);
		}
		return multi;
	}

	private static int abs(int i) {
		if (i < 0) {
			return negate(i);
		}
		return i;
	}

	private static int subtract(int a, int b) {
		return a + negate(b);
	}

	// Flip the sign of a number
	private static int negate(int b) {
		int negateB = 0;
		int sign = b > 0 ? -1 : 1; // i.e. if b is +ve, set sign = -1
		while (b != 0) {
			negateB += sign;
			/* if (b > 0) {
				b--;
			} else {
				b++;
			} */
			// Above comented out section in short
			b += sign;
		}
		return negateB;
	}

}
