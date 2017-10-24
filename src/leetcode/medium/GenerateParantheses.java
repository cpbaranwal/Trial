package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParantheses {

  public static void main(String[] args) {
   int n=3;
   GenerateParantheses obj= new GenerateParantheses();
   List<String> list= obj.generateParenthesis(n);
   System.out.println("result= "+list);
  }

  static final String leftParan="(";
  static final String rightParan=")";
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<String>();
    if(n==0)
      return list;
    int leftParanRemaining= n;
    int rightParanRemaining= n;
    String currentStr=leftParan;
    leftParanRemaining--;
    generateParenthesisHelper(list,leftParanRemaining,rightParanRemaining,currentStr);
    return list;
  }
  private void generateParenthesisHelper(List<String> list, int leftParanRemaining, int rightParanRemaining, String currentStr) 
  {
    System.out.println("currentStr="+currentStr+"   leftParanRemaining="+leftParanRemaining+"   rightParanRemaining="+rightParanRemaining+"  list="+list);
    if(leftParanRemaining==0 && rightParanRemaining==0)
    {
      list.add(currentStr);
      return;
    }
    if(leftParanRemaining<0 || rightParanRemaining<0 || leftParanRemaining>rightParanRemaining) 
      return;
    generateParenthesisHelper(list,leftParanRemaining-1,rightParanRemaining,currentStr+leftParan);
    generateParenthesisHelper(list,leftParanRemaining,rightParanRemaining-1,currentStr+rightParan);
  }
  
}
