package pack2;
import java.util.*;

public class AnagramList {

	/**
	A file contains set of anagram. print the output as list of similar word one by one.
e.g. plates stop staple pots meat not pot team
Output:-
1. Plates, staple
2. pots, stop .... etc
	 */
	public static void main(String[] args) {
		String strInpt="plates stop staple pots meat not pot team";
		String strArr[]=strInpt.split(" ");
		/*for(int i=0;i<strArr.length;i++)
		{
			System.out.println("strArr[i]="+strArr[i]);
		}*/

		
		printListOfAnagrams( strArr);

	}
	public static void printListOfAnagrams(String[] strArr)
	{
		Map<String,TreeSet<String>>map=new LinkedHashMap<String,TreeSet<String>>();
		for(int i=0;i<strArr.length;i++)
		{
			char[] charArr=strArr[i].toCharArray();
			Arrays.sort(charArr);
			String str=new String(charArr);
			
			TreeSet<String> set=map.get(str);
			if(set==null)
				set=new TreeSet<String>();
			set.add(strArr[i]);
			map.put(str, set);
		}
		
		System.out.println("OUTPUT:");
		//retrieval
		for(String str:map.keySet())
		{
			for(String s1:map.get(str))
			{
				System.out.print("  "+s1);
			}
		}
	}

}
