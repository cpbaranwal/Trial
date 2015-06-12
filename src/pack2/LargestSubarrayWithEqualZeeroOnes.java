package pack2;

/**
Largest subarray with equal number of 0s and 1s
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. Expected time complexity is O(n).

Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 (Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4

 */

public class LargestSubarrayWithEqualZeeroOnes {

	static int lastIndx=-1;
	public static void main(String[] args) {

		int arr[]  = {0, 0, 1, 1, 0,0,0,1,1,0};
		//  -1  -2  -1  0  -1  -2  -3  -2  -1  -2
		int res=getLargestLength(arr);
		System.out.println("Result :  "+res);
		System.out.println(" startIndx: "+(lastIndx-res));

	}
	
	public static int getLargestLength(int[] arr)
	{
		int val=0;  
		int len=arr.length;
		if(arr[0]==0)
			arr[0]=-1;
		for(int i=1;i<len;i++)
		{
			if(arr[i]==0)
				arr[i]=-1;
			arr[i]=arr[i]+arr[i-1];
		}
		for(int i=0;i<len;i++)
			System.out.print("  "+arr[i]);
		
		int tmp1[]=new int[len];
		int tmp2[]=new int[len];  //for -ve numbers
		
		for(int i=0;i<len;i++)  //scan arr[] and fill tmp[]
		{
			int x=arr[i];
			if(x>=0)
			{
			if(tmp1[x]!=0 && (i+1-tmp1[x]>val))
			{
				val=i+1-tmp1[x];
				lastIndx=i;
			}
			else tmp1[x]=i;
			}
			else
			{
				x=-x;
				if(tmp2[x]!=0 && (i+1-tmp2[x]>val))
				{
					val=i+1-tmp2[x];
					lastIndx=i;
				}
				else tmp2[x]=i;
			}
		}
		
		return val;
	}

}
