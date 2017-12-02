package leetcode.medium.bitManipulation;

/**
 * https://leetcode.com/problems/total-hamming-distance/description/
 * @author chandan
 *The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.
 */
public class TotalHammingDistance {

  public static void main(String[] args) {
    int[]nums= {4, 14, 2};
    System.out.println("result= "+totalHammingDistance(nums));
  }
  
  public static int totalHammingDistance(int[] nums) 
  {
    int distance=0;
    int n=nums.length;
    for(int i=0; i<n-1; i++)
    {
      for(int j=i+1; j<n; j++)
      {
        int currDistance= calculateDistance(nums[i],nums[j]);
        System.out.println("nums[i]="+nums[i]+"  nums[j]="+nums[j]+"  currDistance="+currDistance);
        distance=distance+currDistance;
      }
    }
    return distance;
  }

  private static int calculateDistance(int num1, int num2) {
    //int bit=1;
    int dis=0;
    /*
    int num= num1>num2?num1:num2;
    while(bit<=num)
    {
      if((bit & num1) != (bit & num2))
        dis++;
      bit= bit<<1;   
    }
    */
    int xor= num1 ^ num2;
    while(xor>0)
    {
      if((xor & 1) ==1 )
        dis++;
      xor= xor>>1;
    }
    return dis;
  }

}
