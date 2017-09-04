package com.examples.TreesAndGraphs;

public class FirstCommonAncestor {

	Node root1;
	Node root2;
	
	public static void main(String[] args) {
		FirstCommonAncestor fca = new FirstCommonAncestor();
		fca.buildTree();
		
		// Common for 5 & 2 in Tree 1
		Result result1 = fca.findAnc(fca.root1, 5, 2);
		if (result1.isAnc) {
			System.out.println("Ancestor is: " + result1.node.value);
		} else {
			System.out.println("Ancestor not found");
		}
		
		// Common for 9 & 6 in Tree 2
		Result result2 = fca.findAnc(fca.root2, 9, 6);
		if (result2.isAnc) {
			System.out.println("Ancestor is: " + result2.node.value);
		} else {
			System.out.println("Ancestor not found");
		}
	}

	private Result findAnc(Node root, int i, int j) {
		
		// If root is null, i.e. bottom-most child is reached and
		// i or j is not found while traversing from root, return null Result
		if (root == null) {
			return new Result(null, false);
		}
		
		// If the root value matches the 2 nodes whose ancestore is to be found return that root
		if (root.value == i && root.value == j) {
			return new Result(root, true);
		}
		
		Result left = findAnc(root.left, i, j);
		if (left.isAnc) {
			return left;
		}
		Result right = findAnc(root.right, i, j);
		if (right.isAnc) {
			return right;
		}
		
		if (left.node != null && right.node != null) {
			return new Result(root, true);
		} else if (root.value == i || root.value == j) {
			// E.g.: To find the common anc of 5 & 2 in the tree 3->5->2, the following line
			// determines that 2 is NOT the ancestor although root.value matched with i/j because
			// it has both left and right nodes null, i.e. it is in lower position compared to 5. 
			boolean isAncestor = left.node != null || right.node != null;
			return new Result(root, isAncestor);
		}
		
		return left.node != null ? new Result(left.node, false) : new Result(right.node, false);
	}

	private void buildTree() {
		// Tree 1
		root1 = new Node(3);
		root1.right = new Node(5);
		root1.right.right = new Node(2);
		root1.left = new Node(6);
		
		// Tree 2
		root2 = new Node(2);
		root2.left = new Node(7);
		root2.right = new Node(4);
		root2.left.left = new Node(1);
		root2.left.right = new Node(9);
		root2.right.left = new Node(4); // Duplicate
		root2.right.right = new Node(6);
	}
	
	class Result {
		boolean isAnc;
		Node node;
		
		public Result(Node node, boolean isAnc) {
			this.isAnc = isAnc;
			this.node = node;
		}
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
