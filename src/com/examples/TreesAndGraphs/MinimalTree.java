package com.examples.TreesAndGraphs;

public class MinimalTree {

	// Sorted array
	private int[] array = {0,1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) {
		MinimalTree mt = new MinimalTree();
		Node head = mt.createMinimalTree(mt.array, 0, mt.array.length - 1);
		System.out.println("Done");
	}
	
	private Node createMinimalTree(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node tempHead = new Node(array[mid]);
		tempHead.left = createMinimalTree(array, start, mid - 1);
		tempHead.right = createMinimalTree(array, mid + 1, end);
		return tempHead;
	}

	class Node {
		int root;
		Node left = null;
		Node right = null;
		
		public Node(int r) {
			this.root = r;
		}
	}

}
