package com.examples.TreesAndGraphs;

import java.util.Stack;

public class RouteBetweenNodes {

	private Node[] vertices;
	private boolean found = false;
	
	public static void main(String[] args) {
		RouteBetweenNodes rbn = new RouteBetweenNodes(7);
		
		// Setting up the following directed graph
		// 0 -> 1 -> 2 -> 3
		// ^    |
		// |    v
		// 4    5 -> 6
		
		rbn.addEdge(0, 1);
		rbn.addEdge(4, 0);
		rbn.addEdge(1, 2);
		rbn.addEdge(1, 5);
		rbn.addEdge(2, 3);
		rbn.addEdge(5, 6);
		
		rbn.findRoute(4, 6);
		System.out.println("Route found: " + rbn.found);
	}
	
	private void findRoute(int start, int end) {
		boolean[] visited = new boolean[this.vertices.length];
		Stack<Integer> stack = new Stack<Integer> ();
		traverse(start, end, stack, visited);
	}

	private void traverse(int start, int end, Stack<Integer> stack, boolean[] visited) {
		visited[start] = true;
		stack.add(start);
		while (!stack.isEmpty()) {
			if (this.found) {
				break;
			}
			int node = stack.pop();
			if (node == end) {
				this.found = true;
				break;
			}
			Node temp = this.vertices[node];
			while (temp.next != null) {
				temp = temp.next;
				stack.add(temp.value);
			}			
		}
	}

	private void addEdge(int node, int neighbour) {
		Node newNode = new Node(neighbour, null);
		Node temp = this.vertices[node];
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	public RouteBetweenNodes(int vertexCount) {
		this.vertices = new Node[vertexCount];
		for(int i = 0; i < vertexCount; i++) {
			this.vertices[i] = new Node(i, null);
		}
	}

	class Node {
		int value;
		Node next;
		
		public Node(int v, Node n) {
			this.value = v;
			this.next = n;
		}
	}
}
