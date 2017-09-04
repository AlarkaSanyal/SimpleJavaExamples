package com.examples.TreesAndGraphs;

import java.util.Random;

public class RandomNode {

	Node root;
	int size;
	
	public static void main(String[] args) {
		RandomNode rn = new RandomNode();
		rn.insertNode(6);
		rn.insertNode(3);
		rn.insertNode(1);
		rn.insertNode(2);
		rn.insertNode(5);
		rn.insertNode(4);
		rn.insertNode(7);
		
		System.out.println("Random node: " + rn.getRandom().value);
		System.out.println("Random node: " + rn.getRandom().value);
		System.out.println("Random node: " + rn.getRandom().value);
		System.out.println();
		Node found4 = rn.find(4);
		if (found4 != null) {
			System.out.println("Node 4 found: " + found4.value);
		}
		Node found9 = rn.find(9);
		if (found9 == null) {
			System.out.println("Node 9 not found");
		}
	}
	
	public int size() {
		return root == null ? 0 : root.size();
	}
	
	public void insertNode(int n) {
		if (root == null) {
			root = new Node(n);
		} else {
			root.insertNode(n);
		}
	}
	
	public Node find(int value) {
		if (root == null) {
			return null;
		} else {
			return root.find(value);
		}
	}
	
	public Node getRandom() {
		if (root == null) {
			return null;
		}
		Random random = new Random();
		int randomIndex = random.nextInt(size());
		return root.getRandom(randomIndex);
	}
	
	class Node {
		int value;
		Node left;
		Node right;
		int size; // Number of nodes under this node
		
		public Node(int val) {
			this.value = val;
			this.size = 1;
		}
		
		public Node find(int value) {
			if (value == this.value) {
				return this;
			} else if (value < this.value) {
				return left == null ? null : left.find(value);
			} else {
				return right == null ? null : right.find(value);
			}
		}
		
		public Node getRandom(int randomIndex) {
			// Find the number of nodes on the left of root node
			int leftSize = left == null ? 0 : left.size();
			
			if (randomIndex < leftSize) {
				return left.getRandom(randomIndex);
			} else if (randomIndex == leftSize) {
				return this;
			} else {
				// The random index value for the right should be (total - left side count) 
				return right.getRandom(randomIndex - (leftSize + 1));
			}
		}

		public int size() {
			return size;
		}
		
		public void insertNode(int n) {
			if (n < value) {
				if (left == null) {
					left = new Node(n);
				} else {
					left.insertNode(n);
				}
			} else {
				if (right == null) {
					right = new Node(n);
				} else {
					right.insertNode(n);
				}
			}
			size++;
		}
	}
}
