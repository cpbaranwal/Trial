package pack5;

public class LongestCommonSubsequenceDP {

	/**
	 * Good program
	 	program to find longest common subsequence  for two given strings.
	 */
	public static void main(String[] args) {
		

		int length = getLongestSubSequenceLengthUsingDP();
		System.out.println("length=="+length);
		String subSeq= getSubSequenceStringHelper();
		System.out.println("subSeq= "+subSeq);
		int length2 = getLCSUsingRecursion(str1,str2);
		System.out.println("length2=="+length2);
		
	}
	
	private static  String str1 = "abcdefghii";
	private static  String str2 = "aaddbbffccddmmii";
	static int[][] storage;  static int m,n;
	private static int getLongestSubSequenceLengthUsingDP()  //time-O(m*n)  space-(m*n)
	{
		m = str1.length();   n=str2.length();
		storage = new int[m+1][n+1];
	
		for(int i=m-1; i>=0; i--)
		{
			for(int j=n-1; j>=0; j--)
			{
				storage[i][j] = storage[i+1][j+1];
				if(str1.charAt(i) == str2.charAt(j))
				{  storage[i][j] ++; }
				
				if(storage[i+1][j] > storage[i][j])
					storage[i][j] = storage[i+1][j];
				if(storage[i][j+1] > storage[i][j])
					storage[i][j] = storage[i][j+1];
			}
		}
		
		return storage[0][0];
	}
	private static String getSubSequenceStringHelper()  //method to return the subsequence String
	{
		String res="";
		int length = storage[0][0];
		int i=0; int j=0;
		while(length>0)
		{
			if(str1.charAt(i)==str2.charAt(j))
			{
				res = res+str1.charAt(i);
				i++;
				j++;
				length--;
			}
			else if(storage[i+1][j]==storage[i][j])
			{
				i++;
			}
			else if(storage[i][j+1]==storage[i][j])
			{
				j++;
			}
			else
			{
				i++;
				j++;
			}
		}
		return res;
	}
	
	private static int getLCSUsingRecursion(String s1, String s2)
	{
		int len =0;
		if(s1==null || s1.isEmpty() || s2==null || s2.isEmpty())
			return 0;
		
		int len1 = (s1.charAt(0)==s2.charAt(0)?1:0) + getLCSUsingRecursion(s1.substring(1),s2.substring(1));
		int len2 = getLCSUsingRecursion(s1.substring(1),s2);
		int len3 = getLCSUsingRecursion(s1,s2.substring(1));
		
		len= (len1>len2?len1:len2);//max of all
		len = (len>len3?len:len3);
		
		return len;
	}
}
