package com.graph.crammed;

import java.util.LinkedList;

import com.node.Graph;

/**
 * @Autor : Keshav Kumar
 * @Date : 03-Dec-2018
 */

public class DFS {

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		new DFS().DFSTraversal(4);
		System.out.println("");
		System.out.println("Following is Depth First Traversal for disconnected grtaph");

		new DFS().DFSTraversal(2, 4);
	}

	/**
	 * Function to traverse disconnected graph
	 * 
	 * @param noOfVertices
	 */
	private void DFSTraversal(int noOfVertices) {
		boolean[] visited = new boolean[noOfVertices];
		for (int j = 0; j < noOfVertices; j++) {
			if (!visited[j]) {
				DFSUtil(j, visited);
			}
		}
	}

	/**
	 * Function to traverse graph from given source
	 * 
	 * @param noOfVertices
	 */
	private void DFSTraversal(int source, int noOfVertices) {
		boolean[] visited = new boolean[noOfVertices];
		DFSUtil(source, visited);
	}

	private void DFSUtil(int j, boolean[] visited) {
		visited[j] = true;
		System.out.print(j + " ");
		// Recur for all the vertices adjacent to this vertex
		LinkedList<Integer> adjList = Graph.getAdjacencyList(j);
		for (Integer integer : adjList) {
			if (!visited[integer]) {
				DFSUtil(integer, visited);
			}
			// ;
		}
	}

}
