package com.examples.TreesAndGraphs;

public class CheckBalanced {

	private int[] array = {0,1,2,3,4,5,6,7,8};
	
	public static void main(String[] args) {
		CheckBalanced cb = new CheckBalanced();
		
		// Used for building a balanced tree
		MinimalTree mt = new MinimalTree();
		TreeNode node1 = mt.createMinimalTree(cb.array, 0, cb.array.length - 1);
		
		boolean balanced1 = cb.checkBalanced(node1) == Integer.MIN_VALUE ? false : true;		
		System.out.println("Tree is balanced: " + balanced1);
		
		// Used for building a non-balanced tree
		TreeNode node2 = new TreeNode(1);
		node2.left = new TreeNode(2);
		node2.right = new TreeNode(3);
		node2.right.left = new TreeNode(4);
		node2.right.right = new TreeNode(5);
		node2.right.right.left = new TreeNode(6);
		
		boolean balanced2 = cb.checkBalanced(node2) == Integer.MIN_VALUE ? false : true;		
		System.out.println("Tree is balanced: " + balanced2);
	}

	private int checkBalanced(TreeNode root) {
		if (root == null) {
			return 1;
		}
		
		int leftHeight = checkBalanced(root.left);
		if (leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE; // Error out at any time height doesn't match
		}
		int rightHeight = checkBalanced(root.right);
		if (rightHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE; // Error out at any time height doesn't match
		}
		
		int heightDifference = Math.abs(leftHeight - rightHeight);
		
		if (heightDifference > 1) {
			return Integer.MIN_VALUE; // Set error value at any time height difference is more than 1
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

}
