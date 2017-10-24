package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 https://leetcode.com/problems/permutations-ii/description/
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class Permutations2 {

  public static void main(String[] args) {
    Permutations2 obj= new Permutations2();
    int[] nums={1,2,1};
    
    System.out.println("result= "+obj.permuteUnique(nums));

  }
  
  Set<List<Integer>> result= new HashSet<List<Integer>>();
  public List<List<Integer>> permuteUnique(int[] nums) 
  {
    if(nums== null || nums.length==0)
      return new ArrayList<List<Integer>>(result);
    Arrays.sort(nums);
    List<Integer> srcList= new ArrayList<Integer>();
    for(Integer num: nums)
      srcList.add(num);
    permuteHelper(srcList,new ArrayList<Integer>());
    
    return new ArrayList<List<Integer>>(result);
  }
  
  private void permuteHelper(List<Integer> srcList,List<Integer> destList)
  {
    if(srcList.isEmpty())
    {
      result.add(new ArrayList<Integer>(destList));
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
