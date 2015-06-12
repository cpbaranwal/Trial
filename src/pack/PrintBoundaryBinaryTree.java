package pack;

public class PrintBoundaryBinaryTree {

	/**
	 *    Print all edge nodes of a complete binary tree anti-clockwise.
    That is all the left most nodes starting at root, then the leaves left to right and finally all the rightmost nodes.
    In other words, print the boundary of the tree.
    
     _30_
   /    \   
  10    20
 /     /  \
50    45  35

The correct solution should print 30, 10, 50, 45, 35, 20.

    Variant: Print the same for a tree that is not complete.
    
            ______30______
       /              \
    __20__          __40__
   /      \        /      \
  10      25      35      50
 /  \       \            /
 5  15      28          41

The correct solution should print 30, 20, 10, 5, 15, 28, 35, 41, 50, 40.
    
	 */
	public static void main(String[] args) {
		
		Node root=new Node(30);
		root.l = new Node(20);
		root.l.l=new Node(10);
		root.l.l.l = new Node(5);
		root.l.l.r = new Node(15);
		root.l.r = new Node(25);
		root.l.r.r = new Node(28);
		
		root.r = new Node(40);
		root.r.l = new Node(35);
		root.r.r = new Node(50);
		root.r.r.l = new Node(41);
		
		
		printBoundary(root);

	}
	public static void printBoundary(Node root)
	{
		if(root==null)
		{System.out.println("nothing to print");
			return;
		}
		printLeftPart(root);
		printLeafNodes(root);
		printRightNodes(root.r);
	}
	
	public static void printLeftPart(Node st)
	{
		if(st==null || st.l==null)
		return;
		System.out.print("  "+st.data);
		printLeftPart(st.l);
		return;
	}
	public static void printLeafNodes(Node st)
	{
		if(st==null)
			return;
		if(st.l==null && st.r==null)
		{
			System.out.print("  "+st.data);
			return;
		}
		printLeafNodes( st.l);
		printLeafNodes( st.r);
	}
	public static void printRightNodes(Node st)
	{
		if(st==null )
			return;			
			printRightNodes(st.r);
			System.out.print("  "+st.data);
			return;
	}
}



class Node
{
	int data;
	Node l,r;
	
	public Node(int x)
	{l=null;r=null;data=x;}
}
