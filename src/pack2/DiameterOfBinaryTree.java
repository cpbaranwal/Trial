package pack2;

public class DiameterOfBinaryTree {

	/**
	 Find the(two) nodes which are at maximum distance in a binary tree?
	 This is not finding the distance but the nodes which are farthest.
	  				  N1
                    /   \
                 N2    N3
                /       /\
            N4          N5 N6
          /\           /\
       N7 N8         N9 N10
       
       N7-N9 is farthest.
	 */
	
	static Node n1=new Node("s1");
	static Node n2=new Node("s2");
	public static void main(String[] args) {
		
		Node r;
		r=new Node("N1");
		r.left=new Node("N2");
		r.left.left=new Node("N4");
		r.left.left.left=new Node("N7");
		r.left.left.right=new Node("N8");
		r.right=new Node("N3");
		r.right.right=new Node("N6");
		r.right.left=new Node("N5");
		r.right.left.left=new Node("N9");
		r.right.left.right=new Node("N10");
		
		
		System.out.println("diameter is  :  "+getDiameter(r));
		System.out.println(" 1st Node:"+n1.data);
		System.out.println(" 2nd Node:"+n2.data);
		
		

	}
	
	public static int getDiameter(Node r)
	{
		if(r==null)
			return 0;
		
		int lenLeft=getDiameter(r.left);
		int lenRite=getDiameter(r.right);
		int heightLeft= getHeight(r.left);
		int heightRight=getHeight(r.right);
		int lenCurrent=heightLeft+1+heightRight;
		
		//if(lenCurrent>heightLeft && lenCurrent>heightRight)
		{
			setNode(r.left,n1,heightLeft-1);
			setNode(r.right,n2,heightRight-1);
			return lenCurrent;
		}
	//	else if(heightLeft>lenCurrent  && heightLeft>heightRight)
		//	return heightLeft;
		//else return heightRight;
	}
	
	public static void setNode(Node s,Node d, int num)
	{
		if(s==null)
			return;
		if(num==0)
			d=s;
		else{
			setNode(s.left,d,num-1);
			setNode(s.right,d,num-1);
		}
	}
	
	public static int getHeight(Node node)
	{
		if(node==null)
			return 0;
		
		int cntL=getHeight(node.left);
		int cntR=getHeight(node.right);
		if(cntL>cntR)
			return (1+cntL);
		else 
			return (1+cntR);
	}
	
	static class Node{
		String data;
		Node left;
		Node right;
		public Node(String str)
		{
			data=str;left=null;right=null;
		}
	}

}
