package pack5;

public class HeapSort {

	/**
	     program for sorting a given array using heapSort
	 */
	
	public static void main(String[] args)
	{
		int[] arr = {1,3,7,2,6,8,5,4};
		
		//buildHeap(arr);
		heapSort(arr);
		for(int x:arr)
		System.out.print("  "+x);
		
	}
	
	private static void heapSort(int[] arr)
	{
		heapSortHelper(arr,arr.length-1);
		
	}

	private static void heapSortHelper(int[] arr, int lastIndx)
	{
		if(lastIndx <= 0)
			return;
		//System.out.println();
		//for(int x:arr)
			//System.out.print("  "+x);
		
		buildHeap(arr, lastIndx);
		swapElements(arr,0,lastIndx);
		lastIndx--;
		heapSortHelper(arr,lastIndx);
		
	}

	private static void swapElements(int[] arr, int i, int lastIndx) 
	{
		int tmp = arr[i];
		arr[i]= arr[lastIndx];
		arr[lastIndx] = tmp;
		
	}

	public static void buildHeap(int[] arr, int lastIndx)  //building max heap   Time - O(N)
	{
		//int len =arr.length;
		//for(int i=(len-1)/2; i>=0; i--)
		for(int i=lastIndx/2; i>=0; i--)
		{
			percolateDown(arr,i,lastIndx);
		}
	}

	private static void percolateDown(int[] arr, int i, int lastIndx) 
	{
		int leftChild = 2*i +1;
		int rightChild = 2*i +2;
		int maxElementIndex = i;
		//if(leftChild<arr.length-1    &&   arr[maxElementIndex]<arr[leftChild])
		if(leftChild<lastIndx    &&   arr[maxElementIndex]<arr[leftChild])
			maxElementIndex = leftChild;
		//if(rightChild<arr.length-1    &&   arr[maxElementIndex]<arr[rightChild])
		if(rightChild<lastIndx    &&   arr[maxElementIndex]<arr[rightChild])
			maxElementIndex = rightChild;
		
		if( maxElementIndex != i)
		{
			int tmp = arr[maxElementIndex];
			arr[maxElementIndex] = arr[i];
			arr[i] = tmp;
			
			//percolateDown(arr, maxElementIndex,lastIndx);//looks unnecessary
		}
		
	}

}
