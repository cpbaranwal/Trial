package pack5;

public class LongestPalindromeSubsequenceDP {

	/**
	    Given a String, find the length of longest palindrome subsequence in the string.
	    Dynamic Programming
	 */
	public static void main(String[] args) {

		String str = "abcdefghgfexjklymnoppzonmlkj";
		System.out.println("result= "+getLengthLongestPalindromeSubsequenceDP(str));

	}
	
	private static int getLengthLongestPalindromeSubsequenceDP(String input)
	{
		int n = input.length();
		int[][] max = new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			max[i][i] = 1;
			if(i<n-1 && input.charAt(i)==input.charAt(i+1))
				max[i][i+1] = 2;
		}
		
		for(int i=2; i<n; i++)// is is the length of currently considered substring
		{
			for(int j=0; j+i<=n-1; j++)//j is starting index of currently considered substring and k is last
			{
				int k= j+i;
				if(input.charAt(j)==input.charAt(k))
					max[j][k]= max[j+1][k-1] + 2;
				else
				{
				if(max[j][k]<max[j+1][k])
					max[j][k]=max[j+1][k];
				if(max[j][k]<max[j][k-1])
					max[j][k]=max[j][k-1];
				}
			}
			
		}
		
		return max[0][n-1];
	}

}
