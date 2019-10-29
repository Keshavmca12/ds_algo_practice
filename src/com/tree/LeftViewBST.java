package com.tree;

import com.node.BinaryTreeNode;

/**
 * @Autor : Keshav Kumar
 * @Date : 29-Oct-2018
 */

public class LeftViewBST {
	private static int maxLevel = 0;
	public static void main(String[] args) {
       BinaryTreeNode  node = new BinaryTreeNode(12); 
        node.left = new BinaryTreeNode(10); 
        node.right = new BinaryTreeNode(30); 
        node.right.left = new BinaryTreeNode(25); 
        node.right.right = new BinaryTreeNode(40); 
        
        printLeftView(node, 1);
	}

	private static void printLeftView(BinaryTreeNode root, int currentLevel) {
		if (root == null) {
			return;
		}
		if(  maxLevel < currentLevel){
			maxLevel = currentLevel;
			System.out.print(root.data + "           ");
		}
		printLeftView(root.left, currentLevel+1);
		printLeftView(root.right, currentLevel+1);
	}
}
