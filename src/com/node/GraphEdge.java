package com.node;

/**
 * @Autor : Keshav Kumar
 * @Date : 29-Oct-2019
 */

public class GraphEdge {
	int NO_OF_VERTICES, NO_OF_EDGES;
	EdgeWithWight edges[];

	public GraphEdge(int vertices, int edges) {
		super();
		NO_OF_VERTICES = vertices;
		NO_OF_EDGES = edges;
		this.edges = new EdgeWithWight[NO_OF_EDGES];
		for (int i = 0; i < NO_OF_EDGES; i++) {
			this.edges[i] = new EdgeWithWight();
		}
	}

	public EdgeWithWight[] getEdges() {
		return edges;
	}

	public void setEdges(EdgeWithWight[] edges) {
		this.edges = edges;
	}

	

}
