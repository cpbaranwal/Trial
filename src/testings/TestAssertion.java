package testings;

public class TestAssertion {

	private TestAssertion()
	{
		System.out.println("constructor called!!");
		throw new AssertionError();
	}
	
	public static void method1()
	{
		TestAssertion ta = new TestAssertion();
	}
	public static void main(String[] args) {
		System.out.println("in main");
		method1();
		System.out.println("ends");
	}

}
