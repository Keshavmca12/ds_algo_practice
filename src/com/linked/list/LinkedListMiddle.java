package com.linked.list;

import com.java.LinkedList;

/**
 * @Autor : Keshav Kumar
 * @Date : 17-Feb-2020
 */

public class LinkedListMiddle {

	public static void main(String[] args) {
		int value = 1;
		Node n1 = new Node(value++);
		Node n2 = new Node(value++);
		Node n3 = new Node(value++);
		Node n4 = new Node(value++);
		Node n5 = new Node(value++);
		Node n6 = new Node(value++);
		Node n7 = new Node(value++);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		Node middleNode = getMiddleElement(n1);
		System.out.println(middleNode != null ? middleNode.data : -1);
		
		
		java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
		list.add(50);
		list.add(60);
		System.out.println(list);

	}

	public static Node  getMiddleElement(Node node){
		Node next = node;
		Node nextToNext = node;
		if(node == null){
			return node;
		}
		while(nextToNext.next != null){
			next  = next.next;
			nextToNext = next.next.next;
		}
		
		return next;
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		
	}

}
