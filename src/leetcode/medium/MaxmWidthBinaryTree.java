package leetcode.medium;
import java.util.*;


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
        //t.left.left.left= new TreeNode(6);
        t.left.right= new TreeNode(3);
        //t.right= new TreeNode(2);
        //t.right.left= new TreeNode(2);
        //t.right.right= new TreeNode(9);
        //t.right.right.right= new TreeNode(7);
        MaxmWidthBinaryTree obj = new MaxmWidthBinaryTree();
        int res= obj.widthOfBinaryTree(t);
        System.out.println("res= "+res);

    }

    
    static List<TreeNode> list1 = new ArrayList<TreeNode>();
    static List<TreeNode> list2 = new ArrayList<TreeNode>();
    static int max=0;
    public int widthOfBinaryTree(TreeNode root)
    {
        if(root==null)
            return 0;
        list1.add(root.left);
        list1.add(root.right);
        findMaxWidthHelper();
        return max;
    }

    private void findMaxWidthHelper()
    {
        boolean flagContinue=true;
        while(flagContinue)
        {
            flagContinue = false;

            if(!list1.isEmpty())
            {

                int indx1=-1; int indx2=-1;
                for(int i =0; i< list1.size(); i++)
                {
                    TreeNode node = list1.get(i);
                    if(node!=null)
                    {
                        flagContinue = true;//needed to check if any valid number
                        list2.add(node.left);
                        list2.add(node.right);
                        if(indx1 == -1)
                            indx1=i;
                        else
                            indx2=i;
                    }
                    else
                    {
                        list2.add(null);
                        list2.add(null);
                    }
                }
                if(max < (indx2-indx1+1))
                    max=(indx2-indx1+1);
                System.out.println("list1 ="+list1);
                System.out.println("list1  indx1="+indx1+"   indx2="+indx2+"  max="+max+"  ");
                list1 = new ArrayList<TreeNode>();
            }
            else //!list2.isEmpty()
            {
                int indx1=-1; int indx2=-1;
                for(int i =0; i< list2.size(); i++)
                {
                    TreeNode node = list2.get(i);
                    if(node!=null)
                    {
                        flagContinue = true;//needed to check if any valid number
                        list1.add(node.left);
                        list1.add(node.right);
                        if(indx1 == -1)
                            indx1=i;
                        else
                            indx2=i;
                    }
                    else
                    {
                        list1.add(null);
                        list1.add(null);
                    }
                }
                if(max < (indx2-indx1+1))
                    max=(indx2-indx1+1);
                System.out.println("list2 ="+list2);
                System.out.println("list2  indx1="+indx1+"   indx2="+indx2+"  max="+max+"  ");
                list2 = new ArrayList<TreeNode>();
            }
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}