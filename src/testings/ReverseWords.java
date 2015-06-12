package testings;

public class ReverseWords {

	/**
	  Reverse words of a given sentence.
	  e.g. my name is chandan
	  o/p- chandan is name my

	 */
	public static void main(String[] args) {

	String str="  My name      is chandan  ";
	System.out.println("Result:  "+reverseString(str));

	}
	
	public static String reverseString(String inpt)
	{
		String str=inpt;
		if(str==null)
			return null;
		
		int len=str.length();
		char arr[]=new char[len];
		for(int i=0;i<len;i++)
		{
			arr[i]=str.charAt(len-1-i);
		}
		for(int i=0;i<len;i++)
		{
			
			while(i<arr.length-1 && arr[i]==' ')
				i++;
			
			int j=i;
				
			while(j<arr.length && arr[j]!=' ')
				j++;
				
			if(j!=i)
			{
					for(int k=0;k<(j-i)/2;k++)
					{
						char tmp=arr[i+k];
						arr[i+k]=arr[j-1-k];
						arr[j-1-k]=tmp;
					}
			}	
				
			
				i=j;
			
			
		}
		
		str=new String(arr);
		
		return str;
	}

}
