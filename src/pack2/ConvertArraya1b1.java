package pack2;

public class ConvertArraya1b1 {

	/**
	 * 
If [a1,a2,a3...,an,b1,b2...bn] is given input change this to [a1,b1,a2,b2.....an,bn] , solution should be in-place

soln:  (to be implemented,soln here is different) First swap elements in the middle pair
Next swap elements in the middle two pairs
Next swap elements in the middle three pairs
iterate n-1 steps.

Ex: with n = 4.
a1 a2 a3 a4 b1 b2 b3 b4
a1 a2 a3 b1 a4 b2 b3 b4
a1 a2 b1 a3 b2 a4 b3 b4
a1 b1 a2 b2 a3 b3 a4 b4
	 */
	public static void main(String[] args) {
		
		int a[]={1,3,5,7,9,2,4,6,8,10};
		swapElements(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print("  "+a[i]);

	}
	
	public static void swapElements (int[] arr,int i,int j)  //O(n^2) firstly b1 is moved to index 1,then b2 is moved to index 3 .....and so on
	{
		
		
		if(i+1==j)
			return;
		
		int k=(i+j)/2;
		k=k+1;
		while(k>i+1)
		{
			swap(arr,k,k-1);
			k--;
		}
		
		swapElements (arr, i+2, j);
		
		return ;
	}
	
	public static void swapElements2(int[] a, int i, int j)   //O(n*logn)  divide and conquer....not running,some bugs to sort out
	{  
		//see solution in pack5
	}
	
	public static void swap(int[]arr,int i, int j)
	{
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		return;
	}

}
