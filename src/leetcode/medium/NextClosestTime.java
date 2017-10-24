package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-closest-time/description/
 * @author chandan
 *Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
 *There is no limit on how many times a digit can be reused.
You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid.
 "1:34", "12:9" are all invalid.
Example 1:
Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  
It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:
Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class NextClosestTime {

  public static void main(String[] args) {
    NextClosestTime obj = new NextClosestTime();
    String time="17:01";
    System.out.println("result= "+obj.nextClosestTime(time));

  }
  
  
  //approach: for minutes :MM we need to take next higher number possible from the digits available, 
  //if not possible we need to take smallest number in hour and minutes HH:MM for next day
  public String nextClosestTime(String time) {
    //19:34 , 23:59
    int[] arr= {time.charAt(0)-'0',time.charAt(1)-'0',time.charAt(3)-'0',time.charAt(4)-'0'};
    Arrays.sort(arr);
    int min= Integer.parseInt(time.substring(3,5));
    int min2ndDigit= min%10;
    int min1stDigit= min/10;
    
    //when greater minutes is possible
    for(int i=0;i<3;i++)
    {
      if(min2ndDigit==arr[i] && arr[i]!=arr[i+1])
      {
        int tmpMin=(min1stDigit*10+arr[i+1]);
        String tmpMinStr=""+tmpMin;
        if(tmpMin<10)
          tmpMinStr="0"+tmpMinStr;
        return (time.substring(0,2)+":"+tmpMinStr);
      }
    }
    for(int i=0;i<3;i++)
    {
      if(min1stDigit==arr[i] && arr[i]!=arr[i+1])
      {
        if(arr[i+1]>5)
          break;
        int tmpMin=(arr[i+1]*10+arr[0]);
        String tmpMinStr=""+tmpMin;
        if(tmpMin<10)
          tmpMinStr="0"+tmpMinStr;
        return (time.substring(0,2)+":"+tmpMinStr);
      }
    }
    
    int hr= Integer.parseInt(time.substring(0,2));
    int hr2ndDigit= hr%10;
    int hr1stDigit= hr/10; 
  //when greater hour is possible
    for(int i=0;i<3;i++)
    {
      if(hr2ndDigit==arr[i] && arr[i]!=arr[i+1])
      {
        int hour=(hr1stDigit*10+arr[i+1]);
        if(hour>23)
          break;
        return ( (hour<10 ? "0"+hour:""+hour)+":"+arr[0]+arr[0]);
      }
    }
    for(int i=0;i<3;i++)
    {
      if(hr1stDigit==arr[i] && arr[i]!=arr[i+1])
      {
        int hour=(arr[i+1]*10+arr[0]);
        if(hour>23)
          break;
        return ((hour<10 ? "0"+hour:""+hour)+":"+arr[0]+arr[0]);
      }
    }
    
    //when no option found
    return ""+arr[0]+arr[0]+":"+arr[0]+arr[0];
    
  }

}
