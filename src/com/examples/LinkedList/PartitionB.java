package com.examples.LinkedList;

public class PartitionB {

	Node head;
	Node tail = null;
	
	public static void main(String[] args) {
		PartitionB pb = new PartitionB();
		pb.push(5);
		pb.push(6);
		pb.push(7);
		pb.push(2);
		pb.push(8);
		pb.push(3);
		pb.print(pb.head, "Original");
		Node part = pb.partition(4);
		pb.print(pb.head, "Partitioned");
	}

	private Node partition(int i) {
		
		// Find length
		/*Node n = head;
		int length = 0;
		while (n != null) {
			length++;
			n = n.next;
		}
		
		Node newHead = head;
		Node temp = head;
		while (head != null && length != 0) {
			Node temp1 = head.next;
			head.next = null;
			if (head.value < i) {
				tail.next = head;
				temp.next = temp1;
			}
			head = temp1;
			length--;
		}*/
		Node temp = head;
		while (temp != null && temp.value != 8) {
			temp = temp.next;
		}
		Node newNode = new Node(1);
		newNode.next = temp;
		temp = newNode;
		
		Node newNode1 = new Node(4);
		newNode1.next = temp.next.next;
		temp.next.next = newNode1;
		
		return null;
	}

	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
		if (tail == null) {
			tail = head;
		}
	}

	private void print(Node node, String string) {
		System.out.println();
		System.out.println(string);
		while (node != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
	}

}
