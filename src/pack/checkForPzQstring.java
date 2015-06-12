package pack;

import java.util.ArrayList;
import java.util.List;

public class checkForPzQstring {

	
	public static void main(String[] args) {
		String str="xxyxabxyxx";
		System.out.println("start");
		System.out.println("result=="+isPzQstring(str));
		System.out.println("end");

	}
	
	public static boolean isPzQstring(String str)
	{
		if(str==null)
			return false;
		
		//int pos1=0;
		int pos11=0;
		int pos2=str.length()-1;;
		for(int i=0;i<(str.length()/2);i++)
		{
			if (str.charAt(i)!='x' && str.charAt(i)!='y')
			{
				pos11=i-1;
				while(str.charAt(i)!='x' && str.charAt(i)!='y')
					i++;
				
				pos2=i;
				break;
			}
		}
		if(pos11!=str.length()-1-pos2)
		return false;
		
		List<Character> l1=new ArrayList<Character>();
		List<Character> l2=new ArrayList<Character>();
		
		for(int i=0;i<=pos11;i++)
		{
			l1.add(str.charAt(i));
		}
			
		populateList(l2,str,pos2);
		
		System.out.println("l1:");
		for(Character ch:l1)
		{
			System.out.print("	"+ch);
		}
		System.out.println("");
		System.out.println("l2:");
		for(Character ch:l2)
		{
			System.out.print("	"+ch);
		}
		System.out.println("");
		return l1.equals(l2);
	}
	public static void populateList(List<Character> l2,String str,int pos2)
	{
		if(pos2==str.length())
			return;
		populateList(l2,str,pos2+1);
		l2.add(str.charAt(pos2));
		return;
	}

}
