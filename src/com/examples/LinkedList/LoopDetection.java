package com.examples.LinkedList;

public class LoopDetection {

	Node head;
	Node tail;
	
	// List2 = 5->1->2->7->4->9->6->7 (loop at 7)
	// length = 8
	public static void main(String[] args) {
		LoopDetection ld = new LoopDetection();
		
		//ld.head = ld.push(7, ld.head);
		ld.head = ld.push(6, ld.head);
		ld.head = ld.push(9, ld.head);
		ld.head = ld.push(4, ld.head);
		ld.head = ld.push(7, ld.head);
		ld.head = ld.push(2, ld.head);
		ld.head = ld.push(1, ld.head);
		ld.head = ld.push(5, ld.head);
		ld.completeLoop();
		ld.print(ld.head, "Original", 8);
		Node loop = ld.detectLoop(ld.head);
		ld.print(loop, "Looped", 4);
	}
	
	private Node detectLoop(Node head) {
		Node slow = head;
		Node fast = head;
		
		// slow - 1 step, fast - 2 steps
		while (fast != null && fast.next != null) {
			slow = slow.next; // 1 step
			fast = fast.next.next; // 2 steps
			if (slow == fast) {
				break;
			}			
		}
		
		// If no loop, fast would be null
		if (fast == null) {
			return null;
		}
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}

	private void completeLoop() {
		tail.next = head.next.next.next;
	}

	private void print(Node node, String message, int length) {
		System.out.println();
		System.out.println(message);
		for (int i = 0; i < length; i++) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
		System.out.println("....");
	}

	private Node push(int i, Node head) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
		if (tail == null) {
			tail = head;
		}
		return head;
	}

}
