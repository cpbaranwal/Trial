package testings;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;


public class Dog extends Animal implements Serializable
{
	String dName=null;
	//private static final long serialVersionUID = -7844838557203783141L;
	transient String dName2=null;
	
	public Dog(String x)
	{
		super(null);
		System.out.println("Dog: Object is created");
		dName=x;
		dName2=x+"Transient";
	}
	
	
	public static void eat()
	{
		System.out.println("Dog; eat");
	}
	
	public static void eat2()
	{
		System.out.println("Dog; eat2");
	}
	
	
	public static void main(String args[])
	{
		Dog dog = new Dog("vodafone");
		
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)
	//this method must be private as jvm checks whether this method exists with private access otherwise ignores it
            throws IOException {
		System.out.println("overriden writeObject is called");
		stream.defaultWriteObject();
		stream.writeObject(dName2);  // serializing a transient member explicitly
   
		
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
    	System.out.println("overriden readObject is called");
    	//throw new NotSerializableException();
    	stream.defaultReadObject();
    	dName2 = (String) stream.readObject();
   
    }
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Dog: dName="+dName+"  dName2="+dName2;
	}
	
	
}

