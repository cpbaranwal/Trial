package pack7;

import  pack5.QuickSort;

public class Find3ElementsWithGivenSum {

	/**
	   Given an array of N elements find 3 elements whose sum is equal to a given number say 'sum'
	   e.g.   int[] arr ={3,7,5,2,1,8,9}
	   int sum = 12
	   
	   Solution - O(n^2)
	   approach - sort the array in O(N*logN)....at each iteration fix the leftmost element , 
	   then search two elements in between the array till last so that 
	   sum of leftMostFixed and two other elements becomes=sum
	   on fixing the leftmost element...the solution is similar to finding 2 elements with a given sum....
	   
	 */
	public static void main(String[] args)
	{
		 int[] arr ={3,7,5,2,1,8,9};
		 int sum =15;
		 
		 find3ElementsIfPossible(arr,sum);

	}

	private static void find3ElementsIfPossible(int[] arr, int sum) 
	{
		if(arr==null)
			return;
		QuickSort.quickSort(arr, 0, arr.length-1);
		for(int x: arr)
			System.out.print("   "+x);
		System.out.println();
		
		//int leftStart=0;
		//int rightStart= arr.length-1;
		//int leftTmp=leftStart+1;
		
		for(int leftStart=0; leftStart<arr.length-3; leftStart++)
		{
			int leftTemp=leftStart+1;
			int rightTemp = arr.length-1;
			
			while(rightTemp > leftTemp)
			{
				if((arr[leftTemp]+arr[rightTemp]) == sum-arr[leftStart])
				{
					System.out.println("sum Found:  sum="+sum+"   num1="+arr[leftStart]+"   num2="+arr[leftTemp]+"  num3="+arr[rightTemp]);
					leftTemp++;
					rightTemp--;
				}
				else if((arr[leftStart]+arr[leftTemp]+arr[rightTemp]) < sum)
				{
					leftTemp++;
				}
				else  // if((arr[leftStart]+arr[leftTemp]+arr[rightTemp]) > sum)
				{
					rightTemp--;
				}
				
				
			}
			
		}
	}

}
