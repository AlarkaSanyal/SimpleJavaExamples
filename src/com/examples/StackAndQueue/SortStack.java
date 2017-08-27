package com.examples.StackAndQueue;

import java.util.Stack;

public class SortStack {

	Stack<Integer> stack;
	
	public static void main(String[] args) {
		SortStack ss = new SortStack();
		ss.stack = new Stack<Integer>();
		ss.stack.push(3);
		ss.stack.push(1);
		ss.stack.push(6);
		ss.stack.push(4);
		ss.stack.push(7);
		ss.stack.push(2);
		ss.stack.push(9);
		
		ss.printStack("Original");
		
		ss.sortStack();
		
		ss.printStack("Sorted");
	}

	private void sortStack() {
		Stack<Integer> helper = new Stack<Integer>();
		int temp;
		while (!stack.isEmpty()) {
			// Store current value in temp
			temp = stack.pop();
			
			// Move the bigger values from helper to original
			while (!helper.isEmpty() && helper.peek() < temp) {
				stack.push(helper.pop());
			}
			
			// Push the temp value on top of helper
			helper.push(temp);
		}
		
		// Move everything to original array for ascending order
		while (!helper.isEmpty()) {
			stack.push(helper.pop());
		}		
	}

	private void printStack(String message) {
		System.out.println();
		System.out.println(message);
		for (int i : stack) {
			System.out.print(i + ",");
		}
	}

}
