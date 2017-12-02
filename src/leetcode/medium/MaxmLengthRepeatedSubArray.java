package leetcode.medium;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 * @author chandan
 *Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */
public class MaxmLengthRepeatedSubArray {

  public static void main(String[] args) {
    int[] arr1={1,2,3,2,1};
    int[] arr2= {3,2,1,4,7};
    System.out.println("result= "+findLength(arr1, arr2));

  }
  
  public static int findLength(int[] arr1, int[] arr2) 
  {
    //int len=0;
    if(arr1==null || arr1.length==0 || arr2==null || arr2.length==0)
      return 0;
    
    int m=arr1.length;
    int n= arr2.length;
    int max=0;
    
    int[][] storage= new int[m+1][n+1];
    for(int i=1; i<=m; i++)
    {
      for(int j=1; j<=n; j++)
      {
        if(arr1[i-1]==arr2[j-1])
        {
          storage[i][j]= 1+storage[i-1][j-1];
          if(storage[i][j]>max)
            max=storage[i][j];
        }
        else
          storage[i][j]=0;
      }
    }
    
    return max;
  }

}
