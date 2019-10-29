package com.tree;

import com.node.BinaryTreeNode;

/**
 * @author Keshav Kumar
 * @Date 25-Oct-2018
 */
public class PrintLeaves {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.right.left = new BinaryTreeNode(5);
		root.right.right = new BinaryTreeNode(8);
		root.right.left.left = new BinaryTreeNode(6);
		root.right.left.right = new BinaryTreeNode(7);
		root.right.right.left = new BinaryTreeNode(9);
		root.right.right.right = new BinaryTreeNode(10);

		printLeaves(root);
	}

	private static void printLeaves(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}
		printLeaves(tree.left);
		printLeaves(tree.right);
		if (tree.left == null && tree.right == null) {
			System.out.println(tree.data);
		}
	}
}
