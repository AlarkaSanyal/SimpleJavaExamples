package com.examples.TreesAndGraphs;

public class CheckSubTree {

	Node root;
	
	public static void main(String[] args) {
		CheckSubTree cst = new CheckSubTree();
		cst.buildTree();
		boolean sub = cst.checkSub(cst.root, cst.root.left);
		System.out.println("Is sub-tree: " + sub);
	}

	private boolean checkSub(Node big, Node small) {
		// Null small tre will always be a subtree
		if (small == null) {
			return true;
		}
		// Null big tree means small can never be a sub tree of null
		if (big == null) {
			return false;
		} else {
			// If the node values match, check the two trees
			if (big.value == small.value && matchTree(big, small)) {
				return true;
			}
		}
		// Else run recursive on left and right
		return checkSub(big.left, small) || checkSub(big.right, small);
	}

	private boolean matchTree(Node big, Node small) {
		// If big and small are null, that means the traversal has reached the bottom and they should be equal
		if (big == null && small == null) {
			return true;
		}
		// If only one is null, that means small is not equal to big, i.e. NOT a sub tree
		if (big == null || small == null) {
			return false;
		}
		// If nodes match, run recursive on left and right and return TRUE only if both left and right recursive runs return true.
		if (big.value == small.value) {
			return matchTree(big.left, small.left) && matchTree(big.right, small.right);
		}
		return false;
	}

	private void buildTree() {
		// Tree 1
		root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(9);
		root.right.left = new Node(4); // Duplicate
		root.right.right = new Node(6);
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
