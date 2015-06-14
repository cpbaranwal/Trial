package pack8;

/**
date: 14 june 2015
Convert an arbitrary Binary Tree to a tree that holds Children Sum Property

Problem: Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property.
 You can only increment data values in any node (You cannot change structure of tree and cannot decrement value of any node). 
 e.g.inorder of Original Tree: 
  3  7  5  50  1  2  30
             50
           /     \             
         /         \
       7             2
     / \             /\
   /     \          /   \
  3        5      1      30
  
  one possible result:
  inorder of New Tree: 
  14  19  5  50  1  31  30
            50
          /     \             
        /         \
      19            31
     / \             /\
   /     \          /   \
  14      5       1      30
  
  http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 */

import pack6.TreeUtil;
import pack6.TreeUtil.Tnode;
public class ChildrenSumBinaryTree {

	public static void main(String[] args) 
	{
		System.out.println("Program to modify a binary tree into a Tree where node value is sum of children nodes");
		Tnode root= new Tnode(50);
		root.l=new Tnode(7);
		root.r=new Tnode(2);
		root.l.l=new Tnode(3);
		root.l.r=new Tnode(5);
		root.r.l=new Tnode(1);
		root.r.r=new Tnode(30);
		
		System.out.println("inorder of Original Tree: ");
		TreeUtil.inorderTraversal(root);
		
		modifyChildrenSumNode(root);
		
		System.out.println("\n inorder of New Tree: ");
		TreeUtil.inorderTraversal(root);

	}

	private static int modifyChildrenSumNode(Tnode node)
	{
		if(node==null )
			return 0;
		
		int leftSum = modifyChildrenSumNode(node.l);
		int rightSum = modifyChildrenSumNode(node.r);
		if((leftSum+rightSum) > node.data )
			node.data = leftSum+rightSum;
		else if ((leftSum+rightSum) < node.data )  //we cant decrease node value ,so will increase value of one of children down the line, lets take left childs only
		{
			increaseValueChildrenDown(node);
		}
		
		return node.data;
	}

	private static void increaseValueChildrenDown(Tnode node) //helper method to increase value of children when parent node value is greater than sum of children values
	{
		if(node.l!=null)
		{
			node.l.data = node.data - (node.r==null? 0: node.r.data);
			increaseValueChildrenDown(node.l);
		}
		else if(node.r!=null)
		{
			node.r.data = node.data ;
			increaseValueChildrenDown(node.r);
		}
		return;
	}

}
