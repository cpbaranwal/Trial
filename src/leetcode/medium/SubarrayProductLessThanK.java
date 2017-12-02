package leetcode.medium;


/**
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 * @author chandan
 *Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 */
public class SubarrayProductLessThanK {

  public static void main(String[] args) 
  {
      int[] nums={1,1,1};
      int k=1;
      System.out.println("results="+numSubarrayProductLessThanK(nums, k));

  }
  
  //using DP
  public static int numSubarrayProductLessThanK(int[] arr, int k) 
  {
    if(arr==null || arr.length==0)
      return 0;
    int n= arr.length;
    int[][] store= new int[n][n];
    int cnt=0;
    
    //initialize storage
    for(int i=0;i<n;i++)
    {
      if(arr[i]<k)
      {
        store[i][i]=  arr[i];
        cnt++;
      }
      
    }
    
    //now compute and populate
    
    for(int i=0;i<n-1;i++)
    {
      for(int j=i+1; j<n; j++)
      {
        int tmp= store[i][j-1]*arr[j];
        if(tmp!=0 && tmp<k)
        {
          store[i][j]=tmp;
          cnt++;
        }
        else
          break;
      }
    }
   return cnt; 
  }

}
