package pack5;

public class ReverseWordsInGivenString {

	/**
	    Reverse words in a given String in optimized space and time.
	    space- O(N)  time-O(N)
	    
	 */
	public static void main(String[] args) {


		String input = "  Hi my name is chandan  ";
		System.out.println("input.length()=="+input.length());
		//System.out.println("result1="+getReversedString(input));
		System.out.println("result2="+getReversedWordsString(input));  //better one ,simple and elegant

	}
	
	public static String getReversedString(String input)
	{
		//String output = null;
		
		if(input==null)
			throw new IllegalArgumentException("Input String cannot be null");
		if(input.length()<2 || input.trim().indexOf(" ")==-1)//single word
			return input;
		
		char arr[] = input.toCharArray();
		for(int i=0,j=arr.length-1; i<j; i++,j--)
		{
			char temp = arr[i]; arr[i]=arr[j]; arr[j]=temp;
		}
		//System.out.println(new String(arr));
		int i=0,j=0;
		for(; j<arr.length; j++)
		{
			if(arr[j]==' ')
			{
				int k = j-1;
				while(j<arr.length-1 && arr[j+1]==' ')
				{
					j++;
				}
				if(i<k)
				{
					//System.out.println("before i=="+i+"   j=="+j+"   k=="+k);
					//System.out.println(new String(arr));
				}
				while(i<k)
				{
					char temp=arr[i]; arr[i]=arr[k]; arr[k]=temp;
					i++; k--;
				}
				//System.out.println("after i=="+i+"   j=="+j+"   k=="+k);
				//System.out.println(new String(arr));
				i=j+1;			
			}
			
		}
		//corner case- last word
		if(i<j-1)
		{
			char temp = arr[i]; arr[i]=arr[j-1]; arr[j-1]=temp;
			i++; j--;
		}
		return new String(arr);
	}
	
	//a better one below
	private static String getReversedWordsString(String str1)
	{
		if(str1==null || (str1.indexOf(" ")==-1))
		{
			System.out.println("no changes needed");
			return str1;
		}
		
		char[] arr = str1.toCharArray();
		for(int i=0,j=arr.length-1; i<j; i++,j--)
		{
			char tmp = arr[i];
			arr[i]=arr[j];
			arr[j]=tmp;
		}
		System.out.println("print1: "+new String(arr));
		
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]==' ')
				continue;
			int j= i;
			while((j<arr.length) && arr[j]!=' ')
				j++;
			
			
			reverseCharacters(arr,i,j-1);
			i=j-1;
		}
		
		return new String(arr);
		
	}

	private static void reverseCharacters(char[] arr, int start, int end)
	{
		//System.out.println("before reverseCharacters: ");
		for(int x=start; x<=end; x++)
			System.out.print(arr[x]);
		System.out.println();
		for(int i=start,j=end; i<j; i++,j--)
		{
			char tmp = arr[i];
			arr[i]=arr[j];
			arr[j]=tmp;
		}
		//System.out.println("after reverseCharacters: ");
		for(int x=start; x<=end; x++)
			System.out.print(arr[x]);
		System.out.println();
	}

}
