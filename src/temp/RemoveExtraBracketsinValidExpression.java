package temp;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author chandan
 * remove extra unnecessary brackets in valid expression
 * e.g. 
 * ((((a+b))*((c/d)))) --> ((a+b)*(c/d))
 * (((a+b)*(c/d)))  -->  ((a+b)*(c/d))
 * ((a+b))   -->  (a+b)
 */
public class RemoveExtraBracketsinValidExpression {

  public static void main(String[] args) 
  {
    String input= "((((a+b))*((c/d))))"; 
    //input= "(((a+b)*(c/d)))";
    input= "((a+b))";
    System.out.println("result= "+removedExtraBrackets(input));
  }
  
  /*Assumption:
   * 1. The given expression is always valid expression, not validating that.
   * 2. There are no spaces in between characters.
   * 
   * approach:
   * As per our last discussion yesterday, I was using stack to hold all the characters from expression. There should be slight change in approach.
   * Stack should keep track of only open and close brackets else it will be difficult
   * Stack should be used to find occurrences like first there should be "((" type occurrence and then somewhere after that there should be "))"
   * Maintain indexes of such occurrences in stack instead of characters themselves
   */
  private static final Character OPEN_BRACKET= '(';
  private static final Character CLOSE_BRACKET= ')';
  private static final Character SPECIAL_CHARACTER= '#';
  public static String removedExtraBrackets(String input)
  {
    if(input==null || input.isEmpty())
      return input;
    char[] arr= input.toCharArray();
    char[] res= input.toCharArray();//this will hold output
    int len= arr.length;
    //stack will only hold indexes for open/close bracket 
    Stack<Integer> stack = new Stack<Integer>();
    for(int i=0; i<len; i++)
    {
      char ch= arr[i];
      if((ch!=OPEN_BRACKET) && (ch!=CLOSE_BRACKET))
        continue;//do nothing  if character is not bracket symbol
      if(ch==OPEN_BRACKET)
      {
        //Two cases here: 1.next character is again bracket   2. next character is not bracket
        if(arr[i+1]==OPEN_BRACKET)
          stack.push(-i);//insert -ve index value to mark that it was ( before another (
        else
          stack.push(i);//insert +ve  index value to mark that it was a normal ( and there is no ( after it
        
      }
      else //ch=CLOSE_BRACKET
      {
        if(arr[i-1]==CLOSE_BRACKET)//Two contiguous close brackets "))" found ,so we need to check
        {
          if(stack.peek()<=0)
          { // <0 means opening bracket was like "((" so found redundant, =0 for boundary condition
            res[i-1]=SPECIAL_CHARACTER;
            res[-stack.pop()]=SPECIAL_CHARACTER;
          }
        }
        else
          stack.pop();//just remove previous open bracket index
      }
    }
    System.out.println("arr= "+Arrays.toString(arr));
    //finally remove the special characters
    StringBuffer strBuff= new StringBuffer();
    for(char ch:res)
      if(ch!=SPECIAL_CHARACTER)
        strBuff.append(ch);
    String resultStr=strBuff.toString();
    
    System.out.println("before resultStr="+resultStr);
    //special case handling :  for expression like (a+b)*(c+d) should be returned as ((a+b)*(c+d))
    int bracketCount=0;
    boolean needsExtraBracket=false;
    for(int i=0; i<resultStr.length();i++)
    {
      char ch= resultStr.charAt(i);
      if(ch==OPEN_BRACKET)
        bracketCount++;
      else if(ch==CLOSE_BRACKET)
        bracketCount--;
      else if(bracketCount==0)//if normal character without being inside a bracket
      {
        needsExtraBracket=true;
        break;
      }       
    }
    
    if(needsExtraBracket)
      resultStr= "("+resultStr+")";
    System.out.println("after resultStr="+resultStr);
    return resultStr;
  }

}
