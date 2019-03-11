package pack5;

public class FindMaxSumSubsetArray {

	/**
	Given an array of n elements unsorted, find subset of the array making the max sum.
	 Ex: {-2,-3,-5,40,-10,-10,100,1}
	 answer would be {40,-10,-10,100,1}
	 
	 This solution is in O(N) ...though the naive solution will be in O(N3)
	
	 */
	
	public static int  start=0;
	public static int  last=0;
	public static int maxSum=0;
	
	public static void main(String[] args) {
		System.out.println("in main()");
		
		int[] arr={-2,-3,-5,40,-10,-10,100,1};
		
		
		//findMaxSubSeqInSingleTraversal(arr);//approach1
		//System.out.println("maxSum=="+maxSum);
		//System.out.println("start=="+start);
		//System.out.println("last=="+last);
		
		//findMaxSubSeqUsingDP(arr);//approach2
	    //System.out.println("maxSum=="+maxSum);
		
		
		maxSum = findMaxSubSeqUsingDC(arr,0,arr.length-1);//approach3
		System.out.println("maxSum=="+maxSum);
		

	}

	
	private static void findMaxSubSeqUsingDP(int[] arr)  //time- O(N)   space-O(N)
	{
		int[] tmp = new int[arr.length];
		tmp[0]=arr[0]>0?arr[0]:0;
		for(int i=1; i<arr.length; i++)
		{
			if(tmp[i-1]+arr[i] >0)
			{
				tmp[i] = tmp[i-1] +arr[i];
				maxSum = tmp[i]>maxSum? tmp[i]:maxSum;
			}
			else
				tmp[i]=0;	
		}
		
	}
	
	private static void findMaxSubSeqInSingleTraversal(int[] arr)   //time- O(n)   space-O(1)
	{
		start=0;last=0;
		int tmpStart=0;
		int tmpSum=0;
		for(int i=0; i<arr.length; i++)
		{
			if(tmpSum+arr[i] >0)
			{
				tmpSum = tmpSum+arr[i];
				if(tmpSum > maxSum)
				{
					maxSum = tmpSum;
					last = i;
					start=tmpStart;
				}
			}
			else
			{
				tmpSum=0;
				tmpStart=i+1;
			}
				
		}
		
		
	}
	
	
	private static int findMaxSubSeqUsingDC(int[] arr, int left, int right)  //NlogN
    {
        //System.out.println("left="+left+"   right="+right);
        
       
        if(left>right)
            return 0;
        if(left==right)
            return arr[left];
       
        int mid= (left+right)/2;
        int leftHalfSum = findMaxSubSeqUsingDC(arr,left,mid);
        int rightHalfSum = findMaxSubSeqUsingDC(arr,mid+1,right);
       
        int maxLeftContiguous = 0;
        int tmpLeftSumContiguous = 0;
        int index = mid-1;
        while(index>=left)
        {
            tmpLeftSumContiguous = tmpLeftSumContiguous+ arr[index];
            if(tmpLeftSumContiguous>maxLeftContiguous)
            {
                maxLeftContiguous = tmpLeftSumContiguous;
            }
            index--;
        }
        int maxRightContiguous = 0;
        int tmpRightSumContiguous = 0;
        index = mid;
        while(index<=right)
        {
            tmpRightSumContiguous = tmpRightSumContiguous+ arr[index];
            if(tmpRightSumContiguous>maxRightContiguous)
            {
                maxRightContiguous = tmpRightSumContiguous;
            }
            index++;
        }
       
        int localSum = maxLeftContiguous+maxRightContiguous;
       
        return maxOfThree(leftHalfSum,rightHalfSum,localSum);
       
    }
   
    private static int maxOfThree(int sum1,int sum2,int sum3)
    {
        if(sum1>sum2)
        {
            return (sum1>sum3? sum1:sum3);
        }
        else
        {
            return (sum2>sum3? sum2:sum3);
        }
    }
	
	
}
