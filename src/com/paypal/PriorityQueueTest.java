package com.paypal;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class PriorityQueueTest {
public static void main(String[] args) {
	PriorityQueue<Integer> pQueue= new PriorityQueue<>(Collections.reverseOrder());
	pQueue.add(50);
	pQueue.add(90);
	pQueue.add(700);
	pQueue.add(90);
	pQueue.add(700);
	System.out.println(pQueue);
	
	
	TreeSet<Integer> tSet= new TreeSet<>();
	tSet.add(50);
	tSet.add(90);
	tSet.add(700);
	System.out.println(tSet);
	
	System.err.println(tSet.pollLast());
	
	System.out.println(tSet);
}
}

