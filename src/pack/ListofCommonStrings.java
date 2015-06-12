package pack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListofCommonStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> l1=new ArrayList<String>();
		l1.add("chandan");
		l1.add("priya");
		l1.add("mukesh");
		l1.add("mummy");
		l1.add("papa");
		List<String> l2=new ArrayList<String>();
		l2.add("bhaiya");
		l2.add("didi");
		l2.add("priya");
		l2.add("mummy");
		l2.add("chandan");
		
		List <String> l3= new ArrayList<String>();
		Set<String> set=new HashSet<String>();
		if(l1.size()<=l2.size())
		{
			set.addAll(l1);
			System.out.println("set.size()"+set.size());
			for(String str:l2)
			{
				if(set.remove(str)){
					l3.add(str);
				}
			}
		}
		else{
			//vice-versa
		}
		
		for(String str:l3)
		{
			System.out.println(str);
			
		}
	}
		
	}


