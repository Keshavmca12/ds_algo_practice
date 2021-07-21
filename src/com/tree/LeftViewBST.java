package com.tree;

import com.node.BinaryTreeNode;

/**
 * @Autor : Keshav Kumar
 * @Date : 29-Oct-2018
 */

public class LeftViewBST {
	private static int maxLevel = 0;
	public static void main(String[] args) {
      /* BinaryTreeNode  node = new BinaryTreeNode(12); 
        node.left = new BinaryTreeNode(10); 
        node.right = new BinaryTreeNode(30); 
        node.right.left = new BinaryTreeNode(25); 
        node.right.right = new BinaryTreeNode(40); */
		
		BinaryTreeNode node = new BinaryTreeNode(1); 
        node.left = new BinaryTreeNode(2); 
        node.right = new BinaryTreeNode(3); 
        node.left.left = new BinaryTreeNode(4); 
        node.left.right = new BinaryTreeNode(5); 
        node.right.left = new BinaryTreeNode(6); 
        node.right.right = new BinaryTreeNode(7); 
        node.right.left.right = new BinaryTreeNode(8); 
        
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
