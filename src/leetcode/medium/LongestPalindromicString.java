package leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * @author chandan Given a string s, find the longest palindromic substring in
 *         s. You may assume that the maximum length of s is 1000. Example:
 *         Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 *         Example: Input: "cbbd" Output: "bb"
 *
 */
public class LongestPalindromicString {

  public static void main(String[] args) {
    String str="eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
        + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
    LongestPalindromicString obj = new LongestPalindromicString();
    System.out.println("result="+obj.longestPalindrome(str));

  }

  public String longestPalindrome(String str) {
    if (str == null || str.length() < 2)
      return str;
    String maxPalindrome = str.substring(0, 1);
    // char[] arr= s.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      int indx1 = i;
      int indx2 = i;

      String s1 = "";
      String s2 = "";
      s1 = longestPalindromeHelper(str, indx1, indx2);
      if ((i + 1) < str.length() && str.charAt(i) == str.charAt(i + 1))
        s2 = longestPalindromeHelper(str, indx1, indx2 + 1);
      if (s1.length() > maxPalindrome.length())
        maxPalindrome = s1;
      if (s2.length() > maxPalindrome.length())
        maxPalindrome = s2;
      // System.out.println("maxPalindrome = "+maxPalindrome);
    }
    return maxPalindrome;

  }

  public String longestPalindromeHelper(String str, int indx1, int indx2) {
    String maxPalindrome = "";
    while (indx1 >= 0 && indx2 < str.length()) {
      if (str.charAt(indx1) != str.charAt(indx2))
        break;
      indx1--;
      indx2++;
    }
    if ((indx2 - indx1 + 1) > maxPalindrome.length())
      maxPalindrome = str.substring(indx1, indx2 + 1);
    return maxPalindrome;
  }

}
