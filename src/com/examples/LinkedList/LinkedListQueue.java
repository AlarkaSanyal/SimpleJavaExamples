package com.examples.LinkedList;

public class LinkedListQueue {

	Node first;
	Node last;
	
	public void enqueue(Node node) {
		// Enqueue the data in a reverse order so that it's easier to dequeue
		if (first == null) {
			node.next = first;
			first = node;
			last = first;
		} else {
			last.next = node;
			last = node;
		}
	}
	
	public void dequeue() {
		if (first == null) {
			System.out.println("Empty queue");
		} else {
			System.out.println("\nDequeued: " + first.value);
			first = first.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListQueue ll = new LinkedListQueue();
		ll.enqueue(new Node(23));
		ll.enqueue(new Node(21));
		ll.enqueue(new Node(45));
		ll.enqueue(new Node(32));
		ll.printQueue("Queue after 4 pushes");
		ll.enqueue(new Node(65));
		ll.enqueue(new Node(14));
		ll.printQueue("\nQueue after 6 pushes");
		ll.dequeue();
		ll.printQueue("Queue after 1 dequeue");
		ll.enqueue(new Node(85));
		ll.enqueue(new Node(16));
		ll.printQueue("\nQueue after 2 more pushes");
		ll.dequeue();
		ll.printQueue("Queue after 1 more dequeue");
	}

	private void printQueue(String heading) {
		System.out.println(heading);
		Node queue = first;
		System.out.print("First ");
		while (queue != null) {
			if (queue.next != null) {
				System.out.print(queue.value + " -> ");
			} else {
				System.out.print(queue.value);
			}
			queue = queue.next;
		}
		System.out.print(" Last");		
	}
}
