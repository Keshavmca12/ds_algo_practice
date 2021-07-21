package com.tree;

import com.node.BinaryTreeNode;

/**
 * @Autor : Keshav Kumar 
 * @Date : 29-Oct-2018
 */

public class RightViewTree {
	
	private static int maxLevel = 0;

	public static void main(String[] args) {
		BinaryTreeNode node = new BinaryTreeNode(1); 
        node.left = new BinaryTreeNode(2); 
        node.right = new BinaryTreeNode(3); 
        node.left.left = new BinaryTreeNode(4); 
        node.left.right = new BinaryTreeNode(5); 
        node.right.left = new BinaryTreeNode(6); 
        node.right.right = new BinaryTreeNode(7); 
        node.right.left.right = new BinaryTreeNode(8); 
          
        printRightView(node, 1);
	}
	
	private static void printRightView(BinaryTreeNode root, int currentLevel) {
		
		if (root == null) {
			return;
		}
		
		System.out.println("node " + root.data);
		if(  maxLevel < currentLevel){
			maxLevel = currentLevel;
			System.out.print(root.data + "           ");
		}
		printRightView(root.right, currentLevel+1);
		printRightView(root.left, currentLevel+1);
	}
}


