package pack3;

public class SortedSubsequenceOfSize3 {

	/**
	Find a sorted subsequence of size 3 in linear time
June 8, 2012

Given an array of n integers, find the 3 elements such that
 a[i] < a[j] < a[k] and i < j < k in 0(n) time. If there are multiple such triplets, 
 then print any one of them.

Examples:

Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
Output: 5, 6, 30

Input:  arr[] = {1, 2, 3, 4}
Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4

Input:  arr[] = {4, 3, 2, 1}
Output: No such triplet

	 */
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4};
		printNumbers(arr);
	}
	
	public static void printNumbers(int[] arr)
	{
		if(arr==null || arr.length<3)
		{	System.out.println("Invalid output");
		return;
		}
		
		int len=arr.length;
		
		int indx=0;		
		int small[]=new int[len];
		small[0]=-1;
		for(int i=1;i<len;i++)
			{
				if(arr[i]>arr[indx])
				{
					small[i]=indx;
				}
				else{
					small[i]=-1;
					indx=i;
				}
			}
		
		
		indx=len-1;
		int big[]=new int[len];
		big[len-1]=-1;
		for(int i=len-2;i>=0;i--)
		{
			if(arr[i]<arr[indx])
			{
				big[i]=indx;
			}
			else
			{
				big[i]=-1;
				indx=i;
			}
		}
		
		for(int i=0;i<len;i++)
		{   if(small[i]!=-1 && big[i]!=-1)
			System.out.println("Triplet : "+arr[small[i]]+"   "+arr[i]+"   "+arr[big[i]]);
		}
		
	}

}
