package testings;
import java.util.*;

public class CovariantTest {

	
	public static void main(String[] args) 
	{
		Person[] arr1 = new Employee[5];
		//Object[] arr1 = new Employee[5];
		arr1[0] = new Person();
		//arr1[0] = new Employee();
		arr1[0].live();
		
		//Person per = new Employee();
		//per.live();
		
		List<Integer[]> myList = new ArrayList<Integer[]>();
		

	}
	
	static class Person
	{
		private void live()
		{
			System.out.println("i am alive");
		}
	}

	static class Employee extends Person
	{
		public void suffer()
		{
			System.out.println("i am suffering");
		}
	}

}
