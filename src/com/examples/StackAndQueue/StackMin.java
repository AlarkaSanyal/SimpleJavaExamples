package com.examples.StackAndQueue;

import java.util.Stack;

public class StackMin extends Stack<Integer> {

	Stack<Integer> si;
	
	public static void main(String[] args) {
		StackMin sm = new StackMin();
		sm.si = new Stack<Integer> ();
		
		sm.push(4);
		sm.push(5);
		sm.push(1); // Min
		sm.push(7);
		
		System.out.println("Min: " + sm.min());
		
		sm.pop(); // Removes 7
		sm.pop(); // Removes 1
		sm.pop(); // Removes 5
		
		sm.push(2); // New Min
		sm.push(9);
		sm.push(8);
		
		System.out.println("New min: " + sm.min());
	}
	
	public void push(int i) {
		if (i < min()) {
			si.push(i);
		}
		super.push(i);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			si.pop();
		}
		return value;
	}
	
	public int min() {
		if (si.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return si.peek();
	}
}
