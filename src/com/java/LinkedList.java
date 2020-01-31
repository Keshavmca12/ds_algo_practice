package com.java;

/**
 * @Autor : Keshav Kumar
 * @Date : 09-Jan-2020
 */

public class LinkedList {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		printList(node1);
		System.out.println("*****after reverse**********");
		printList(revrseList(node1));
	//	printList(node1);
	}

	private static Node revrseList(Node node) {
		if (node == null) {
			System.out.println("Empty nort possible");
		}
		Node prev = null; 
        Node current = node; 
        Node next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
	}

	private static void printList(Node node1) {
		if (node1 == null) {
			System.out.println("Empty");
		}
		while (node1 != null) {
			System.out.println(node1.data);
			node1 = node1.next;
		}

	}
}

class Node {

	public Node(int data) {
		this.data = data;
	}

	int data;
	Node next;

/*	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}*/

}
