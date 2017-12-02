package leetcode.medium.tree;

/**
 * https://leetcode.com/problems/house-robber-iii/description/
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 */
public class HouseRobber {

  public static void main(String[] args) {
    TreeNode t= new TreeNode(3);
    t.left= new TreeNode(4);
    t.left.left= new TreeNode(1);
    t.left.right= new TreeNode(3);
    t.right= new TreeNode(5);
    t.right.right= new TreeNode(1);
    //t.right.left.left= new TreeNode(4);
    //t.right.right= new TreeNode(4);
    System.out.println("result= "+rob(t));

  }
  
  public static int rob(TreeNode root) 
  {
    if(root==null)
      return 0;
    
    int amt1= root.val;
    if(root.left!=null)
      amt1= amt1 + rob(root.left.left) +rob(root.left.right);
    if(root.right!=null)
      amt1= amt1 + rob(root.right.left) +rob(root.right.right);
    
    int amt2= rob(root.left) + rob(root.right);
    return amt1>amt2? amt1:amt2;  
  }


}
