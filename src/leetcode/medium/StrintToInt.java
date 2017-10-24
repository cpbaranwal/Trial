package leetcode.medium;

public class StrintToInt {

  public static void main(String[] args) {
    StrintToInt obj = new StrintToInt();
    String str = "1";
    int num = obj.myAtoi(str);
    System.out.println("result= " + num);
  }

  public int myAtoi(String str) {
    if (str == null)
      return 0;
    str = str.trim();
    if (str.isEmpty())
      return 0;
    int num = 0;
    boolean isNegative = false;
    int i = 0;
    if (str.charAt(0) == '-') {
      isNegative = true;
      i++;
    } else if (str.charAt(0) == '+')
      i++;

    for (; i < str.length(); i++) {
      char ch = str.charAt(i);
      int digit = ch - '0';
      System.out.println("ch=" + ch + "  digit=" + digit);
      if (digit > 9 || digit < 0)
        break;
      int prev = num;
      num = num * 10 - digit;
      if (prev < num || num > -Integer.MAX_VALUE) {
        num = Integer.MIN_VALUE; // value has overflown
        break;
      }
    }
    if (!isNegative)
      num = -1 * num;
    return num;
  }

}
