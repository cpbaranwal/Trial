package leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/print-binary-tree/description/
 * @author chandan
 * Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
 *
 */
public class PrintBinaryTreeLikeArray {

  public static void main(String[] args) {
    TreeNode t= new TreeNode(1);
    //t.left= new TreeNode(2);
    //t.left.right= new TreeNode(4);
    //t.left.left= new TreeNode(3);
    //t.left.left.left= new TreeNode(4);
    //t.right= new TreeNode(3);
    System.out.println("result = "+printTree(t));
    
  }
 
    public static List<List<String>> printTree(TreeNode root) {
      List<List<String>> list= new ArrayList<List<String>>();
      if(root==null)
        return list;
      int m= getDepthOfTree(root);
      int n= (int)Math.pow(2, m) -1 ;
      List<String> l1= new ArrayList<String>(n);
      for(int i=0;i<n;i++)
      l1.add("");
      for(int i=0; i<m; i++)
      {
        list.add(new ArrayList<String>(l1));       
      }
      System.out.println("before m="+m+"  n="+n+"  list="+list);
      populateTreeHelper(root,list,m,m,0);
      return list;
      
      
      
    }
    
    private static void populateTreeHelper(TreeNode node, List<List<String>> list, int m, int currDepth,int leftIndx)
    {
      if(node==null)
        return;
      List<String> l1= list.get(m-currDepth);
      int indx= leftIndx + (int)Math.pow(2, currDepth-1) - 1;
      //if(leftIndx>0 && indx==leftIndx)
        //indx++;
      l1.set(indx, String.valueOf(node.val));
      System.out.println("in-between currDepth="+currDepth+"node.val="+node.val+"  leftIndx="+leftIndx+"  indx="+indx+"  list="+list);
      populateTreeHelper(node.left,list,m,currDepth-1,leftIndx);
      populateTreeHelper(node.right,list,m,currDepth-1,indx+1);
    }

    private static int  getDepthOfTree(TreeNode node)
    {
      if(node==null)
        return 0;
      int l= getDepthOfTree(node.left);
      int r= getDepthOfTree(node.right);
      
      return (1 + Math.max(l, r));
    }
    
    

}
