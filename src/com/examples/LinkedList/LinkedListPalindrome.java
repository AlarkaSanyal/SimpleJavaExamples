package com.examples.LinkedList;

public class LinkedListPalindrome {

	Node head;
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public static void main(String[] args) {
		
		// -----------Not palindrome-----------
		LinkedListPalindrome ll = new LinkedListPalindrome();
		ll.push(23);
		ll.push(21);
		ll.push(45);
		ll.push(32);
		ll.push(65);
		ll.push(14);
		ll.isPalindrome("LinkedList");
		
		// --------Palindrome 1 element-----------
		LinkedListPalindrome ll1 = new LinkedListPalindrome();
		ll1.push(23);
		ll1.isPalindrome("\nLinkedList 1 element");
		
		// -----------Palindrome Even 2 elements-----------
		LinkedListPalindrome llp2 = new LinkedListPalindrome();
		llp2.push(21);
		llp2.push(21);
		llp2.isPalindrome("\nLinkedList 2 elements");
		
		// -----------Palindrome Even-----------
		LinkedListPalindrome llpEven = new LinkedListPalindrome();
		llpEven.push(23);
		llpEven.push(21);
		llpEven.push(45);
		llpEven.push(45);
		llpEven.push(21);
		llpEven.push(23);
		llpEven.isPalindrome("\nLinkedList Even");
		
		// -----------Palindrome Odd-----------
		LinkedListPalindrome llpOdd = new LinkedListPalindrome();
		llpOdd.push(23);
		llpOdd.push(21);
		llpOdd.push(45);
		llpOdd.push(999);
		llpOdd.push(45);
		llpOdd.push(21);
		llpOdd.push(23);
		llpOdd.isPalindrome("\nLinkedList Odd");

	}

	private void isPalindrome(String heading) {
		System.out.println(heading);
		printAll();
		boolean palindrome = true;
		Node main = head;
		Node helper = head;
		//Node midPoint = null;
		if (head != null && head.next != null) {
			// After this loop, main ptr will point to the center
			while (helper != null && helper.next != null) {
				main = main.next;
				helper = helper.next.next;
			}
			
			// For odd cases, we need to save the midpoint to build back the original
			if (helper == null) {
				//midPoint = main;
				main = main.next;
			}
			
			main = reverse(main);
			
			//Check if equal
			
			while (main != null) {
				if (main.value != head.value) {
					palindrome = false;
				}
				main = main.next;
				head = head.next;
			}
		}
		System.out.println("\nPalindrome: " + palindrome);
	}

	private Node reverse(Node main) {
		Node prev = null;
		Node current = main;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private void printAll() {
		Node node = head;
		while (node != null) {
			if (node.next != null) {
				System.out.print(node.value + "->");
			} else {
				System.out.print(node.value);
			}
			node = node.next;
		}
		
	}

}
