package temp;

public class MergeTwoSortedArrays {

	/**
	 * @param args
	 */
	public static int MAX=100000;
	public static void main(String[] args) {
		int arr1[]=new int[10];
		int arr2[]=new int[4];
		
		arr1[0]=2;arr1[1]=5;arr1[2]=10;arr1[3]=16;arr1[4]=35;arr1[5]=40;arr1[6]=MAX;arr1[7]=MAX;arr1[8]=MAX;arr1[9]=MAX;
		arr2[0]=8;arr2[1]=9;arr2[2]=20;arr2[3]=50;
		
		System.out.println("Before: ");
		for(int x:arr1)
			System.out.print("	"+x);
			
				System.out.println(" ");
				for(int x:arr2)
					System.out.print("	"+x);	
				
				arr1=mergeSecondArrayIntoOne(arr1,arr2);
		
				System.out.println("\nAfter: ");
				for(int x:arr1)
					System.out.print("	"+x);
		

	}
	
	public static int[] mergeSecondArrayIntoOne(int[] big, int[] small)
	{
		int length = small.length;
		for(int i=0,j=0; j< small.length; i++)
		{
			if(big[i] > small[j])
			{
				for(int k=big.length+j-small.length; k>i; k--)
				{
					big[k] = big[k-1];
				}
				big[i] = small[j];
				j++;
				System.out.println("j=="+j+"   i=="+i);
			}
		}
		
		
		return big;
	}
	
}
