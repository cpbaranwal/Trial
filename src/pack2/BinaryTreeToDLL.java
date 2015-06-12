package pack2;

import pack2.DiameterOfBinaryTree.Node;

public class BinaryTreeToDLL {

	/**
	   				 N1
                    /   \
                 N2    N3
                /       /\
            N4          N5 N6
          /\           /\
       N7 N8         N9 N10
	 */
	
	static class Node{
		Node r=null;Node l=null;String data=null;;
		public Node(String x)
		{
			data=x;
		}
	}
	
	public static void main(String[] args) {
		Node root;
		root=new Node("N1");
		root.l=new Node("N2");
		root.l.l=new Node("N4");
		root.l.l.l=new Node("N7");
		root.l.l.r=new Node("N8");
		root.r=new Node("N3");
		root.r.r=new Node("N6");
		root.r.l=new Node("N5");
		root.r.l.l=new Node("N9");
		root.r.l.r=new Node("N10");
		
		System.out.println("linked list traversal:");
		root=convertToDLL(root);
		Node p=root;
		System.out.print(" "+p.data);p=p.r;
		while(p!=root)
		{
			System.out.print(" "+p.data);
			p=p.r;
		}
		
	}
	
	public static Node convertToDLL(Node st)
	{
		if(st==null)
			return null;
		Node left=st.l;
		Node right=st.r;
		st.l=st;
		st.r=st;
		left=convertToDLL(left);		
		left=join(left,st);
		right=convertToDLL(right);
		left=join(left,right);
		
		
		return left;		
	}
	
	public static Node join(Node n1,Node n2)
	{
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;
		
		Node p=n1;
		while(p.r!=n1)
		{p=p.r;		
		}
		p.r=n2;
		n1.l=n2.l;
		n2.l.r=n1;
		n2.l=p;
		return n1;
	}

}
