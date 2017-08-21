package com.examples.LinkedList;

import java.util.HashSet;

public class RemoveDupsA {

	Node head = null;
	
	public static void main(String[] args) {
		RemoveDupsA rmdLL = new RemoveDupsA();
		rmdLL.push(10);
		rmdLL.push(12);
		rmdLL.push(17);
		rmdLL.push(12);
		rmdLL.push(21);
		rmdLL.push(22);
		rmdLL.push(34);
		rmdLL.removeDups();		
	}

	private void printLL(Node printNode, String string) {
		System.out.println(string);
		while (printNode != null) {
			System.out.print(printNode.value + " -> ");
			printNode = printNode.next;
		}
	}

	private void removeDups() {
		RemoveDupsA rmdLL = new RemoveDupsA();
		Node printNode = head;
		rmdLL.printLL(printNode, "Original");
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		System.out.println();
		System.out.println("Dups Removed");
		while (head != null) {
			if (set.contains(head.value)) {
				previous.next = head.next;
			} else {
				set.add(head.value);
				previous = head;
				System.out.print(previous.value + " -> ");
			}
			head = head.next;			
		}
	}

	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;		
	}
}
