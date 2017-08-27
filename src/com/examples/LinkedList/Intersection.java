package com.examples.LinkedList;

public class Intersection {

	Node head1;
	Node head2;
	
	// List1 =    6->3->7->4->9->null
	// List2 = 5->1->2->7->4->9->null
	public static void main(String[] args) {
		Intersection inter = new Intersection();
		
		inter.head1 = inter.push(9, inter.head1);
		inter.head1 = inter.push(4, inter.head1);
		inter.head1 = inter.push(7, inter.head1);
		inter.head1 = inter.push(3, inter.head1);
		inter.head1 = inter.push(6, inter.head1);
		inter.print(inter.head1, "List1");
		
		inter.head2 = inter.push(2, inter.head2);
		// Connecting List1 with List2 @ value=7
		inter.head2.next = inter.head1.next.next;
		inter.head2 = inter.push(1, inter.head2);
		inter.head2 = inter.push(5, inter.head2);
		inter.print(inter.head2, "List2");
		
		// Intersection
		Node intersection = inter.intersection(inter.head1, inter.head2);
		inter.print(intersection, "Intersection");		
	}
	
	private Node intersection(Node head1, Node head2) {
		// Find length and tail
		LengthTail lt1 = new LengthTail(head1);
		LengthTail lt2 = new LengthTail(head2);
		
		// If tails do not match, there is no intersection
		if (lt1.tail != lt2.tail) {
			return null;
		}
		
		// Identify smaller and bigger lists
		Node smaller = lt1.length > lt2.length ? head2 : head1;
		Node bigger = lt1.length > lt2.length ? head1 : head2;
		
		int diffLength = Math.abs(lt1.length - lt2.length);
		
		while (bigger != null) {
			if (bigger == smaller) {
				break;
			}
			if (diffLength != 0) {
				diffLength--;
				bigger = bigger.next;
			} else {
				bigger = bigger.next;
				smaller = smaller.next;
			}			
		}
		
		return bigger;
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

class LengthTail {
	Node tail = null;
	int length = 0;
	public LengthTail (Node head) {
		while (head != null) {
			length++;
			tail = head;
			head = head.next;
		}
	}
}
