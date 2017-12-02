package leetcode.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 * @author chandan
 *Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.


 */
public class MinimumWindowSubstring {

  public static void main(String[] args) 
  {
    String s= "ADOBECODEBANC";
    String t= "ABC";
    System.out.println("result= "+minWindow(s,t));

  }
  
  //assumption: only range A-Z
  public static String minWindow(String s, String t) 
  {
    String res="";
    int[] needToFind= new int[26];
    int[] foundTillNow= new int[26];
    int currCount=0; 
    int left=0; int right=Integer.MAX_VALUE;
    int tlen=t.length();
    int slen=s.length();
    for(int i=0; i<tlen; i++)
      needToFind[t.charAt(i)- 'A']++;
    //System.out.println("needToFind[]= "+Arrays.toString(needToFind));
    
    int indx1=0; int indx2=0;
    for(; indx2<slen ;indx2++)
    {
      //System.out.println("s.charAt(indx2)="+s.charAt(indx2)+"   indx2="+indx2+"   indx1="+indx1);
      if(needToFind[s.charAt(indx2)-'A'] == 0)
        continue;
      foundTillNow[s.charAt(indx2)-'A']++;
     
      if(foundTillNow[s.charAt(indx2)-'A'] <= needToFind[s.charAt(indx2)-'A'])
      {
        currCount++;
      }
      
      if(currCount==tlen)//we need to try to shorten string if possible
      {
        while(needToFind[s.charAt(indx1)-'A'] == 0   ||    foundTillNow[s.charAt(indx1)-'A'] > needToFind[s.charAt(indx1)-'A'])
        {
          if(foundTillNow[s.charAt(indx1)-'A'] > needToFind[s.charAt(indx1)-'A'])
            foundTillNow[s.charAt(indx1)-'A']--;
          indx1++;
        }
        //System.out.println(" indx1="+indx1+" indx2="+indx2+" currCount="+currCount+"foundTillNow[]= "+Arrays.toString(foundTillNow));
        //if(res.isEmpty() || (indx2-indx1+1)<res.length())
        if(res.isEmpty() || (indx2-indx1)<(right-left))
        {
          //System.out.println("indx2="+indx2+"   indx1="+indx1);
          left=indx1;
          right=indx2;
          res=s.substring(left,right+1);
        }
      }
    }   
    if(!res.isEmpty())
      res=s.substring(left,right+1);
    return res;
  }

}
