package temp;

import abceligopq.ReverseLinkedList.Node;

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node st=new Node(1);
		st.nxt=new Node(2);
		st.nxt.nxt=new Node(3);
		st.nxt.nxt.nxt=new Node(4);
		st.nxt.nxt.nxt.nxt=new Node(5);
		st.nxt.nxt.nxt.nxt.nxt=new Node(6);
		
		System.out.println("After:");
		Node p = getReverseLinkedList(st);
		while(p!=null)
		{
			System.out.print("  "+p.data);
			p=p.nxt;
		}

	}
	
	public static Node getReverseLinkedList(Node root)
	{
		Node p= root;
		if(p==null)
			throw new IllegalArgumentException("Null input");
		if(p.nxt==null)
			return p;
		
		Node q=null,r=p.nxt;
		while(p.nxt!=null)
		{
			r = p.nxt;
			p.nxt = q;
			q=p;
			p=r;	
		}
		r.nxt=q;
		
		
		return r;
	}
	
	private static class Node 
	{
		Node nxt;
		int data;
		
		public Node(int data)
		{
			this.data=data;
			nxt=null;
		}
	}

}
