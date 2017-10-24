package leetcode.goodOnes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 * @author chandan
 *Given a set of distinct integers, nums, return all possible subsets.
Note: The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class AllPossibleSubsets {

  public static void main(String[] args) {
    int[] nums={1,2,3};
    AllPossibleSubsets obj= new AllPossibleSubsets();
    System.out.println("result= "+obj.subsets(nums));

  }
  
  List<List<Integer>> result= new ArrayList<List<Integer>>();
  public List<List<Integer>> subsets(int[] nums) 
  {
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    
    for(int len=0; len<=nums.length; len++)
    {
      subsetsHelper(nums,0,len,new ArrayList<Integer>());
       
    }
    return result;
  }
  
  
  
  private void subsetsHelper(int[] nums, int index,int len, List<Integer> currList  )
  {
    //System.out.println(" index="+index+"   len="+len+"   currList.size="+currList.size()+"    currList="+currList);
    if(len==currList.size())
    {
      result.add(new ArrayList<Integer>(currList));
      return;
    }
    for(int i=index;i<nums.length;i++)
    {
      currList.add(nums[i]);
      subsetsHelper(nums,i+1,len,currList);
      currList.remove(currList.size()-1);
    }
  }
  

}
