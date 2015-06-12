package testings;
import java.util.*;

public  class AbstractClassExample {

public static void main(String[] args) {
		
	List<Dog> dogList=new ArrayList<Dog>();
	//dogList.add(new Dog("ddd"));
	
	List< Animal> animalList=new ArrayList<Animal>();
	
	//animalList.add(new Dog("d1"));
	//animalList=dogList;
	
	
	
	
	Dog[] dogArr=new Dog[10];
	Animal[] animalArr=new Animal[10];
	animalArr[0] = new Cat("d10");
	System.out.println("animalArr= "+animalArr);
	animalArr=dogArr;
	animalArr[1] = new Cat("d11");
	System.out.println("animalArr= "+animalArr);
	
	
	
	
	//addEntryList(dogList);
	//addEntryArray(arr);
	
	
	}



public   void addEntryList(List<Animal> animalList)
{
	System.out.println("addEntry1");
	animalList.add(new Cat("d1"));
	System.out.println("addEntry1");
	for(Object obj:animalList)
	{
		System.out.println(obj);
	}
}

public static  void addEntryArray(Animal[] animalArr)
{
	System.out.println("addEntry");
	animalArr[0]=new Dog("d1");
}



}
