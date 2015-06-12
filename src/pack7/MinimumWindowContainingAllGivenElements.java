package pack7;

public class MinimumWindowContainingAllGivenElements {

	/**
	      Given a set T of characters and a string S, find the minimum window in S 
	      which will contain all the characters in T in complexity O(n).
    eg,
    String str = “ADOBECODEBANC”
    String strToFind = “ABC”

    Minimum window is “BANC”.
	 */
	//TODO need to debug this program later
	
	static int[] hasFound = new int[26];  //assuming the characters are only Capital alphabets
	static int[] needToFind = new int[26];
	static int startIndxForMinmWindow=0,lastIndxForMinmWindow=Integer.MAX_VALUE,minmWindowSize=Integer.MAX_VALUE;
	static int count=0;  //count will keep count of numbers that has been found till now
	public static void main(String[] args) 
	{
		 String strSource = "ADOBECODEBANC";
		 String strToFind = "ABC";
		 	 
		 findMinimumWindowContainingAllElements(strSource,strToFind);
		 System.out.println("main::   minmWindowSize="+minmWindowSize+"   startIndxForMinmWindow="+startIndxForMinmWindow+"   lastIndxForMinmWindow="+lastIndxForMinmWindow);
		 System.out.println("sub string found="+strSource.substring(startIndxForMinmWindow, lastIndxForMinmWindow+1));
	}
	
	private static void findMinimumWindowContainingAllElements(String strSource,String strToFind) 
	{
		for(int i=0; i<strToFind.length(); i++)
		{
			char ch = strToFind.charAt(i);
			needToFind[ch-'A']++;  //initialize the array
		}
		
		int start=0;int last=0;
		for( start=0,last=0; last<strSource.length(); last++)
		{
			System.out.println("start="+start+"    last="+last);
			if( needToFind[strSource.charAt(last)-'A'] == 0)
				continue;
			
			hasFound[strSource.charAt(last)-'A']++;
			if(hasFound[strSource.charAt(last)-'A']  <=   needToFind[strSource.charAt(last)-'A'])
				count++;
			
			if(count == strToFind.length())
			{
				while(  needToFind[strSource.charAt(start)-'A'] == 0   ||    needToFind[strSource.charAt(start)-'A']<hasFound[strSource.charAt(start)-'A'])
				{
					
					System.out.println("start2="+start+"  last2="+last);
					if (needToFind[strSource.charAt(start)-'A']<hasFound[strSource.charAt(start)-'A'])
						hasFound[strSource.charAt(start)-'A']--;
					start++;
					
				}
					
				if(minmWindowSize > (last-start+1))
				{
					minmWindowSize = (last-start+1);
					startIndxForMinmWindow = start;
					lastIndxForMinmWindow = last;
					System.out.println("minmWindowSize="+minmWindowSize+"  startIndxForMinmWindow="+startIndxForMinmWindow+"  lastIndxForMinmWindow="+lastIndxForMinmWindow);
				}
				
					
			}
			
		}
		
		
	}

}
