package com.examples.LinkedList;

public class SumListForward {

	Node head1;
	Node head2;
	
	// list = 6->1->7 i.e. 617
	// list = 5->1->2 i.e. 512
	// Sum = 1->1->2->9 i.e. 1129
	public static void main(String[] args) {
		SumListForward list = new SumListForward();
		
		// list = 6->1->7 i.e. 617
		list.head1 = list.push(7, list.head1);
		list.head1 = list.push(1, list.head1);
		list.head1 = list.push(6, list.head1);
		list.print(list.head1, "list");
		
		// list = 5->1->2 i.e. 512
		list.head2 = list.push(2, list.head2);
		list.head2 = list.push(1, list.head2);
		list.head2 = list.push(5, list.head2);
		list.print(list.head2, "list");
		
		// Sum
		Node sum = list.sum(list.head1, list.head2, list);
		list.print(sum, "Sum (In Forward)");
	}
	
	private Node sum(Node head1, Node head2, SumListForward list) {
		int sum = 0;
		int base = 0;
		Node len1 = head1;
		Node len2 = head2;
		if (len1 != null && len2 != null) {
			while (true) {
				base++;
				if (len1 != null) {
					len1 = len1.next;
				}
				if (len2 != null) {
					len2 = len2.next;
				}
				if (len1 == null && len2 == null) {
					break;
				}
			}
		}
		
		while (base != 0) {
			base--;
			if (head1 != null) {
				sum += (head1.value) * (Math.pow(10, base));
				head1 = head1.next;
			}
			if (head2 != null) {
				sum += (head2.value) * (Math.pow(10, base));
				head2 = head2.next;
			}
		}
		
		// Convert int to LinkedList
		Node result = null;
		while (sum > 9) {
			result = list.push(sum%10 , result);
			sum = sum/10;			
		}
		result = list.push(sum , result);
		
		return result;
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
