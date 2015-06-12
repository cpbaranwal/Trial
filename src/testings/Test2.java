package testings;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;

public class Test2 {

	/**
	 
	 */
	
	String str= "chandan";
	public static void main(String[] args) {
		
		/*ExecutorService e1=Executors.newFixedThreadPool(10);
		Future f1=null;
		AtomicInteger a1=null;
		*/
		
		int x=-1;
		x=x>>32;
		boolean bool=x>0;
		System.out.println("x = "+x);
		
	}
	
	
	class Node
	{
		int data;
		Node nxt;
		
		public Node(int x)
		{
			this.data=x;
		}
	}
	
	class  MyStack
	{
		Node head;
		Node minNode;
		
		public MyStack()
		{
			head=null;
		}
		
		public boolean push(int n)
		{
			try{  Node tmp=new Node(n);
			if(head==null)
			{				
				head.nxt=null;
				minNode=new Node(n);
			}
			else
			{
				tmp.nxt=head;	
				if(n<=minNode.data)
				{
					Node tmp2=new Node(n);
					tmp2.nxt=minNode;
					minNode=tmp2;
				}
			}
			head=tmp;
			return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
		}
		
		public int pop() throws Exception
		{
			if(head==null)
				throw new Exception("No Number Remaining");
			
			Node tmp=head;
			if(tmp.data==minNode.data)
			{
				minNode=minNode.nxt;
			}
			head=head.nxt;
			return tmp.data;
		}
		
		public boolean isEmpty()
		{
			return (head==null);
		}
		
		public int getMin() throws Exception
		{
			if(minNode==null)
				throw new Exception("No Number Remaining");
			
			return minNode.data;
			
		}
		
		
		
		
	}
	
	/*public static void copyList(List src,List dest)
	{
		for(int i=0;i<src.size();i++)
		{
			dest.add(src.get(i));
		}
	}*/
	
	/*public static void unboundedMethod(List<?> l1,List<?> l2)
	{
		
		Integer x=(Integer)l1.get(0);
		l2.add(l1.get(0));
		//System.out.println(x*10);
	}*/

	
}
