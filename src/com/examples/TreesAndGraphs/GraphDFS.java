package com.examples.TreesAndGraphs;

public class GraphDFS {

	private int vertices; // Number of vertices
	private Node[] nodes; // Adjacency List
	
	public static void main(String[] args) {
		GraphDFS dfs = new GraphDFS(7);
		
		// Setting up the following directed graph
		// 0 -> 1 -> 2 -> 3
		// ^    |
		// |    v
		// 4    5 -> 6
		
		dfs.addEdge(0, 1);
		dfs.addEdge(4, 0);
		dfs.addEdge(1, 5);
		dfs.addEdge(1, 2);
		dfs.addEdge(5, 6);
		dfs.addEdge(2, 3);
		
		dfs.traverse();		
	}
	
	private void traverse() {
		boolean[] visited = new boolean[this.vertices];
		for (int vertex = 0; vertex < this.vertices; vertex++) {
			if (!visited[vertex]) {
				traverse(vertex, visited);
			}
		}
	}

	private void traverse(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		while (nodes[vertex].next != null && !visited[nodes[vertex].next.value]) {
			traverse(nodes[vertex].next.value, visited);
		}
		System.out.println();
	}

	public GraphDFS(int vertices) {
		this.vertices = vertices;
		nodes = new Node[vertices];
		for (int i = 0; i < this.vertices; i++) {
			nodes[i] = new Node(i, null);
		}		
	}
	
	public void addEdge(int vertex, int node) {
		Node newNode = new Node(node, null);
		Node temp = nodes[vertex];
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
}

class Node {
	int value;
	Node next;
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}
