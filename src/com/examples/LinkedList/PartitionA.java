package com.examples.LinkedList;

public class PartitionA {

	Node head;
		
	public static void main(String[] args) {
		PartitionA pa = new PartitionA();
		pa.push(2);
		pa.push(5);
		pa.push(7);
		pa.push(4);
		pa.push(8);
		pa.push(1);
		pa.push(6);
		pa.push(9);
		pa.print(pa.head, "Original");
		Node partitioned = pa.partition(pa.head, 5);
		pa.print(partitioned, "Partitioned");
	}

	private Node partition(Node node, int i) {
		Node bigHead = null;
		Node bigTail = null;
		Node smallHead = null;
		
		while (node != null) {
			Node temp = node.next;
			node.next = null;
			if (node.value > i) {
				Node big = node;
				big.next = bigHead;
				bigHead = big;
				if (bigTail == null) {
					bigTail = bigHead;
				}
			} else {
				Node small = node;
				small.next = smallHead;
				smallHead = small;
			}
			node = temp;
		}
		bigTail.next = smallHead;
		return bigHead;
	}
	
	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
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
