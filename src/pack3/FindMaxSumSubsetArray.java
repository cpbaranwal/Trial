package pack3;

public class FindMaxSumSubsetArray {

	/**
	Given an array of n elements unsorted, find subset of the array making the max sum.
	 Ex: {-2,-3,-5,40,-10,-10,100,1}
	 answer would be {40,-10,-10,100,1}
	 
	 This solution is in O(N)...though the naive solutio will be in O(N3)
	
	 */
	
	public static int  start=0;
	public static int  last=0;
	public static int maxSum=0;
	
	public static void main(String[] args) {
		System.out.println("in main()");
		
		int[] arr={-2,-3,-5,40,-10,-10,100,1,-200};
		
		findSubset(arr);
		
		System.out.println("maxSum=="+maxSum);
		System.out.println("start=="+start);
		System.out.println("last=="+last);

	}
	
	public static void findSubset(int[] arr)
	{
		//boundary conditions check...if all numbers are negative ,choose only a single number thats least negative,return that number.
		
		int sum=0;
		int tmpStart=0;
		for(int i=0;i<arr.length;i++)
		{
			sum=sum+arr[i];
			if(sum<0)
			{
				sum=0;
				tmpStart=i+1;
			}
			else if(sum>maxSum)
			{
				maxSum=sum;
				start=tmpStart;
				last=i;
			}
				 
			
		}
		
		
		
		//helperMethod(arr,0,arr.length-1);
	}
	
	//public static void helperMethod(int[] arr,int p ,int q)
}
