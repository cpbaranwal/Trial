package temp;

public class DeleteGivenNodeInCircularLinkedList {

	/**
	 
	 */
	public static void main(String[] args)
	{
		Node head = new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next=head;
		Node p = head;
		System.out.print(p.data);
		p=p.next;
		while(p!=head)
		{
			System.out.print("  "+p.data);
			p=p.next;
		}	
		System.out.println();
		head = deleteNode(head.next.next.next.next);
		
	    p = head;
		System.out.print(p.data);
		p=p.next;
		while(p!=head)
		{
			System.out.print("  "+p.data);
			p=p.next;
		}	
		System.out.println();

	}
	
	private static Node deleteNode(Node node) 
	{
		if(node== null)
			throw new IllegalArgumentException("Null is not allowed");
		if(node.next == node)
			return null;
		
		Node node2= node.next;
		Node tmp= node2;
		while(tmp.next!=node)
		{
			tmp = tmp.next;
		}
		tmp.next = node2;
		
		return node2;
	}

	static class Node
	{
		Node next;
		int data;
		public Node(int data) {
			super();
			this.next = null;
			this.data = data;
		}
		
	}

}
