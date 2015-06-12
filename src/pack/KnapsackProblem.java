package pack;

public class KnapsackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

     

	}
	
	public static int knapsackWidoutDP(int W,int wt[],int val[],int n)  //O(2^n)
	{
		if(W==0 || n==0)
			return 0;
		
		if(W>=wt[n-1])
		{
			return (val[n-1]+knapsackWidoutDP( W-wt[n-1],wt,val,n)>knapsackWidoutDP(W,wt,val,n-1)?val[n-1]+knapsackWidoutDP( W-wt[n-1],wt,val,n):knapsackWidoutDP(W,wt,val,n-1));
		}else
			return knapsackWidoutDP(W,wt,val,n-1);
		
		
	}
	
	public static int knapsackWidDP(int W,int wt[],int val[],int n) // O(n*W)
	{
		int[][] K=new int[n+1][W+1];
		
		for(int i=0;i<n;i++) // starting from case when there is only one element
		{
			for(int j=0;j<W;j++)  // taking optimised solution for sub-problems and then combining all
			{
				if(i==0||j==0)
					K[i][j]=0;
				else
				{
					if(j>=wt[i-1])
					{
						K[i][j]=val[i-1]+K[i-1][j-wt[i-1]]>K[i-1][j]?val[i-1]+K[i-1][j-wt[i-1]]:K[i-1][j];
					}
					else
						K[i][j]=K[i-1][j];
				}
				
				
			}
		}
		
		
		return K[n][W];
	}

}
