package leetcode.goodOnes;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * @author chandan
 *Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets 
 *such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {

  public static void main(String[] args) 
  {
   int[] nums={2,1,2,2};
   System.out.println("result= "+canPartition(nums));

  }
  
  
  
  //DP Solution   TODO debug, one small bug remaining
  public static boolean canPartition(int[] nums) 
  {
    if(nums==null || nums.length<2)
      return false;
    int sum=0;
    for(int num:nums)
    {
      sum +=num;
    }
      
    if(sum%2==1)
      return false;
    sum= sum/2;
    int n= nums.length;
    boolean[][] sumElementArr= new boolean[sum+1][n+1];//default is false;
    for(int i=1; i<=sum; i++)
      sumElementArr[i][0]=false;
    for(int j=0; j<=n; j++)
      sumElementArr[0][j]=true;
    for(int k=0; k<n ; k++)
    {
      int elem= nums[k];
      if(elem<=sum)
        sumElementArr[elem][1]=true;
      //System.out.println("sumElementArr["+elem+"][1]="+sumElementArr[elem][1]);
      else // can not expect element greter than totalSum/2
    	  return false;  
    }
    
    for (int i = 0; i <= sum; i++)
    {
        for (int j = 0; j <= n; j++)
          System.out.print("   "+ sumElementArr[i][j]);
        System.out.println("\n");
    }
    System.out.println("\n.....AFTER.... \n");
    
    for(int i=1; i<=sum ; i++)
    {
      for(int j=1; j<=n; j++)
      {
        sumElementArr[i][j]= sumElementArr[i][j-1];
        if(sumElementArr[i][j])
          System.out.println("111111   sumElementArr["+i+"]["+j+"]="+sumElementArr[i][j]);
        if(i >= nums[j-1])
        {
          sumElementArr[i][j]= sumElementArr[i][j] || sumElementArr[i-nums[j-1]][j];
          if(sumElementArr[i][j])
            System.out.println("2222222   sumElementArr["+i+"]["+j+"]="+sumElementArr[i][j]);
        }
          
      }
    }
    
    for (int i = 0; i <= sum; i++)
    {
        for (int j = 0; j <= n; j++)
          System.out.print("   "+ sumElementArr[i][j]);
        System.out.println("\n");
    }
    
    System.out.println("sumElementArr[sum][n]="+sumElementArr[sum][n]);
    return sumElementArr[sum][n];
  }
  
  //recursive solution
  public static boolean canPartition2(int[] nums) 
  {
    if(nums==null || nums.length<2)
      return false;
    return canPartitionHelper(nums,0,0,0);
  }

  private static boolean canPartitionHelper(int[] nums, int indx, int sum1, int sum2)
  {
     if(indx==nums.length)
     {
       if(sum1==sum2)
         return true;
       else
         return false;
     }
     boolean bool1= canPartitionHelper(nums,indx+1, sum1+nums[indx], sum2);
     boolean bool2= canPartitionHelper(nums,indx+1, sum1, sum2+nums[indx]);
     return bool1 || bool2;
  }

}
