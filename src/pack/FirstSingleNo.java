package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class FirstSingleNo {

	
	public static void main(String[] args) {
		
		
		LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();
		try {
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("enter: ");
		    String str = in.readLine();
		    while (str != null && !str.isEmpty()) {
		    			        
		        int num=Integer.parseInt(str);
		        int cnt=(map.get(num)!=null)?map.get(num):0;
		        map.put(num,cnt+1);
		        str=in.readLine();
		           		    }
		    System.out.println("ends..... ");
		    
		   for(int num:map.keySet())
		    {
		    	System.out.println("key:  "+num+"    count: "+map.get(num));  // the count with value=1 is the number  :)
		    }
		    
		    
		} catch (Exception e) {
			System.out.println("Exception:  "+e.getMessage());
		}
	}

}


