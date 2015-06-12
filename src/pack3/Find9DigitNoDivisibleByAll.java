package pack3;

public class Find9DigitNoDivisibleByAll {

	/**
		you are given nos 1,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9
		 u hav to form a 9 digit no such dat 1st 2 digits are divisible by 2,
		 1st 3 digits are divisible by 3,1st 4 digits are divisible by 4 and so on..... 
		 (repetitions not allowed)
	 */
	public static void main(String[] args) {
		
		int[] arr={1,2,3,4,5,6,7,8,9};
		System.out.println("In Main");
		printNumber(arr);
		System.out.println("Main Ends");
	}
	
	public static void printNumber(int[] arr)
	{
		if(arr==null || arr.length!=9)
		{
			System.out.println("Invalid input");
			return;
		}
		
		for(int i=0;i<9;i++)
		{
			if(arr[i]!=i+1)
			{
				System.out.println("Wrong Data");
				return;
			}
		}
		
		helper1(arr,0);
		
		//381654729
		//int[] arr2={3,8,1,6,5,4,7,2,9};
		//checkAndPrint(arr2);
		
	}
	
	public static void helper1(int[] arr, int indx)
	{
		if(indx>8)
			return;
		
		for(int i=indx;i<=8;i=i+2)
		{ 
			swap(arr,i,indx);
			
		//	if(i!=4) // skip 5....its place is constatnt
		{
			helper2(arr,1);
		}
		helper1(arr,indx+2);//recursively calling same function
			swap(arr,i,indx);
		}
		
		
	}
	
	public static void swap(int[]arr, int i,int j)
	{
		int tmp=arr[i];arr[i]=arr[j];arr[j]=tmp;
	}
	
	public static void checkAndPrint(int[] arr)
	{
		int num=0;
		int i=0;
		for(;i<9;i++)
		{
			num=num*10+arr[i];
			if(num%(i+1)!=0)
				break;
		}
		//System.out.println("num="+num);
		if(i>=9 )
			System.out.println("One valid result:  "+num);
	}
	
	public static void helper2(int[] arr, int indx)
	{
		if(indx>7)
			return;
		
		for(int j=indx;j<=7;j=j+2)
		{
			swap(arr,j,indx);
			checkAndPrint(arr);
			helper2(arr,indx+2);
			swap(arr,j,indx);
		}
		
		
	}

}
