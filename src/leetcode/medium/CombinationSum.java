package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * @author chandan
 *Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */
public class CombinationSum {

  public static void main(String[] args) {
    CombinationSum obj= new CombinationSum();
    int target=4;
    int[] candidates= {2,1};
    System.out.println("result= "+obj.combinationSum(candidates, target));
  }
  
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> resultList= new ArrayList<List<Integer>>();
    if(target<=0)
      return resultList;
    //for(int i=0;i<candidates.length;i++)
    Arrays.sort(candidates);
      combinationSumHelper(candidates,target,resultList,0,new ArrayList<Integer>());
    return resultList;
  }

  private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> resultList, 
      int currSum,List<Integer> currList)
  {
    System.out.println("resultList="+resultList+"   currSum="+currSum+"  currList="+currList);
    
    if(currSum>target )
      return;
    
    if(currSum==target)
    {
      resultList.add(new ArrayList<Integer>(currList));
      return;
    }
    for(int i=0;i<candidates.length;i++)
    {
      Integer currElement= candidates[i];
      if(!currList.isEmpty() && currList.get(currList.size()-1)>currElement)
        continue;//only increasing order elements considered to remove duplicates
      currList.add(currElement);
      
      combinationSumHelper(candidates,target,resultList,currSum+currElement,currList);
      currList.remove(currElement);
    }
    
  }

}
