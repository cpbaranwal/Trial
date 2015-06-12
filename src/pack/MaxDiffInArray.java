package pack;

/**instead of taking difference of the picked element with every other element,
 * we take the difference with the minimum element found so far. So we need to keep track of 2 things:
1) Maximum difference found so far (max_diff).
2) Minimum number visited so far (min_element).
      time - O(N)
*/


public class MaxDiffInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[]={10, 2, 6, 80, 9,100};
		
		System.out.println("getMaxDiff(int[] arr)=="+getMaxDiff(arr));
		

	}
	
	
	public static int getMaxDiff(int[] arr)
	{
		int maxDif=0; int min=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<arr[min])
			{
				min=i;
			}
			else
			if(arr[i]-arr[min]>maxDif)
			{
				maxDif=arr[i]-arr[min];
			}
		}
		return maxDif;
		
		

	}

}
