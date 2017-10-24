package leetcode.medium;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 * Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
Note: m and n will be at most 100.
 */
public class UniquePaths2 {

  public static void main(String[] args) {
    UniquePaths2 obj= new UniquePaths2();
   
    int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
    
    System.out.println("result= "+obj.uniquePathsWithObstacles(obstacleGrid));

  }
  
  //approach: number of ways to move m-1 down and n-1 move right
  int numPath=0;
  public int uniquePathsWithObstacles(int[][] grid) {
    int m=grid.length; 
    int n=grid[0].length;
    if(m<1 || n<1 || grid[0][0]==1)
      return 0;
    if(m<2 && n<2)
      return 1;
    uniquePathsHelperDP(grid,m,n);
    return numPath;
  }
  
  
  
  private void uniquePathsHelperDP(int[][] grid,int m, int n) 
  {
    int[][] pathArr= new int[m][n];
    for(int i=0;i<m;i++)
    {
      if(grid[i][0]==1)
        break;
      pathArr[i][0]=1;
    }
      
    for(int i=0;i<n;i++)
    {
      if(grid[0][i]==1)
        break;
      pathArr[0][i]=1;
    }
      
    for(int i=1;i<m;i++)
    {
      for(int j=1;j<n;j++)
      {
        if(grid[i][j]==1)
          pathArr[i][j]=0;
        else
          pathArr[i][j]= pathArr[i-1][j] + pathArr[i][j-1];
      }
    }
    numPath= pathArr[m-1][n-1];
  }

  

}
