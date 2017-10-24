package leetcode.medium;

/**
 * https://leetcode.com/problems/simplify-path/description/
 * @author chandan
 *Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */

//TODO
public class SimplifyUnixPath {

  public static void main(String[] args) {
    SimplifyUnixPath obj= new SimplifyUnixPath();
    String str= "";
    System.out.println("result= "+obj.simplifyPath(str));

  }
  
  private static String SLASH="/";
  private static String DOUBLE_SLASH="//";
  public String simplifyPath(String path) {
    String str=path;
    if(path==null || path.isEmpty() || !path.contains(SLASH))
      return path;
    
    while(str.contains(DOUBLE_SLASH))
    {
      int indx= str.indexOf(DOUBLE_SLASH);
      int i= indx+1;
      while(i<str.length() && str.charAt(i)=='/')
        i++;
      String tmpStr= str.substring(0,indx+1);
      if(i - indx >1 && i<str.length())
        tmpStr= tmpStr + str.substring(i);
      str= tmpStr;
    }
    
    
    //Stack<String> stack= new Stack<String>
    return str;
  }

}
