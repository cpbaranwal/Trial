package pack6;

import pack6.TreeUtil.Tnode;

public class LowestCommonAncestorInBST {

	/**
	     given a BST and two numbers,find LCA. assume both numbers exist.
	    			 6
                    / \
                   2    8
                  /\     /\
                 1  4   7  9
                    /\
                   3  5              
	 */
	public static void main(String[] args) {
		Tnode root= new Tnode(6);
		root.l=new Tnode(2);
		root.r=new Tnode(8);
		root.l.l=new Tnode(1);
		root.l.r=new Tnode(4);
		root.r.l=new Tnode(7);
		root.r.r=new Tnode(9);
		root.l.r.l=new Tnode(3);
		root.l.r.r=new Tnode(5);
		
		System.out.println("getLCA(root)= "+getLCA(root));
		
	}
	
	static int num1 = 5;
	static int num2 = 4;
	public static int getLCA(Tnode root)
	{
		if(num1>num2)  //preserving order num1<num2
		{
			num1 = num1^num2;
			num2 = num1^num2;
			num1 = num1^num2;
			System.out.println("num1="+num1+"   num2="+num2);
		}
		return getLCAhelper(root).data;
	}
	
	private static Tnode getLCAhelper(Tnode head)
	//Since its a BST, we dnt have to iterate through all the nodes,we can use checks to decide where to stop looking for numbers
	{
		if(head==null)     //although given number will exist
			return null;
		
		System.out.print("  "+head.data);
		if(head.data>=num1 && head.data<=num2)
			return head;
		
		if(head.data<num1)
			return getLCAhelper(head.r);
		else //if(head.data>num2)
			return getLCAhelper(head.l);

	}

}
