package com.examples.TreesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFSUsingInBuiltLinkedList {
	
	private int V; // Number of vertices
	private LinkedList<Integer> adj[]; // Adjacency List
	
	public static void main(String[] args) {
		GraphDFSUsingInBuiltLinkedList dfs = new GraphDFSUsingInBuiltLinkedList(7);
		
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
		boolean[] visited = new boolean[V];
		for (int i=0;i<V;i++) {
			if(!visited[i]) {
				traverse(i, visited);
			}
		}
	}

	private void traverse(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		Iterator<Integer> i = adj[vertex].iterator();
		while (i.hasNext()) {
			int next = i.next();
			if (!visited[next]) {
				traverse(next, visited);
			}
		}
		System.out.println();
	}

	public GraphDFSUsingInBuiltLinkedList(int vertices) {
		this.V = vertices;
		adj = new LinkedList[V];
		for (int i=0; i<V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int node, int neighbour) {
		adj[node].add(neighbour);
	}
}
