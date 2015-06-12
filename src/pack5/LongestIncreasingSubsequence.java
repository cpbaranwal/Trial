package pack5;

public class LongestIncreasingSubsequence {

    /**  DP problem
         int arr[] = {3,2,4,1,6,7,8,5,15,11};
         program to find length of longest increasing subsequence in the given array.     


      
     */
    public static void main(String[] args)
    {
        int arr[] = {3,2,4,1,6,7,8,5,10,11};
        int length = getLengthLIS(arr);
        System.out.println("length== "+length);

    }
   
   
    /*
     approach:
     M[i] denotes maxm LIS length till index i starting from 0.
     M[i] = scan all M[i] from j = 0 to j=i-1  and look for:  arr[i]>arr[j] && M[j]+1>maxLengthTilNow
     */
    private static int  getLengthLIS(int[] arr)
    {
        int length = arr.length;
        int[] M = new int[length];
        for(int i=0;i<length;i++)
            M[i] = 1;
       
        for(int i=1; i<arr.length; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(arr[i]>arr[j] && (M[j]+1>M[i]))
                {
                    M[i] = M[j]+1;
                }
            }
        }
        return M[length-1];
       
    }

}