package leetcode.medium.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 * @author chandan
 *Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1: 
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.
 */
public class FindDuplicateTrees {

  public static void main(String[] args) 
  {
    TreeNode t= new TreeNode(2);
    t.left= new TreeNode(2);
    t.left.left= new TreeNode(3);
    t.right= new TreeNode(2);
    t.right.left= new TreeNode(3);
    //t.right.left.left= new TreeNode(4);
    //t.right.right= new TreeNode(4);
     System.out.println("result= "+findDuplicateSubtrees(t));
  }
  
   static Map<List<Integer>,Integer> map= new HashMap<List<Integer>,Integer>();
   static List<TreeNode> resultList= new ArrayList<TreeNode>();
  public  static List<TreeNode> findDuplicateSubtrees(TreeNode root) 
  {
    findDuplicateSubtreesHelper(root);
    return resultList;
  }
  private static void findDuplicateSubtreesHelper(TreeNode node) 
  {
    if(node==null)
      return;
    List<Integer> numList= new ArrayList<Integer>();
    findTreeStartingFromCurrentNode(numList,node);
    Integer value= map.get(numList);
    if(value==null)
    {
      map.put(numList, 1);
    }
    else//duplicate
      {
      if(value==1)//first time duplicate
        {
          resultList.add(node);
          //System.out.println(" duplicate numList= "+numList);
        }
      map.put(numList, value+1);
      }
    
    findDuplicateSubtreesHelper(node.left);
    findDuplicateSubtreesHelper(node.right);
  }
  private static void findTreeStartingFromCurrentNode( List<Integer> numList, TreeNode currNode) 
  {
    numList.add(currNode.val);
    /*
    if(currNode.left==null && currNode.right==null)//reached some leaf node
    {
      Integer value= map.get(numList);
      if(value==null)
      {
        map.put(numList, 1);
      }
      else//duplicate
        {
        if(value==1)//first time duplicate
          {
            resultList.add(currPathRoot);
            System.out.println(" duplicate numList= "+numList);
          }
        map.put(numList, value+1);
        }   
      return;
    }
    */
    
    if(currNode.left!=null)
      findTreeStartingFromCurrentNode(numList,currNode.left);
    else
      numList.add(null);
    if(currNode.right!=null)
      findTreeStartingFromCurrentNode(numList,currNode.right);
    else
      numList.add(null);
  }

}
