package pack6;

public class LinkedListUtil {

	/**
	    utility clas to define Nodes o a single linked list and doubly linked list.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class Node
	{
		int data;
		Node nxt;
		public Node(int data) {
			super();
			this.data = data;
			nxt=null;
		}
		
	}

	public static class Dnode
	{
		int data;
		Dnode nxt;
		Dnode prev;
		public Dnode(int data) {
			prev=null;
			this.data = data;
			nxt=null;
		}
		
	}

}
