package pack7;

public class UniqueNumberOfPathsInRectangle {

	/**
	     find the unique number of paths to reach from point say (0,0) to (5,3)
	     
	     one solution using Combination :
	     total number of steps =8 so its 8
	                                      C
	                                       3
	                                       
	    Second solution (using DP):
	    Approach: initialize both the boundary horizontal and verticallines.
	    The total unique paths at grid (r,c) is equal to 
	              the sum of total unique paths from grid to the right (r,c-1) and the grid below (r-1,c).
	 */
	public static void main(String[] args) 
	{
		int m=5,n=3;
		
		int numUniquePaths = getUniquePathsusingDP(m,n);
		System.out.println("numUniquePaths= "+numUniquePaths);

	}

	private static int getUniquePathsusingDP(int m, int n) 
	{
		int[][] tmpArr = new int[m+1][n+1];
		
		for(int i=1; i<=m ;i++)
			tmpArr[i][0]=1;  //initialize boundary horizontal line
		for(int i=1; i<=n ;i++)
			tmpArr[0][i]=1;  //initialize boundary vertical line
		
		for(int i=1; i<=m; i++)
		{
			for(int j=1; j<=n; j++)
			{
				tmpArr[i][j] = tmpArr[i-1][j] + tmpArr[i][j-1];  //most important step
			}
		}
		
		return tmpArr[m][n];
	}

}
