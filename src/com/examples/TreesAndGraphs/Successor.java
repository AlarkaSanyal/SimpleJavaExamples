package com.examples.TreesAndGraphs;

public class Successor {

	TreeNodeWithParent root;
	
	public static void main(String[] args) {
		Successor s = new Successor();
		//        5
		//        /\
		//       2  8
		//      /\  /\
		//     0  4 6 11
		//       /    /
		//      3     9
		//            \
		//             10
		s.root = new TreeNodeWithParent(5);
		
		s.root.left = new TreeNodeWithParent(2);
		s.root.left.parent = s.root;
		
		s.root.left.left = new TreeNodeWithParent(0);
		s.root.left.left.parent = s.root.left;
		
		s.root.left.right = new TreeNodeWithParent(4);
		s.root.left.right.parent = s.root.left;
		
		s.root.left.right.left = new TreeNodeWithParent(3);
		s.root.left.right.left.parent = s.root.left.right;
		
		s.root.right = new TreeNodeWithParent(8);
		s.root.right.parent = s.root;
		
		s.root.right.left = new TreeNodeWithParent(6);
		s.root.right.left.parent = s.root.right;
		
		s.root.right.right = new TreeNodeWithParent(11);
		s.root.right.right.parent = s.root.right;
		
		s.root.right.right.left = new TreeNodeWithParent(9);
		s.root.right.right.left.parent = s.root.right.right;
		
		s.root.right.right.left.right = new TreeNodeWithParent(10);
		s.root.right.right.left.right.parent = s.root.right.right.left;
		
		System.out.println("Successor for Node 0: " + s.findSucc(s.root.left.left));
		System.out.println("Successor for Node 4: " + s.findSucc(s.root.left.right));
		System.out.println("Successor for Node 6: " + s.findSucc(s.root.right.left));
		System.out.println("Successor for Node 10: " + s.findSucc(s.root.right.right.left.right));
		System.out.println("Successor for Node 11: " + s.findSucc(s.root.right.right));
	}

	private Integer findSucc(TreeNodeWithParent node) {
		if (node == null) {
			return null;
		}
		Integer successor = null;
		// If right sub tree is not null, find the smallest value in the right sub tree
		if (node.right != null) {
			successor = findSmallestInRight(node.right);
		} else {
			TreeNodeWithParent tempNode = node;
			TreeNodeWithParent tempParent = node.parent;
			while (tempParent != null && tempNode != tempParent.left) {
				tempNode = tempParent;
				tempParent = tempParent.parent;
			}
			successor = tempParent != null ? tempParent.value : null;
		}
		return successor;
	}

	private Integer findSmallestInRight(TreeNodeWithParent node) {
		while (node.left != null) {
			node = node.left;
		}
		return node.value;
	}
}

class TreeNodeWithParent {
	int value;
	TreeNodeWithParent left = null;
	TreeNodeWithParent right = null;
	TreeNodeWithParent parent = null;
	
	public TreeNodeWithParent(int v) {
		this.value = v;
	}	
}