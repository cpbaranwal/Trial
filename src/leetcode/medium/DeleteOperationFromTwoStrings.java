package leetcode.medium;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 * 
 * @author chandan Given two words word1 and word2, find the minimum number of
 *         steps required to make word1 and word2 the same, where in each step
 *         you can delete one character in either string. Example 1: Input:
 *         "sea", "eat" Output: 2 Explanation: You need one step to make "sea"
 *         to "ea" and another step to make "eat" to "ea". Note: The length of
 *         given words won't exceed 500. Characters in given words can only be
 *         lower-case letters.
 */
public class DeleteOperationFromTwoStrings {

  public static void main(String[] args) {
    String str1 = "seatingerrr";
    String str2 = "treating";
    DeleteOperationFromTwoStrings obj = new DeleteOperationFromTwoStrings();
    //System.out.println("result steps= " + obj.minDistance(str1, str2));
    System.out.println("longest substring length= "+obj.findLongestSubstringLength(str1, str2));
  }

  public int minDistance(String word1, String word2) {
    int len = findLongestSubsequenceLength(word1, word2);
    return (word1.length() + word2.length() - 2 * len);
  }

  private int findLongestSubsequenceLength(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();
    int[][] arr = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j]= arr[i-1][j-1];
        if(str1.charAt(i-1)==str2.charAt(j-1))
          arr[i][j]++;
        else
        {
          arr[i][j]= Math.max(arr[i-1][j], arr[i][j-1]);
        }     
      }
    }
    System.out.println("lcs = "+arr[m][n]);
    return arr[m][n];
  }
  
  private int findLongestSubstringLength(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();
    int maxlen=0;
    for(int i=0;i<m; i++)
    {
      int j=0;int k=i;
      int tmpLen=0;
      while(j<n && k<m)
      {
      if(str1.charAt(k) == str2.charAt(j))
        {
          tmpLen++;
          System.out.println(" updated tmpLen="+tmpLen+"  str1.charAt(i1)="+str1.charAt(k)+"  str2.charAt(j)="+str2.charAt(j));
        k++; j++;
        }
        else
        {
          if(tmpLen>maxlen)
            maxlen = tmpLen;
          tmpLen=0;
          j++;
        }
      }
      if(tmpLen>maxlen)
        maxlen = tmpLen;
    }
    
    System.out.println("longest substring = "+maxlen);
    return maxlen;
  }
  

}
