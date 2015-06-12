package pack5;

public class LongestPalindromeSubstringDP {

	/**
	    Given a String, find the length of longest palindrome substring in the string.
	    Dynamic Programming
	 */
	public static void main(String[] args) {

		String str = "abcdeedcjklmnonmlkj";
		System.out.println("result= "+getLengthLongestPalindromeSubstringDP(str));

	}
	
	//imp - need to keep a maxLength variable
	private static int getLengthLongestPalindromeSubstringDP(String input)
	{
		int n = input.length();
		int[][] max = new int[n][n];
		int maxLength=0;
		
		for(int i=0; i<n; i++)
		{
			max[i][i] = 1;
			if(i<n-1 && input.charAt(i)==input.charAt(i+1))
				max[i][i+1] = 1;
		}
		
		for(int i=2; i<n; i++)//i is length of currently considered substring
		{
			for(int j=0; j+i<n; j++)//j is starting index of currently considered substring and k is last
			{
				int k= j+i;
				if(input.charAt(j)==input.charAt(k)  &&  max[j+1][k-1]==1)
					{
					max[j][k]= 1;
					maxLength=i+1;
					}
				
			}
			
		}
		
		return maxLength;
	}

}
