package abceligopq;

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
		
		Node p=reverse(st);
		while(p!=null)
		{
			System.out.print("  "+p.data);
			p=p.nxt;
		}
		
       
	}
	
	
	public static Node reverse(Node st)
	{
		if(st==null|| st.nxt==null)
			return st;
		
		Node curr=st;
		Node prev=null;
		
		while(curr!=null)
		{  System.out.println("Curr=="+curr.data);
			Node tmp=curr.nxt;
			curr.nxt=prev;
			prev=curr;
			curr=tmp;
		}
		return prev;
		
	}
	
	public static class Node
	
	{
		Node nxt;
		int data;
		public Node(int x)
		{
			data=x;
			nxt=null;
		}
	}

}
