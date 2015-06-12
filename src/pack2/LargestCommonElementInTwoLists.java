package pack2;
import java.util.*;

public class LargestCommonElementInTwoLists {

	/**
	 There are two unsorted lists containing integers.
	  Provide a solution to find the largest common integer in both lists
	   (findCommonLargest(List<Integer> list1, List<Integer> list2)). 
	   You can use additional data structures if needed but utility methods
	    from java collections are not allowed. 
	    There are many solutions possible for this problem; 
	    please provide the most efficient solution you can come up
	     with and provide its running time in Big O notation. *
	 */
	public static void main(String[] args) {
		List<Integer> l1= new ArrayList<Integer>();
		List<Integer> l2= new ArrayList<Integer>();
		l1.add(10);l1.add(2);l1.add(15);l1.add(16);l1.add(10);l1.add(19);l1.add(12);
		
		l2.add(10);l2.add(15);l2.add(19);l2.add(16);
		try {
			getLargest(l1,l2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public static void getLargest(List<Integer> l1, List<Integer> l2) throws Exception   // time complexity O(N), space complexity O(N)
	{
		if(l1== null || l1.isEmpty()|| l2==null || l2.isEmpty())
		{ throw new Exception("Invalid input!!");
		}
		
		int smallstSize=l1.size()<l2.size()?l1.size():l2.size();
		Map<Integer,Integer> map=new LinkedHashMap<Integer,Integer>(smallstSize);
		
		
		for(Integer num:l1)
		{
			if(map.get(num)==null)
				map.put(num, 1);
		}
		for(Integer num:l2)
		{
			if(map.get(num)!=null)
				map.put(num, 2);
		}
		
		if(map.size()==0)
		{
			System.out.println("No common element");
			return;
		}
		// finding greatest number by iterating on linkedhashmap which ensures fast iteration.....O(N) where N=smallstSize
		int res=0;
		for(Integer num:map.keySet())
		{
			if(map.get(num)==2 && num>res)
			{
				res=num;
			}
		}
		
		System.out.println("Largest number is:  "+res);
		return;
		

}
}
