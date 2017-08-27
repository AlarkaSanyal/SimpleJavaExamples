package com.examples.StackAndQueue;

public class MultiStack {

	int[] stackSizes = {0, 0, 0}; // Sizes of 3 stacks
	int[] values = new int[18]; // Total size = 3 X 6 = 18
	int size = 6; // Each stack size
	
	public static void main(String[] args) {
		MultiStack ms = new MultiStack();
		
		// Push(value, stack#)
		ms.push(3, 3);
		ms.push(2, 2);
		ms.push(1, 1);
		ms.push(6, 3);
		ms.push(7, 3);
		ms.push(8, 2);
		ms.push(5, 1);
		ms.push(3, 1);
		ms.push(8, 2);
		ms.push(4, 3);
		ms.push(9, 1);
		ms.push(3, 1);
		ms.push(6, 2);
		ms.push(7, 3);
		ms.push(8, 3);
		
		System.out.println("Original");
		ms.printStacks();
		
		// Peek (stack#)
		System.out.println();
		System.out.println();
		System.out.println("Peek");
		ms.peek(1);
		ms.peek(2);
		ms.peek(3);
		
		// Pop (stack#)
		System.out.println();
		System.out.println("Pop");
		ms.pop(1);
		ms.pop(2);
		ms.pop(3);
		System.out.println();
		System.out.println("After pop");
		ms.printStacks();
		
		// Peek (stack#)
		System.out.println();
		System.out.println();
		System.out.println("Peek");
		ms.peek(1);
		ms.peek(2);
		ms.peek(3);
	}

	private void pop(int stackNum) {
		int offset = size * (stackNum - 1);
		int index = offset + (stackSizes[stackNum - 1] - 1);
		System.out.println("Stack " + stackNum + " pop value: " + values[index]);
		values[index] = 0;
		stackSizes[stackNum - 1]--;
	}

	private void printStacks() {
		int counter = 0;
		System.out.print("Stack: ");
		for (int val : values) {
			if (counter == 6) {
				System.out.println();
				System.out.print("Stack: ");
				counter = 0;
			}
			counter++;
			System.out.print(val + ",");
		}
	}

	private void peek(int stackNum) {
		int tempVal;
		int offset = size * (stackNum - 1);
		tempVal = values[offset + (stackSizes[stackNum - 1] - 1)];
		System.out.println("Stack " + stackNum + ": " + tempVal);
	}

	private void push(int value, int stackNum) {
		int offset = size * (stackNum - 1);
		values[offset + stackSizes[stackNum - 1]] = value;
		stackSizes[stackNum - 1]++;		
	}
}
