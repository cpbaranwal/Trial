package pack7;

import java.util.HashSet;
import java.util.Stack;

public class SplitStringToValidWordsFromDictionary {

	/**
	 	You are given a string of n characters s[1...n], which you believe to be a corrupted text document 
	 	in which all punctuation has vanished (so that it looks something like "itwasthebestoftimes..."). 
	 	You wish to reconstruct the document using a dictionary,
	 */
	
	
	public static void main(String[] args) 
	{
		dictionary.add("it");
		dictionary.add("was");
		dictionary.add("the");
		dictionary.add("best");
		dictionary.add("of");
		dictionary.add("times");
		dictionary.add("its");
		dictionary.add("time");
		dictionary.add("were");
		dictionary.add("there");
		dictionary.add("beast");
		dictionary.add("for");
		
		String str = "itwasthebestoftimes";
		boolean isValidString = isValidString(str);
		System.out.println("isValidString="+isValidString);
		if(isValidString)
		{
			String result = printStringWithSpaces(str);
			System.out.println("result="+result);
		}

	}
	
	private static String printStringWithSpaces(String str) 
	{
		int len = str.length();
		String resultStr = "";
		int prev=len-1;
		for(int i=len-2; i>=0; i--)
		{
			if(boolArray[i]==1)
			{
				String subStr = str.substring(i+1, prev+1);
				if(dictionary.contains(subStr))
				{
					resultStr = subStr+" "+resultStr;
					prev = i;
				}	
			}
		}
		
		//corner last case
		resultStr = str.substring(0, prev+1)+" "+resultStr;
		return resultStr;
		
	}

	static HashSet<String> dictionary = new HashSet<String>();
	static int[] boolArray; 
	public static boolean isValidString(String str)//O(N^2)
	{
		if(str==null)
			return true;
		boolArray = new int[str.length()]; 
		for(int i=0; i<str.length(); i++)//O(N)
		{
			String wholeWord = str.substring(0, i+1);//O(N)
			if(dictionary.contains(wholeWord))
				boolArray[i]=1;
			
			for(int j=0; j+1<i; j++)//O(N)
			{		
				if(boolArray[j]==1)
					{
					String partialWord = str.substring(j+1, i+1);//O(N)
					if(dictionary.contains(partialWord))
						boolArray[i]=1;
					}
			}
		}
		for(int x: boolArray)
			System.out.print(x+",");
		System.out.println();
		
		if(boolArray[str.length()-1]==1)
			return true;
		return false;
	}

}
