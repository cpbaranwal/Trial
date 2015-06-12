package pack5;

public class QuickSort {

	/**
	   program to sort an array using Quicksort
	 */
	public static void main(String[] args) {

		int arr[] = {2,5,3,7,4,1,8,9};
		quickSort(arr,0,arr.length-1);
		for(int x: arr)
			System.out.print("  "+x);

	}
	
	public static void quickSort(int[] arr,int left,int right)
	{
		if(left>=right)
			return;
		int pivotIndex = getPivotIndex(arr,left,right);
		quickSort(arr,left,pivotIndex-1);
		quickSort(arr,pivotIndex+1,right);
		
	}
	
	private static int getPivotIndex(int[] arr, int left, int right)
	{
		int item = arr[left];  //item whose correct index has to be found out
		int tmpLeft=left;
		int tmpRight=right;
		
		while(tmpLeft<tmpRight)
		{
			while(item >= arr[tmpLeft])
				tmpLeft++;
			while(item < arr[tmpRight])
				tmpRight--;
			if(tmpLeft < tmpRight)
			{
				int temp = arr[tmpLeft]; arr[tmpLeft]=arr[tmpRight]; arr[tmpRight]=temp;
			}
		}
		System.out.println("tmpLeft = "+tmpLeft+"    tmpRight="+tmpRight);
		arr[left] = arr[tmpRight];
		arr[tmpRight] = item;
		return tmpRight;
		
	}

}
