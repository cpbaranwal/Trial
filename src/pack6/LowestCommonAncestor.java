package pack6;

import pack6.TreeUtil.Tnode;

public class LowestCommonAncestor {

	/**
    given a Binary Tree (not BST) and two numbers,find LCA. assume both numbers exist.
   			    1
               / \
              2    3
             /\     /\
            4  5   6  7
           /    /\
          8   9   10              
*/
public static void main(String[] args) {
	Tnode root= new Tnode(1);
	root.l=new Tnode(2);
	root.r=new Tnode(3);
	root.l.l=new Tnode(4);
	root.l.r=new Tnode(5);
	root.l.l.l=new Tnode(8);
	root.l.r.l=new Tnode(9);
	root.l.r.r=new Tnode(10);
	root.r.l=new Tnode(6);
	root.r.r=new Tnode(7);
	
	System.out.println("getLCA= "+getLCA(root));
	
}

static int num1=10;
static int num2=5;
public static int getLCA(Tnode root)
{
	if(root==null || (root.l==null && root.r==null))
		return -1;
	
	return getLCAhelper(root).data;
	
}
private static Tnode getLCAhelper(Tnode head)
{
	if(head==null)
		return null;
	
	if(head.data==num1 || head.data==num2)
		return head;
	
	Tnode left = getLCAhelper(head.l);
	Tnode right = getLCAhelper(head.r);
	if(left!=null && right!=null)
		return head;
	
	if(left!=null)
		return left;
	else
		return right;
}

}
