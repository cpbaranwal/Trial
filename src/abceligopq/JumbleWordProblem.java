package abceligopq;

import java.util.*;

public class JumbleWordProblem {

	/**
	 
		Design a data structure to solve the scramble/jumble word problem that comes in the newspaper.
I/p: list of letters
O/p: all the valid dictionary words
eg: ogd
O/p : god, dog.
You solution should be performance oriented. Design the dictionary to store the valid words as well. 

	 */
	public static void main(String[] args) {
		
		String str="odg";
		
		List<String> lst= getWordsList(str);
		Trie tr=new Trie();
		for(String s:lst)
		{
			System.out.println(s);
			insertWord(s, tr);
		}
		
			
			
		
	}
	
	public static class Trie
	{
		char ch;
		Trie arr[];
		boolean isAWord=false;
		
		public Trie()
		{
			arr=new Trie[26];
		}
		public Trie(char ch)
		{this.ch=ch;
			arr=new Trie[26];
		}
	}
	
	public static void insertWord(String str,Trie tr)
	{
		int i=0;
		for( i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			int y=ch-'a';
			if(tr.arr[y]==null){
				tr.arr[y]=new Trie(ch);
				tr=tr.arr[y];
			}
			
			
		}
		if(i==str.length())
		{
			tr.isAWord=true;
			System.out.println("New Word inserted");
		}
	}
	
	public static List<String> getWordsList(String str)
	{
		List<String> lst=new ArrayList<String>();
		permutation( str.toCharArray(),0,str.length()-1,lst);
		
		return lst;
		
	}
	
	public static void permutation(char[] arr,int p,int q, List<String> lst){
		
		if(p==q)
		{  String res=new String(arr);
			if(isValid(res))
			{
				lst.add(res);
			}
		}
		else
		{
			for(int i=p;i<=q;i++)
			{
				char tmp=arr[p];
				arr[p]=arr[i];
				arr[i]=tmp;
				permutation(arr.clone(),p+1,q,lst);
				arr[i]=arr[p];
				arr[p]=tmp;
			}
		}
	}
	
	public static boolean isValid(String str)
	{
		// some logic
		return true;
	}

}
