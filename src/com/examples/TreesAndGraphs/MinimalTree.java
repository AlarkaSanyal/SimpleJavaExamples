package com.examples.TreesAndGraphs;

public class MinimalTree {

	// Sorted array
	private static int[] array = {0,1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) {
		MinimalTree mt = new MinimalTree();
		Node head = mt.createMinimalTree(0, array.length - 1);
		System.out.println("Done");
	}
	
	private Node createMinimalTree(int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node tempHead = new Node(array[mid]);
		tempHead.left = createMinimalTree(start, mid - 1);
		tempHead.right = createMinimalTree(mid + 1, end);
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
