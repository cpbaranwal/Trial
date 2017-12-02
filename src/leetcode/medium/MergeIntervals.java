package leetcode.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 * @author chandan
 *Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]
 */
public class MergeIntervals {

  public static void main(String[] args) 
  {
    List<Interval> intervals= new ArrayList<Interval>();
    intervals.add(new Interval(1,3));
    intervals.add(new Interval(2,6));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(15,18));
    System.out.println("input= "+intervals);
    
    System.out.println("result= "+merge(intervals));

  }
  
  //approach sort on START for each interval and then try to merge based on END
  public static List<Interval> merge(List<Interval> intervals) 
  {
    List<Interval> resList= new ArrayList<Interval>();
    java.util.Collections.sort(intervals, new Comparator<Interval>(){
      public int compare(Interval o1, Interval o2)
      {
        if(o1==null || o2==null)
          return 1;//true
        return o1.start-o2.start;
      }
    });
    
   for(Interval curr: intervals)
   {
     if(!resList.isEmpty())
     {
       Interval prev= resList.get(resList.size()-1);
       if(curr.start <= prev.end)
       {
         resList.remove(resList.size()-1);//remove,needs to be replaced
         int tmpEnd= curr.end>prev.end ? curr.end:prev.end;
         resList.add(new Interval(prev.start,tmpEnd));
         continue;
       }
     }
     resList.add(new Interval(curr.start,curr.end));
   }
    
    return resList;
  }
  
  
  private static class Interval 
  {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
         
        @Override
        public String toString() {
          return " [start=" + start + ", end=" + end + "]";
        }
         
  }

}
