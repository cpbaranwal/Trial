package testings;

public class MorganSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String str="ABCCBCBA";
		// str="AA";
		//System.out.println("output="+remDup(str));
		
		//String inputStr = "abcdefgh";
		//int K=5;
		//System.out.println("output="+subsetReverse(K, inputStr));
		
		String inputStr ="PtrrvqqT";
		System.out.println("output="+missingChar(inputStr));

	}
	
	
	static  String missingChar(String inputStr)
	{
		if(inputStr==null || inputStr.isEmpty() || inputStr.length()==1)
		{
			System.out.println("Not a valid input");
			return "NONE";
		}
		String str = inputStr.toLowerCase();
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		
		for(int i=0; i< str.length(); i++)
		{
			if(str.charAt(i) < minVal)
				minVal = str.charAt(i);
			if(str.charAt(i) > maxVal)
				maxVal = str.charAt(i);
		}
		
		for(int i=minVal; i<maxVal; i++)
		{
			Character ch = (char)i;
			String tmp = ch.toString();
			if(!str.contains(tmp))
				return tmp;
		}
		
		return "NONE";
	}
	
	
	static String subsetReverse(int K, String str)
	{
		if(K<=0)
		{
			System.out.println("K must be greater than 0 ");
			return str;
		}
		if(str==null || str.isEmpty())
		{
			return str;
		}
		
		int len = str.length();
		if(K > len)
			return str;
		
		StringBuffer str1 = new StringBuffer(str.substring(0,K));
		str1 = str1.reverse();
		
		String output = new String(str1) + subsetReverse(K, str.substring(K));
		return output;
	}
	
	static String remDup(String str)
	{
		if(str==null || str.isEmpty())
			return "-1";
		if(	str.length()==1)
			return str;
		
		for(int i=0; i<str.length()-1; i++)
		{
			if(str.charAt(i) == str.charAt(i+1))
			{
				String str1 ="";
				if(i>0)
				{
					str1 += str.substring(0,i)	;
				}
				if(i+2 < str.length())
				   str1 +=str.substring(i+2);
				
				str = remDup(str1);
			}
		}
		
		return str;
	}

}
