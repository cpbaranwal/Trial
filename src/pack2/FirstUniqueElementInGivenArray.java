package pack2;

public class FirstUniqueElementInGivenArray {

	/*
	 Write a program to find the first unique element in the following array:
		{'a', 'a', 'u', 'b'}
		this solution is using extra space with O(n) time complexity.
	 */
	public static void main(String[] args) {
		char arr[]={'a','b','c','d','e','b','c','a','f'};
		
		try{
		System.out.println("character is:  "+getFirstUniqueElement(arr));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static char getFirstUniqueElement(char[] arr) throws Exception
	{
		if (arr==null)
			throw new Exception("Invalid Input");
		int[] tArr=new int[26];
		
		for(int i=0;i<tArr.length;i++)
			tArr[i]=-1;
		char ch = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]-'a'<0 || arr[i]-'a'>25)
				throw new Exception("Number is not a charcater!!");
			int x=arr[i]-'a';
			if(tArr[x]==-1)
			{
				tArr[x]=1;
			}
			else
			{
				tArr[x]++;
			}
		}
		for(int i=0;i<tArr.length;i++)
		{
			if(tArr[i]==1)
			{
				ch=(char)('a'+i);
				
				break;
			}
		}
		return ch;
		
	}

}
