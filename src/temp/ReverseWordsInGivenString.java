package temp;

public class ReverseWordsInGivenString {

	/**
	 Example: Let the input string be “i like this program very much”. 
	 The function should change the string to “much very program this like i”.
	 */
	
	
	public static void main(String[] args) 
	{
		String str1 = "i like this program very much";

		String str2 = getReversedWordsString(str1);
		System.out.println("result= "+str2);
	}

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
		System.out.println("before reverseCharacters: ");
		for(int x=start; x<=end; x++)
			System.out.print(arr[x]);
		System.out.println();
		for(int i=start,j=end; i<j; i++,j--)
		{
			char tmp = arr[i];
			arr[i]=arr[j];
			arr[j]=tmp;
		}
		System.out.println("after reverseCharacters: ");
		for(int x=start; x<=end; x++)
			System.out.print(arr[x]);
		System.out.println();
	}

}
