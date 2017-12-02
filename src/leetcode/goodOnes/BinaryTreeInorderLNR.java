package leetcode.goodOnes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
 *
 */
//NLR
public class BinaryTreeInorderLNR {

  public static void main(String[] args) {
    TreeNode node= new TreeNode(5);
    node.left=new TreeNode(2);
    node.right=new TreeNode(3);
    node.left.left=new TreeNode(1);
    
    System.out.println("\n result= "+inorderTraversal(node));

  }
  public static List<Integer> inorderTraversal(TreeNode root) 
  {
    List<Integer> list = new ArrayList<Integer>();
    //inorderTraversalRecursion(root,list);
    inorderTraversalIteration(root,list);
    return list;
  }
  
  public static void inorderTraversalIteration(TreeNode node,List<Integer> list) 
  {
    if(node== null)
      return;
    Stack<TreeNode> stack= new Stack<TreeNode>();
    //stack.push(node);
    TreeNode tmpNode=node;
    while(tmpNode!=null || !stack.isEmpty())
    {
      if(tmpNode!=null)
      {
        if(tmpNode.left!=null)
        {
          stack.push(tmpNode);
          tmpNode=tmpNode.left;
        }
        else
        {
          list.add(tmpNode.val);
          System.out.print("  "+tmpNode.val);
          tmpNode=tmpNode.right;
        } 
      }
      else //tmpNode is null
      {
        tmpNode=stack.pop();
        list.add(tmpNode.val);
        System.out.print("  "+tmpNode.val);
        tmpNode=tmpNode.right;
      }
    }
  }
  
  public static void inorderTraversalRecursion(TreeNode node,List<Integer> list) 
  {
    if(node==null)
      return;
    inorderTraversalRecursion(node.left,list);
    list.add(node.val);
    inorderTraversalRecursion(node.right,list);
    
  }
  
  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

}
