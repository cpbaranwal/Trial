package testings;

public class Cat extends Animal implements Cloneable{

	String cName=null;
	public Cat(String x) {
		super(null);
		cName=x;
		// TODO Auto-generated constructor stub
	}
	
	public Cat()
	{
		super(null);
	}
	
	
	public static void eat()
	{
		System.out.println("Cat:  eat");
	}
	
	
	@Override
	protected Cat clone() throws CloneNotSupportedException {
		Cat newObj = (Cat)super.clone();
		System.out.println(" Cat clone is being created");
		return newObj;
	}
	

}
