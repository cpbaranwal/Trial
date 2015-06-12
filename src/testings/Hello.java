package testings;

import java.awt.Point;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Hello {

	//private final volatile int num=0;
	private static int cnt=0;
	public Hello() {
		// TODO Auto-generated constructor stub
		cnt++;
		System.out.println("cnt=="+cnt);
	}

	/**
	 * @param args
	 */
	public static String dummy="someString";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello i am chandan ");
		List<Integer> list = new ArrayList();
		//list
		//Collections.unmodifiableList(list);
	//	List<? extends Object> list = ArrayList<String>();
	//	List<? extends Integer> list = ArrayList<Number>();
		
		
		int x=-11100;
		int y=x>>31;
		System.out.println(x);
		System.out.println(y);
		System.out.println(x*y);
		int n=-10;
		System.out.println((n^(n>>31)));
		System.out.println( (n>>31));
		n = (n^(n>>31)) - (n>>31);
		System.out.println(n);
		
		
		/*Hello[] arr= new Hello[10];
		int len=arr.length;*/
		//arr.clone()
		//Serializable
		//Thread
		//Collections.sort
	//	arr[0]=new Hello();
	//	arr[1]=new Hello();
		//Comparable
		//Comparator
		
		
		/*int a=2;int b=2;
		System.out.print(" "+(~b));
		Math.random();
		
		LinkedList l1=new LinkedList();*/
		
		/*List<Integer> list1=new ArrayList<Integer>();
		Point p;*/
		//Observable obv;
		//Observer obs;
		//IllegalArgumentException
		//List l1=new ArrayList();
		/*HashMap<Integer,String> hm=new HashMap<Integer,String>();
		hm.put(1,"one");hm.put(2,"two");hm.put(3,"three");hm.put(4,"four");hm.put(5,"five");
		
		Set<Integer> set= hm.keySet();
		//hm.remove(3);
		hm.put(6,"six");
		
		for(int num:set){
			System.out.println("num: "+num);
		}
		*/
		
		//ConcurrentHashMap map=null;
		
		/*String str1="Hello";
				String str2="He";
				String str3=str2+"llo";
				
				char[] chArr={'1','2','3','4','5'};
				String temp=Arrays.toString(chArr);
				System.out.println("temp=="+temp);
				
				String s1="hellooolloollooo";
				s1=s1.replaceAll("oo", "pp");
				s1=s1.replace('o','p');
				System.out.println("s1==="+s1);
				*/

			//	System.out.println((str1==str3));
				
				/*Queue q1= new LinkedList();//interface based on collection
				Stack s1=new Stack();//class based on Vector
				System.gc();
				System.out.println(Runtime.getRuntime().freeMemory());
				List<Integer> l1=new ArrayList<Integer>(10);
				l1.add(1);l1.add(1);l1.add(1);l1.add(1);l1.add(1);
				*/
				//int abc=new Integer(10);
				//System.out.println(Runtime.getRuntime().freeMemory());
				//Long abcd=new Long(10);
				//System.out.println(Runtime.getRuntime().freeMemory());
			
			BlockingQueue q1=new ArrayBlockingQueue(5);
			//Thread
			//Integer.MAX_VALUE
				
		

	}

}

//picture. *  https://docs.google.com/leaf?id=0Byw9MixQ2sK7NTllZjJlNTEtNmRmNC00M2EyLTgzYzUtYjU3NTAzZWI3Mjgx&hl=en_US

