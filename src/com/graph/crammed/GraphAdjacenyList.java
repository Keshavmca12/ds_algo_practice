package com.graph.crammed;

import com.node.Graph;

/**
 * @Autor : Keshav Kumar 
 * @Date : 17-Oct-2019
 */

public class GraphAdjacenyList {
	
	public static void main(String[] args) {
		 int V = 5; 
	        Graph graph = new Graph(V); 
	         graph.addEdge(0, 1); 
	         graph.addEdge(0, 4); 
	         graph.addEdge(1, 0); 
	         graph.addEdge(1, 2); 
	         graph.addEdge(1, 3); 
	         graph.addEdge(1, 4); 
	         graph.addEdge(2, 1); 
	         graph.addEdge(2, 3); 
	         graph.addEdge(3, 1); 
	         graph.addEdge(3, 2); 
	         graph.addEdge(3, 4); 
	         graph.addEdge(4, 0); 
	         graph.addEdge(4, 1); 
	         graph.addEdge(4, 3); 
	        // print the adjacency list representation of  
	        // the above graph 
	         Graph.printGraph(); 
	         
	         Graph.searchEdge(2, 1); 
	         Graph.searchEdge(0, 3);
	}
	
	

}


