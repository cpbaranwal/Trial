package temp;

import pack6.TreeUtil.Tnode;

public class InorderSuccessorInBinaryTree {

	/**
		
			
	    			 1
                    / \
                   2   3
                  /\    /\
                 4  5  6  7 
                /\
               8  9
               
     hint:
     struct node* inOrderSuccessor(struct node* root, struct node* x)
{
    if( x->right != NULL )
        return minValue(x->right);
 
    struct node *successor = NULL;
 
    while (root != NULL)
    {
        if (x->data < root->data)
        {
            successor = root;
            root = root->left;
        }
        else if (x->data > root->data)
            root = root->right;
        else
           break;
    }
    return successor;
}
            
	 */
	public static void main(String[] args)
	{

		Tnode root= new Tnode(1);
		root.l=new Tnode(2);
		root.r=new Tnode(3);
		root.l.l=new Tnode(4);
		root.l.r=new Tnode(5);
		root.r.l=new Tnode(6);
		root.r.r=new Tnode(7);
		root.l.l.l=new Tnode(8);
		root.l.l.r=new Tnode(9);
		
		Tnode node = root.l.l;
		Tnode inorderSuccessor = findInorderSuccessor(root,node);//LNR
		System.out.println("node.data:"+node.data+"    inorderSuccessor.data:"+inorderSuccessor.data);

	}
	
	
	static Tnode successor = null;
	private static Tnode findInorderSuccessor(Tnode root,Tnode node)
	{
		//TODO
		return null;
	}

	static class Tnode
	{
		Tnode l,r;
		int data;
		Tnode(int num)
		{
			data=num;
		}
	}

}
