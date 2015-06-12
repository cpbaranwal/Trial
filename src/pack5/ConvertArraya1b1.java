package pack5;

public class ConvertArraya1b1 {

	/**
	 * 
If [a1,a2,a3...,an,b1,b2...bn] is given input, change this to [a1,b1,a2,b2.....an,bn] ,
 solution should be in-place

soln:  (to be implemented,soln here is different) First swap elements in the middle pair
Next swap elements in the middle two pairs
Next swap elements in the middle three pairs
iterate n-1 steps.


	 */
	public static void main(String[] args) {
		
		int a[]={1,3,5,7,11,33,55,77};
		//swapElementsBruteForce(a,0,a.length-1);
		swapElementsDC(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print("  "+a[i]);

	}
	
	
	private static void swapElementsDC(int[] arr, int left, int right)   //Divide and Conquer - O(n*log(n))
	{
		//condition - total even numbers shud be i power of 2^n   e.g.  2,4,8,16,etc....
		/*
		   Ex: with n = 4.
			a1 a2 a3 a4 b1 b2 b3 b4
			a1 a2 b1 b2 a3 a4 b3 b4
			a1 b1 a2 b2 a3 b3 a4 b4
		 */
		
		if(right-left<=2)  //imp boundary condition,  last two elemnts in pair shud not be swapped
			return;
		int mid = (left+right)/2 +1;  //1st element of 2nd half array
		int midOfMid = (left + mid)/2;  //1st element of 2nd half of 1st half array
		
		for(int i=0;i<arr.length;i++)
			System.out.print("  "+arr[i]);
		System.out.println("");
		
		for(int i=midOfMid,j=mid; i<mid; i++,j++)
		{
			swap(arr,i,j);
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print("  "+arr[i]);
		System.out.println("");
		
		swapElementsDC(arr,left,mid-1);
		swapElementsDC(arr,mid,right);
		
	}
	
	
	
	/*
	   Ex: with n = 4.
		a1 a2 a3 a4 b1 b2 b3 b4
		a1 a2 a3 b1 a4 b2 b3 b4
		a1 a2 b1 a3 b2 a4 b3 b4
		a1 b1 a2 b2 a3 b3 a4 b4
	 */
	private static void swapElementsBruteForce(int[] arr, int left, int right)   //Brute force - O(n^2)
	{
		if(left>=right)
			return;
		
		int indxFirstElementOfRightArray = (left+right)/2 + 1;
		int valueToBeShifted = arr[indxFirstElementOfRightArray];
		for(int i=indxFirstElementOfRightArray; i-left>1; i--)
		{
			arr[i]=arr[i-1];
		}
		arr[left+1]= valueToBeShifted;
		swapElementsBruteForce(arr, left+2, right);
		
	}
	
	
	public static void swap(int[]arr,int i, int j)
	{
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		return;
	}

}
