package temp;

public class CountNoOfValidBinaryStrings {

	/**
	You have to count how many binary strings are possible of length "K".
Constraint: Every 0 has a 1 in its immediate left.

111011 <-- valid
0111 <--- invalid
111100 <-- invalid
	 */
	
	static int cntr=0;
	public static void main(String[] args) {

		int len =4;
		printAndCountValidString(len);

	}
	
	public static void printAndCountValidString(int len)
	{
		if(len<1)
			throw new IllegalArgumentException();
		printAndCountValidStringHelper("1",len-1);
		System.out.println("cntr=="+cntr);
	}
	public static void printAndCountValidStringHelper(String prefix, int len)
	{
		if(prefix.indexOf("00")!= -1)
			return;
		if(len == 0 )
		{
			System.out.println(prefix);
			cntr++;
		}
		else
		{
			printAndCountValidStringHelper(prefix+"1",len-1);
			printAndCountValidStringHelper(prefix+"0",len-1);
		}
		
	}

}
