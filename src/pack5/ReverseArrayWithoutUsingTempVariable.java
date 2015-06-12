package pack5;

import java.util.*;

public class ReverseArrayWithoutUsingTempVariable {

	/**
	  Reverse a given array without using any temporary variable
	  e.g.  
input array=[[C@e48e1b]
  a  b  c  d  :  f  g  h
output array=[[C@e48e1b]
  h  g  f  :  d  c  b  a 
	 */
	public static void main(String[] args) {

		char arr[]= {'a','b','c','d',':','f','g','h'};
		
		System.out.println("input array="+Arrays.asList(arr).toString());
		for(int i=0; i<arr.length; i++)
		System.out.print("  "+arr[i]);
		
		reverseArrayWithoutTempVar(arr);
		System.out.println("");
		System.out.println("output array="+Arrays.asList(arr).toString());
		for(int i=0; i<arr.length; i++)
		System.out.print("  "+arr[i]);

		
	}
	
	
	//approach....swap  elements from both ends....then move 1 step from left end and 1 step from right end.
	public static char[] reverseArrayWithoutTempVar(char[] arr)
	{
		if (null == arr)
			throw new IllegalArgumentException(" Null can not be the input");
		
		if(arr.length>1)
		{
			int j=arr.length-1;
			for(int i=0; i<j; i++,j--)
			{
				arr[i] = (char)(arr[i]^arr[j]);
				arr[j] = (char)(arr[i]^arr[j]);
				arr[i] = (char)(arr[i]^arr[j]);
				
			}
			
			
		}
		
		
		
		
		return arr;
	}

}
