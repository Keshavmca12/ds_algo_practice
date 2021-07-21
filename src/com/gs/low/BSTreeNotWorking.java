package com.gs.low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author kesha
 *This solution does not work 
 *
 *try to find 
 */
public class BSTreeNotWorking {

	private Integer data;
	private BSTreeNotWorking left;
	private BSTreeNotWorking right;

	public BSTreeNotWorking(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BSTreeNotWorking() {
		// TODO Auto-generated constructor stub
	}

	public boolean findVal(BSTreeNotWorking node, int data) {
		if (node == null) {
			return false;
		}
		if (data == node.data) {
			return false;
		} else if (data < node.data) {
			findVal(node.left, data);
		} else {
			findVal(node.right, data);
		}
		return false;
	}

	public boolean contains(BSTreeNotWorking root, int value) {
		// your code
		return findVal(root, value);

	}

	public BSTreeNotWorking putInTree(BSTreeNotWorking node, int data) {
		if (node.data == null) {
			node = new BSTreeNotWorking(data);
			return node;
		}
		if (data < node.data) {
			if (node.left == null) {
				BSTreeNotWorking temp = new BSTreeNotWorking(data);
				node.left = temp;
				return node;
			} else {
				putInTree(node.left, data);
			}
		} else {
			if (node.right == null) {
				BSTreeNotWorking temp = new BSTreeNotWorking(data);
				node.right = temp;
				return node;
			} else {
				putInTree(node.right, data);
			}
		}
		return null;
	}

	public BSTreeNotWorking put(BSTreeNotWorking root, int value) {
		return putInTree(root, value);
	}

	public List<Integer> inOrderTraversal(BSTreeNotWorking root) {
		List<Integer> dataList = new ArrayList<>();
		inOrderTraversal(root, dataList);
		return dataList;
	}

	public void inOrderTraversal(BSTreeNotWorking node, List<Integer> dataList) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left, dataList);
		dataList.add(node.data);
		inOrderTraversal(node.right, dataList);
	}

	public static void main(String[] args) {
		BSTreeNotWorking searchTree = new BSTreeNotWorking();

		searchTree = searchTree.put(searchTree, 3);
		System.out.println(searchTree.inOrderTraversal(searchTree));
		searchTree = searchTree.put(searchTree, 1);
		System.out.println(searchTree.inOrderTraversal(searchTree));
		searchTree = searchTree.put(searchTree, 2);
		System.out.println(searchTree.inOrderTraversal(searchTree));
		searchTree = searchTree.put(searchTree, 5);
		System.out.println(searchTree.inOrderTraversal(searchTree));
		if (Arrays.asList(1, 2, 3, 5).equals(searchTree.inOrderTraversal(searchTree))
				&& !searchTree.contains(searchTree, 0) && searchTree.contains(searchTree, 1)
				&& searchTree.contains(searchTree, 2) && searchTree.contains(searchTree, 3)
				&& !searchTree.contains(searchTree, 4) && searchTree.contains(searchTree, 5)
				&& !searchTree.contains(searchTree, 6)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

}
