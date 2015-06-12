package abceligopq;

public class RearrangeLinkedList {

	/**
		Link list contains positive and negative num, 
		rearrange the link list such that all the positive are on one side and all the negative on the other,
		maintaining the order of appearance.

	 */
	
	private static class Node
	{
		int data;
		Node nxt;
		public Node(int x)
		{
			data=x;
		}
	}
	
	public static void main(String[] args) {
		
			Node st=new Node(1);
			st.nxt=new Node(-22);
			st.nxt.nxt=new Node(-3);
			st.nxt.nxt.nxt=new Node(-4);
			st.nxt.nxt.nxt.nxt=new Node(-5);
			
			Node newSt=reverseList(st);
			while(newSt!=null)
			{
				System.out.println("");;
				System.out.print("  "+newSt.data);
				newSt=newSt.nxt;
			}
			
	}
	
	public static Node reverseList(Node st)
	{
		if(st==null || st.nxt==null)
			return st;
		
		Node neg=null;
		Node p=st;
		Node newSt=st;
		Node prev=null;
		while(p!=null )
		{  
			if(p.data<0)
			{
				if(neg==null)
					{  neg=p;  
					   newSt=neg;					  
					}
				else
				{
					neg.nxt=p;
					neg=neg.nxt;					
				}
				if(prev==null)
				{
					st=p.nxt;					
				}
				else
				{
					prev.nxt=p.nxt;
					
				}
				p=p.nxt;
				neg.nxt=null;
			}
			else
			{
			
			prev=p;
			p=p.nxt;
			}
						
		}
		if(neg!=null)
		{neg.nxt=st;}
		
		return newSt;
	}

}
