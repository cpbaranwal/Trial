package leetcode.easy;

import leetcode.easy.LongestUnivaluePath.TreeNode;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 * @author chandan
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, 
 * where each node in this tree has exactly two or zero sub-node. 
 * If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
If no such second minimum value exists, output -1 instead.
Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 */
public class SecondMinmNodeInBinaryTree {

  public static void main(String[] args) {
    TreeNode t= new TreeNode(2);
    t.left= new TreeNode(2);
    //t.left.left= new TreeNode(4);
    //t.left.right= new TreeNode(4);
    t.right= new TreeNode(2);
    t.right.left= new TreeNode(2);
    t.right.right= new TreeNode(2);
    SecondMinmNodeInBinaryTree obj = new SecondMinmNodeInBinaryTree();
    int res= obj.findSecondMinimumValue(t);
    System.out.println("res= "+res);
  }
  
  public int findSecondMinimumValue(TreeNode root) {
    if(root==null || root.left==null)
      return -1;
    int l= root.left.val;
    if(l==root.val)
      l= findSecondMinimumValue(root.left);
    int r= root.right.val;
    if(r==root.val)
      r=findSecondMinimumValue(root.right);
    
    //System.out.println("current val="+root.val+"  l="+l+"   r="+r);
    if(r==root.val && l==root.val)
      return -1;
    else if(r==root.val || r==-1)
      return l;
    else if(l==root.val || l==-1)
      return r;
    else  
      return (r<l ?  r:l);
    
  }
  
  
  
  static public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
