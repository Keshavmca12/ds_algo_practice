package com.graph.crammed;

import java.util.LinkedList;
import java.util.Queue;

import com.node.Graph;

/**
 * @Autor : Keshav Kumar
 * @Date : 03-Dec-2018
 */

public class BFS {
	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		BFSTraversal(2, 4);
	}

	private static void BFSTraversal(int source, int noOfVertices) {

		boolean[] visited = new boolean[noOfVertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[source] = true;
		queue.add(source);
		while (!queue.isEmpty()) {
			int vertex = queue.remove();
			System.out.print(vertex + "    ");
			LinkedList<Integer> adjList = Graph.getAdjacencyList(vertex);
			for (Integer integer : adjList) {
				if (!visited[integer]) {
					visited[integer] = true;
					queue.add(integer);
				}
			}
		}
	}
}
