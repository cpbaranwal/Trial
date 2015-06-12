package pack6;
import pack6.LinkedListUtil.Dnode;
//import pack6.TreeUtil.Tnode;;
import pack6.TreeUtil.Tnode;

public class DLLtoBinaryTree {

	/**
	    program to convert sorted DLL to Binary search Tree
	    note - the head node must be static as it has to be UPDATED EVERYTIME ON GLOBAL BASIS WHILE IT IS removed while forming tree........
	    ........which is based upon bottom up approach in same fashion as inorder traversal
	    
	 */
	
	static Dnode head = null;
	public static void main(String[] args) {
		
		 head = new Dnode(1);
		Dnode p2 = new Dnode(2);
		Dnode p3 = new Dnode(3);
		Dnode p4 = new Dnode(4);
		Dnode p5 = new Dnode(5);
		head.prev=null; head.nxt=p2;
		p2.prev=head;  p2.nxt=p3;
		p3.prev=p2;  p3.nxt=p4;
		p4.prev=p3;  p4.nxt=p5;
		p5.prev=p4; p5.nxt=null;
		
		
		
		Dnode root = getTreeFromDLL();
		System.out.println("root.data= "+root.data);
		inorderTraversal(root);
		
	}
	
	
	
	private static Dnode getTreeFromDLL() //bottom up approach
	{
		if(head==null || head.nxt==null)
			return head;
		int numNodes =0;
		Dnode tmp=head;
		while(tmp!=null)//determining number of nodes
		{
			//System.out.print("   "+tmp.data);
			numNodes++;
			tmp =tmp.nxt;
		}
		System.out.println();
		return getTreeFromDLLHelper(0,numNodes-1);
	}



	private static Dnode getTreeFromDLLHelper( int start, int last) 
	{
		if(start>last || head==null)
			return null;
		//1,2,3,4,5
		
		int mid = (start+last)/2;
		
		Dnode leftChild = getTreeFromDLLHelper(start,mid-1);
		Dnode currentNode = head;
		System.out.println("currentNode = "+currentNode.data+"   mid="+mid+"   start="+start+"     last="+last);
		currentNode.prev = leftChild;
		head = head.nxt;//tricky part
		Dnode rightChild = getTreeFromDLLHelper(mid+1,last);
		currentNode.nxt =  rightChild;
		
		return currentNode;
		
		
	}



	/*
	static int count=0;
	public static Dnode getTreeFromDLL(Dnode head)
	{//count++;
		if(head==null || head.nxt==null)
			return head;
		
		//System.out.println();
		Dnode tmp=head;
		while(tmp!=null)
		{
			System.out.print("  "+tmp.data);
			tmp=tmp.nxt;
		}
		System.out.println();
		
		Dnode mid = findmidNode(head);
		if(mid.prev!=null)
			mid.prev.nxt=null;
		
		if(mid.nxt!=null)
			mid.nxt.prev=null;
		
		Dnode q=mid.nxt;
		mid.nxt=null;
		
		System.out.println("mid.data="+mid.data);
		//if(count>=7)
			//System.exit(0);
		mid.prev = getTreeFromDLL(head);
		mid.nxt = getTreeFromDLL(q);
		return mid;
		
		
	}
	
	private static Dnode findmidNode(Dnode head) {
		Dnode fast=head;
		Dnode slow = head;
		while(fast.nxt!=null && fast.nxt.nxt!=null)
		{
			slow=slow.nxt;
			fast=fast.nxt.nxt;
		}
		return slow;
	}


	/*
	
	public static Dnode getTreeFromDLL(Dnode head)
	{
		if(head==null || head.nxt==null)
			return head;
		
		Dnode last=head;
		while(last.nxt!=null)
			last=last.nxt;
		
		
		return getTreeFromDLLHelper(head, last);
		
	}

	public static Dnode getTreeFromDLLHelper(Dnode head,Dnode last)
	{
		if(head==null )
			return head;
		if(head==last)
		{
			head.prev=null;
			head.nxt=null;
			return head;
		}
		
		Dnode midNode = findMidDnode( head,last);
		//System.out.println("   head.data= "+head.data+"   last.data= "+last.data);
		if(midNode==null)
			return null;
		System.out.println("   head.data= "+head.data+"   midNode.data= "+midNode.data+"   last.data= "+last.data);
		if(midNode.prev!=null)
			midNode.prev.nxt=null;
		if(midNode.nxt!=null)
			midNode.nxt.prev=null;
		midNode.prev  = getTreeFromDLLHelper(head, midNode.prev);
		midNode.nxt   = getTreeFromDLLHelper(midNode.nxt, last);
		return midNode;
	}
	private static Dnode findMidDnode(Dnode head,Dnode last) 
	{
		Dnode q=last;//1,2,3,4
		Dnode p=head;
		if(head==null || last==null)
			return null;
		if(p==q)
			return p;
		while(p!=null && q!=null && p!=q  && p.nxt!=q)
		{
			p=p.nxt;
			q=q.prev;
		}
		
		return p;
	}
	
	*/
	private static void inorderTraversal(Dnode root)//LNR
	{
		if(root==null)
			return;
		inorderTraversal(root.prev);
		System.out.print("  "+root.data);
		inorderTraversal(root.nxt);
	}

}
