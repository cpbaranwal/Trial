package pack2;

public class ReverseDigitsOfNumberWithoutExtraSpace {

	/**
		Determine whether an integer is a palindrome. Do this without extra space.
	 */
	public static int num2;
	public static void main(String[] args) {
		
		int num=1284554821;
		num2=num;
		
		System.out.println("Result=="+isPalindrome(num));

	}
	
	public  static boolean isPalindrome(int num1)
	{
		if(num1==0)
			return true;
		if(isPalindrome(num1/10))
		{
			if(num1%10==num2%10)
			{
				num2=num2/10;
				return true;
			}
		}
		return false;
	}

}
