package com.examples.TreesAndGraphs;

public class ValidateBST {
	
	private int[] array1 = {0,1,2,3,4,5,6,7,8};
	private int[] array2 = {0,1,2,4,3,5,6,7,8};

	public static void main(String[] args) {
		ValidateBST vb = new ValidateBST();
		
		// Used for building a BST
		MinimalTree mt = new MinimalTree();
		
		// BST
		TreeNode node1 = mt.createMinimalTree(vb.array1, 0, vb.array1.length - 1);
		boolean valid1 = vb.validate(node1, null, null);
		System.out.println("Tree is BST: " + valid1);
		
		// Not BST
		TreeNode node2 = mt.createMinimalTree(vb.array2, 0, vb.array2.length - 1);		
		boolean valid2 = vb.validate(node2, null, null);
		System.out.println("Tree is BST: " + valid2);
	}

	private boolean validate(TreeNode node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}
		if ((min != null && node.root <= min) || (max != null && node.root > max)) {
			return false;
		}
		if (!validate(node.left, min, node.root) || !validate(node.right, node.root, max)) {
			return false;
		}
		return true;
	}

}
