package testings;

public  class Animal {

	/**
	 example to show things regarding polymorphism for Generics in Collection and array
	 */
	
	
	public Animal()
	{
		System.out.println("Animal: Object is created");
		//this constructor is mandatory if  there's already an argument constructor and the extending class is serializable
	}
	
	
	public Animal(Animal obj)
	{
		//dummy constructor to test serializable
	}
	public static void eat()
	{
		System.out.println("Animal: eat");
	}
	
	
	public static void main(String[] args)
	{
		Animal obj = new Cat();
		obj.eat();
		System.out.println("1");
		try {
			Animal obj2 = (Animal)obj.clone();
			obj2.eat();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("2");
	}
	
	
}

