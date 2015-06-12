package pack;

public class PrintInterleaving {

	
	public static void main(String[] args) {
		String s1="ab";
		String s2="de";
		String s3="";
		printIntLeaving(s1,s2,s3);

	}
	
	public static void printIntLeaving(String s1,String s2,String s3)
	{
		if(s1==null || s1.isEmpty())
		{
			System.out.println(s3+s2);
		}
		else
			if(s2==null  || s2.isEmpty())
			{
				System.out.println(s3+s1);
			}
			else
			{
				printIntLeaving(s1.substring(1),s2,s3+String.valueOf(s1.charAt(0)));
				printIntLeaving(s1,s2.substring(1),s3+String.valueOf(s2.charAt(0)));
			}
	}

}
