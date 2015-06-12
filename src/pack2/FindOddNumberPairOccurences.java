package pack2;

public class FindOddNumberPairOccurences {

	/**
	Given an unsorted array that contains even number of occurrences for all numbers except two numbers. 
	Find the two numbers which have odd occurrences in O(n) time complexity and O(1) extra space.
	Examples:
	Input: {12, 23, 34, 12, 12, 23, 12, 45}
	Output: 34 and 45
	 */
	public static void main(String[] args) {
		
		int a[]=  {12, 23, 34, 12, 12, 23, 12, 45};
		findOddPair(a);
	}
	
	public static void findOddPair(int[] arr)
	{
		int xor=arr[0];
		for(int i=1;i<arr.length;i++)
			xor=xor^arr[i];
		
		int setBit= xor & (~(xor-1));
		int x=0;
		int y=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if((arr[i]&setBit)==setBit)
				x=x^arr[i];
			else
				y=y^arr[i];
		}
		System.out.println("  x=="+x+"  y=="+y);
			
		return;
	}

}
