package leetcode.medium;

/**
 * https://leetcode.com/problems/unique-paths/description/
 * @author chandan
 *A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
Note: m and n will be at most 100.
 */
public class UniquePaths {

  public static void main(String[] args) {
    UniquePaths obj= new UniquePaths();
    int m=1; int n=2;
    System.out.println("result= "+obj.uniquePaths(m, n));

  }
  
  //approach: number of ways to move m-1 down and n-1 move right
  int numPath=0;
  public int uniquePaths(int m, int n) {
    
    if(m<1 || n<1)
      return 0;
    if(m<2 && n<2)
      return 1;
    //uniquePathsHelperRecursive(m-1,n-1);
    uniquePathsHelperDP(m,n);
    return numPath;
  }
  
  private void uniquePathsHelperDP(int m, int n) 
  {
    int[][] pathArr= new int[m][n];
    for(int i=0;i<m;i++)
      pathArr[i][0]=1;
    for(int i=0;i<n;i++)
      pathArr[0][i]=1;
    for(int i=1;i<m;i++)
    {
      for(int j=1;j<n;j++)
      {
        pathArr[i][j]= pathArr[i-1][j] + pathArr[i][j-1];
      }
    }
    numPath= pathArr[m-1][n-1];
  }

  //using recursion
  private void uniquePathsHelperRecursive(int m, int n) 
  {
    if(m==0 && n==0)
    {
      numPath++;
      return;
    }
    if(m<0 || n<0)
      return;
    uniquePathsHelperRecursive(m-1,n);
    uniquePathsHelperRecursive(m,n-1);
    
  }

}
