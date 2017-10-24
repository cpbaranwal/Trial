package leetcode.goodOnes;

/**
 * https://leetcode.com/problems/maximal-square/description/
 * 
 * @author chandan Given a 2D binary matrix filled with 0's and 1's, find the
 *         largest square containing only 1's and return its area. For example,
 *         given the following matrix: 1 0 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 3 0
 *         Return 4.
 */
public class MaximalSquare {

  public static void main(String[] args) {
    char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' } };
    MaximalSquare obj = new MaximalSquare();
    System.out.println("result= " + obj.maximalSquare(matrix));
  }

  private static int one = '1';
  private static int zero = '0';

  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
      return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] arr = new int[m][n];
    int maxEdge = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = matrix[i][j] == '1' ? 1 : 0;
        
        if (arr[i][j] == 1 ) {
          if(i > 0 && j > 0)
          {
          int min = Math.min(arr[i - 1][j - 1], arr[i - 1][j]);
          min = Math.min(min, arr[i][j - 1]);
          arr[i][j] = 1 + min;
          if (maxEdge <= min)
            maxEdge = min + 1;
          }
          else
          {
            maxEdge= maxEdge<arr[i][j] ? arr[i][j]:maxEdge;
          }
        }
      }
    }
    return (maxEdge * maxEdge);
  }
 

}
