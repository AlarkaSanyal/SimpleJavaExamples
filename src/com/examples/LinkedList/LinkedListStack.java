package com.examples.LinkedList;

public class LinkedListStack {

	Node last;
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = last;
		last = newNode;
	}
	
	public void peek() {
		if (last != null) {
			System.out.println("\n\nPeeked value: " + last.value);
		} else {
			System.out.println("Empty stack");
		}		
	}
	
	public void pop() {
		Node popped = null;
		if (last != null) {
			popped = last;
			last = last.next;
		}
		if (popped != null) {
			System.out.println("\n\nPopped value: " + popped.value);
		} else {
			System.out.println("Empty stack");
		}		
	}
	
	public static void main(String[] args) {
		LinkedListStack ll = new LinkedListStack();
		
		// Peek on empty stack
		ll.peek();
		// Pop on empty stack
		ll.pop();
		
		// Adding values to stack
		ll.push(23);
		ll.push(21);
		ll.push(45);
		ll.push(32);
		ll.push(65);
		ll.push(14);
		
		ll.printStack("\nOriginal");
		
		ll.peek();
		
		ll.printStack("\nAfter peek");
		
		ll.pop();
		
		ll.printStack("\nAfter pop");
	}

	private void printStack(String heading) {
		System.out.println(heading);
		Node currentStack = last;
		while (currentStack != null) {
			if (currentStack.next != null) {
				System.out.print(currentStack.value + "->");
			} else {
				System.out.print(currentStack.value);
			}
			currentStack = currentStack.next;
		}
	}
}
