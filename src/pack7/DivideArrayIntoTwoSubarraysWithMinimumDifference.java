package pack7;

import java.util.ArrayList;
import java.util.List;

public class DivideArrayIntoTwoSubarraysWithMinimumDifference {

	/**  //TODO
		There is an array {1,2,3,4,5,6,7,8}
Divide the array in two subarrays such that
the difference between sum of the elements of individual subarrays is minimum.

lets say u divide the arrays in a1 and a2.
Then sum of elements of a1 - sum of elements of a2 should be minimum 
if u divide the array in other way possible.

//is it a NP problem?


	 */
	
	
	static List<Integer> l1 = new ArrayList<Integer>();
	static List<Integer> l2 = new ArrayList<Integer>();
	public static void main(String[] args) 
	{
		int[] arr =  {1,2,3,4,5,6,7,8};
		
		divideArrayIntoSubArrays(arr);
		System.out.println("list l1= "+l1);
		
		System.out.println("list l2= "+l2);

	}
	private static void divideArrayIntoSubArrays(int[] arr)
	{
		if(arr==null || arr.length<2)
			return;
		
		//lets assume given array is sorted otherwise i will sort it in O(NlogN)
		int sum=0;
		for(int x: arr)
			sum += x;
		int midSum = sum/2;
			
		int nearestToMidSum = 0;
		
		
	}

}
