package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
  
 Enter number of rows:
5
    *    
   ***   
  *****  
 ******* 
********* 
 
 */
public class Triangle {

	
	
	public static void main(String[] args) {
		
		BufferedReader br=null;
		try
		{	Triangle obj=new Triangle();
			System.out.println("Enter number of rows:");
			 br=new BufferedReader(new InputStreamReader(System.in));
			int num=Integer.parseInt(br.readLine());
			br.close();
			obj.printTriangle(num);
		}
		
		
		catch(NumberFormatException ex)
		{  System.out.println("Enter only integer values, exception:"+ex.getMessage());
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
			
		System.out.println("ends.........");
	}
	
	public void printTriangle(int numOfRows)
	{
		int n=2*(numOfRows-1)+1;
		
		for(int i=0;i<numOfRows;i++)
		{
			//int k=2*i+1;
			for(int j=0;j<(n-2*i-1)/2;j++)
				System.out.print(" ");
			
			for(int j=0;j<(2*i+1);j++)
				System.out.print("*"); 
			
			for(int j=0;j<(n-2*i-1)/2;j++)
				System.out.print(" ");
			
			System.out.println();
			
		}
		return;
	}

}
