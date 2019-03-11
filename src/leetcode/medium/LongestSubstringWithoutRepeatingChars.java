package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * @author chandan
 * Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingChars {

  public static void main(String[] args) {
    String str=  "pwwkew";
    LongestSubstringWithoutRepeatingChars obj = new LongestSubstringWithoutRepeatingChars();
    System.out.println(obj.lengthOfLongestSubstring(str));

  }


  //approach- using a queue and a hashset
  public int lengthOfLongestSubstring(String s) {
    if(s==null)
      return -1;
    if(s.length()<2)
      return s.length();
    char[] arr=s.toCharArray();
    List<Character> queue= new LinkedList<Character>();
    Set<Character> set= new HashSet<Character>();
    int maxLen=0;
    for(int i=0;i<arr.length; i++)
    {
      char elem=arr[i];
      if(set.contains(elem))
      {
        char ch= queue.remove(0);
        while(ch!=elem)
        {
          set.remove(ch);
          ch=queue.remove(0);
        }
      }
      else
      {
        set.add(elem);
      }
      queue.add(elem);
      if(maxLen<queue.size())
      {
        maxLen=queue.size();
        System.out.println("maxLen="+maxLen+"    queue="+queue+"  set="+set);
      }
    }
    return maxLen;
  }
}
