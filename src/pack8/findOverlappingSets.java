package pack8;

import java.util.*;

/**
  amazon-interview-questions
http://www.careercup.com/question?id=5199356015673344

Given set of job schedules with start and end time, write a function that returns indexes of overlapping sets.

for ex :-
input -> [1,2][5,6][1,5][7,8][1,6]
return -> [0,1,2,4]
 
 */

public class findOverlappingSets {

	public static void main(String[] args) 
	{
		TimeObj o1 = new TimeObj(1,2);
		TimeObj o2 = new TimeObj(5,6);
		TimeObj o3 = new TimeObj(1,5);
		TimeObj o4 = new TimeObj(7,10);
		TimeObj o5 = new TimeObj(1,6);
		TimeObj o6 = new TimeObj(9,12);
		
		
		List<TimeObj> list = new ArrayList<TimeObj>();
		list.add(o1);list.add(o2);list.add(o3);list.add(o4);list.add(o5);list.add(o6);
		
		printOverlappingSets(list);

	}
	
	private static void printOverlappingSets(List<TimeObj> list) 
	{
		//sort the list
		Collections.sort(list);
		System.out.println("after sorting:");
		for(TimeObj elem: list)
		{
			System.out.println(" start:"+elem.start+"     end:"+elem.end);
		}
		System.out.println();
		
		
		System.out.println("  Intersecting sets are : ");
		int currMin=list.get(0).start;
		int currMax=list.get(0).end;
		boolean isFirstObj=true;
		for(int i=0; i<list.size()-1; i++)
		{
			int j=i+1;
			//if there is intersection
			if(list.get(j).start==currMin || list.get(j).start==currMax || ( list.get(j).start > currMin  && list.get(j).start<currMax) )
			{
				if(isFirstObj)//first time object
				{
					isFirstObj=false;
					System.out.println(" intersection found:  start="+list.get(i).start+"    end="+list.get(i).end);
				}
				System.out.println(" intersection found:  start="+list.get(j).start+"    end="+list.get(j).end);
				if(currMax<list.get(j).end)
				{
					currMax = list.get(j).end;
				}
			}
			else//not intersection
			{
				isFirstObj=true;//the next jth element will be considered as fresh firstObject in next iteration if that happens
				currMin=list.get(j).start;
				currMax=list.get(j).end;
			}
		}
		
	}

	static class TimeObj implements Comparable<TimeObj>
	{
		int start;
		int end;
		public TimeObj(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TimeObj other = (TimeObj) obj;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}
		
		@Override
		public int compareTo(TimeObj o2)
		{
			if(this.start < o2.start)
				return -1;
			if(this.end < o2.end)
				return -1;
			return 1;
		}
	}

}
