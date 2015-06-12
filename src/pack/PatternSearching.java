package pack;

public class PatternSearching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		
		String txt =  "AABAACAADAABAAABAA";
		String pat = "AABA";		
		searchPattern(txt,pat);	
		System.out.println("program ends");
	}
	
	public static void searchPattern(String txt,String pat)
	{
		if(txt==null || pat==null)
			return;
		int l1=txt.length();
		int l2=pat.length();
		if(l1<l2) return;
		
		int k=0;
		for(int i=0;i<l1-l2;i++)
		{	k=0;
			if(txt.charAt(i)==pat.charAt(k))
			{
				while(k<l2 && txt.charAt(i)==pat.charAt(k))
				{
					i++; k++;
				}
				if(k==l2)
				{
					System.out.println("pattern found at index:"+(i-k));
				}
				 i=i-k;
			}
		}
			
			
		
	}

}
