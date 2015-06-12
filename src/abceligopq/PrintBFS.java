package abceligopq;

import java.util.*;

public class PrintBFS {

	/**
	    level order print
	 */
	public static void main(String[] args) {
		
		Tree tr=new Tree(1);
		tr.l=new Tree(2);
		tr.r=new Tree(3);
		tr.l.l=new Tree(4);
		tr.l.r=new Tree(5);
		tr.r.l=new Tree(6);
		tr.r.r=new Tree(7);
		tr.l.l.l=new Tree(8);
		tr.l.l.r=new Tree(9);
		
		printLevelByLevel(tr);
		
	}
	
	static List<Tree> lst1=new ArrayList<Tree>(); 
	static List<Tree> lst2=new ArrayList<Tree>();
	public static class Tree
	{
		int data;
		Tree l,r;
		public Tree(int x)
		{
			data=x;
		}
	}
	
	public static void printLevelByLevel(Tree root)
	{
		if(root==null)
			return;
		
		lst1.add(root);
		while(!lst1.isEmpty() || !lst2.isEmpty())
		{  System.out.println("=>");
			if(!lst1.isEmpty())
			{while(!lst1.isEmpty())
			{
				for(int i=0;i<lst1.size();i++)
				{
					Tree tmp=lst1.remove(i);
					if(tmp.l!=null)
						lst2.add(tmp.l);
					if(tmp.r!=null)
						lst2.add(tmp.r);
					System.out.println("  "+tmp.data);
				}
			}
			}
			else
			{
				while(!lst2.isEmpty())
				{
					for(int i=0;i<lst2.size();i++)
					{
						Tree tmp=lst2.remove(i);
						if(tmp.l!=null)
							lst1.add(tmp.l);
						if(tmp.r!=null)
							lst1.add(tmp.r);
						System.out.println("  "+tmp.data);
					}
				}
			}
		}
	}

}
