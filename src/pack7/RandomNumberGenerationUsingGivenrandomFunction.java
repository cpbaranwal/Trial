package pack7;

import java.util.Random;

public class RandomNumberGenerationUsingGivenrandomFunction {

	/**
	    Given a function which generates a random integer in the range 1 to 7,
	    write a function which generates a random integer in the range 1 to 10 uniformly.
	    
	    Approach- run the given random function 2 times. 
	    It will give maxm possible combinations of 7*7=49 times.
	    Since we have to find random number between 1 to 10, we initialize an array[7][7] with numbers 1 to 10
	    on repetition till 40th number in array i.e. array[5][[4].
	    Numbers from 41 to 49 will be discarded and the function will be called again.
	    
	       0  1  2  3  4  5  6  
	       
		   1  2  3  4  5  6  7
		   8  9 10  1  2  3  4
		   5  6  7  8  9 10  1
		   2  3  4  5  6  7  8
		   9 10  1  2  3  4  5
		   6  7  8  9 10  *  *
		   *  *  *  *  *  *  *
	 */
	
	
	static int arr[][] = new int[7][7];
	public static void main(String[] args)
	{
		//initialize the 2-D array as above
		for(int i=0; i<7; i++)
		{
			for(int j=0; j<7; j++)
			{
				//TODO arr[i][j] = (i*7 + (j+1)) - 
			}
		}
		
		System.out.println(getRandom10());
	}
	
	
	static int getRandom10()
	{
		int rand1 = getRandom7();
		int rand2 = getRandom7();
		
		if( arr[rand1][rand2] != 0)
			return arr[rand1][rand2];
		else
			return getRandom10();
	}
	
	static int getRandom7()
	{
		return (new Random().nextInt(7));
	}
	

}
