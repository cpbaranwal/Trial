package leetcode.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * @author chandan
 *Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuySellStock {

  public static void main(String[] args) 
  {
    //int[] prices= {2,1,2,1,0,1,2};
    int[] prices= {3,2,6,5,0,3};//{7, 1, 5, 3, 6, 4};
    System.out.println("result= "+maxProfit2(prices));

  }


  public static int maxProfit2(int[] prices)
  {
    int res=0;
    if(prices==null || prices.length<2)
      return 0;
    int buy=prices[0]; int sell=prices[0];
    int max=0;
    for(int num : prices)
    {
      if(num > sell)
      {
        sell = num;
        if(max < (sell - buy))
          max = (sell - buy);
        //System.out.println("current max= "+ max +" num="+num);
      }
      else if(num < buy)
      {
        buy = num;
        sell = num;
      }
    }
    return max;
  }


  public static int maxProfit(int[] prices) 
  {
    int res=0;
    if(prices==null || prices.length<2)
      return 0;
    int min=prices[0]; int max=0;
    int len=prices.length;
    for(int i=1; i<len; i++)
    {
      int elem= prices[i];
      if(elem>max)
      {
        max=elem;
        if(res< (max-min))
          res= max-min;
      }
      if(min>elem)
      {
        min=elem;
        max=elem;
      }
      System.out.println("min="+min+"   max="+max+"   res="+res);
    }
    return res;
  }

}
