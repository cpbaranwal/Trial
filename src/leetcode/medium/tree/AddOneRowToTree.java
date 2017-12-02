package leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;





/**
 * https://leetcode.com/problems/add-one-row-to-tree/description/
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:
Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   

Example 2:
Input: 
A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
Note:
The given d is in range [1, maximum depth of the given tree + 1].
The given binary tree has at least one tree node.
 *
 */
public class AddOneRowToTree {

  public static void main(String[] args) {
    TreeNode t= new TreeNode(4);
    t.left= new TreeNode(2);
    t.left.right= new TreeNode(1);
    t.left.left= new TreeNode(3);
    //t.left.left.left= new TreeNode(4);
    t.right= new TreeNode(6);
    t.right.left= new TreeNode(5);
    System.out.println("input= "+inorderTraversal(t));
    int v=1; int d=2;
    
    TreeNode root=addOneRow(t,v,d);
    System.out.println("result= "+inorderTraversal(root));
    

  }
  
  
  
  public static TreeNode addOneRow(TreeNode root, int v, int d) {
    if(root==null || d<1)
      return root;
    if(d==1)
    {
      TreeNode tmp= new TreeNode(v);
      tmp.left=root;
      return tmp;
    }
    addOneRowHelper(root,v,d);
    return root;
  }

  private static void addOneRowHelper(TreeNode node, int v, int d) 
  {
    if(node==null)
      return;
    if(d==2)
    {
      TreeNode tmpLeft=node.left;
      node.left= new TreeNode(v);
      if(tmpLeft!=null)
      {
        node.left.left= tmpLeft;
      }     
      TreeNode tmpRight=node.right;
      node.right= new TreeNode(v);
      if(tmpRight!=null)
      {
        node.right.right= tmpRight;
      }
      return;
    }
    addOneRowHelper(node.left,v,d-1);
    addOneRowHelper(node.right,v,d-1);
  }
  
  public static List<Integer> inorderTraversal(TreeNode root) 
  {
    List<Integer> list = new ArrayList<Integer>();
    inorderTraversalRecursion(root,list);
    //inorderTraversalIteration(root,list);
    return list;
  }
  
  
  
  public static void inorderTraversalRecursion(TreeNode node,List<Integer> list) 
  {
    if(node==null)
      return;
    inorderTraversalRecursion(node.left,list);
    list.add(node.val);
    inorderTraversalRecursion(node.right,list);
    
  }
}
