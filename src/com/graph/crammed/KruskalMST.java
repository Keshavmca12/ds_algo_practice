package com.graph.crammed;

import com.node.EdgeWithWight;
import com.node.GraphEdge;

/**
 * @Autor : Keshav Kumar
 * @Date : 29-Oct-2019
 */

public class KruskalMST {
	
	
	

	public static void main(String[] args) {
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of getEdges() in graph
		GraphEdge graph = new GraphEdge(V, E);

		// add edge 0-1
		graph.getEdges()[0].src = 0;
		graph.getEdges()[0].dest = 1;
		graph.getEdges()[0].weight = 10;

		// add edge 0-2
		graph.getEdges()[1].src = 0;
		graph.getEdges()[1].dest = 2;
		graph.getEdges()[1].weight = 6;

		// add edge 0-3
		graph.getEdges()[2].src = 0;
		graph.getEdges()[2].dest = 3;
		graph.getEdges()[2].weight = 5;

		// add edge 1-3
		graph.getEdges()[3].src = 1;
		graph.getEdges()[3].dest = 3;
		graph.getEdges()[3].weight = 15;

		// add edge 2-3
		graph.getEdges()[4].src = 2;
		graph.getEdges()[4].dest = 3;
		graph.getEdges()[4].weight = 4;

		System.out.println("Graph : **************");
		for (int i = 0; i < graph.getEdges().length; i++) {
			System.out.println("src : " + graph.getEdges()[i].src + " dest : " + graph.getEdges()[i].dest
					+ "  weigth   :  " + graph.getEdges()[i].weight);
		}
		
		
		kruskal(graph, V, E);
		
	}
	
	public static void kruskal(GraphEdge graph, int vertices, int edges) {
		EdgeWithWight result[] = new EdgeWithWight[vertices - 1];
		// TODO Auto-generated method stub
		
	}
	
}
