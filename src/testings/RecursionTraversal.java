package testings;

public class RecursionTraversal {

	static Node l3=null;
	public static void main(String[] args) {
		
		Node l1=new Node(3);//3456
		l1.nxt=new Node(4);
		l1.nxt.nxt=new Node(5);
		l1.nxt.nxt.nxt=new Node(6);
		
		
		Node l2=new Node(4);//400
		l2.nxt=new Node(0);
		l2.nxt.nxt=new Node(0);
		
		
		try{
			Node p=getResult(l1,l2);
			while(p!=null)
			{
				System.out.print(p.data);
				p=p.nxt;
			}				
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}

	public static Node getResult(Node l1,Node l2) throws Exception
	{
		
		if(l1==null && l2==null)
		throw new Exception("Invalid Input");		
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		Node p1=l1; int len1=0;
		Node p2=l2; int len2=0;
		
		while(p1!=null)
		{
			len1++;
			p1=p1.nxt;
		}
		p1=l1;
		while(p2!=null)
		{
			len2++;
			p2=p2.nxt;
		}
		p2=l2;
		
		Node tmp=null;
		int diff=0;
		//System.out.println(len1+"  "+len2);
		if(len1>len2)
		{
			tmp=l1;
			diff=len1-len2;
			for(int i=0;i<diff;i++)
				p1=p1.nxt;
		}
		else if(len2>len1)
		{
			tmp=l2;
			diff=len2=len1;
			for(int i=0;i<diff;i++)
				p2=p2.nxt;
		}
		
		int carry=getAddedNode(p1,p2);
		if(tmp!=null)// i.e. diff>0
		{
			addRemainingNodes(tmp,diff,carry);
		}
		
		return l3;
	}
	
	static int addRemainingNodes(Node tmp,int diff,int carr)
	{
		int carry=carr;
		if(diff>1)
			carry=addRemainingNodes(tmp.nxt,diff-1,carr);
		int x=tmp.data+carry;
		Node newNode=new Node(x%10);
		newNode.nxt=l3;
		l3=newNode;
		return x/10;
	}
	
	static int getAddedNode(Node p1,Node p2)
	{	if(p1==null)
		return 0;
	int carr=0;
	if(p1.nxt!=null){
		carr=getAddedNode( p1.nxt, p2.nxt);			
	}
	int x=p1.data+p2.data+carr;	
	//System.out.println("x="+x);
	Node tmp=new Node(x%10);
	tmp.nxt=RecursionTraversal.l3;
	RecursionTraversal.l3=tmp;
	carr=x/10;	
		
	return carr;
	}
	
	static class Node
	{
		int data;
		Node nxt;
		public Node(int x)
		{
			data=x;
			nxt=null;
			
		}
	}

}
