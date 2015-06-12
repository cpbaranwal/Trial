package testings;

public class Practice implements Cloneable{

	String str2 = "chandan";
	Object obj;
	public static void main(String[] args) throws CloneNotSupportedException {
		Test2 t2 = new Test2();
		Practice p = new Practice();
		Practice p2 = (Practice)p.clone();
		//System.out.println(t2.str == p.str2);
		
		String str1= "chandan";
		String str2 = new String("chandan");
		str2 = str2.intern();
		System.out.println(str1==str2);
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		 return super.clone();
		
	}

}
