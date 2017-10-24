package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 * @author chandan
 *Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */
public class CombinationSum2 {

  public static void main(String[] args) {
    CombinationSum2 obj= new CombinationSum2();
    int target=8;
    int[] candidates= {10, 1, 2, 7, 6, 1, 5};
    System.out.println("CombinationSum2 result= "+obj.combinationSum2(candidates, target));
  }
  
  
  //Note: Alternatively we can use Set instead of list for easier solution
  /*
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> resultList= new ArrayList<List<Integer>>();
    if(target<=0)
      return resultList;
    //for(int i=0;i<candidates.length;i++)
    Arrays.sort(candidates);
    System.out.println(Arrays.toString(candidates));
      combinationSumHelper(candidates,target,resultList,0,new ArrayList<Integer>(),0);
    return resultList;
  }

  
 
  private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> resultList, 
      int currSum,List<Integer> currList,int index)
  {
    System.out.println(" resultList="+resultList+"   currSum="+currSum+"  currList="+currList+"  index="+index);
    
    if(currSum==target)
    {
      resultList.add(new ArrayList<Integer>(currList));
      //System.out.println(" resultList="+resultList+"   currSum="+currSum+"  currList="+currList+"  index="+index);
      return;
    }
    
    if(currSum>target ||index>=candidates.length)
      return;
   
    
    Integer currElement= candidates[index];
    if(!currList.isEmpty() && currList.get(currList.size()-1)>currElement)
      return;//only increasing order elements considered to remove duplicates
    
    currList.add(currElement);
    if(index>0 &&  candidates[index-1]==currElement && target==currElement )
      return;
    else
    combinationSumHelper(candidates,target,resultList,currSum+currElement,currList,index+1);
    currList.remove(currElement);
    if(index>0 &&  candidates[index-1]==currElement && currList.contains(currElement ))
      return;
    else
      combinationSumHelper(candidates,target,resultList,currSum,currList,index+1);
  }
  */
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Set<List<Integer>> resultSet= new HashSet<List<Integer>>();
    if(target<=0)
      return new ArrayList<List<Integer>>(resultSet);
    Arrays.sort(candidates);
    System.out.println(Arrays.toString(candidates));
      combinationSumHelper(candidates,target,resultSet,0,new ArrayList<Integer>(),0);
    return new ArrayList<List<Integer>>(resultSet);
  }
  private void combinationSumHelper(int[] candidates, int target, Set<List<Integer>> resultSet, 
      int currSum,List<Integer> currList,int index)
  {
    System.out.println(" resultSet="+resultSet+"   currSum="+currSum+"  currList="+currList+"  index="+index);
    
    if(currSum==target)
    {
      resultSet.add(new ArrayList<Integer>(currList));
      //System.out.println(" resultList="+resultList+"   currSum="+currSum+"  currList="+currList+"  index="+index);
      return;
    }
    
    if(currSum>target ||index>=candidates.length)
      return;
   
    
    Integer currElement= candidates[index];
    if(!currList.isEmpty() && currList.get(currList.size()-1)>currElement)
      return;//only increasing order elements considered to remove duplicates
    
    currList.add(currElement);
    
    combinationSumHelper(candidates,target,resultSet,currSum+currElement,currList,index+1);
    currList.remove(currElement);
      combinationSumHelper(candidates,target,resultSet,currSum,currList,index+1);
  }

}
