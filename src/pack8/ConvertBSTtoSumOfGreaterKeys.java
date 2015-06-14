package pack8;
import pack6.TreeUtil;
import pack6.TreeUtil.Tnode;

/**
date: 14 june 2015
Convert a BST to a Binary Tree such that sum of all greater keys is added to every key

Given a Binary Search Tree (BST), convert it to a Binary Tree such that every key of the original BST is changed to key plus sum of all greater keys in BST.

Examples:

Input: Root of following BST
 1.           5
            /   \
           2     13
 
2.            30
           /     \             
         /         \
       10             50
     / \             /\
   /     \          /   \
  5       20      40      60
             

Output: The given BST is converted to following Binary Tree
1.            18
            /   \
          20     13
2.           180
           /     \             
         /         \
      210            110
     / \             /\
   /     \          /   \
215      200      150    60
            
link: http://www.geeksforgeeks.org/convert-bst-to-a-binary-tree/
 */
public class ConvertBSTtoSumOfGreaterKeys {

	public static void main(String[] args)
	{
		System.out.println("Program to modify a binary tree into a Tree where node value is sum of children nodes");
		Tnode root= new Tnode(30);
		root.l=new Tnode(10);
		root.r=new Tnode(50);
		root.l.l=new Tnode(5);
		root.l.r=new Tnode(20);
		root.r.l=new Tnode(40);
		root.r.r=new Tnode(60);
		
		System.out.println("inorder of Original Tree: ");
		TreeUtil.inorderTraversal(root);
		
		convertToSumGrtrKeys(root);
		
		System.out.println("\n inorder of New Tree: ");
		TreeUtil.inorderTraversal(root);

	}

	//approach: RNL
	//basically we have to traverse nodes in RNL order and every time we visit a node, we have to add the node value to a global variable sumKeys
	//and update the node value as well with the current sumKeys value.
	static int sumKeys = 0;
	private static void convertToSumGrtrKeys(Tnode node) 
	{
		if(node==null)
			return;
		convertToSumGrtrKeys(node.r);
		sumKeys = sumKeys +node.data;
		node.data = sumKeys;
		convertToSumGrtrKeys(node.l);
	}

	

}
