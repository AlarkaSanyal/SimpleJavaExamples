package com.examples.TreesAndGraphs;

import java.util.Iterator;
import java.util.Stack;

public class BuildOrder {

	Vertex[] vertices;
	Stack<Integer> buildOrder;
	
	public static void main(String[] args) {
		BuildOrder bo = new BuildOrder(9);
		// Setting up the following directed graph
		//        2----
		//      ^ |    |
		//     /  v    v
		//8 -> 6 -> 1 -> 5   4 -> 7
		//     \  ^
		//      v |
		//       3 -> 0
		
		// Add edges
		bo.addEdge(8, 6);
		bo.addEdge(6, 1);
		bo.addEdge(6, 2);
		bo.addEdge(6, 3);
		bo.addEdge(1, 5);
		bo.addEdge(2, 1);
		bo.addEdge(2, 5);		
		bo.addEdge(3, 1);
		bo.addEdge(3, 0);
		
		bo.addEdge(4, 7);
		
		bo.buildOrder();
	}
	
	private void buildOrder() {
		boolean[] visited = new boolean[vertices.length];
		buildOrder = new Stack<Integer>();
		boolean[] set = new boolean[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			if (!visited[i]) {
				buildOrder(i, visited, set);
			}
		}
		Iterator<Integer> it = buildOrder.iterator();
		System.out.println();
		System.out.println("Order");
		while (it.hasNext()) {
			System.out.print(it.next() + " -> ");
		}
	}

	private void buildOrder(int i, boolean[] visited, boolean[] set) {
		visited[i] = true;
		Vertex current = vertices[i];
		System.out.print(i + " -> ");
		while (current.neighbour != null && !visited[current.neighbour.value]) {
			current = current.neighbour;
			buildOrder(current.value, visited, set);
		}
		if(!set[i]) {
			buildOrder.push(i);
			set[i] = true;
		}
	}

	private void addEdge(int vertex, int neighbour) {
		Vertex newVertex = new Vertex(neighbour);
		Vertex tempV = vertices[vertex];
		while (tempV.neighbour != null) {
			tempV = tempV.neighbour;
		}
		tempV.neighbour = newVertex;
	}

	public BuildOrder(int vertexCount) {
		vertices = new Vertex[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			vertices[i] = new Vertex(i);
		}
	}
	
	class Vertex {
		int value;
		Vertex neighbour = null;
		
		public Vertex(int v) {
			this.value = v;
		}
	}
}
