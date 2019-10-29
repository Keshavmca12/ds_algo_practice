package com.node;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Autor : Keshav Kumar
 * @Date : 03-Dec-2018
 */

public class Graph {

	private static LinkedList<Integer> adj[]; // Adjacency Lists

	public Graph() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	@Override
	public String toString() {
		for (int i = 0; i < adj.length; i++) {
			System.out.println(i+ " : " +adj[i]);
		}
		return "";
	}


	// Function to add an edge into the graph
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public static LinkedList<Integer> getAdjacencyList(int vertex) {
		return adj[vertex];
	}
	
	public static void searchEdge(int u, int v) {
		boolean found = getAdjacencyList(u).contains(v);
		if (found) {
			System.out.println("Edge found between " + u + " and " + v);
		} else {
			System.out.println("Edge not found between " + u + " and " + v);
		}
	}
	
	public static void printGraph(){
		int i = 0;
		for (LinkedList<Integer> linkedList : adj) {
			System.out.print("head : " + (i++));
			for (Integer integer : linkedList) {
				System.out.print(" => " + integer);
			}
			System.out.println("");
		}
	}

}
