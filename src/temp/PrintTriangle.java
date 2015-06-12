package temp;

import java.io.*;

public class PrintTriangle {

	
	 /*
  
 Enter number of rows:
5
    *    
   ***   
  *****  
 ******* 
********* 
 
 */
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		//int num = 6;
		
			System.out.println("Enter no of rows:");
			br = new BufferedReader(new InputStreamReader(System.in));
			int num;
			try {
				num = Integer.parseInt(br.readLine());
				printTriangle(num);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		

	}
	
	public static void printTriangle(int numLines)
	{
		if (numLines<1)
			throw new IllegalArgumentException();
		
		//int numSymbols = 1;
		for(int i=0; i<numLines; i++)
		{
			int numSymbols = 2*i+1;
			int numSpaces = numLines-1-i;
			System.out.println();
			for(int y=0;y<numSpaces;y++)
				System.out.print(" ");
			for(int y=0;y<numSymbols;y++)
				System.out.print("*");
			for(int y=0;y<numSpaces;y++)
				System.out.print(" ");
		}
		
		
	}

}
