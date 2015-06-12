package temp;

public class FindElementInRotatedSortedArray {

	/**
	Find an element in a sorted rotated integer array.
	    e.g.  int[] arr={15,21,24,35,3,8,10,13};
	    for 10, return index 6
	 */
	public static void main(String[] args) {
		int[] arr={15,21,24,35,3,8,10,13};
		
		int num=35;
		System.out.println("Index found:"+findIndex( arr,num));
		

	}
	
	public static int findIndex(int[] arr, int num)
	{
		if(arr==null)
			throw new IllegalArgumentException("Null not allowed");
		
		return helperFindIndex(arr,num,0,arr.length-1);
	}
	
	public static int helperFindIndex(int[] arr, int num , int p , int q)
	{
		int index = -1;
		if(p>q)
			return index;
		if(num == arr[p])
			return p;
		if(num == arr[q])
			return q;
		
		int mid = (p+q)/2;
		if(num == arr[mid])
			return mid;
		
		if(num < arr[mid])
		{
			if(num>arr[p] && arr[p]<arr[mid])
				return helperFindIndex(arr,num,p,mid-1);
			else
				return helperFindIndex(arr,num,mid+1,q);
		}
		else  //num>arr[mid]
		{
			if(num<arr[q] && arr[mid]<arr[q])
				return helperFindIndex(arr,num,mid+1,q);
			else
				return helperFindIndex(arr,num,q,mid-1);
		}
		
	}
}
