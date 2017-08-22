package com.examples.LinkedList;

public class DeleteNodeN {
	
	Node head;

	public static void main(String[] args) {
		DeleteNodeN ddLL = new DeleteNodeN();
		ddLL.push(5);
		ddLL.push(9);
		ddLL.push(6);
		ddLL.push(45);
		ddLL.push(21);
		ddLL.push(4);
		ddLL.push(47);
		ddLL.push(7);
		ddLL.print(ddLL.head, "Original");
		ddLL.delete(3);
		System.out.println();
		ddLL.print(ddLL.head, "Deleted LinkedList");
	}

	// Delete nth from last node
	private void delete(int i) {
		Node main = head;
		Node helper = main;
		int counter = 0;
		while (helper != null) {
			if (counter >= i) {
				if (helper.next != null) {
					main = main.next;
				} else {
					main = main.next.next;
				}				
			}
			counter++;
			helper = helper.next;
		}		
	}

	private void print(Node node, String string) {
		System.out.println(string);
		while (node != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
	}

	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
	}

}
