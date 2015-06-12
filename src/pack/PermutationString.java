package pack;

public class PermutationString {

	
	public static void main(String[] args) {
		String str= "abc";
		char[] arr=str.toCharArray(); 
		printPermutation(arr,0,str.length());
		System.out.println("ends......="+arr.toString());
	}
	
	public static void printPermutation(char[] s,int c,int n)
	{
		if(s==null )
			return;
		if(c==n)
			System.out.println("res: "+String.valueOf(s));;
			
			for(int i=c;i<n;i++)
			{
				char tmp=s[c];
				s[c]=s[i];
				s[i]=tmp;
				printPermutation(s, c+1, n);
				s[i]=s[c];
				s[c]=tmp;
			}
	}

}
