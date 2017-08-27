package com.examples.StackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

	ArrayList<Stack<Integer>> stackArray = new ArrayList<Stack<Integer>> ();
	int capacity = 6;
	
	public static void main(String[] args) {
		SetOfStacks sp = new SetOfStacks();
		
		// Push
		sp.push(4);
		sp.push(7);
		sp.push(1);
		sp.push(3);
		sp.push(9);
		sp.push(8);
		sp.push(7);
		sp.push(2);
		
		sp.printStack("Original");
		
		// Peek
		System.out.println();
		System.out.println("Peek: " + sp.peek());
		
		// Pop
		sp.pop();
		sp.pop();
		sp.pop();
		
		sp.printStack("After pop");
		
		// Peek
		System.out.println();
		System.out.println("Peek: " + sp.peek());
	}
	
	public int peek() {
		Stack<Integer> lastStack = getLastStack();
		return lastStack.peek();
	}
	
	public int pop() {
		Stack<Integer> lastStack = getLastStack();
		if (stackArray.isEmpty()) {
			return 0;
		}
		int value = lastStack.pop();
		if (lastStack.isEmpty()) {
			stackArray.remove(stackArray.size() - 1);
		}
		return value;
	}
	
	public void push(int i) {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack == null || lastStack.size() == capacity) {
			Stack<Integer> stack = new Stack<Integer> ();
			stack.push(i);
			stackArray.add(stack);
		} else {
			lastStack.push(i);
		}
	}
	
	public Stack<Integer> getLastStack() {
		if (stackArray.isEmpty()) {
			return null;
		}
		return stackArray.get(stackArray.size() - 1);
	}
	
	private void printStack(String string) {
		System.out.println();
		for (Stack<Integer> st : stackArray) {
			System.out.println();
			System.out.print("Stack: ");
			for (int i : st) {
				System.out.print(i + ",");
			}
		}
	}
}
