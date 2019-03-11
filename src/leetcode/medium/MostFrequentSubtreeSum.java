package leetcode.medium;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. 
 * The subtree sum of a node is defined as the sum of all the node values formed 
 * by the subtree rooted at that node (including the node itself). So what is the 
 * most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * @author chandan
 *
 */
public class MostFrequentSubtreeSum {

  public static void main(String[] args) {
    TreeNode node= new TreeNode(5);
    node.left=new TreeNode(2);
    node.right=new TreeNode(-5);
    System.out.println("result= "+ Arrays.toString(findFrequentTreeSum(node)));
   

  }
  
  public static int[] findFrequentTreeSum(TreeNode root) 
  {
    if(root==null)
      return null;
    TreeMap<Integer,Integer> tmap= new TreeMap<Integer,Integer>();
    findFrequentTreeSumHelper(root,tmap);
    int[] arr= new int[tmap.size()];
    int i=0;
    System.out.println("tmap="+tmap);
    for(Entry<Integer,Integer> entry:tmap.entrySet())
    {
      arr[i++]=(entry.getKey());
    }
    return arr;
  }
  
  public static int findFrequentTreeSumHelper(TreeNode node,TreeMap<Integer,Integer> tmap) 
  {
    if(node==null)
      return 0;
    int l= findFrequentTreeSumHelper(node.left,tmap);
    int r= findFrequentTreeSumHelper(node.right,tmap);
    int sum= node.val+l+r;
    System.out.println("node.val= "+node.val+"   sum="+sum  );
    if(tmap.containsKey(sum))
    {
      int value= tmap.remove(sum);
      tmap.put(sum,value+1);
    }
    else
    {
      tmap.put(sum, 1);
    }
    return sum;
  }
  
  public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
