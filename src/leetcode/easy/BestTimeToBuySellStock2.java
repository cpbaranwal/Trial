package leetcode.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuySellStock2 {

  public static void main(String[] args) 
  {
    int[] prices= {6,1,3,2,4,7};
    System.out.println("result= "+maxProfit(prices));

  }
  
  public static int maxProfit(int[] prices) 
  {
    int res=0;
    int total=0;
    if(prices==null || prices.length<2)
      return 0;
    int min=prices[0]; int max=prices[0];
    int len=prices.length;
    for(int i=1; i<len; i++)
    {
      int elem= prices[i];
      if(elem>max)
      {     
        min=max;
        max=elem;
        total= total+ (max-min);
      }   
      else if(elem<max)
      {
        min=elem;
        max=elem;
        //total= total+ (max-min);
      }
      System.out.println("min="+min+"   max="+max+"   res="+res+"   total="+total);
    }
    //total= total+res;
    return total;
  }

}
