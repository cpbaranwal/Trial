package pack4;

public class Merge2SortedArrays {

	/**
	 You have 2 sorted Arrays. A and B. A is shorter than B. 
	 B has few elements in sorted order and has space for all elements of A. 
	 Now Merge these both array so that All elements are sorted. 
	 You cannot use extra Array. Use Only Array B
	 arr1={2,5,10,16,35,40};
	 arr2={8,9,20,50}
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
				
				arr1=mergeArrays(arr1,arr2);
		
				System.out.println("\nAfter: ");
				for(int x:arr1)
					System.out.print("	"+x);
		

	}
	
	public static int[] mergeArrays(int[] big, int[] small)
	{
		int l1=big.length;
		int l2=small.length;
		
		int i=0;int j=0;
		for(; j<l2;i++)
		{
			if(big[i]>=small[j])
			{
				System.out.println("k==="+(i+l2-j)+"  i==="+i+"   j==="+j);
				for(int k=l1-l2+j;k>i;k--)
				{
					
					big[k]=big[k-1];
				}
				big[i]=small[j];
				j++;
			}
		}
		System.out.println(i+""+j);
		
		
		return big;
	}

}
