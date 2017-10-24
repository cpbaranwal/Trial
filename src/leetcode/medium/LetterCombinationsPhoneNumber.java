package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * @author chandan
 * Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
public class LetterCombinationsPhoneNumber {

  public static void main(String[] args) {
    LetterCombinationsPhoneNumber obj= new LetterCombinationsPhoneNumber();
    String digits="";
    List<String> list= obj.letterCombinations(digits);
    System.out.println("result= "+list);

  }
  private static Map<Integer,List<String>> map= new HashMap<Integer,List<String>>();
  static{
    map.put(1, new ArrayList<String>());
    map.put(2, Arrays.asList("a","b","c"));
    map.put(3, Arrays.asList("d","e","f"));
    map.put(4, Arrays.asList("g","h","i"));
    map.put(5, Arrays.asList("j","k","l"));
    map.put(6, Arrays.asList("m","n","o"));
    map.put(7, Arrays.asList("p","q","r","s"));
    map.put(8, Arrays.asList("t","u","v"));
    map.put(9, Arrays.asList("w","x","y","z"));
    map.put(0, new ArrayList<String>());
  }
  
  public List<String> letterCombinations(String digits) {
    List<String> resultList= new ArrayList<String>();
    try
    {
    List<List<String>> tmpListOfList= new ArrayList<List<String>>();
    for(int i=0;i<digits.length(); i++)
    {
      Integer num= Integer.parseInt(digits.substring(i, i+1));
      List<String> charListForNum= map.get(num);
      if(!charListForNum.isEmpty())
        tmpListOfList.add(charListForNum);
    }
    
    String str="";
    letterCombinationsHelper(tmpListOfList,0,str,resultList);
      
    }
    catch(Exception ex)
    {
      System.out.println("exception ex: "+ex);
    }
    return resultList;
  }

  private void letterCombinationsHelper(List<List<String>> tmpListOfList, int index, String str,List<String> resultList) 
  {
    if(index== tmpListOfList.size() )
    {
      if(!str.trim().isEmpty())
        resultList.add(str);
      return;
    }
    List<String> currList= tmpListOfList.get(index);
    for(String ch: currList)
    {
      letterCombinationsHelper(tmpListOfList,index+1,str+ch,resultList);
    }
    
  }

}
