package com.examples.LinkedList;

public class LinkedListNthFromLast {

Node head;
	
	class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		
		LinkedListNthFromLast linkedList = new LinkedListNthFromLast();
		linkedList.push(5);
		linkedList.push(10);
		linkedList.push(23);
		linkedList.push(46);
		linkedList.push(54);
		linkedList.push(78);
		
		linkedList.nthElementFromEnd(4);
	}
	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void nthElementFromEnd(int n) {
		Node ptrMain;
		Node ptrHelper;
		
		int count = 0;
		ptrMain = head;
		ptrHelper = head;
		
		while (count < n) {
			if (ptrHelper.next == null) {
				System.out.println("n is larger than size of LinkedList");
				return;
			}
			ptrHelper = ptrHelper.next;
			count++;
		}
		
		while (ptrHelper.next != null) {
			ptrMain = ptrMain.next;
			ptrHelper = ptrHelper.next;
		}
		
		System.out.println("nth element from end is " + ptrMain.value + " where n = " + n);
		
	}

}
