package com.examples.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

	Vertex[] vertices;
	
	public static void main(String[] args) {
		GraphBFS bfs = new GraphBFS(7);
		
		// Setting up the following directed graph
		// 0 -> 1 -> 2 -> 3
		// ^    |
		// |    v
		// 4    5 -> 6
		
		// Add edges
		bfs.addEdge(0, 1);
		bfs.addEdge(4, 0);
		bfs.addEdge(1, 2);
		bfs.addEdge(1, 5);
		bfs.addEdge(5, 6);
		bfs.addEdge(2, 3);
		
		bfs.traverse();
	}
	
	private void traverse() {
		Queue<Integer> queue = new LinkedList<Integer> ();
		boolean[] visited = new boolean[this.vertices.length];
		for (int i = 0; i < this.vertices.length; i++) {
			if (!visited[i]) {
				traverse(i, queue, visited);
			}
		}
	}

	private void traverse(int vertex, Queue<Integer> queue, boolean[] visited) {
		visited[vertex] = true;
		queue.add(vertex);
		System.out.print(vertex+ ",");
		while (!queue.isEmpty()) {
			int tempVertex = queue.poll();
			while (this.vertices[tempVertex].next != null) {
				if (!visited[this.vertices[tempVertex].next.value]) {
					System.out.print(this.vertices[tempVertex].next.value+ ",");
					queue.add(this.vertices[tempVertex].next.value);
					visited[this.vertices[tempVertex].next.value] = true;					
				}
				this.vertices[tempVertex] = this.vertices[tempVertex].next;
			}
		}
		System.out.println();
	}

	private void addEdge(int vertex, int neighbour) {
		Vertex newVertex = new Vertex(neighbour, null);
		Vertex temp = this.vertices[vertex];
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newVertex;
	}

	public GraphBFS(int vertexCount) {
		// Set the total number of vertices
		this.vertices = new Vertex[vertexCount];
		
		// Initialize each vertex
		for (int i = 0; i < vertexCount; i++) {
			this.vertices[i] = new Vertex(i,  null);
		}
	}

}

class Vertex {
	int value;
	Vertex next;
	
	public Vertex(int val, Vertex n) {
		this.value = val;
		this.next = n;
	}
}