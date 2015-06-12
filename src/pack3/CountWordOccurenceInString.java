package pack3;

public class CountWordOccurenceInString {

	/**
	 		find the no. of time a particular word is occurring in a string?
		eg. "Hello I am going to I with Hello am
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String str="Hello I am going to I with Hello am goingoingoinggoing going";
		String wrd="going";
		
		System.out.println("Count:  "+getCount(str,wrd));

	}
	
	public static int getCount(String str,String wrd) throws Exception
	{
		int cnt=0;
		if(str==null || wrd==null || wrd.length()>str.length())
			throw new Exception("Wrong Input");
		
		for(int i=0;i<=str.length()-wrd.length();i++)
		{
			
			if(str.charAt(i)==wrd.charAt(0))
			{
				int p=0;int j=i;
				while(p<wrd.length() && str.charAt(j)==wrd.charAt(p))
				{
					p++;
					j++;
				}
				if(p==wrd.length())
				{
					cnt++;
					System.out.println(str.substring(i, str.length()));
					i=j-1;
				}
				
			}
		}
		
		return cnt;
	}

}
