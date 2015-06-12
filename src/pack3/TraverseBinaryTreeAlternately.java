package pack3;
import java.util.*;

public class TraverseBinaryTreeAlternately {

	/**
	     A
	     
	   B	C
	 
	 D	 E F	G
   
   H   I
   
   print in order :
   A
   CB
   DEFG
   IH
	  
	 */
	public static void main(String[] args) {
		
			Node rt=new Node('A');
			//rt.nodeList=new ArrayList<Node>();
			Node b=new Node('B');
			rt.nodeList.add(b);
			Node c=new Node('C');
			rt.nodeList.add(c);
			
			Node d=new Node('D');
			Node e=new Node('E');
			Node f=new Node('F');
			Node g=new Node('G');
			Node h=new Node('H');
			
			b.nodeList.add(d);
			b.nodeList.add(e);
			c.nodeList.add(f);
			c.nodeList.add(g);
			d.nodeList.add(h);
			
			Node i=new Node('I');
			d.nodeList.add(i);
			
			printElements(rt);
			
			
	}
	
	private static class Node 
	{
		List<Node> nodeList;
		char ch;
		public Node(char x)
		{
			ch=x;
			nodeList=new ArrayList<Node>();
		}
	}
	
	public static void printElements(Node rt)
	{
		if (rt==null)
			return;
		
		List<Node> l1=new ArrayList<Node>();
		List<Node> l2=new ArrayList<Node>();
		l1.add(rt);
		
		while(!l1.isEmpty() || !l2.isEmpty())
		{
			if(!l1.isEmpty())
			{
				while(!l1.isEmpty())
				{
					Node tmp=l1.remove(0);
					System.out.print(""+tmp.ch);
					List<Node> tList=tmp.nodeList;
					if(tList!=null && !tList.isEmpty())
					{
						l2.addAll(tList);
					}
				}
				System.out.println((""));
			}
			
			
			if((!l2.isEmpty()))
			{
				while(!l2.isEmpty())
				{
					Node tmp=l2.remove(l2.size()-1);
					System.out.print(""+tmp.ch);
					List<Node> tList=tmp.nodeList;
					if(tList!=null)
					{
						while(!tList.isEmpty()){
							l1.add(tList.remove(tList.size()-1));
						}
					}
				}
				List<Node> l3=new ArrayList<Node>();
				while(!l1.isEmpty())
				{
					l3.add(l1.remove(l1.size()-1));
				}
				l1=l3;
				System.out.println((""));
			}
			
		}
		
		
	}

}
