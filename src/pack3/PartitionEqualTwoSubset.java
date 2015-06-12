package pack3;

public class PartitionEqualTwoSubset {

	/**
	 Partition problem is to determine whether a given set can be partitioned into two subsets 
	 such that the sum of elements in both subsets is same.
Examples
arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.

Following are the two main steps to solve this problem:
1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2. 
	 	 */
	public static void main(String[] args) {
		
		int arr[] = {1, 5, 11, 5,2};
		
		System.out.println(" Is Two Equal Sets possible: "+isPossible(arr));

	}
	
	public static boolean isPossible(int[] arr)
	{
		int sum=0;
		for(int x:arr)
		{
			sum+=x;
		}
		if(sum%2==1)
			return false;
					
			else
			return	checkPossibilityUsingRecursion(arr,0,arr.length-1,sum/2);
	}
	
	public static boolean checkPossibilityUsingRecursion(int[] arr,int p,int q,int tot)
	{
		if(p>q)
			return false;
		if(tot==0)
			return true;
		if(tot<0)
			return false;
		
		
		return (checkPossibilityUsingRecursion(arr,p+1,q,tot-arr[p])  || checkPossibilityUsingRecursion(arr,p+1,q,tot) );
		
	}
	
	/*public static boolean checkUsingDP(int[] arr,int tot)
	{
		
	}*/

}
