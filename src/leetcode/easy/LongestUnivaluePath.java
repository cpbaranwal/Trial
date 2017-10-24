package leetcode.easy;


/**
 * https://leetcode.com/problems/longest-univalue-path/description/
 * @author chandan
 *Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
Note: The length of path between two nodes is represented by the number of edges between them.
Example 1:
Input:
              5
             / \
            4   5
           / \   \
          1   1   5
Output:  2
Example 2:
Input:
              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2
 */
public class LongestUnivaluePath {

  public static void main(String[] args) {
    TreeNode t= new TreeNode(1);
    //t.left= new TreeNode(4);
    //t.left.left= new TreeNode(4);
    //t.left.right= new TreeNode(4);
    //t.right= new TreeNode(5);
    //t.right.right= new TreeNode(5);
    LongestUnivaluePath obj = new LongestUnivaluePath();
    System.out.println("result= "+obj.longestUnivaluePath(t));

  }
  
  static int maxCnt=0;
  public int longestUnivaluePath(TreeNode root)
  {
    longestUnivaluePathHelper(root);
    return maxCnt;
  }
  public int longestUnivaluePathHelper(TreeNode root)
  {
    if(root==null || (root.left==null && root.right==null))
        return 0;

    TreeNode node=root;
    int cnt1=0;int cnt2=0;
    if(node.left!=null)
    {
      cnt1=longestUnivaluePathHelper(node.left);
      if(node.val==node.left.val)
        cnt1++;
      else
        cnt1=0;
    }
    if(node.right!=null)
    {
      cnt2=longestUnivaluePathHelper(node.right);
      if(node.val==node.right.val)
        cnt2++;
      else
        cnt2=0;
    }
    int cnt=0;
    if(cnt1>0)
      cnt += cnt1;
    if(cnt2>0)
      cnt += cnt2;
    if(cnt>maxCnt)
      maxCnt=cnt;
    
    return cnt;
  }
  
  
  
  static public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
