package com.examples.LinkedList;

public class RemoveDupsB {

	Node head;
	
	public static void main(String[] args) {
		RemoveDupsB rmdLL = new RemoveDupsB();
		rmdLL.push(10);
		rmdLL.push(12);
		rmdLL.push(23);
		rmdLL.push(12);
		rmdLL.push(15);
		rmdLL.push(18);
		rmdLL.push(9);
		
		rmdLL.printForward(rmdLL.head);
		rmdLL.removeDups();
		rmdLL.printForward(rmdLL.head);
	}

	private void removeDups() {
		Node main = head;
		Node runner;
		while (main != null) {
			runner = main;
			while (runner.next != null) {
				if (main.value == runner.next.value) {
					runner.next = (runner.next).next;					
				}
				runner = runner.next;
			}
			main = main.next;
		}
	}

	private void printForward(Node printNode) {
		System.out.println("Forward");
		while (printNode != null) {
			System.out.print(printNode.value + " -> ");			
			printNode = printNode.next;
		}
	}

	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;		
	}

}
