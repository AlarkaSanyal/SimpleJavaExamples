package com.examples.Recursion;

import java.util.Stack;

public class ParenthesisPair {

	public static void main(String[] args) {
		ParenthesisPair pp = new ParenthesisPair();
		String s = "{{}{{{}}}{}}";
		boolean valid = pp.validate(s);
		System.out.println("Valid: " + valid);
	}

	private boolean validate(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '{') {
				stack.push(c[i]);
			} else {
				if (stack.isEmpty() || stack.peek() != '{') {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty() ? true : false;
	}

}
