package leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 * @author chandan
 *Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
 */
public class MaxmBinaryTreeFromArray {

 
    public static void main(String[] args) 
    {
      int[] arr= {3,2,1,6,0,5};
      TreeNode root= constructMaximumBinaryTree(arr);
      System.out.println("result= "+inorderTraversal(root));
      
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) 
    {
      if(nums==null || nums.length<1)
        return null;
      return constructMaximumBinaryTreeHelper(nums,0,nums.length-1);
    }
    
    private static TreeNode constructMaximumBinaryTreeHelper(int[] nums, int left, int right) 
    {
      if(left>right)
        return null;
      if(left==right)
        return new TreeNode(nums[left]);
      int maxElementIndx=left;
      for(int i=left;i<=right;i++)
      {
        if(nums[i]>nums[maxElementIndx])
          maxElementIndx=i;
      }
      TreeNode currNode= new TreeNode(nums[maxElementIndx]);
      currNode.left= constructMaximumBinaryTreeHelper(nums,left,maxElementIndx-1);
      currNode.right= constructMaximumBinaryTreeHelper(nums,maxElementIndx+1,right);
      return currNode;
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
