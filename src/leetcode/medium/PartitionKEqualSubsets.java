package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * @author chandan
 *Given an array of integers nums and a positive integer k, find whether it's possible
 * to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 */
public class PartitionKEqualSubsets {

  public static void main(String[] args)
  {
    //int[] nums = {4, 3, 2, 3, 5, 2, 1};
    //int k = 4;
    int[] nums = {2, 1, 4, 5, 6};
    int k = 3;
    System.out.println("result= "+canPartitionKSubsets(nums,k) );

  }
  
  //recursive solution
  public static boolean canPartitionKSubsets(int[] nums, int k) 
  {
    if(nums==null || nums.length<k)
      return false;
    int sum=0;
    for(int num: nums)
      sum += num;
    if(sum%k != 0)
      return false;
    
    sum= sum/k;
    for(int num: nums)//optimisation: no element should be greater than number
    {
      if(num>sum)
        return false;
    }
    
    List<Integer> sumArray= new ArrayList<Integer>(k);
    for(int i=0; i<k; i++)
      sumArray.add(0);
    return canPartitionKSubsets(nums,0,sum,sumArray);
    
  }

  private static boolean canPartitionKSubsets(int[] nums, int indx, int sum, List<Integer> sumArray) 
  {
    //boolean bool= false;
    if(indx==nums.length)
    {
      for(Integer num: sumArray)
      {
        if(num!=sum)
          return false;
      }
        return true;
    }
    
    int elem= nums[indx];
    for(int i=0; i<sumArray.size(); i++)
    {
      //List<Integer> sumArrayTmp= new ArrayList<Integer>(sumArray);
      int currNumInArr= sumArray.get(i);
      int tmpNumInArr= currNumInArr+elem;
      if(tmpNumInArr > sum)
        continue;
      sumArray.set(i, tmpNumInArr);
      if(canPartitionKSubsets(nums,indx+1,sum,sumArray))
        return true;
      sumArray.set(i, currNumInArr);
    }
    
    return false;
  }

}
