package com.examples.TreesAndGraphs;

public class MinDepthBinaryTree {

	Node root;

	public static void main(String[] args) {
		MinDepthBinaryTree mdt = new MinDepthBinaryTree();
		mdt.buildTree();
		int minDepth = mdt.minDepth(mdt.root);
		System.out.println("Minimum depth: " + minDepth);
	}

	private int minDepth(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int left = (root.left != null) ? minDepth(root.left) : Integer.MAX_VALUE;
		int right = (root.right != null) ? minDepth(root.right) : Integer.MAX_VALUE;

		return 1 + Math.min(left, right);
	}

	private void buildTree() {
		root = new Node(2);
		root.left = new Node(7);
		root.left.right = new Node(7);
		root.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(6);
		root.right.right.left = new Node(5);
	}

	class Node {
		int value;
		Node left = null;
		Node right = null;

		public Node(int v) {
			this.value = v;
		}
	}
}

