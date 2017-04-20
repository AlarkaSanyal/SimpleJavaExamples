package com.examples.LinkedList;

public class LinkedListMiddleElement {

	Node head;
	
	class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public void findMiddle() {
		Node ptr1 = head;
		Node ptr2 = head;
		
		while (ptr2 != null && ptr2.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		System.out.println("Middle element is " + ptr1.value);
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public static void main(String[] args) {
		LinkedListMiddleElement llOdd = new LinkedListMiddleElement();
		
		llOdd.push(4);
		llOdd.push(7);
		llOdd.push(12);
		llOdd.push(23);
		llOdd.push(2);
		llOdd.push(43);
		llOdd.push(13);
		
		llOdd.findMiddle();
	}
}
