package pack3;

public class SortCircularAndLinearLinkedList {

	/**
	You have a sorted circular linked list and a sorted linear linked list.
	Write a program to merge these two arrays and create a new sorted circular linked list
	 */
	public static void main(String[] args) {
		
		

	}
	
	
	// i can insert the whole linear linked list in the circular linked list or the other way around
	// well it will depend whose length is larger. i will be inserting in circular linked list
	
	
	public static Node getSortedCircularList(Node lList,Node cList) 
	{
		if(lList==null)
			return cList;
		
		Node cFst=cList;
		Node cLst=findLastInCircularList(cList,cFst);
		
		cFst=insertInCircularList(cFst,cLst,lList);
		
		return cList;
	}
	
	private static Node insertInCircularList(Node cFst, Node cLst, Node lList)
	{
		while(lList!=null)
		{
			Node curr=lList;
			lList=lList.nxt;
			
			if(curr.data<cFst.data)
			{// insert at start
				if(cFst==cLst)
				{
					cFst.nxt=curr;
					curr.nxt=cFst;
					cLst=cFst;
					cFst=curr;
				}
				else
				{
					curr.nxt=cFst;
					cLst.nxt=curr;
					cFst=curr;
				}
			}
			else if(curr.data>cLst.data)
			{
				if(cFst==cLst)
				{
					cFst.nxt=curr;
					curr.nxt=cFst;
					cLst=curr;
				}
				else
				{
					cLst.nxt=curr;
					curr.nxt=cFst;
					cLst=curr;
					
				}
			}
			else
			{   
				Node prev=cFst; Node tmp=cFst.nxt;
				while(curr.data>tmp.data)
				{
					prev=tmp;
					tmp=tmp.nxt;
				}
				prev.nxt=curr;
				curr.nxt=tmp;
			}
				
		}
		
		return cFst;
	}
	
	
	private static Node findLastInCircularList(Node cList, Node cFst)
	{
		Node cLst=cFst;
		while(cLst.nxt!=cFst)
			cLst=cLst.nxt;
		
		return cLst;
	}
	
	private static class Node
	{
		int data;
		Node nxt;
		
		public Node(Node nxt)
		{
			this.nxt=nxt;
		}
	}

}


