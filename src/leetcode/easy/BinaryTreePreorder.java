package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * @author chandan
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
 *
 */
//NLR
public class BinaryTreePreorder {

  public static void main(String[] args) {
    TreeNode node= new TreeNode(5);
    node.left=new TreeNode(2);
    node.right=new TreeNode(3);
    node.left.left=new TreeNode(1);
    
    System.out.println("result= "+preorderTraversal(node));

  }
  public static List<Integer> preorderTraversal(TreeNode root) 
  {
    List<Integer> list = new ArrayList<Integer>();
    //preorderTraversalRecursion(root,list);
    preorderTraversalIteration(root,list);
    return list;
  }
  
  public static void preorderTraversalIteration(TreeNode node,List<Integer> list) 
  {
    if(node== null)
      return;
    Stack<TreeNode> stack= new Stack<TreeNode>();
    stack.push(node);
    while(!stack.isEmpty())
    {
      TreeNode curr= stack.pop();
      list.add(curr.val);
      if(curr.right!=null)
        stack.push(curr.right);
      if(curr.left!=null)
        stack.push(curr.left);
    }
  }
  
  public static void preorderTraversalRecursion(TreeNode node,List<Integer> list) 
  {
    if(node==null)
      return;
    list.add(node.val);
    preorderTraversalRecursion(node.left,list);
    preorderTraversalRecursion(node.right,list);
    
  }
  
  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

}
