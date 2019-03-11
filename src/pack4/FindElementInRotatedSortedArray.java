package pack4;

public class FindElementInRotatedSortedArray {

	/**
	    Find an element in a sorted rotated integer array.
	    e.g.  int[] arr={15,21,24,35,3,8,10,13};
	    for 10, return index 7
	 */
	public static void main(String[] args) {
		int[] arr={15,21,24,35,3,8,10,13};
		
		int num=15;
		System.out.println("Index found:"+findNumberIndx2( arr,num));
		

	}

	// smarter and shorter
	public static int findNumberIndx2(int[] arr,int num){
		if(arr==null || arr.length ==0)
			return -1;  //throw exception

		return findNumberIndx2(arr, num, 0 , arr.length-1);
	}
	private static int findNumberIndx2(int[] arr, int num, int left, int right) {
		//terminating conditions
		if(left>right)
			return -1;
		if(arr[left]==num)
			return left;
		if(arr[right]==num)
			return right;

		int mid = (left+right)/2;
		if(num>=arr[left] && num<=arr[mid])
			return findNumberIndx2(arr, num, left, mid);
		else
			return findNumberIndx2(arr, num, mid+1, right);


	}


	public static int findNumberIndx(int[] arr,int num)
	{
		if(arr==null || arr.length ==0)
			return -1;  //throw exception
		
		/*if(arr[0]==num)
			return 0;
		
		if(arr[arr.length-1]==num)
			return arr.length-1;*/
		
		return( helperMethod(arr,num,0,arr.length-1));
		
	}
	
	private static int helperMethod(int[] arr,int num,int p, int q)
	{
		
		if(p>=q)
			return -1;
		/*
		if(arr[p]==num)
			return p;
		
		if(arr[q]==num)
			return q;
		*/
		int mid=(p+q)/2;
		System.out.println("  p="+p+"   q="+q+"   mid="+mid);
		int x=arr[mid];
		if(x==num)
			return mid;
		
		if(num<x)
		{  
			if(arr[p]<arr[mid] && num>arr[p])  // mst imp condition to satisfy
				return helperMethod(arr,num,p,mid);
			else
				return helperMethod(arr,num,mid+1,q);
		}
		else  //num>x
		{  
			if(arr[mid]<arr[q] && num<arr[q])  // mst imp condition to satisfy
				return helperMethod(arr,num,mid+1,q);
			else
				return helperMethod(arr,num,p,mid);
		}
	}

}
