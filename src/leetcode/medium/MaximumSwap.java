package leetcode.medium;

/**
 * https://leetcode.com/problems/maximum-swap/description/
 * @author chandan
 *Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 *Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]
 */
public class MaximumSwap {

  public static void main(String[] args) 
  {
    //int num= 98368;
    int num= 10909091;
    System.out.println("result= "+maximumSwap(num));

  }
  
  
  //approach:  traverse loop within loop, find max number on right which is gretaer than 1st number from left
  public static int maximumSwap(int num)
  {
    System.out.println("num="+num);
    if(num<12)
      return num; 
    String str= String.valueOf(num);
    int[] arr= new int[str.length()];
    for(int i=0;i<str.length(); i++)
      arr[i]= Integer.parseInt(""+str.charAt(i));
    
    int len=str.length();
    int i =0;
    //for(int i=0; i<len-1; i++)
    //{
      int maxIndx=i+1;
      for(int j=i+1; j<len; j++)
      {
        if(arr[j]>=arr[maxIndx])
          maxIndx=j;
      }
      if(arr[maxIndx]>arr[i])//interchange
      {
        //System.out.println("arr[maxIndx]="+arr[maxIndx]+" arr[i]="+arr[i]+"  i="+i+"  maxIndx="+maxIndx);
        int tmp=arr[i];
        arr[i]=arr[maxIndx];
        arr[maxIndx]=tmp;
        int res=0;
        for(int t: arr)
          res= res*10 + t;
       // System.out.println("final res="+res);
        return res;
      }
   // }
    return num;
  }  
  
  public static int maximumSwap4(int num)
  {
    System.out.println("num="+num);
    if(num<12)
      return num; 
    String str= String.valueOf(num);
    int i=0;
    //int changeIndx=0;
    for(; i<str.length()-1; i++)
    {
      int d1= Integer.parseInt(""+str.charAt(i));
      int d2= Integer.parseInt(""+str.charAt(i+1));
      if(d1<d2)
      {
        //changeIndx=i;
        break;
      }      
    }
    if(i==str.length()-1)
      return num;//no change needed
    
    //now need to replace positions max on right of changeIndx with leftmost number between 0 and changeIndx with value less than max
    int maxDigitIndx=i;
    int maxDigit= Integer.parseInt(""+str.charAt(i));
    for(int j=i+1;j<str.length();j++)
    {
      int curr= Integer.parseInt(""+str.charAt(j));
      if(maxDigit<=curr)
      {
        maxDigit=curr;
        maxDigitIndx=j;
      }
    }
    System.out.println("i= "+"  maxDigitIndx="+maxDigitIndx+"  maxDigit="+maxDigit);
    int res=0;
    int k=0;
    while( k<i)
    {
      int curr=Integer.parseInt(""+str.charAt(k));
      if(curr>=maxDigit)
      {
        res= res*10 + curr;
        k++;
      }
      else
        break;
    }
    res= res*10 + maxDigit;
    int minIndx=k;
    k++;
    while( k<maxDigitIndx)
    {
      int curr=Integer.parseInt(""+str.charAt(k));
      res= res*10 + curr;
      k++;
    }
    res= res*10 + maxDigit;
    while(k<str.length())
    {
      int curr=Integer.parseInt(""+str.charAt(k));
      res= res*10 + curr;
      k++;
    }
    
    return res; 
  } 
  
  public static int maximumSwap3(int num)
  {
    System.out.println("num="+num);
    if(num<12)
      return num; 
    String numStr= String.valueOf(num);
    int maxDigit= Integer.parseInt(""+numStr.charAt(0));
    int maxDigitIndx=0;
    for(int i=0;i<numStr.length();i++)
    {
      int curr= Integer.parseInt(""+numStr.charAt(i));
      if(curr>=maxDigit)
      {
        maxDigit=curr;
        maxDigitIndx=i;
      }
    }
    if(maxDigitIndx==0)
      return num;
    int res=maxDigit;
    System.out.println("res="+res+"   maxDigit="+maxDigit+"   maxDigitIndx="+maxDigitIndx);
    for(int i=1;i<maxDigitIndx;i++)
      res= res*10 + Integer.parseInt(""+numStr.charAt(i));
    res= res*10 + Integer.parseInt(""+numStr.charAt(0));
    if(maxDigitIndx<numStr.length()-1)
      for(int i=maxDigitIndx+1;i<numStr.length();i++)
        res= res*10 + Integer.parseInt(""+numStr.charAt(i));
    System.out.println("final res="+res);
    return res;
  } 
  
  public static int maximumSwap2(int num)
  {
    if(num<12)
      return num;  
    int res=0;
    String numStr= String.valueOf(num);
    int i=0;
    int digit=0;
    for(; i<numStr.length()-1; i++)
    {
      digit= Integer.parseInt(""+numStr.charAt(i));
      int nxtDigit= Integer.parseInt(""+numStr.charAt(i+1));
      if(digit>nxtDigit)
      {
        res= res*10 + digit;
      }
      else
        break;
    }
    if(i==numStr.length()-1)
      return num;
    
    String substr= numStr.substring(i);
    System.out.println("res="+res+"   substr="+substr);
    int maxDigit=digit;int maxDigitIndx=1;
    int j=1;
    for(;j<substr.length();j++)
    {
      int tmpDigit= Integer.parseInt(""+substr.charAt(j));
      if(tmpDigit>=maxDigit)
      {
        maxDigitIndx=j;
        maxDigit=tmpDigit;
      }    
    }
    System.out.println("substr maxDigitIndx="+maxDigitIndx+"   maxDigit="+maxDigit);
    res= res*10 + maxDigit;
    for(int k=1;k<maxDigitIndx;k++)
      res= res*10 + Integer.parseInt(""+substr.charAt(k));
    res= res*10 + Integer.parseInt(""+substr.charAt(0));
    if(maxDigitIndx<substr.length()-1)
      for(int k=maxDigitIndx+1;k<substr.length();k++)
        res= res*10 + Integer.parseInt(""+substr.charAt(k));
    System.out.println("final res= "+res);
    return res;
  }
  
  
  
  
  

}
