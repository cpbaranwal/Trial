package leetcode.medium;


/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 * @author chandan
 *Given a binary tree, write a function to get the maximum width of the given tree. 
 *The width of a tree is the maximum width among all levels. 
 *The binary tree has the same structure as a full binary tree, but some nodes are null.
The width of one level is defined as the length between the end-nodes
 (the leftmost and right most non-null nodes in the level, where the null nodes between
  the end-nodes are also counted into the length calculation.
Example 1:
Input: 
           1
         /   \
        3     2
       / \     \  
      5   3     9 
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: 
          1
         /  
        3    
       / \       
      5   3     
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: 
          1
         / \
        3   2 
       /        
      5      
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input: 
          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null
 */
public class MaxmWidthBinaryTree {

  public static void main(String[] args) {
      TreeNode t= new TreeNode(1);
      t.left= new TreeNode(3);
      t.left.left= new TreeNode(5);
      t.left.right= new TreeNode(3);
      t.right= new TreeNode(2);
      //t.right.left= new TreeNode(2);
      t.right.right= new TreeNode(9);
      MaxmWidthBinaryTree obj = new MaxmWidthBinaryTree();
      int res= obj.widthOfBinaryTree(t);
      System.out.println("res= "+res);

  }
  
  int maxlevel=0;
  public int widthOfBinaryTree(TreeNode root) {
    if(root==null)
      return 0;
    widthOfBinaryTreeHelper(root);
    return (int)Math.pow(2, maxlevel);
    
  }
  public void widthOfBinaryTreeHelper(TreeNode node ) {
    if(node==null)
      return;
    widthOfBinaryTreeHelper(node.left);
    widthOfBinaryTreeHelper(node.right);
    int numLeft=0;int numRight=0;
    TreeNode t1=node;
    TreeNode t2=node;
    while(t1.left!=null)
    {
      t1=t1.left;
      numLeft++;
    }
    while(t2.right!=null)
    {
      t2=t2.right;
      numRight++;
    }
    int num= numLeft<numRight ? numLeft:numRight;
    maxlevel = num>maxlevel ? num:maxlevel;
    
  }
  
  
  
  
    
    
  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


}
