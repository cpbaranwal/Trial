package leetcode.goodOnes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
//LRN
public class BinaryTreePostorderLRN {

  public static void main(String[] args) {
    TreeNode node= new TreeNode(5);
    node.left=new TreeNode(2);
    node.right=new TreeNode(3);
    node.left.left=new TreeNode(1);
    
    System.out.println("\n result= "+postorderTraversal(node));

  }
  public static List<Integer> postorderTraversal(TreeNode root) 
  {
    List<Integer> list = new ArrayList<Integer>();
    //postorderTraversalRecursion(root,list);
    postorderTraversalIteration(root,list);
     Collections.reverse(list); // tricky part
     return list;
  }
  
  public static void postorderTraversalIteration(TreeNode node,List<Integer> list) 
  {
    if(node== null)
      return;
    Stack<TreeNode> stack= new Stack<TreeNode>();
    stack.push(node);
    while(!stack.isEmpty())
    {
      TreeNode tmp= stack.pop();
      if(tmp.left!=null)
        stack.push(tmp.left);
      if(tmp.right!=null)
        stack.push(tmp.right);
      list.add(tmp.val);
    }
    
  }
  
  public static void postorderTraversalRecursion(TreeNode node,List<Integer> list) 
  {
    if(node==null)
      return;
    postorderTraversalRecursion(node.left,list);
    postorderTraversalRecursion(node.right,list);
    list.add(node.val);
    
  }
  
  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

}
