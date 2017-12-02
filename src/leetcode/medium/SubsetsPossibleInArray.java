package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 * @author chandan
 *Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsPossibleInArray {

  public static void main(String[] args) {
    int[] arr= {1,2,2};
    System.out.println("result="+subsetsWithDup(arr));

  }
  
  public static List<List<Integer>> subsetsWithDup(int[] arr) 
  {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(arr==null || arr.length==0)
      return list;
    
    Arrays.sort(arr);//first sort the array
    subsetsWithDupHelper(arr,list,0);
    list.add(new ArrayList<Integer>());
    return list;
    
  }

  private static void subsetsWithDupHelper(int[] arr, List<List<Integer>> list, int indx) 
  {
    if(indx==arr.length )
    {
     // list.add(new ArrayList<Integer>(currList));
      return;
    }
    
    List<List<Integer>>  tmpListOfList= new ArrayList<List<Integer>>();
    for(List<Integer> l1: list)
    {
      List<Integer> l2= new ArrayList<Integer>(l1);
      l2.add(arr[indx]);
      if(!list.contains(l2) && !tmpListOfList.contains(l2))
        tmpListOfList.add(l2);
    }
    
    List<Integer> tmpList= new ArrayList<Integer>();
    tmpList.add(arr[indx]);
    if(!list.contains(tmpList))
      tmpListOfList.add(tmpList);
    //finally add tmpListOfList to main list
    list.addAll(tmpListOfList);
    subsetsWithDupHelper(arr,list,indx+1);
    
  }

}
