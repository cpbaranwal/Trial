package pack6;

import pack6.TreeUtil.Tnode;

public class CheckIfTwoBinaryTreesAreMirror {

	/**
	     Given two binary trees,compare to check if they are mirror images of each other.
	   
	    			  6
                    /   \
                   2     8
                  /\     /\
                 1  4   7  9
                 
	   
	    			  6
                    /   \
                   8     2
                  /\     /\
                 9  7   4  1
	 */
	public static void main(String[] args) {

		Tnode root1= new Tnode(6);
		root1.l=new Tnode(2);
		root1.r=new Tnode(8);
		root1.l.l=new Tnode(1);
		root1.l.r=new Tnode(4);
		root1.r.l=new Tnode(7);
		root1.r.r=new Tnode(9);
		
		Tnode root2= new Tnode(6);
		root2.l=new Tnode(8);
		root2.r=new Tnode(2);
		root2.l.l=new Tnode(9);
		root2.l.r=new Tnode(7);
		root2.r.l=new Tnode(4);
		root2.r.r=new Tnode(1);
		
		System.out.println("result="+isMirrorImage(root1,root2));

	}

	private static boolean isMirrorImage(Tnode root1, Tnode root2) 
	{
		
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		System.out.println("root1.data="+root1.data+"    root2.data="+root2.data);
		if(root1.data!=root2.data)
			return false;
		
		return(isMirrorImage(root1.l,root2.r) && isMirrorImage(root1.r,root2.l));
		
	}

}
