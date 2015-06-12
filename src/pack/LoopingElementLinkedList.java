package pack;

public class LoopingElementLinkedList {

	/**
	 * @param args
	 */
	
	private static class Node{
		private int data;
		private Node next;
		
		public Node(int data,Node next)
		{
			this.data=data;
			this.next=next;
		}
		public Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	static int noElements=0;
	public static void main(String[] args) {
		
		System.out.println("main");
		Node head=new Node(1);
		Node p=head;
		p.next=new Node(2);
		p=p.next; p.next=new Node(3);
		p=p.next; p.next=new Node(4);
		p=p.next; p.next=new Node(5);
		p=p.next; p.next=new Node(6);
		p=p.next; p.next=new Node(7);
		p=p.next; p.next=new Node(8);
		p=p.next; p.next=new Node(9);
		p=p.next; p.next=head.next.next.next;
		
		System.out.println("Elements:");
		p=head;
		for(int i=0;i<10;i++)
		{
			System.out.print("  "+p.data);
			p=p.next;
		}
		System.out.println();	
		
		
		boolean bool=LoopingElementLinkedList.isALoop(head, 0);
		System.out.println("bool=="+bool);
		System.out.println("noElements=="+noElements);
		
		if(bool)
		{
			System.out.println("loopNode=="+getLoopNode(head,noElements).data);
		}
	}
	
	static Node getLoopNode(Node head,int noLoopElements)
	{
		if(head==null)
			return null;
		Node p1=head; Node p2=head;
		while(noLoopElements>0)
		{
			if (p2.next==null)
				return null;
			p2=p2.next;
			noLoopElements--;
		}
		
		while(true)
		{
			if(p2.next==null)
				return null;
			if(p2.next==p1.next)
				return p2.next;
			p2=p2.next;
			p1=p1.next;
		}
		
		
		
	}
	
	static boolean isALoop(Node head,int noOfLoopElements)
	{
		if (head==null || head.next==null||head.next.next==null)
			return false;
		
		
		Node slow=head;
		Node fast=head;
		while(true)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow.data==fast.data)
			{
				noOfLoopElements=1;
				fast=fast.next;
				while(slow.data!=fast.data)
				{
					fast=fast.next;
					noOfLoopElements++;
				}
				System.out.println("noOfLoopElements=="+noOfLoopElements);
				noElements=noOfLoopElements;
				return true;
			}
			else if(fast.next==null || fast.next.next==null)
				return false;
		}
		
		//return false;
	}
	

}
