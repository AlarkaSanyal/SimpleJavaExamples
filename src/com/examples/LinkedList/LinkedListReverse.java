package com.examples.LinkedList;

public class LinkedListReverse {

	Node head;
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public static void main(String[] args) {
		LinkedListReverse ll = new LinkedListReverse();
		ll.push(23);
		ll.push(21);
		ll.push(45);
		ll.push(32);
		ll.push(65);
		ll.push(14);
		
		// Print original
		System.out.println("Original");
		ll.printAll();
		
		//Reverse
		ll.reverse();
		
		// Print original
		System.out.println("\n\nReverse");
		ll.printAll();
	}

	private void reverse() {
		Node prev = null;
		Node current = head;
		Node reverse;
		while (current != null) {
			reverse = current.next;
			current.next = prev;
			prev = current;
			current = reverse;
		}
		head = prev;
	}

	private void printAll() {
		Node node = head;
		while (node != null) {
			if (node.next != null) {
				System.out.print(node.value + "->");
			} else {
				System.out.print(node.value);
			}
			node = node.next;
		}
	}
}
