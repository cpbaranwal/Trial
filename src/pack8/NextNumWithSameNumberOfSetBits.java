package pack8;

public class NextNumWithSameNumberOfSetBits {

	/**
	   Given a number x, find next number with same number of 1 bits in it’s binary representation.
		For example, consider x = 12, whose binary representation is 1100 (excluding leading zeros on 32 bit machine). 
		It contains two logic 1 bits. The next higher number with two logic 1 bits is 17 (10001).
		
		101 -> 110      (5->6)
		111 -> 1011  	(7->11)
		1011 ->1101		(11 -> 13)
		1100 -> 10001  	(12 -> 17)
		1101 -> 1110	(13 -> 14)
		1111 -> 10111   (15 -> 23)
		
		Approach - start scanning from right extreme. find the first 1/set bit on left of which there is a 0 bit. 
		so basically find bits in pattern ....01... and interchange their position to ....10... . 
		Now shift all the set bits on right of this bit to the extreme right.so e.g. 1101100 -> 111001
	 */
	public static void main(String[] args)
	{
		//int input =15; 
		int input =12;
		int output = getNextNumWithSameNumberOfSetBits(input);
		System.out.println("output: "+output);

	}
	
	public static int getNextNumWithSameNumberOfSetBits(int input)
	{
		if(input==0)
			return input;
		
		int first1BitOnRightOf0 =1;
		int noOf0Bits =0;
		int noOf1Bits =0;
		
		while( (first1BitOnRightOf0 & input) == 0)
		{
			first1BitOnRightOf0 = first1BitOnRightOf0<<1;
			noOf0Bits++;
		}			
		
		int first0BitOnLeftOf1 = first1BitOnRightOf0<<1;
		while( (first0BitOnLeftOf1 & input) != 0)
		{
			first1BitOnRightOf0 = first1BitOnRightOf0<<1;
			first0BitOnLeftOf1 = first0BitOnLeftOf1<<1;
			noOf1Bits++;
		}
		
		int tmpOutput = (input | first0BitOnLeftOf1 ) ^ first1BitOnRightOf0;
		tmpOutput = ((tmpOutput >> (noOf0Bits+noOf1Bits)) << noOf0Bits);
		while(noOf1Bits > 0)
		{
			noOf1Bits--;
			tmpOutput = tmpOutput<<1;
			tmpOutput = tmpOutput|1;
		}
		
		return tmpOutput;
		
		
		
		
	}

}
