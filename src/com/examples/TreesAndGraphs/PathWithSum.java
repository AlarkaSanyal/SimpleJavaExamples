package com.examples.TreesAndGraphs;

import java.util.HashMap;

public class PathWithSum {

	public static void main(String[] args) {
		PathWithSum ps = new PathWithSum();
		Node root = ps.buildTree();
		int paths = ps.pathCount(root, 0);
		System.out.println("Number of paths: " + paths);
	}

	private int pathCount(Node root, int targetSum) {
		return pathCount(root, targetSum, 0, new HashMap<Integer, Integer>());
	}

	private int pathCount(Node root, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		if (root == null) {
			return 0;
		}
		
		// Running sum is cumulative sum
		runningSum = runningSum + root.value;
		
		// This gives the current running sum, which if present in the hashmap
		// below means that there is another path
		int tempRunningSum = runningSum - targetSum;
		int totalPaths = 0;
		if (pathCount.containsKey(tempRunningSum)) { // Checking in the hashmap
			totalPaths++;
		}
		// If the current running sum is equal to the target sum, increase totalPath by 1
		if (runningSum == targetSum) {
			totalPaths++;
		}
		
		// Add the runningSum as a key in the hashmap
		updatePathCount(pathCount, runningSum, 1);
		
		// Recursive for left and right nodes
		totalPaths = totalPaths + pathCount(root.left, targetSum, runningSum, pathCount);
		totalPaths = totalPaths + pathCount(root.right, targetSum, runningSum, pathCount);
		
		// Remove the runningSum as a key in the hashmap
		updatePathCount(pathCount, runningSum, -1);
		return totalPaths;
	}

	private void updatePathCount(HashMap<Integer, Integer> pathCount, int runningSum, int delta) {
		// In the hashmap, the "runningSum" is the KEY
		// The VALUEs are the number of times a "runningSum" is present, i.e. count
		int newCount = 0;
		if (pathCount.containsKey(runningSum)) {
			newCount++;
		}
		newCount = newCount + delta;
		if (newCount == 0) {
			// If count (i.e. VALUE) from above explanation becomes 0, remove the KEY
			// to free up space from the hashmap
			pathCount.remove(runningSum);
		} else {
			pathCount.put(runningSum, newCount);
		}
	}

	private Node buildTree() {
		Node root = new Node(5);
		root.left = new Node(3);		
		root.right = new Node(1);
		root.left.left = new Node(-8);
		root.left.left.left = new Node(0);
		root.left.right = new Node(8);
		root.right.left = new Node(2);
		root.right.right = new Node(6);	
		root.right.left.left = new Node(0);
		
		return root;
	}

	class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int val) {
			this.value = val;
		}
	}
}
