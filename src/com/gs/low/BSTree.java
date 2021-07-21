package com.gs.low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTree {

	static class BST {
		static class Node {
			private Integer data;
			private Node left;
			private Node right;
		}

		Node root;

		public BST() {
			this.root = new Node();
		}

		public boolean findVal(Node node, int data) {
			if (node == null) {
				return false;
			}
			if (data == node.data) {
				return true;
			}
			return (findVal(node.left, data) || findVal(node.right, data));
		}

		public void putInTree(Node node, int data) {
			if (node.data == null) {
				node.data = data;
				return;
			}
			if (data < node.data) {
				if (node.left == null) {
					Node temp = new Node();
					temp.data = data;
					node.left = temp;
					return;
				} else {
					putInTree(node.left, data);
				}
			} else {
				if (node.right == null) {
					Node temp = new Node();
					temp.data = data;
					node.right = temp;
					return;
				} else {
					putInTree(node.right, data);
				}
			}
		}

		public void put(int value) {
			putInTree(root, value);
		}

		public boolean contains(int value) {
			// your code
			return findVal(root, value);

		}

		public List<Integer> inOrderTraversal() {
			List<Integer> dataList = new ArrayList<>();
			inOrderTraversal(root, dataList);
			return dataList;
		}

		public void inOrderTraversal(Node node, List<Integer> dataList) {
			if (node == null) {
				return;
			}
			inOrderTraversal(node.left, dataList);
			dataList.add(node.data);
			inOrderTraversal(node.right, dataList);
		}

	}

	public static void main(String[] args) {
		final BST searchTree = new BST();

		searchTree.put(3);
		System.out.println(searchTree.inOrderTraversal());
		searchTree.put(1);
		System.out.println(searchTree.inOrderTraversal());
		searchTree.put(2);
		System.out.println(searchTree.inOrderTraversal());
		searchTree.put(5);
		System.out.println(searchTree.inOrderTraversal());
		if (Arrays.asList(1, 2, 3, 5).equals(searchTree.inOrderTraversal()) && !searchTree.contains(0)
				&& searchTree.contains(1) && searchTree.contains(2) && searchTree.contains(3) && !searchTree.contains(4)
				&& searchTree.contains(5) && !searchTree.contains(6)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

}
