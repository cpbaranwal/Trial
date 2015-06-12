package abceligopq;

public class MaxSubArraySum {

	/**
	 An array contains positive and negative numbers. Find the sub-array that has the maximum sum. 
	 */
	public static void main(String[] args) {
		
		int arr[]={1,4,-2,2,6,-2,9,-5};
		System.out.println("Result=="+maxSum(arr,0,arr.length-1));
	}
	
	public static int maxSum(int[] arr,int p, int q)
	{
		if(p==q)
			return arr[p];
		if(p>q)
			return Integer.MIN_VALUE;
		
		int mid=(p+q)/2;
		int tempMax=arr[mid];
		int tempSum=arr[mid];
		int i=mid-1;
		while(i>=p)
		{
		  tempSum=tempSum+arr[i];
		  if(tempMax<tempSum)
			  tempMax=tempSum;
		  
		  i--;
		}
		i=mid+1;
		while(i<=q)
		{
			tempSum=tempSum+arr[i];
			if(tempMax<tempSum)
				  tempMax=tempSum;
			
			i++;
		}
		
		int maxLeft=maxSum(arr,p,mid-1);
		int maxRight=maxSum(arr,mid+1,q);
		
		if(maxLeft>maxRight)
		{
			return (maxLeft>tempMax?maxLeft:maxLeft);
		}
		else
		{
			return( maxRight>tempMax?maxRight:tempMax);
		}
		
	}

}
