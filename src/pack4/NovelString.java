package pack4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class NovelString {

	/**	 
	 * Input:

The input is one or more non-empty strings of at most 100 capital letters, each string on a line by itself,
 followed by a line containing only two dollars ($$) signaling the end of the input.

Output:
For each input line, output whether or not it is a Novel string using the exact output format shown below.

Sample Input: (Input File: novel.in)
FLBL
FFLL
ORDINARY
R
QYQRQYY
$$

Sample Output: (Output File: novel.out)
FLBL is a Novel string
FFLL is not a Novel string
ORDINARY is a Novel string
R is a Novel string

	 */
	
	
	public static void main(String[] args) {
		
		NovelString ns=new NovelString();
		//String str="QYQRQYY";
		
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:/workspace/Trial/src/pack4/Novel.in.txt"));  // Enter file location
		    BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/chandan/Desktop/NovelOutput.txt")); // Enter file location
		    String str;
		    while ((str = in.readLine()) != null && !str.equals("$$")) {
		       //System.out.println("str="+str);
		       String output=ns.checkNovelString(str);
		       
		       out.write(output);
		       out.write("\n");
		       
		    }
		    in.close();
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
	}
	
	
	//METHOD to be called
	public  String checkNovelString(String str) throws Exception
	{
		if(str==null || str.length()<1 )
			throw new Exception("Invalid Input");
		
		if(str.length()==2)
			return str;
		
		int len=str.length();
		
		for(int i=1;i<len;i++)
		{
			if(!checkForNovelHelper(str,i))
				return (str+" is NOT a Novel String");
		}
		
		return (str+ "is a Novel String");
	}
	
	
	//helper method
	public boolean checkForNovelHelper(String str,int k)
	{
		Set<String> novelSet=new HashSet<String>();
		for(int i=0;i<str.length()-k;i++)
		{
			
			String tmp=String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i+k));
			if(!novelSet.add(tmp))
				return false;
		}
		
		return true;
	}
	
	

}
