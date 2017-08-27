package com.examples.LinkedList;

public class SumListBackward {

	Node head1;
	Node head2;
	
	// list = 6->1->7 i.e. 716
	// list = 5->1->2 i.e. 215
	// Sum = 1->3->9 i.e. 931
	public static void main(String[] args) {
		SumListBackward list = new SumListBackward();
		
		// list = 6->1->7 i.e. 716
		list.head1 = list.push(7, list.head1);
		list.head1 = list.push(1, list.head1);
		list.head1 = list.push(6, list.head1);
		list.print(list.head1, "list");
		
		// list = 5->1->2 i.e. 215
		list.head2 = list.push(2, list.head2);
		list.head2 = list.push(1, list.head2);
		list.head2 = list.push(5, list.head2);
		list.print(list.head2, "list");
		
		// Sum
		Node sum = list.sum(list.head1, list.head2, list);
		list.print(sum, "Sum (In Forward)");
	}

	private Node sum(Node head1, Node head2, SumListBackward list) {
		Node sum = null;
		if (head1 != null || head2 != null) {
			int tempCarry = 0;
			int tempSum = 0;
			while (true) {
				tempSum = tempCarry;
				if (head1 != null) {
					tempSum += head1.value;
					head1 = head1.next;
				}
				if (head2 != null) {
					tempSum += head2.value;
					head2 = head2.next;
				}
				if (tempSum > 9) {
					sum = list.push((tempSum%10), sum);
					tempCarry = 1;
				} else {
					sum = list.push(tempSum, sum);
					tempCarry = 0;
				}
				if (head1 == null && head2 == null) {
					break;
				}
			}
			if (tempCarry > 0) {
				sum = list.push(tempCarry, sum);
			}
		}
		return sum;
	}

	private void print(Node node, String message) {
		System.out.println();
		System.out.println(message);
		while (node != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
	}

	private Node push(int i, Node head) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
		return head;
	}

}
