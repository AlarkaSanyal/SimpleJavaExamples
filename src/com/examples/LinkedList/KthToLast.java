package com.examples.LinkedList;

public class KthToLast {

	Node head;
	
	public static void main(String[] args) {
		KthToLast kLL = new KthToLast();
		kLL.push(5);
		kLL.push(7);
		kLL.push(9);
		kLL.push(2);
		kLL.push(14);
		kLL.push(15);
		kLL.push(10);
		kLL.print(kLL.head, "Original");
		Node kTh = kLL.findK(4);
		kLL.print(kTh, "kTh to Last");
	}

	private Node findK(int i) {
		Node main = head;
		Node helper = main;
		int counter = 0;
		while (main != null) {
			if (counter >= i) {
				helper = helper.next;
			}
			main = main.next;
			counter++;
		}
		return helper;
	}

	private void print(Node node, String string) {
		System.out.println();
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
