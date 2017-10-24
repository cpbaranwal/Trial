package leetcode.hard;

/**
 * https://leetcode.com/problems/regular-expression-matching/description/
 * @author chandan
 * entire input string (not partial).
The function prototype should be:
bool isMatch(const char *s, const char *p)
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 *
 */

// TODO solution not working
public class RegularExpressionMatching {

  public static void main(String[] args) {
    //String s= "aab";  String p= "c*a*b";//pattern
    //String s= "ab";  String p= "c*a*b";
    String s= "aaa";  String p= "ab*a*c*a";
    RegularExpressionMatching obj = new RegularExpressionMatching();
    System.out.println("result= "+obj.isMatch(s, p));

  }
  
  private static final char DOT_CHAR='.';
  private static final char STAR_CHAR='*';
  public boolean isMatch(String s, String p) 
  {
    if(s==null)
      return false;
    if(s.length()!=p.length() && p.indexOf(STAR_CHAR)== -1)
      return false;
    Character prev=null;
    return isMatchHelper(s,p,prev);
  }
  
  
  
  private boolean isMatchHelper(String s, String p, Character prev) 
  {
    System.out.println("s="+s+"    p="+p+"   prev="+prev);
    if(s.isEmpty() )
    {
      if(p.isEmpty() || ( p.charAt(0)==STAR_CHAR && p.length()==1)  )
        return true;
      return false;
    }
    else if(p.isEmpty())
    {
      return false;
    }
    
    char sChar= s.charAt(0);
    char pChar= p.charAt(0);
    // !s.isEmpty() && !p.isEmpty()
    if(pChar==sChar || pChar==DOT_CHAR)
    {
      boolean bool= isMatchHelper(s.substring(1),p.substring(1),pChar);
      if( pChar==DOT_CHAR && p.length()>2 && p.charAt(1)==STAR_CHAR)
        bool= bool || isMatchHelper(s,p.substring(2),null);
      return bool;
    }
    if(pChar==STAR_CHAR)
    {
      if(prev==DOT_CHAR)// case .* : always true if no character after .*
      {
        if(p.length()<2)//ab,a.*
          return true;
        boolean bool= false;
        for(int i=0;i<s.length();i++)
          bool= bool || isMatchHelper(s.substring(i),p.substring(1),null);
        return bool;
      }
        
      if(prev==sChar)//aaa,a*
      {
        System.out.println("111111");
        boolean bool1= isMatchHelper(s.substring(1),p.substring(1),null);
        boolean bool2= isMatchHelper(s.substring(1),p,prev);
        System.out.println("bool1= "+bool1+"   bool2="+bool2);
        return bool1 || bool2 ;
      }
      else
        return isMatchHelper(s,p.substring(1),null);//ab,a*b
    }
    //pChar!=sChar && pChar!=DOT_CHAR && pChar!=STAR_CHAR
    if(p.length()>1 && p.charAt(1)==STAR_CHAR)
      return isMatchHelper(s,p.substring(2),prev);
    
    return false;
  }
  
  
  /*
  private boolean isMatchHelper(String s, String p, Character prev) 
  {
    if(s.isEmpty() )
    {
      //if(p.isEmpty() || p.charAt(0)==DOT_CHAR || p.charAt(0)==STAR_CHAR)
      if(p.isEmpty() || (p.length()==1 && p.charAt(0)==STAR_CHAR) )
        return true;
      return false;
    }
    else if(p.isEmpty())
    {
      if(prev==null || prev!=STAR_CHAR)
        return false;
      return true;
    }
    char sChar= s.charAt(0);
    char pChar= p.charAt(0);
     if(sChar==pChar || pChar==DOT_CHAR)
    {
      return isMatchHelper(s.substring(1),p.substring(1),pChar);
    }
    else //s.charAt(0)!=p.charAt(0)
    {
      if(pChar==STAR_CHAR)
      {
        if(prev!=null && prev==DOT_CHAR)
          return true;
        if(prev!=null && prev==sChar)
        {
          boolean bool1= isMatchHelper(s.substring(1),p,prev);          
          boolean bool2= isMatchHelper(s.substring(1),p.substring(1),pChar);
          return bool1||bool2;
        }
           
        
      }
      else//pChar!=STAR_CHAR
      {
        
      }
      
    }
     return false;
    
  }
  */

}
