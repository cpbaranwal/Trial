package pack3;

public class CountValidNoOfBinaryString {

	/**
	You have to count how many binary strings are possible of length "K".
Constraint: Every 0 has a 1 in its immediate left.

111011 <-- valid
0111 <--- invalid
111100 <-- invalid
	 */
	public static void main(String[] args) {
		
		
		int len=4;
		printAndCntValidString("",len);
		System.out.println("cntr=="+cntr);

	}
	public static int cntr=0;
	
	public static void printAndCntValidString(String inpt, int len)
	{
		if(len<0)
			return;
		
		if(len==0)
		{
			checkAndPrint(inpt);
		}
		
		printAndCntValidString(inpt+"1",len-1);
		printAndCntValidString(inpt+"0",len-1);
	}
	
	public static void checkAndPrint(String str)
	{
		if(str.startsWith("0") || str.contains("00"))
		return;
		
		System.out.println("valid string: "+str);
		cntr++;
	}

}
