package com.tree;

import com.node.BinaryTreeNode;

/**
 * @author Keshav Kumar
 * @Date 25-Oct-2018
 */
public class TreeMirror {

	public static void main(String[] args) {
	        BinaryTreeNode root = new BinaryTreeNode(1); 
	        root.left = new BinaryTreeNode(2); 
	        root.right = new BinaryTreeNode(3); 
	        root.left.left = new BinaryTreeNode(4); 
	        root.left.right = new BinaryTreeNode(5); 
	        inorderTraversal(root);
	        mirrorTree(root);
	        System.out.println("******** after mirror **************");
	        inorderTraversal(root);
	}

	private static void mirrorTree(BinaryTreeNode tree) {
		if(tree == null){
			return ;
		}
		mirrorTree(tree.left);
		mirrorTree(tree.right);
		BinaryTreeNode temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
	}
	
	private static  void inorderTraversal(BinaryTreeNode tree){
		if(tree == null){
			return ;
		}
		inorderTraversal(tree.left);
		System.out.print(tree.data + "            ");
		inorderTraversal(tree.right);
	}

}
