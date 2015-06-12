package temp;

public class FindlargestSubarrayWithEqualZeroAndOneInABinaryArray {

	/**
	 	 Find largest sub – array with equal number of 0s and 1s in a binary array?
	 	 int[] arr = {1,0,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0};
	 */
	
	
	static int leftIndx=Integer.MAX_VALUE;
	static int rightIndx=Integer.MIN_VALUE;
	static int count=0;
	public static void main(String[] args) 
	{
		int[] arr = {1,0,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0};
		findLargestSubArray(arr);
		System.out.println("count="+count+"  leftIndx="+leftIndx+"   rightIndx="+rightIndx);
		if(rightIndx-leftIndx < arr.length)
		{
			System.out.println("SubArray found:");
			for(int x=leftIndx; x<=rightIndx; x++)
				System.out.print("  "+arr[x]);
		}
	}
	private static void findLargestSubArray(int[] arr)
	{
		//boundary conditions
		
		int len = arr.length;
		for(int i=0; i<len-1; i++)
		{
			if(arr[i] == arr[i+1])
				continue;
			int j=i;
			int k=i+1;
			int tmpCount=2;
			while(j>0 && k<len-1 && (arr[j]==arr[j-1]  && arr[k]==arr[k+1]))
					{
						j--;
						k++;
						tmpCount +=2;
					}
			if(tmpCount>count)
			{
				count = tmpCount;
				leftIndx = j;
				rightIndx = k;
			}
		}
		
		
	}

}
