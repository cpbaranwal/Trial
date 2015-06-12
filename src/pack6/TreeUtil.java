package pack6;

/*
  utility class for tree
	   				 1
                    / \
                   2   3
                  /\    /\
                 4  5  6  7 
                /\
               8  9
 */

public class TreeUtil {

public static void main(String args[])
{
	System.out.println("Tree:  ");
	Tnode root= new Tnode(1);
	root.l=new Tnode(2);
	root.r=new Tnode(3);
	root.l.l=new Tnode(4);
	root.l.r=new Tnode(5);
	root.r.l=new Tnode(6);
	root.r.r=new Tnode(7);
	root.l.l.l=new Tnode(8);
	root.l.l.r=new Tnode(9);
	
	inorderTraversal(root);//LNR
}

public static class Tnode
{
	public int data;
	public Tnode l,r;
	public Tnode(int data) {
		super();
		this.data = data;
		l=null; r=null;
	}
	
}

public static void inorderTraversal(Tnode root)//LNR
{
	if(root==null)
		return;
	inorderTraversal(root.l);
	System.out.print("  "+root.data);
	inorderTraversal(root.r);
}



}