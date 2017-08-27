package com.examples.StackAndQueue;

import java.util.Stack;

public class QueueViaStack {

	Stack<Integer> newStack;
	Stack<Integer> oldStack;
	
	public static void main(String[] args) {
		QueueViaStack qvs = new QueueViaStack();
		qvs.newStack = new Stack<Integer> ();
		qvs.oldStack = new Stack<Integer> ();
		
		// Push
		qvs.push(3);
		qvs.push(1);
		qvs.push(5);
		qvs.push(4);
		qvs.printStack("Original");
		
		// Peek
		System.out.println();
		System.out.println("Peek: " + qvs.peek());
		
		// Pop
		qvs.pop(); // Removes 3
		qvs.pop(); // Removes 1
		qvs.printStack("After pop");
		// Peek
		System.out.println();
		System.out.println("Peek after pop: " + qvs.peek());
				
		// Push
		qvs.push(8);
		qvs.push(9);
		qvs.push(6);
		qvs.push(4);
		qvs.printStack("After push");
		// Peek
		System.out.println();
		System.out.println("Peek after push: " + qvs.peek());
	}
	
	private void printStack(String message) {
		shiftStack("push");
		System.out.println();
		System.out.println(message);
		for (int i : newStack) {
			System.out.print(i + ",");
		}
	}

	public void push(int i) {
		shiftStack("push");
		newStack.push(i);
	}
	
	public int peek() {
		shiftStack("not push");
		return oldStack.peek();
	}
	
	public int pop() {
		shiftStack("not push");
		return oldStack.pop();
	}

	private void shiftStack(String type) {
		switch(type) {
		case "push":
			if (newStack.isEmpty() && !oldStack.isEmpty()) {
				while (!oldStack.isEmpty()) {
					newStack.push(oldStack.pop());
				}
			}
			break;
		case "not push":
			if (oldStack.isEmpty() && !newStack.isEmpty()) {
				while (!newStack.isEmpty()) {
					oldStack.push(newStack.pop());
				}
			}
			break;
		}
	}

}
