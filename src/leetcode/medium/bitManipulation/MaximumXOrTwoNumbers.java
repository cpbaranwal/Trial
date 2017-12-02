package leetcode.medium.bitManipulation;

/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 * @author chandan
 *Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class MaximumXOrTwoNumbers {

  public static void main(String[] args) 
  {
    int[] nums={3, 10, 5, 25, 2, 8};
    

  }
  
  // easy approach: O(NlogN) sort array and look for adjacent pairs which give max XOR
  //TODO restriction: have to do in O(N) time
  public static int findMaximumXOR(int[] nums) 
  {
    return 0;
  }

}
