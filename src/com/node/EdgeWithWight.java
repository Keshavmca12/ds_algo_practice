package com.node;

/**
 * @Autor : Keshav Kumar
 * @Date : 29-Oct-2019
 */

public class EdgeWithWight implements Comparable<EdgeWithWight> {

	public int src;
	public int dest;
	public int weight;

	@Override
	public int compareTo(EdgeWithWight o) {
		return this.weight - o.weight;
	}

}
