package com.tree;

import java.util.Stack;

import com.node.BinaryTreeNode;

/**
 * @author Keshav Kumar
 * @Date 29-Oct-2018
 */

public class ZigzagTraversal {
	public static void main(String[] args) {
		    BinaryTreeNode node = new BinaryTreeNode(1); 
		    node.left = new BinaryTreeNode(2); 
		    node.right = new BinaryTreeNode(3); 
		    node.left.left = new BinaryTreeNode(7); 
		    node.left.right = new BinaryTreeNode(6); 
		    node.right.left = new BinaryTreeNode(5); 
		    node.right.right = new BinaryTreeNode(4); 
		  
		    System.out.println("ZigZag Order traversal of binary tree is"); 
		    printZigzag(node); 
	}

	private static void printZigzag(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}
		Stack<BinaryTreeNode> currentLevel = new Stack<>();
		Stack<BinaryTreeNode> nextLevel = new Stack<>();
		boolean leftToRight = true;
		currentLevel.push(tree);
		while (!currentLevel.isEmpty()) {

			BinaryTreeNode currentNode = currentLevel.pop();
			System.out.print(currentNode.data + "     ");
			if (leftToRight) {
				if (currentNode.left != null) {
					nextLevel.push(currentNode.left);
				}
				if (currentNode.right != null) {
					nextLevel.push(currentNode.right);
				}
			} else {
				if (currentNode.right != null) {
					nextLevel.push(currentNode.right);
				}
				if (currentNode.left != null) {
					nextLevel.push(currentNode.left);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				currentLevel = nextLevel;
				nextLevel = new Stack<>();
			}
		}
	}
}
