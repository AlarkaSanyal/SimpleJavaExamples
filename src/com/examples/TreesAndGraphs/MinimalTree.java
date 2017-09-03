package com.examples.TreesAndGraphs;

public class MinimalTree {

	// Sorted array
	private int[] array = {0,1,2,3,4,5,6,7,8};
	
	public static void main(String[] args) {
		MinimalTree mt = new MinimalTree();
		TreeNode head = mt.createMinimalTree(mt.array, 0, mt.array.length - 1);
		System.out.println("Done");
		mt.printInorder(head);
	}
	
	private void printInorder(TreeNode head) {
		if (head == null) {
			return;
		}
		printInorder(head.left);
		System.out.print(head.root + " -> ");
		printInorder(head.right);
	}

	public TreeNode createMinimalTree(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode tempHead = new TreeNode(array[mid]);
		tempHead.left = createMinimalTree(array, start, mid - 1);
		tempHead.right = createMinimalTree(array, mid + 1, end);
		return tempHead;
	}
	
	
}
