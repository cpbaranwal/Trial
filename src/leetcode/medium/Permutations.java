package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 * @author chandan
 *Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations {

  public static void main(String[] args) {
    Permutations obj= new Permutations();
    int[] nums={1,2,3};
    
    System.out.println("result= "+obj.permute(nums));

  }
  
  List<List<Integer>> resultList= new ArrayList<List<Integer>>();
  public List<List<Integer>> permute(int[] nums) 
  {
    if(nums== null || nums.length==0)
      return resultList;
    List<Integer> srcList= new ArrayList<Integer>();
    for(Integer num: nums)
      srcList.add(num);
    permuteHelper(srcList,new ArrayList<Integer>());
    
    return resultList;
  }
  
  private void permuteHelper(List<Integer> srcList,List<Integer> destList)
  {
    if(srcList.isEmpty())
    {
      resultList.add(new ArrayList<Integer>(destList));
      return;
    }
    int len=srcList.size();
    for(int i=0; i<len; i++)
    {
      Integer num= srcList.get(i);
      destList.add(num);
      List<Integer> copySrcList= new ArrayList<Integer>(srcList);
      copySrcList.remove(i);
      permuteHelper(copySrcList,destList);
      destList.remove(destList.size()-1);
    }
  }

}
