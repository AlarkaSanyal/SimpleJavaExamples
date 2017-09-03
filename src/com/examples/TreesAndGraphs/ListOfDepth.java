package com.examples.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepth {

	private int[] array = {0,1,2,3,4,5,6,7,8};
	ArrayList<LinkedList<Integer>> lists;
	
	public static void main(String[] args) {
		ListOfDepth ld = new ListOfDepth();
		ld.lists = new ArrayList<LinkedList<Integer>>();
		// Used for building the tree
		MinimalTree mt = new MinimalTree();
		TreeNode node = mt.createMinimalTree(ld.array, 0, ld.array.length - 1);
		ld.printTreeAndBuildList(node);
		ld.printList();
	}

	private void printList() {
		System.out.println();
		System.out.println("LinkedLists");
		for (int i = 0; i < lists.size(); i++) {
			LinkedList<Integer> list = lists.get(i);
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " -> ");
			}
			System.out.println();
		}
	}

	private void printTreeAndBuildList(TreeNode node) {
		Queue<NodeWithLevel> queue = new LinkedList<NodeWithLevel>();
		int level = 0;
		queue.add(new NodeWithLevel(level, node));
		while (!queue.isEmpty()) {
			LinkedList<Integer> list = null;
			NodeWithLevel temp = queue.poll();
			level = temp.level;
			if (lists.size() != level && lists.get(level) != null) {
				lists.get(level).add(temp.node.root);				
			} else {
				list = new LinkedList<Integer>();
				list.add(temp.node.root);
				lists.add(level, list);
			}
			System.out.print(temp.node.root + "(" + temp.level + "), ");
			if (temp.node.left == null && temp.node.right == null) {
				// Do nothing
			} else {
				level++;
			}
			if (temp.node.left != null) {
				queue.add(new NodeWithLevel(level, temp.node.left));
			}
			if (temp.node.right != null) {
				queue.add(new NodeWithLevel(level, temp.node.right));
			}			
		}
	}
	
	class NodeWithLevel {
		TreeNode node;
		int level;
		
		public NodeWithLevel(int level, TreeNode node) {
			this.level = level;
			this.node = node;
		}
	}
}
