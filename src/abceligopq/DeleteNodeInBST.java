package abceligopq;

public class DeleteNodeInBST {

	/**
	    Delete a Node with a Given value in a given Binary Search Tree
	 */
	public static void main(String[] args) {
		

	}
	
	public static Tree deleteNode(Tree rt,int x){
		Tree par=null;
		par=findParentNodeIfExists( rt, x);
		System.out.println("Parent data:"+ par.data);
		if(par==null && rt.data==x)
		{ return deleteRoot( rt,x);
		
		}
		else if(par!=null)
		{
		//	return deleteNode(x,par);
		}
		return rt;
		
	}
	
	public static Tree deleteRoot(Tree rt,int x)
	{
		if(rt.l==null && rt.r==null)
			return null;
		if(rt.r!=null)
		{
			int tmp=rt.data;
			rt.r.data=rt.data;
			rt.data=tmp;
			
		}
		else
		{
			rt.data=rt.l.data;
			rt.l.data=x;
			
		}
		//deleteNode(x,rt);
		return rt;
	}
	
	/*public static boolean deleteNode(int x, Tree par)
	{
		Tree ch=null;
		if(par.l.data==x)
			{ch=par.l;
				if(ch.r==null)
				{
					par.l=ch.l;
					return true;
				}
				else
				{
					par=ch;
					Tree tmp=ch.r;
					while(tmp.l!=null)
					{
						par=tmp;tmp=tmp.l;
					}
					ch.data=tmp.data;
					tmp.data=x;
					deleteNode(x,par);
				}
			
			}
		else
			{ch=par.r;
			
			}
		
		
	}*/
	
	public static Tree findParentNodeIfExists(Tree rt,int x)
	{
		if(rt.data==x)
			return null;
		Tree par=rt;
		Tree p=rt.l;
		if(x>par.data)			
		p=rt;
		
		while(p!=null && p.data!=x )
		{
			par=p;
			if(x>p.data)
				p=p.r;
			else p=p.l;
		}
		if(p==null)
			return null;
		else return par;
	}
	
	/*public static boolean deleteNode(int x,Tree par)
	{
		if(rt==null)
			return false;
		
		
		if(rt.data==x)
		{
			if(par==null)  // root element contains data
			{
			if(rt.r==null && rt.l==null)
				{
					rt=null;
					return true;
				}
			if(rt.r!=null)
			{
				rt.data=rt.r.data;
				rt.r.data=x;
				par=rt;
				rt=rt.r;
			}
			else
			{
				rt.data=rt.l.data;
				rt.l.data=x;
				par=rt;
				rt=rt.l;
			}
				
			}
			else{
				if(par.l==rt)
				{
					
				}
			}
			
		}
		
		return false;
	}*/
	
	private static class Tree
	{
		int data; Tree l,r;
		public Tree(int x)
		{
			data=x;
		}
		
	}

}
