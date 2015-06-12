package temp;

public class ReverseString {

	/**
	    program to reverse a given string.
	    input = "chandan"
	    output: nadnahc
	    
	 */
	public static void main(String[] args) {
		System.out.println("main starts");
		String str = "chandan";
		String output = getReversedString(str);
		System.out.println("output: "+output);

	}
	
	public static String getReversedString(String input) 
	{
		String output = null;
		
		if(input==null)
			throw new IllegalArgumentException("NULL is an invalid argument!");
		
		int len = input.length();
		if(len==1)
		{ return input;}
		
		//StringBuilder sb = new StringBuilder(len);
		char[] arr = new char[len];
		for(int i =0; i<len; i++)
		{
			arr[i] = input.charAt(len-1-i);
		}
		output = new String(arr);
		
		return output;
	}

}
